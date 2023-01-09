package com.example.graphicruler.controllers;

import com.example.graphicruler.models.ScalimeterBoard;

public class MeasureController extends Controller {

    public MeasureController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public void getMeasure (float result){
        this.scalimeterBoard.getMeasure(result);
    }
}
