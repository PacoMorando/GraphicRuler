package com.example.graphicruler.controllers;

import com.example.graphicruler.models.ScalimeterBoard;

public class CalculateFromScaledUnityController extends Controller{
    public CalculateFromScaledUnityController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public String calculateFromResult (float result){
        return String.valueOf(this.scalimeterBoard.calculateFromResult(result));
    }
}