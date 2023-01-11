package com.example.graphicruler.controllers;

import com.example.graphicruler.models.ScalimeterBoard;

public class CalculateFromResultController extends Controller{
//CAMBIAR NOMBRE A LA CLASE, NO DEBERIA DE SER "FROM RESULT"
    public CalculateFromResultController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public String calculateFromResult (float result){
        return String.valueOf(this.scalimeterBoard.calculateFromResult(result));
    }
}