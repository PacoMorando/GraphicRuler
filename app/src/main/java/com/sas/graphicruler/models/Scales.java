package com.sas.graphicruler.models;

public enum Scales {
    ONE_TO_20(20f, 0.5f,ObjectScales.TABLE_LAMP),
    ONE_TO_25(25f, 0.5f,ObjectScales.TABLE_LAMP),
    ONE_TO_50(50f, 1.0f,ObjectScales.HUMAN_SCALE),
    ONE_TO_75(75f, 1.0f,ObjectScales.HUMAN_SCALE),
    ONE_TO_100(100f, 1.0f,ObjectScales.HUMAN_SCALE),
    ONE_TO_125(125f, 1.0f,ObjectScales.LAMP),
    ONE_TO_200(200f, 5.0f,ObjectScales.LAMP),
    ONE_TO_250(250f, 5.0f,ObjectScales.LAMP),
    ONE_TO_500(500f, 10.0f,ObjectScales.HOUSE);

    private final float scale;
    private final float unitHeightFactor;
    private final ObjectScales objectScale;

    Scales(float scale, float unitHeightFactor,ObjectScales objectScale) {
        this.scale = scale;
        this.unitHeightFactor = unitHeightFactor;
        this.objectScale = objectScale;
    }

    public float getScale() {
        return this.scale;
    }

    public float getScaledHeight() {
        return this.scale / this.unitHeightFactor;
    }

    public float getUnitHeightFactor(){
        return this.unitHeightFactor;
    }

    public ObjectScales getObjectScale(){
        return this.objectScale;
    }
}