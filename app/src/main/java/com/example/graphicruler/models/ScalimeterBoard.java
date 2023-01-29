package com.example.graphicruler.models;

import java.util.ArrayList;

public class ScalimeterBoard {

    private ArrayList<GraphicElement> graphicElements;
    private final ScaleCalculator scaleCalculator;
    private MeasureBars measureBars;

    public ScalimeterBoard(float scale){
        this.scaleCalculator = new ScaleCalculator(scale);
    }

    public void setScale(float scale) {
        this.scaleCalculator.setScale(scale);
    }

    public void setRulerInCentimeters(){
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

    public int getUnitHeight(float deviceHeight) {
        return 0;
    }
}
