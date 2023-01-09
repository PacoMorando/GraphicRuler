package com.example.graphicruler.controllers;

import com.example.graphicruler.models.ScalimeterBoard;

public class CalculateFromResultController extends Controller{

    public CalculateFromResultController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public void calculateFromResult (float result){
        this.scalimeterBoard.calculateFromResult(result);
    }
}