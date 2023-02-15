package com.example.graphicruler.controllers;

import com.example.graphicruler.models.ScalimeterBoard;


public class CalculateFromScaledUnityController extends Controller {
    public CalculateFromScaledUnityController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public String calculateFromResult(float result) {
        return formattedNumber(this.scalimeterBoard.calculateFromResult(result));
    }

    private String formattedNumber(float number) {
        String numberFormatted = String.format("%.3f", number);
        if ((int) number == Float.parseFloat(numberFormatted)) {
            return String.valueOf((int) number);
        }
        return numberFormatted;
    }
}