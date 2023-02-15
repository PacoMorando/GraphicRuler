package com.example.graphicruler.controllers;

import com.example.graphicruler.models.ScalimeterBoard;


public class CalculateFromUnityController extends Controller {
    public CalculateFromUnityController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public String calculateFromUnity(float unity) {
        return formattedNumber(this.scalimeterBoard.calculateFromUnity(unity));
    }

    private String formattedNumber(float number) {
        String numberFormatted = String.format("%.3f", number);
        if ((int) number == Float.parseFloat(numberFormatted)) {
            return String.valueOf((int) number);
        }
        return numberFormatted;
    }
}
