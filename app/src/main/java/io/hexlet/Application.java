package io.hexlet;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name="app", mixinStandardHelpOptions = true, version = "1.0")
public class Application implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "The first file to be merged.", paramLabel = "filepath1")
    private String file1;

    @CommandLine.Parameters(index = "1", description = "The first file to be merged.", paramLabel = "filepath2")
    private String file2;

    @CommandLine.Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: stylish]",
            defaultValue = "stylish"
    )
    private String format;


    public static void main(String[] args) {
        var res = new CommandLine(new Application()).execute(args);
        System.exit(res);
    }

    @Override
    public Integer call() throws Exception {
        var diff = Differ.generate(file1, file2, format);
        System.out.println(diff);
        return 0;
    }
}
