package com.example.graphicruler.controllers;

import com.example.graphicruler.models.ScalimeterBoard;

public class ConfigScaleController extends Controller {
    public ConfigScaleController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public void setScale(float scale) {
        this.scalimeterBoard.setScale(scale);
    }
}
