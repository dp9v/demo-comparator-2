package io.hexlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeSet;

public class Differ {
    public static String generate(String file1, String file2, String format) {
        var fileContent1 = readFile(file1);
        var fileContent2 = readUrl(file2);

        var file1Parsed = parse(fileContent1);
        var file2Parsed = parse(fileContent2);

        var diff = compare(file1Parsed, file2Parsed);

        return format(diff, format);
    }


    public static String readFile(String path) {
        return "";
    }

    public static String readUrl(String url) {
        return "";
    }

    public static Map<String, Object> parse(String content) {
        return null;
    }

    // 1. Sorted
    // 2. Keep values: key, new value, old value, status('added', 'removed', 'changed', 'unchanged'))
    public static List<CompareResult> compare(Map<String, Object> file1, Map<String, Object> file2) {
        var result = new ArrayList<CompareResult>();
        var keys = new TreeSet<String>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());
        for (var key : keys) {
            var value1 = file1.get(key);
            var value2 = file2.get(key);
            if (Objects.equals(value2, value1)) {
                result.add(new CompareResult(key, Status.UNCHANGED, value1, value2));
            }

        }

        return result;
    }

    public static String format(List<CompareResult> diff, String format) {
        return "{}";
    }
}
