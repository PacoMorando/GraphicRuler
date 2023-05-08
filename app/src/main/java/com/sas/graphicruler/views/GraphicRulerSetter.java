package com.sas.graphicruler.views;

import com.sas.graphicruler.controllers.ConfigScaleController;

public class GraphicRulerSetter extends RulerSetter {
    public GraphicRulerSetter(ConfigScaleController configScaleController) {
        super(configScaleController);
    }

    public int getUnitRulerHeight(int position) {
        return this.configScaleController.getGraphicRulerUnitHeight(position);
    }

    public String getPositionValue(int position) {
        return this.configScaleController.getGraphicRulerPositionValue(position);
    }

    @Override
    public int getItemCount() {
        return this.configScaleController.getGraphicRulerItemCount();
    }

    @Override
    public int getView() {
        return 0;
    }

    @Override
    public int getUnitNumberView() {
        return 0;
    }

    @Override
    public int getUnitRulerView() {
        return 0;
    }
}
