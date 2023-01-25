package com.example.graphicruler.views;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graphicruler.controllers.ConfigScaleController;
import com.example.graphicruler.databinding.ActivityMainBinding;
import com.example.graphicruler.models.ScalimeterBoard;

public class GraphicElementsView {

    private final ActivityMainBinding activityMainViewBinding;
    private final RulerRecyclerAdapter rulerRecyclerAdapter;
    private final GraphicScaleRecyclerAdapter graphicScaleRecyclerAdapter;
    private ConfigScaleController configScaleController;
    private final Context context;
    //EL CONTEXT TIENE QUE SER UN SINGLETON!!!!!!!!!!!!!!!

    public GraphicElementsView(ScalimeterBoard scalimeterBoard, ActivityMainBinding activityMainViewBinding, Context context) {
        this.activityMainViewBinding = activityMainViewBinding;
        this.rulerRecyclerAdapter = new RulerRecyclerAdapter(context);
        this.graphicScaleRecyclerAdapter = new GraphicScaleRecyclerAdapter(context);
        this.context = context;
        this.graphicsInit();
        this.configScaleController = new ConfigScaleController(scalimeterBoard);
    }

    private void graphicsInit(){
        graphicRuler(this.activityMainViewBinding.rulerRecyclerView,this.rulerRecyclerAdapter);
        graphicRuler(this.activityMainViewBinding.graphicScaleRecyclerView,this.graphicScaleRecyclerAdapter);
    }

    private void graphicRuler(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setLayoutManager(this.setManagerForRulers());
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(0);
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

    public void setScale(int scale) {
        this.rulerRecyclerAdapter.setScaledHeight(scale);//Este metodo debe reiniciar el adapter con nuevos datos
    }

    private float getDeviceHeightDensity() {
        return this.context.getResources().getDisplayMetrics().ydpi;
    }
}
