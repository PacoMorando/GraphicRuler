package com.example.graphicruler.models;

public class ScaleCalculator {
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
}
