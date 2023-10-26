package com.sas.graphicruler.views;

import com.sas.graphicruler.R;
import com.sas.graphicruler.controllers.ConfigScaleController;

public class ComposeUnityRulerSetter extends RulerSetter {

    public ComposeUnityRulerSetter(ConfigScaleController configScaleController) {
        super(configScaleController);
    }

    @Override
    public int getView() {
        return R.layout.molecule_compose_unity_ruler;
    }

    @Override
    public int getUnitNumberView() {
        return R.id.compose_unit_number;
    }

    @Override
    public int getUnitRulerView() {
        return R.id.compose_unit_ruler;
    }
}
