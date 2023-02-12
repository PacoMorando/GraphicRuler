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

    public int getItemCount(int totalScreenHeightInInches) {
        return this.scalimeterBoard.getRulerSize(totalScreenHeightInInches);
    }

    public float getScale() {
        return this.scalimeterBoard.getScale();
    }

    public String getPositionValue(int position) {
        return this.scalimeterBoard.getPositionValue(position);
    }
}