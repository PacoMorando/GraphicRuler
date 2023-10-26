package com.sas.graphicruler.views;

import com.sas.graphicruler.controllers.ConfigScaleController;

public abstract class RulerSetter {

    protected final ConfigScaleController configScaleController;

    public RulerSetter(ConfigScaleController configScaleController){
        this.configScaleController = configScaleController;
    }
    public abstract int getView();

    public  String getPositionValue(int position){
        return this.configScaleController.getRulerPositionValue(position);
    }

    public int getUnitRulerHeight() {
        return this.configScaleController.getUnitHeight();
    }

    public int getItemCount() {
        return this.configScaleController.getItemCount(Context.getTotalScreenHeightInInches());
    }

    public abstract int getUnitNumberView();

    public abstract int getUnitRulerView();
}
