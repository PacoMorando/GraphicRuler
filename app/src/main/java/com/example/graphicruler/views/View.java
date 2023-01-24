package com.example.graphicruler.views;

import android.content.Context;
import android.view.MenuItem;


import com.example.graphicruler.databinding.ActivityMainBinding;
import com.example.graphicruler.models.ScalimeterBoard;

public class View {
    private final ActivityMainBinding activityMainViewBinding;
    private final ScaleCalculatorView scaleCalculatorView;
    private final GraphicElementsView graphicElementsView;

    public View(ActivityMainBinding activityMainViewBinding, Context context) {
        this.activityMainViewBinding = activityMainViewBinding;
        ScalimeterBoard scalimeterBoard = new ScalimeterBoard(this.getScaleFactor());
        this.scaleCalculatorView = new ScaleCalculatorView(scalimeterBoard, activityMainViewBinding);
        this.graphicElementsView = new GraphicElementsView(scalimeterBoard, activityMainViewBinding, context);
    }

    private float getScaleFactor() {
        return Float.parseFloat(String.valueOf(this.activityMainViewBinding.scaleFactor.getText()));
    }

    public void viewInit() {
        //this.graphicElementsView.graphicsInit();
        this.activityMainViewBinding.unities.addTextChangedListener(this.scaleCalculatorView.getUnitiesWatcher());
        this.activityMainViewBinding.scaledUnities.addTextChangedListener(this.scaleCalculatorView.getScaledUnitiesWatcher());
    }

    public void setScale(MenuItem menuItem) {
        int scale = Integer.parseInt((String) menuItem.getTitle());
        this.activityMainViewBinding.scaleFactor.setText(menuItem.getTitle());
        this.scaleCalculatorView.setScale(scale);
        this.graphicElementsView.setScale();
    }
}