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

        testCases.add(new String[]{"Test1", "10.0", "20.0", "BLACK", "*"});

        testCases.add(new String[]{"Test2", "10.0", "20.0", "BLACK", "*", "30.0", "40.0"});

        testCases.add(new String[]{"Test3", "10.0", "20.0", "BLACK", "*", "30.0", "40.0", "WHITE"});

        testCases.add(new String[]{"Test4", "10.0", "20.0", "BLACK", "*", null});

        return testCases.toArray(new String[0][]);
    }

    public static void solve(String[][] tests) {
        for (String[] test : tests) {
            MPoint point = new MPoint(test[0], Double.parseDouble(test[1]), Double.parseDouble(test[2]),
                    Color.web(test[3]), test[4].charAt(0));

            if (test.length >= 6 && test[5] != null) {
                point.setX(Double.parseDouble(test[5]));
                point.setY(Double.parseDouble(test[6]));
            }

            if (test.length >= 8 && test[7] != null) {
                point.setColor(Color.web(test[7]));
            }

            if (test.length >= 9 && test[8] == null) {
                point = null;
            }
        }
    }

    public static void check(String[][] tests) {
        for (String[] test : tests) {
            MPoint point = new MPoint(test[0], Double.parseDouble(test[1]), Double.parseDouble(test[2]),
                    Color.web(test[3]), test[4].charAt(0));

            if (point != null) {
                System.out.println("Test PASSED: " + test[0]);
            } else {
                System.out.println("Test FAILED: " + test[0]);
            }
        }
    }
}
