package com.sas.graphicruler.controllers;

import com.sas.graphicruler.models.ScalimeterBoard;


public class CalculateFromScaledUnityController extends Controller {
    public CalculateFromScaledUnityController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public String calculateFromResult(float result) {
        return formattedNumber(this.scalimeterBoard.calculateFromResult(result));
    }
}