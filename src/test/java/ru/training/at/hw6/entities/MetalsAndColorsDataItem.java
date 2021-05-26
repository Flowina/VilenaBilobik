package ru.training.at.hw6.entities;

import java.util.LinkedList;
import java.util.List;

public class MetalsAndColorsDataItem {
    public Integer[] summary;
    public String[] elements;
    public String color;
    public String metals;
    public String[] vegetables;

    public String[] getSummaryOdd() {
        List<String> result = new LinkedList<>();
        for (Integer x : summary) {
            if (x % 2 != 0) {
                result.add(x.toString());
            }
        }
        return result.toArray(new String[0]);
    }

    public String[] getSummaryEven() {
        List<String> result = new LinkedList<>();
        for (Integer x : summary) {
            if (x % 2 == 0) {
                result.add(x.toString());
            }
        }
        return result.toArray(new String[0]);
    }

    private Integer calcSummarySum() {
        Integer result = 0;
        for (Integer x : summary) {
            result += x;
        }
        return result;
    }

    public List<String> getExpectedResultLines() {
        List<String> lines = new LinkedList<>();
        lines.add(String.format("Summary: %d", calcSummarySum()));
        lines.add(String.format("Elements: %s", String.join(", ", elements)));
        lines.add(String.format("Color: %s", color));
        lines.add(String.format("Metal: %s", metals));
        lines.add(String.format("Vegetables:  %s", String.join(", ", elements)));
        return lines;
    }
}

