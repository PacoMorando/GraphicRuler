package com.example.graphicruler.views;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.graphicruler.databinding.ActivityMainBinding;
import com.example.graphicruler.models.GraphicElement;
import com.example.graphicruler.models.ScalimeterBoard;

public class View {
    private final ActivityMainBinding activityMainViewBinding;
    private final Context context;
    private final ScaleCalculatorView scaleCalculatorView;
    private GraphicElementsView graphicElementsView;

    public View(ActivityMainBinding activityMainViewBinding, Context context) {
        this.activityMainViewBinding = activityMainViewBinding;
        this.context = context;
        ScalimeterBoard scalimeterBoard = new ScalimeterBoard(this.getScaleFactor());
        this.scaleCalculatorView = new ScaleCalculatorView(scalimeterBoard, activityMainViewBinding);
    }

    private float getScaleFactor() {
        return Float.parseFloat(String.valueOf(this.activityMainViewBinding.scaleFactor.getText()));
    }

    public void viewInit() {
        rulerInit();
        graphicScaleInit();
        this.activityMainViewBinding.unities.addTextChangedListener(this.scaleCalculatorView.getUnitiesWatcher());
        /*this.activityMainViewBinding.unities.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (activityMainViewBinding.unities.hasFocus()) {
                    setScaledUnitiesResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });*/

        this.activityMainViewBinding.scaledUnities.addTextChangedListener(scaleCalculatorView.getScaledUnitiesWatcher());

        /*new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //CAMBIAR NOMBRE A LA CLASE, NO DEBERIA DE SER "FROM RESULT"
                if (activityMainViewBinding.scaledUnities.hasFocus()) {
                    setUnitiesResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        }*/
    }

    //ESTOS METODOS SE REPITEN, REFACTORIZAR
    private void rulerInit() {
        this.activityMainViewBinding.rulerRecyclerView.setLayoutManager(this.setManagerForRulers());
        RulerRecyclerAdapter rulerRecyclerAdapter = new RulerRecyclerAdapter(this.context);
        this.activityMainViewBinding.rulerRecyclerView.setAdapter(rulerRecyclerAdapter);
        this.activityMainViewBinding.rulerRecyclerView.scrollToPosition(0);
    }

    private void graphicScaleInit() {
        this.activityMainViewBinding.graphicScaleRecyclerView.setLayoutManager(this.setManagerForRulers());
        GraphicScaleRecyclerAdapter graphicScaleRecyclerAdapter = new GraphicScaleRecyclerAdapter(this.context);
        this.activityMainViewBinding.graphicScaleRecyclerView.setAdapter(graphicScaleRecyclerAdapter);
        this.activityMainViewBinding.graphicScaleRecyclerView.scrollToPosition(0);
    }

    private LinearLayoutManager setManagerForRulers() {
        LinearLayoutManager rulerLinearLayoutManager = new LinearLayoutManager(this.context) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rulerLinearLayoutManager.setReverseLayout(true);
        rulerLinearLayoutManager.setStackFromEnd(true);
        return rulerLinearLayoutManager;
    }

   /* public void setUnitiesResult() {
        if (this.activityMainViewBinding.scaledUnities.getText().length() == 0) {
            this.activityMainViewBinding.unities.setText("0");
        }
        if (this.activityMainViewBinding.scaledUnities.getText().length() != 0) {
            this.activityMainViewBinding.unities.setText(this.scaleCalculatorView.calculateFromResult(String.valueOf(this.activityMainViewBinding.unities.getText())));
        }
    }

    public void setScaledUnitiesResult() {
        if (activityMainViewBinding.unities.getText().length() == 0) {
            activityMainViewBinding.scaledUnities.setText("0");
        }
        if (activityMainViewBinding.unities.getText().length() != 0) {
            activityMainViewBinding.scaledUnities.setText(this.scaleCalculatorView.calculateFromUnity(String.valueOf(this.activityMainViewBinding.unities.getText())));
        }
    }*/

    public void setScale(MenuItem menuItem) {
        this.activityMainViewBinding.scaleFactor.setText(menuItem.getTitle());
        this.scaleCalculatorView.setScale(Integer.parseInt((String) menuItem.getTitle()));
        /*this.setScaledUnitiesResult();
        this.setUnitiesResult();*/
    }
}