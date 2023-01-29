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
    private final ConfigScaleController configScaleController;
    private final Context context;
    //EL CONTEXT TIENE QUE SER UN SINGLETON!!!!!!!!!!!!!!!

    public GraphicElementsView(ScalimeterBoard scalimeterBoard, ActivityMainBinding activityMainViewBinding, Context context) {
        this.activityMainViewBinding = activityMainViewBinding;
        this.rulerRecyclerAdapter = new RulerRecyclerAdapter(context);
        this.graphicScaleRecyclerAdapter = new GraphicScaleRecyclerAdapter(context);
        this.context = context;
        this.configScaleController = new ConfigScaleController(scalimeterBoard);
        this.graphicsInit();
        this.setScale();
    }

    private void graphicsInit(){
        graphicRuler(this.activityMainViewBinding.rulerRecyclerView,this.rulerRecyclerAdapter);
        graphicRuler(this.activityMainViewBinding.graphicScaleRecyclerView,this.graphicScaleRecyclerAdapter);
    }

    private void graphicRuler(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setLayoutManager(this.setManagerForRulers());
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(0);//tal vez este se borra
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

    public void setScale() {
        this.rulerRecyclerAdapter.setScaledHeight(this.getUnitHeight());//este es el que tengo que pasar como parametro para no tener que crear un nuevo ConfigScaleController
        this.rulerRecyclerAdapter.notifyDataSetChanged();
        this.activityMainViewBinding.rulerRecyclerView.scrollToPosition(0);
    }

    private int getUnitHeight() {
        return this.configScaleController.getUnitHeight(this.context.getResources().getDisplayMetrics().ydpi);
    }
}
