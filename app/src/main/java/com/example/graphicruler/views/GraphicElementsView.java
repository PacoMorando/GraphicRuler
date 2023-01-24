package com.example.graphicruler.views;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graphicruler.databinding.ActivityMainBinding;
import com.example.graphicruler.models.ScalimeterBoard;

public class GraphicElementsView {

    private final RecyclerView rulerRecyclerView;
    private final RecyclerView graphicScaleRecyclerView;

    public GraphicElementsView(ScalimeterBoard scalimeterBoard, ActivityMainBinding activityMainViewBinding) {
        this.rulerRecyclerView = activityMainViewBinding.rulerRecyclerView;
        this.graphicScaleRecyclerView = activityMainViewBinding.graphicScaleRecyclerView;
    }

    public void graphicsInit(Context context){
        graphicRuler(this.rulerRecyclerView,new RulerRecyclerAdapter(context),context);
        graphicRuler(this.graphicScaleRecyclerView,new GraphicScaleRecyclerAdapter(context),context);
    }

    private void graphicRuler(RecyclerView recyclerView, RecyclerView.Adapter adapter, Context context) {
        recyclerView.setLayoutManager(this.setManagerForRulers(context));
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(0);
    }

    private LinearLayoutManager setManagerForRulers(Context context) {
        LinearLayoutManager rulerLinearLayoutManager = new LinearLayoutManager(context) {
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

    }
}
