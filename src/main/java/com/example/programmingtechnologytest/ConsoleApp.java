package com.example.programmingtechnologytest;

import javafx.scene.paint.Color;

import java.util.Scanner;

public class ConsoleApp {
    private static MPoint pointB;
    private static MPoint pointD;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("Введите команду: createB, moveB, createD, moveD, updateColorD, deleteB, exit");
            command = scanner.nextLine();
            switch (command) {
                case "createB":
                    createPoint(scanner, "B");
                    break;
                case "moveB":
                    movePoint(scanner, "B");
                    break;
                case "createD":
                    createPoint(scanner, "D");
                    break;
                case "moveD":
                    movePoint(scanner, "D");
                    break;
                case "updateColorD":
                    updateColorPointD();
                    break;
                case "deleteB":
                    deletePointB();
                    break;
                case "exit":
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неизвестная команда.");
            }
            updateOutput();
        } while (!command.equals("exit"));
    }

    private static void createPoint(Scanner scanner, String pointName) {
        System.out.println("Введите координаты x и y:");
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите цвет:");
        Color color = Color.web(scanner.nextLine());
        System.out.println("Введите символ:");
        char symbol = scanner.nextLine().charAt(0);

        if (pointName.equals("B")) {
            pointB = new MPoint(pointName, x, y, color, symbol);
        } else if (pointName.equals("D")) {
            pointD = new MPoint(pointName, x, y, color, symbol);
        }
    }

    private static void movePoint(Scanner scanner, String pointName) {
        System.out.println("Введите новые координаты x и y:");
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        if (pointName.equals("B") && pointB != null) {
            pointB.setX(x);
            pointB.setY(y);
        } else if (pointName.equals("D") && pointD != null) {
            pointD.setX(x);
            pointD.setY(y);
        }
    }

    private static void updateColorPointD() {
        if (pointB != null && pointD != null) {
            pointD.setColor(pointB.getColor());
        }
    }

    private static void deletePointB() {
        pointB = null;
    }

    private static void updateOutput() {
        String output = "pointB" + (pointB != null ? pointB.toString() : "null") + " "
                + "pointD" + (pointD != null ? pointD.toString() : "null");
        System.out.println(output);
    }
}
