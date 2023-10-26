package com.sas.graphicruler.controllers;

import com.sas.graphicruler.models.ScalimeterBoard;


public class CalculateFromUnityController extends Controller {
    public CalculateFromUnityController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public String calculateFromUnity(float unity) {
        return formattedNumber(this.scalimeterBoard.calculateFromUnity(unity));
    }

}
