package com.example.graphicruler.controllers;

import android.icu.number.Precision;

import com.example.graphicruler.models.ScalimeterBoard;

import java.math.BigDecimal;

public class CalculateFromScaledUnityController extends Controller {
    public CalculateFromScaledUnityController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public String calculateFromResult(float result) {
        return formattedNumber(this.scalimeterBoard.calculateFromResult(result));//AQUI VA EL FORMATEADOR
        //return String.valueOf(this.scalimeterBoard.calculateFromResult(result));//AQUI VA EL FORMATEADOR
    }

    private String formattedNumber(float number) {
        String numberFormatted = String.format("%.3f", number);
        if ((int)number == Float.parseFloat(numberFormatted)) {
            return String.valueOf((int) number);
        }
        return numberFormatted;
    }
}