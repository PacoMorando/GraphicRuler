package com.sas.graphicruler.views;

import com.sas.graphicruler.R;
import com.sas.graphicruler.controllers.ConfigScaleController;

public class SingleUnityRulerSetter extends RulerSetter {

    public SingleUnityRulerSetter(ConfigScaleController configScaleController) {
        super(configScaleController);
    }

    @Override
    public int getView() {
        return R.layout.molecule_single_unity_ruler;
    }

    @Override
    public int getUnitNumberView() {
        return R.id.single_unit_number;
    }

    @Override
    public int getUnitRulerView() {
        return R.id.single_unit_ruler;
    }
}
