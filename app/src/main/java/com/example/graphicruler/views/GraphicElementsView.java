package com.example.graphicruler.views;

import android.content.Context;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graphicruler.controllers.ConfigScaleController;
import com.example.graphicruler.databinding.ActivityMainBinding;
import com.example.graphicruler.models.ScalimeterBoard;

public class GraphicElementsView {

    private final ActivityMainBinding activityMainViewBinding;
    //private final RecyclerView rulerRecyclerView;
    //private final RecyclerView graphicScaleRecyclerView;
    //private ImageView objectScaleView;
    private final RulerRecyclerAdapter rulerRecyclerAdapter;
    private final GraphicScaleRecyclerAdapter graphicScaleRecyclerAdapter;
    private ConfigScaleController configScaleController;
    private final Context context;

    public GraphicElementsView(ScalimeterBoard scalimeterBoard, ActivityMainBinding activityMainViewBinding, Context context) {
        this.activityMainViewBinding = activityMainViewBinding;
        this.rulerRecyclerAdapter = new RulerRecyclerAdapter(context);
        this.graphicScaleRecyclerAdapter = new GraphicScaleRecyclerAdapter(context);
        this.context = context;
        this.graphicsInit();
        this.configScaleController = new ConfigScaleController(scalimeterBoard);
    }

    public void graphicsInit(){
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

    public void setScale() {
        this.rulerRecyclerAdapter.setScaledHeight();//A desarrollar
    }
}
