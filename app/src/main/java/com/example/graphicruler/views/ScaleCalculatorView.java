package com.example.graphicruler.views;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.graphicruler.controllers.CalculateFromScaledUnityController;
import com.example.graphicruler.controllers.CalculateFromUnityController;
import com.example.graphicruler.controllers.ConfigScaleController;
import com.example.graphicruler.databinding.ActivityMainBinding;
import com.example.graphicruler.models.ScalimeterBoard;

public class ScaleCalculatorView {
    private final CalculateFromUnityController calculateFromUnityController;
    private final CalculateFromScaledUnityController calculateFromScaledUnityController;
    private final ConfigScaleController configScaleController;//este a lo mejor no va aqui
    private final EditText unities;
    private final EditText scaledUnities;

    public ScaleCalculatorView(ScalimeterBoard scalimeterBoard, ActivityMainBinding activityMainViewBinding) {
        this.calculateFromUnityController = new CalculateFromUnityController(scalimeterBoard);
        this.calculateFromScaledUnityController = new CalculateFromScaledUnityController(scalimeterBoard);
        this.configScaleController = new ConfigScaleController(scalimeterBoard);
        this.unities = activityMainViewBinding.unities;
        this.scaledUnities = activityMainViewBinding.scaledUnities;
    }


    public void setScale(int scale) {
        configScaleController.setScale(scale);
        this.setScaledUnitiesResult();
        this.setUnitiesResult();
    }

    public TextWatcher getUnitiesWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (unities.hasFocus()) {
                    setScaledUnitiesResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        };
    }

    public TextWatcher getScaledUnitiesWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (scaledUnities.hasFocus()) {
                    setUnitiesResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        };
    }

    private void setUnitiesResult() {
        if (this.scaledUnities.getText().length() == 0) {
            this.unities.setText("0");
        }
        if (this.scaledUnities.getText().length() != 0) {
            this.unities.setText(this.calculateFromResult(String.valueOf(this.scaledUnities.getText())));
        }
    }
    private void setScaledUnitiesResult() {
        if (this.unities.getText().length() == 0) {
            this.scaledUnities.setText("0");
        }
        if (this.unities.getText().length() != 0) {
            this.scaledUnities.setText(this.calculateFromUnity(String.valueOf(this.unities.getText())));
        }
    }

    private String calculateFromResult(String result) {
        return this.calculateFromScaledUnityController.calculateFromResult(Float.parseFloat(result));
    }

    private String calculateFromUnity(String unity) {
        return this.calculateFromUnityController.calculateFromUnity(Float.parseFloat(unity));
    }
}