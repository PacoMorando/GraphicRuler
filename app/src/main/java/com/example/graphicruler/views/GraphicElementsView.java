package com.example.graphicruler.views;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graphicruler.R;
import com.example.graphicruler.controllers.ConfigScaleController;
import com.example.graphicruler.databinding.ActivityMainBinding;

public class GraphicElementsView {

    private final ActivityMainBinding activityMainViewBinding;
    private RulerRecyclerAdapter rulerRecyclerAdapter;
    private final GraphicScaleRecyclerAdapter graphicScaleRecyclerAdapter;
    private final ConfigScaleController configScaleController;

    public GraphicElementsView(ConfigScaleController configScaleController, ActivityMainBinding activityMainViewBinding) {
        this.activityMainViewBinding = activityMainViewBinding;
        this.configScaleController = configScaleController;
        this.graphicScaleRecyclerAdapter = new GraphicScaleRecyclerAdapter(new GraphicRulerSetter(configScaleController));
    }

    public void graphicsInit(RulerSetter rulerSetter) {
        this.configScaleController.setUnitHeight(Context.getDeviceHeight());
        this.setScale(rulerSetter);
    }

    private void setRulers(RulerSetter rulerSetter) {
        this.rulerRecyclerAdapter = new RulerRecyclerAdapter(rulerSetter);
        this.graphicRuler(this.activityMainViewBinding.rulerRecyclerView, this.rulerRecyclerAdapter);//aqui va un new
        this.graphicRuler(this.activityMainViewBinding.graphicScaleRecyclerView, this.graphicScaleRecyclerAdapter);
    }

    private void graphicRuler(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setLayoutManager(this.setManagerForRulers());
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(0);
    }

    private LinearLayoutManager setManagerForRulers() {
        LinearLayoutManager rulerLinearLayoutManager = new LinearLayoutManager(Context.getInstance()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rulerLinearLayoutManager.setReverseLayout(true);
        rulerLinearLayoutManager.setStackFromEnd(true);
        return rulerLinearLayoutManager;
    }

    public void setScale(RulerSetter rulerSetter) {
        this.setObjectScale();
        this.setRulers(rulerSetter);
    }

    private void setObjectScale() {
        this.activityMainViewBinding.objectScaleView.setImageResource(this.setObjectScaleImageResource());
        this.activityMainViewBinding.objectScaleView.getLayoutParams().height = this.configScaleController.getObjectScaleHeight();
        this.activityMainViewBinding.objectScaleView.getLayoutParams().width = this.configScaleController.getObjectScaleWidth();
    }

    private int setObjectScaleImageResource() {
        if (this.configScaleController.getObjectScaleDrawableId() == 3) {
            return R.drawable.object_scale_house;
        }
        if (this.configScaleController.getObjectScaleDrawableId() == 1) {
            return R.drawable.object_scale_chair;
        }
        else {
            return R.drawable.object_scale_human;
        }
    }

    /*private int getObjectScaleHeight() {
        return this.configScaleController.getObjectScaleHeight();
    }*/
}
