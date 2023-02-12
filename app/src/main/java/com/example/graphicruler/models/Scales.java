package com.example.graphicruler.models;

public enum Scales {
    ONE_TO_20(20f, 0.5f),
    ONE_TO_25(25f, 0.5f),
    ONE_TO_50(50f, 1.0f),
    ONE_TO_75(75f, 1.0f),
    ONE_TO_100(100f, 1.0f),
    ONE_TO_125(125f, 1.0f),
    ONE_TO_200(200f, 5.0f),
    ONE_TO_250(250f, 5.0f),
    ONE_TO_500(500f, 10.0f);

    private final float scale;
    private final float unitHeightFactor;

    Scales(float scale, float unitHeightFactor) {
        this.scale = scale;
        this.unitHeightFactor = unitHeightFactor;
    }

    public float getScale() {
        return this.scale;
    }

    public float getHeight() {
        return this.scale / this.unitHeightFactor;
    }

    public float getUnitHeightFactor(){
        return this.unitHeightFactor;
    }
}
