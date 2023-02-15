package com.example.graphicruler.models;

public class ScaleCalculator {
    private static final int TOTAL_GRAPHIC_SCALE_BARS = 6;
    private final float INCHES_TO_CENTIMETERS = 2.54f;
    private Scales scale;
    private float rulerUnity = 100.0f;
    private int unitHeight;

    public ScaleCalculator(float scale) {
        this.scale = Scales.valueOf(this.getScaleName(scale));
    }

    public void setScale(float scale) {
        this.scale = Scales.valueOf(this.getScaleName(scale));
    }

    private String getScaleName(float scale) {
        return "ONE_TO_" + (int) scale;
    }

    public float calculateFromResult(float result) {
        return result * scale.getScale() / rulerUnity;
    }

    public float calculateFromUnity(float unity) {
        return unity / scale.getScale() * rulerUnity;
    }

    public void setRulerUnity(float rulerUnity) {
        this.rulerUnity = rulerUnity;
    }

    public int getUnitHeight() {
        return Math.round(this.unitHeight * (this.rulerUnity / this.scale.getHeight())); // QUE LA OPERACION SE HAGA AQUI Y NO EN EL ENUMERADO
    }

    public int getObjectScaleHeight() {
        return Math.round(this.unitHeight * (this.rulerUnity / this.scale.getScale()) * 2);//TODO RESOLVER ESTE NUMERO NAGICO... TAL VEZ LO OBJETOS DEBERIAN DE SER ENUMERADOS???
    }

    public void setUnitHeight(float deviceHeight) {
        this.unitHeight = Math.round((deviceHeight / this.INCHES_TO_CENTIMETERS));
    }

    public float getScale() {
        return scale.getScale();
    }

    public String getPositionValue(int position) {
        float floatPositionValue = position * this.scale.getUnitHeightFactor();
        int integerPositionValue = (int) (position * this.scale.getUnitHeightFactor());
        if (floatPositionValue == integerPositionValue) {
            return String.valueOf(integerPositionValue);
        }
        return String.valueOf(floatPositionValue);
    }

    public int getRulerSize(int totalScreenHeightInInches) {
        return (int) (this.calculateFromResult(this.totalScreenHeightInCentimeters(totalScreenHeightInInches)) / this.scale.getUnitHeightFactor());
    }

    private float totalScreenHeightInCentimeters(int totalScreenHeightInInches) {
        return (float) Math.ceil(totalScreenHeightInInches * this.INCHES_TO_CENTIMETERS);
    }

    public String getGraphicRulerPositionValue(int position) {
        float floatPositionValue = this.graphicRulerUnitNumber(position) * this.scale.getUnitHeightFactor();
        int integerPositionValue = (int) (this.graphicRulerUnitNumber(position) * this.scale.getUnitHeightFactor());
        if (floatPositionValue == integerPositionValue) {
            return String.valueOf(integerPositionValue);
        }
        return String.valueOf(floatPositionValue);
    }

    private int graphicRulerUnitNumber(int position) {
        if (position == 3) {
            return 5;
        }
        if (position == 4) {
            return 10;
        }
        if (position == 5) {
            return 20;
        }
        if (position == 6) {
            return 40;
        }
        return position;
    }

    public int getGraphicRulerItemCount() {
        return TOTAL_GRAPHIC_SCALE_BARS;
    }

    public int getGraphicRulerUnitHeight(int position) {
        if (position == 2) {
            return 3 * this.getUnitHeight();
        }
        if (position == 3) {
            return 5 * this.getUnitHeight();
        }
        if (position == 4) {
            return 10 * this.getUnitHeight();
        }
        if (position == 5) {
            return 30 * this.getUnitHeight();
        }
        return this.getUnitHeight();
    }
}