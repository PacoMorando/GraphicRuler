package com.example.graphicruler.views;

import android.view.View;

import com.example.graphicruler.controllers.ConfigScaleController;

public class ComposeUnityRulerSetter extends RulerSetter {

    public ComposeUnityRulerSetter(ConfigScaleController configScaleController) {
        super(configScaleController);
    }

    @Override
    public int getView() {
        //View view = LayoutInflater.from(context).inflate(R.layout.molecule_ruler_test, parent, false);
        return 0;
    }

    @Override
    public String getPositionValue(int position) {
        return null;
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
