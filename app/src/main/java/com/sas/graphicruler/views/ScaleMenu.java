package com.sas.graphicruler.views;

import com.sas.graphicruler.controllers.ConfigScaleController;

import java.util.HashMap;

public class ScaleMenu {
    private final String SINGLE_UNITY = "single";
    private final String DOUBLE_UNITY = "double";
    private final String COMPOSE_UNITY = "compose";
    private float scale;
    private final HashMap<String, RulerSetter> rulerSetters = new HashMap<>();

    public ScaleMenu(float scale, ConfigScaleController configScaleController) {
        this.rulerSetters.put(this.COMPOSE_UNITY, new ComposeUnityRulerSetter(configScaleController));
        this.rulerSetters.put(this.DOUBLE_UNITY, new DoubleUnityRulerSetter(configScaleController));
        this.rulerSetters.put(this.SINGLE_UNITY, new SingleUnityRulerSetter(configScaleController));
        this.scale = scale;
    }

    public RulerSetter getRulerSetter(float scale) {
        this.setScale(scale);
        return this.rulerSetters.get(this.pickSetter());
    }

    private void setScale(float scale) {
        this.scale = scale;
    }

    private String pickSetter() {//this method can be refactored
        if (scale == 100f || scale == 125f) {
            return this.SINGLE_UNITY;
        }
        if (scale == 50f || scale == 75f || scale == 500f) {
            return this.DOUBLE_UNITY;
        }
        if (scale == 20f || scale == 25f || scale == 200f || scale == 250f) {
            return this.COMPOSE_UNITY;
        }
        return this.SINGLE_UNITY;
    }
}