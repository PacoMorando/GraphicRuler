package com.example.graphicruler.views;

import com.example.graphicruler.R;
import com.example.graphicruler.controllers.ConfigScaleController;

public class SingleUnityRulerSetter extends RulerSetter {

    public SingleUnityRulerSetter(ConfigScaleController configScaleController) {
        super(configScaleController);
    }

    @Override
    public int getView() {
        return R.layout.molecule_single_unity_ruler;
    }

    @Override
    public String getPositionValue(int position) {
        return String.valueOf(position);
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
