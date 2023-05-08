package com.sas.graphicruler.views;

import android.content.Context;
import android.os.Build;

import com.sas.graphicruler.controllers.ConfigScaleController;
import com.sas.graphicruler.databinding.ActivityMainBinding;
import com.sas.graphicruler.models.ScalimeterBoard;

public class View {
    private final ActivityMainBinding activityMainViewBinding;
    private final ScaleCalculatorView scaleCalculatorView;
    private final GraphicElementsView graphicElementsView;
    private final ConfigScaleController configScaleController;
    private final ScaleMenu scaleMenu;


    public View(ActivityMainBinding activityMainViewBinding, Context context) {
        com.sas.graphicruler.views.Context.init(context);
        this.activityMainViewBinding = activityMainViewBinding;
        ScalimeterBoard scalimeterBoard = new ScalimeterBoard(this.getScale());
        this.configScaleController = new ConfigScaleController(scalimeterBoard);
        this.scaleCalculatorView = new ScaleCalculatorView(scalimeterBoard, activityMainViewBinding);
        this.graphicElementsView = new GraphicElementsView(this.configScaleController, activityMainViewBinding);
        this.scaleMenu = new ScaleMenu(this.configScaleController.getScale(),this.configScaleController);
        this.graphicElementsView.graphicsInit(this.scaleMenu.getRulerSetter(this.configScaleController.getScale()));
        dataForTestDevices();
    }

    //TODO ESTE METODO SE TIENE QUE IR AL ENTRAR EN PRODUCCION
    private void dataForTestDevices() {
        StringBuilder screenData = new StringBuilder();
        screenData.append("Test_06\n");
        screenData.append(com.sas.graphicruler.views.Context.getDeviceHeight()).append(" Y Density Per in\n");
        screenData.append(com.sas.graphicruler.views.Context.getTotalDeviceHeight()).append("px H\n");
        screenData.append(com.sas.graphicruler.views.Context.getRealTotalScreenHeightInInches()).append("in real H\n");
        screenData.append(com.sas.graphicruler.views.Context.getRealTotalScreenHeightInInches()*2.54).append("cm real H\n");
        screenData.append(com.sas.graphicruler.views.Context.getTotalScreenHeightInInches()).append("in for APP H\n");
        screenData.append("A"+ Build.VERSION.RELEASE + " SDK " + Build.VERSION.SDK_INT +"\n");
        screenData.append(Build.MODEL+ " ("+Build.MANUFACTURER +")"+"\n");
        screenData.append("Nota: Los datos recogidos de la pantalla no incluyen la altura de las barras de la UI que han sido ocultadas" +
                ", por lo mismo la H for APP se redondea hacia arriba y se suma 1in");
        this.activityMainViewBinding.screenData.setText(screenData);
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