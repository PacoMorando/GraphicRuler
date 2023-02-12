package com.example.graphicruler.views;

import android.view.View;

import com.example.graphicruler.R;
import com.example.graphicruler.controllers.ConfigScaleController;

public class ComposeUnityRulerSetter extends RulerSetter {

    public ComposeUnityRulerSetter(ConfigScaleController configScaleController) {
        super(configScaleController);
    }

    @Override
    public int getView() {
        return R.layout.molecule_compose_unity_ruler;
    }

    /*@Override
    public String getPositionValue(int position) {
        return String.valueOf(position);//este no deber de retornar position, debe retornar una operacion A LO MEJOR ES UN METODO DEL PADRE
    }*/

    @Override
    public int getUnitNumberView() {
        return R.id.compose_unit_number;
    }

    @Override
    public int getUnitRulerView() {
        return R.id.compose_unit_ruler;
    }
}