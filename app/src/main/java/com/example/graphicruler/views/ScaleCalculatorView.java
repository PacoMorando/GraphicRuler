package com.example.graphicruler.views;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.graphicruler.controllers.CalculateFromResultController;
import com.example.graphicruler.controllers.CalculateFromUnityController;
import com.example.graphicruler.controllers.ConfigScaleController;
import com.example.graphicruler.databinding.ActivityMainBinding;
import com.example.graphicruler.models.ScalimeterBoard;

public class ScaleCalculatorView {
    private final CalculateFromUnityController calculateFromUnityController;
    private final CalculateFromResultController calculateFromResultController;
    private final ConfigScaleController configScaleController;//este a lo mejor no va aqui
    private EditText unities;
    private EditText scaledUnities;

    public ScaleCalculatorView(ScalimeterBoard scalimeterBoard, ActivityMainBinding activityMainViewBinding) {
        this.calculateFromUnityController = new CalculateFromUnityController(scalimeterBoard);
        this.calculateFromResultController = new CalculateFromResultController(scalimeterBoard);
        this.configScaleController = new ConfigScaleController(scalimeterBoard);
        this.unities = activityMainViewBinding.unities;
        this.scaledUnities = activityMainViewBinding.scaledUnities;
    }

    public String calculateFromUnity(String unity) {
        return this.calculateFromUnityController.calculateFromUnity(Float.parseFloat(unity));
    }

    public String calculateFromResult(String result) {
        return this.calculateFromResultController.calculateFromResult(Float.parseFloat(result));
    }


    public void setScale(int scale) {
        this.setScaledUnitiesResult();
        this.setUnitiesResult();
        configScaleController.setScale(scale);
    }

    public TextWatcher getUnitiesWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (unities.hasFocus()) {
                    setScaledUnitiesResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    public TextWatcher getScaledUnitiesWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //CAMBIAR NOMBRE A LA CLASE, NO DEBERIA DE SER "FROM RESULT"
                if (scaledUnities.hasFocus()) {
                    setUnitiesResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
    }
    public void setUnitiesResult() {
        if (this.scaledUnities.getText().length() == 0) {
            this.unities.setText("0");
        }
        if (this.scaledUnities.getText().length() != 0) {
            this.unities.setText(this.calculateFromResult(String.valueOf(this.unities.getText())));
        }
    }

    public void setScaledUnitiesResult() {
        if (this.unities.getText().length() == 0) {
            this.scaledUnities.setText("0");
        }
        if (this.unities.getText().length() != 0) {
            this.scaledUnities.setText(this.calculateFromUnity(String.valueOf(this.unities.getText())));
        }
    }
}
