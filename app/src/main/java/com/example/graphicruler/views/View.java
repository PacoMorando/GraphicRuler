package com.example.graphicruler.views;

import android.content.Context;

import com.example.graphicruler.controllers.ConfigScaleController;
import com.example.graphicruler.databinding.ActivityMainBinding;
import com.example.graphicruler.models.ScalimeterBoard;

public class View {
    private final ActivityMainBinding activityMainViewBinding;
    private final ScaleCalculatorView scaleCalculatorView;
    private final GraphicElementsView graphicElementsView;
    private final ConfigScaleController configScaleController;
    private final ScaleMenu scaleMenu;


    public View(ActivityMainBinding activityMainViewBinding, Context context) {
        com.example.graphicruler.views.Context.init(context);
        this.activityMainViewBinding = activityMainViewBinding;
        ScalimeterBoard scalimeterBoard = new ScalimeterBoard(this.getScale());
        this.configScaleController = new ConfigScaleController(scalimeterBoard);
        this.scaleCalculatorView = new ScaleCalculatorView(scalimeterBoard, activityMainViewBinding);
        this.graphicElementsView = new GraphicElementsView(this.configScaleController, activityMainViewBinding);
        this.scaleMenu = new ScaleMenu(this.configScaleController.getScale(),this.configScaleController);
        this.graphicElementsView.graphicsInit(this.scaleMenu.getRulerSetter(this.configScaleController.getScale()));
    }

    private float getScale() {
        return Float.parseFloat(String.valueOf(this.activityMainViewBinding.scaleFactor.getText()));
    }

    public void setScale(float scale) {
        this.configScaleController.setScale(scale);
        this.activityMainViewBinding.scaleFactor.setText(String.format("%.0f",scale));//PLANTEARME UN SINGLETON TXTFORMATER
        this.scaleCalculatorView.setScale();
        this.graphicElementsView.setScale(this.scaleMenu.getRulerSetter(scale));
    }
}