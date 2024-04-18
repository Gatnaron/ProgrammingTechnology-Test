package com.example.programmingtechnologytest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    public TextField xBField;

    @FXML
    public TextField yBField;

    @FXML
    public TextField colorBField;

    @FXML
    public TextField symbolBField;

    @FXML
    public TextField xDField;

    @FXML
    public TextField yDField;

    @FXML
    public TextField colorDField;

    @FXML
    public TextField symbolDField;

    @FXML
    public Label outputLabel;

    public MPoint pointB;
    public MPoint pointD;

    @FXML
    public void initialize() {
        // Начальное состояние: точки не созданы
        pointB = null;
        pointD = null;
    }

    // Методы для выполнения действий с точками

    @FXML
    public void createPointB() {
        double x = Double.parseDouble(xBField.getText());
        double y = Double.parseDouble(yBField.getText());
        Color color = Color.web(colorBField.getText());
        char symbol = symbolBField.getText().charAt(0);

        pointB = new MPoint("B", x, y, color, symbol);
        updateOutput();
    }

    @FXML
    public void movePointB() {
        if (pointB != null) {
            double x = Double.parseDouble(xBField.getText());
            double y = Double.parseDouble(yBField.getText());
            pointB.setX(x);
            pointB.setY(y);
            updateOutput();
        }
    }

    @FXML
    public void createPointD() {
        double x = Double.parseDouble(xDField.getText());
        double y = Double.parseDouble(yDField.getText());
        Color color = Color.web(colorDField.getText());
        char symbol = symbolDField.getText().charAt(0);

        pointD = new MPoint("D", x, y, color, symbol);
        updateOutput();
    }

    @FXML
    public void movePointD() {
        if (pointD != null) {
            double x = Double.parseDouble(xDField.getText());
            double y = Double.parseDouble(yDField.getText());
            pointD.setX(x);
            pointD.setY(y);
            updateOutput();
        }
    }

    @FXML
    public void updateColorPointD() {
        if (pointB != null && pointD != null) {
            pointD.setColor(pointB.getColor());
            updateOutput();
        }
    }

    @FXML
    public void deletePointB() {
        pointB = null;
        updateOutput();
    }

    // Обновление вывода
    private void updateOutput() {
        String output = "pointB" + (pointB != null ? pointB.toString() : "null") + " "
                + "pointD" + (pointD != null ? pointD.toString() : "null");
        outputLabel.setText(output);
    }
}