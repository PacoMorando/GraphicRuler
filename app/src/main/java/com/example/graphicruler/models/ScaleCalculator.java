package com.example.graphicruler.models;

public class ScaleCalculator {
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
    /*public void setScale(float scale) {
        this.scale = scale;
    }*/

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

    /*public int getUnitHeight() {//estos metodos deberian ser accesibles solo por paquete?
        return Math.round(this.unitHeight * (this.rulerUnity/this.scale));
    }*/
    public int getUnitHeight() {
        return Math.round(this.unitHeight * (this.rulerUnity / this.scale.getHeight())); // QUE LA OPERACION SE HAGA AQUI Y NO EN EL ENUMERADO
    }

    public int getObjectScaleHeight() {
        return Math.round(this.unitHeight * (this.rulerUnity / this.scale.getScale()) * 2);//TODO RESOLVER ESTE NUMERO NAGICO... TAL VEZ LO OBJETOS DEBERIAN DE SER ENUMERADOS???
    }

    public void setUnitHeight(float deviceHeight) {
        this.unitHeight = Math.round((deviceHeight / this.INCHES_TO_CENTIMETERS));
    }

    /*public float getScale() {
        return scale;
    }*/
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
        System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n ::::::::::::::::::::::::::::::::::::::::::::" + (int) (this.calculateFromResult(this.totalScreenHeightInCentimeters(totalScreenHeightInInches)) / this.scale.getUnitHeightFactor()) );
        return (int) (this.calculateFromResult(this.totalScreenHeightInCentimeters(totalScreenHeightInInches)) / this.scale.getUnitHeightFactor());
        //return (int) Math.ceil((totalScreenHeightInInches * this.INCHES_TO_CENTIMETERS * (this.scale.getScale() / this.rulerUnity)) / this.scale.getUnitHeightFactor());
        //return result * scale.getScale() / rulerUnity (float) Math.ceil(totalScreenHeightInInches * this.INCHES_TO_CENTIMETERS)
    }

    private float totalScreenHeightInCentimeters(int totalScreenHeightInInches) {
        return (float) Math.ceil(totalScreenHeightInInches * this.INCHES_TO_CENTIMETERS);
    }
}