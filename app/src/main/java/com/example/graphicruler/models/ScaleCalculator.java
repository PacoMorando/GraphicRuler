package com.example.graphicruler.models;

public class ScaleCalculator {
    private final float INCHES_TO_CENTIMETERS = 2.54f;
    private float scale;
    private float rulerUnity = 100.0f;

    public ScaleCalculator (float scale){
        this.scale = scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public float calculateFromResult(float result) {
        return result * scale / rulerUnity;
    }

    public float calculateFromUnity(float unity) {
        return unity / scale * rulerUnity;
    }

    public void setRulerUnity(float rulerUnity) {
        this.rulerUnity = rulerUnity;
    }

    public int getUnitHeight(float deviceHeight) {
        return Math.round((deviceHeight/this.INCHES_TO_CENTIMETERS) * (this.rulerUnity/this.scale));
    }
}
