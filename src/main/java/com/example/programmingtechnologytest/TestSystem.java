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

        // Тесты для создания точек
        testCases.add(new String[]{"Test1", "10.0", "20.0", "BLACK", "*"});
        testCases.add(new String[]{"Test2", "30.0", "40.0", "RED", "#"});

        // Тесты для изменения координат точек
        testCases.add(new String[]{"Test3", "50.0", "60.0", "GREEN", "!"});
        testCases.add(new String[]{"Test4", "70.0", "80.0", "BLUE", "@"});

        // Тесты для изменения цвета точек
        testCases.add(new String[]{"Test5", "90.0", "100.0", "YELLOW", "$"});
        testCases.add(new String[]{"Test6", "110.0", "120.0", "CYAN", "%"});

        // Тесты для удаления точек
        testCases.add(new String[]{"Test7", "130.0", "140.0", "MAGENTA", "^"});
        testCases.add(new String[]{"Test8", "150.0", "160.0", "ORANGE", "&"});

        return testCases.toArray(new String[0][]);
    }

    public static void solve(String[][] tests) {
        List<MPoint> points = new ArrayList<>();
        for (String[] test : tests) {
            MPoint point = new MPoint(test[0], Double.parseDouble(test[1]), Double.parseDouble(test[2]),
                    Color.web(test[3]), test[4].charAt(0));
            points.add(point);
        }

        // Изменение координат точек
        for (MPoint point : points) {
            point.setX(point.getX() + 10);
            point.setY(point.getY() + 10);
        }

        // Изменение цвета точек
        for (MPoint point : points) {
            point.setColor(Color.PINK);
        }

        // Удаление
        points.removeIf(point -> point.getName().equals("Test7") || point.getName().equals("Test8"));

        // Вывод результатов тестов
        for (MPoint point : points) {
            System.out.println(point);
        }
    }

    public static void check(String[][] tests) {
        for (String[] test : tests) {
            MPoint expectedPoint = new MPoint(test[0], Double.parseDouble(test[1]) + 10, Double.parseDouble(test[2]) + 10,
                    Color.PINK, test[4].charAt(0));

            MPoint actualPoint = new MPoint(test[0], Double.parseDouble(test[1]), Double.parseDouble(test[2]),
                    Color.web(test[3]), test[4].charAt(0));

            if (expectedPoint.getName().equals(actualPoint.getName()) &&
                    expectedPoint.getX() == actualPoint.getX() + 10 &&
                    expectedPoint.getY() == actualPoint.getY() + 10 &&
                    expectedPoint.getColor().equals(Color.PINK) &&
                    expectedPoint.getSymbol() == actualPoint.getSymbol()) {
                System.out.println("Test PASSED: " + test[0]);
            } else {
                System.out.println("Test FAILED: " + test[0]);
                System.out.println("Expected: " + expectedPoint);
                System.out.println("Actual: " + actualPoint);
            }
        }
    }
}
