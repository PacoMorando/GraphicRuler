package com.example.graphicruler.views;


import com.example.graphicruler.R;
import com.example.graphicruler.controllers.ConfigScaleController;

public class DoubleUnityRulerSetter extends RulerSetter {
    public DoubleUnityRulerSetter(ConfigScaleController configScaleController) {
        super(configScaleController);
    }

    @Override
    public int getView() {
        return R.layout.molecule_double_unity_ruler;
    }

    @Override
    public int getUnitNumberView() {
        return R.id.double_unit_number;
    }

    @Override
    public int getUnitRulerView() {
        return R.id.double_unit_ruler;
    }
}
