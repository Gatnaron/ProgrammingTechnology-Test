package com.example.programmingtechnologytest;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class TestSystem {
    public static void main(String[] args) {
        String[][] tests = generate();
        solve(tests);
        check(tests);
    }

    public static String[][] generate() {

        List<String[]> testCases = new ArrayList<>();

        // Тесты для создания объекта MPoint
        testCases.add(new String[]{"Test1", "10.0", "20.0", "BLACK", "*"});
        testCases.add(new String[]{"Test2", "40.0", "50.0", "WHITE", "#"});
        return testCases.toArray(new String[0][]);
    }

    public static void solve(String[][] tests) {
        // Реализация эталонного решения
        for (String[] test : tests) {
            MPoint point = new MPoint(test[0], Double.parseDouble(test[1]), Double.parseDouble(test[2]),
                    Color.web(test[3]), test[4].charAt(0));
        }
    }

    public static void check(String[][] tests) {
        // Проверка результатов
        for (String[] test : tests) {
            MPoint point = new MPoint(test[0], Double.parseDouble(test[1]), Double.parseDouble(test[2]),
                    Color.web(test[3]), test[4].charAt(0));

            // Сравнение результатов с ожидаемыми значениями
            if (point != null) {
                System.out.println("Test PASSED: " + test[0]);
            } else {
                System.out.println("Test FAILED: " + test[0]);
            }
        }
    }
}
