package com.sas.graphicruler.controllers;

import com.sas.graphicruler.models.ScalimeterBoard;

public abstract class Controller {
    protected ScalimeterBoard scalimeterBoard;

    public Controller(ScalimeterBoard scalimeterBoard) {
        this.scalimeterBoard = scalimeterBoard;
    }

    protected String formattedNumber(float number) {
        String numberFormatted = String.format("%.3f", number);
        if ((int) number == Float.parseFloat(numberFormatted)) {
            return String.valueOf((int) number);
        }
        return numberFormatted;
    }
}
