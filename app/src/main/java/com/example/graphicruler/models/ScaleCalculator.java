package com.example.graphicruler.models;

public class ScaleCalculator {
    private final float INCHES_TO_CENTIMETERS = 2.54f;
    private float scale;
    private float rulerUnity = 100.0f;
    private int unitHeight;

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

    public int getUnitHeight() {//estos metodos deberian ser accesibles solo por paquete?
        return Math.round(this.unitHeight * (this.rulerUnity/this.scale));
    }

    public void setUnitHeight(float deviceHeight) {
        this.unitHeight = Math.round((deviceHeight/this.INCHES_TO_CENTIMETERS));
    }

    public float getScale() {
        return scale;
    }
}
