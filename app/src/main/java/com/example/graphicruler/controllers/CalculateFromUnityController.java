package com.example.graphicruler.controllers;

import com.example.graphicruler.models.ScalimeterBoard;

public class CalculateFromUnityController extends Controller{
    public CalculateFromUnityController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public String calculateFromUnity (float unity){
        return String.valueOf(this.scalimeterBoard.calculateFromUnity(unity));
    }
}
