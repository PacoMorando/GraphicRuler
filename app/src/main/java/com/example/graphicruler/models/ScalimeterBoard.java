package com.example.graphicruler.models;

import java.util.ArrayList;

public class ScalimeterBoard {

    private ArrayList<GraphicElement> graphicElements;
    private final ScaleCalculator scaleCalculator;
    private MeasureBars measureBars;

    public ScalimeterBoard(float scale) {
        this.scaleCalculator = new ScaleCalculator(scale);
    }

    public void setScale(float scale) {//PLANTEARME RECIBIR STRING
        this.scaleCalculator.setScale(scale);
    }

    public void setRulerInCentimeters() {
        this.scaleCalculator.setRulerUnity(100f);
    }

    public float calculateFromResult(float result) {
        return this.scaleCalculator.calculateFromResult(result);
    }

    public float calculateFromUnity(float unity) {
        return this.scaleCalculator.calculateFromUnity(unity);
    }

    public void getMeasure(float result) {

    }

    public int getUnitHeight() {
        return this.scaleCalculator.getUnitHeight();
    }

    public int getObjectScaleHeight() {
        return this.scaleCalculator.getObjectScaleHeight();
    }

    public void setUnitHeight(float deviceHeight) {
        this.scaleCalculator.setUnitHeight(deviceHeight);
    }

    public float getScale() {
        return this.scaleCalculator.getScale();
    }

    public String getPositionValue(int position) {
        return this.scaleCalculator.getPositionValue(position);
    }

    public int getRulerSize(int totalScreenHeightInInches) {
        return this.scaleCalculator.getRulerSize(totalScreenHeightInInches);
    }

    public String getGraphicRulerPositionValue(int position) {
        return this.scaleCalculator.getGraphicRulerPositionValue(position);
    }

    public int getGraphicRulerItemCount() {
        return this.scaleCalculator.getGraphicRulerItemCount();
    }

    public int getGraphicRulerUnitHeight(int position) {
        return this.scaleCalculator.getGraphicRulerUnitHeight(position);
    }
}
