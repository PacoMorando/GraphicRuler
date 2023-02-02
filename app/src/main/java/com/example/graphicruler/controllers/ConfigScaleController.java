package com.example.graphicruler.controllers;

import com.example.graphicruler.models.ScalimeterBoard;

public class ConfigScaleController extends Controller {
    public ConfigScaleController(ScalimeterBoard scalimeterBoard) {
        super(scalimeterBoard);
    }

    public void setScale(float scale) {
        this.scalimeterBoard.setScale(scale);
    }

    public int getUnitHeight() {
        return this.scalimeterBoard.getUnitHeight();
    }

    public int getObjectScaleHeight() {
        return this.scalimeterBoard.getObjectScaleHeight();
    }

    public void setUnitHeight(float deviceHeight) {
        this.scalimeterBoard.setUnitHeight(deviceHeight);
    }
}
