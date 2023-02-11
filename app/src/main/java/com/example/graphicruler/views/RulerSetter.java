package com.example.graphicruler.views;

import android.view.View;

import com.example.graphicruler.controllers.ConfigScaleController;

public abstract class RulerSetter {

    private final ConfigScaleController configScaleController;

    public RulerSetter(ConfigScaleController configScaleController){
        this.configScaleController = configScaleController;
    }
    public abstract int getView();

    public abstract String getPositionValue(int position);

    public int getUnitRulerHeight() {
        return this.configScaleController.getUnitHeight();
    }

    public int getItemCount() {
        return this.configScaleController.getItemCount();
    }

    public abstract int getUnitNumberView();

    public abstract int getUnitRulerView();
}
