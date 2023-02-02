package com.example.graphicruler.views;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graphicruler.controllers.ConfigScaleController;
import com.example.graphicruler.databinding.ActivityMainBinding;

public class GraphicElementsView {

    private final ActivityMainBinding activityMainViewBinding;
    private final RulerRecyclerAdapter rulerRecyclerAdapter;
    private final GraphicScaleRecyclerAdapter graphicScaleRecyclerAdapter;
    private final ConfigScaleController configScaleController;

    public GraphicElementsView(ConfigScaleController configScaleController, ActivityMainBinding activityMainViewBinding) {
        this.activityMainViewBinding = activityMainViewBinding;
        this.rulerRecyclerAdapter = new RulerRecyclerAdapter();
        this.graphicScaleRecyclerAdapter = new GraphicScaleRecyclerAdapter();
        this.configScaleController = configScaleController;
        this.graphicsInit();
    }

    private void graphicsInit() {
        this.configScaleController.setUnitHeight(Context.getDeviceHeight());
        this.setScale();
        graphicRuler(this.activityMainViewBinding.rulerRecyclerView, this.rulerRecyclerAdapter);
        graphicRuler(this.activityMainViewBinding.graphicScaleRecyclerView, this.graphicScaleRecyclerAdapter);
    }

    private void graphicRuler(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setLayoutManager(this.setManagerForRulers());
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(0);//tal vez este se borra
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

    public void setScale() {
        this.setObjectScaleHeight(this.getObjectScaleHeight());
        this.rulerRecyclerAdapter.setScaledHeight(this.getUnitHeight());
        this.rulerRecyclerAdapter.notifyDataSetChanged();
        this.activityMainViewBinding.rulerRecyclerView.scrollToPosition(0);
        //Me fatla setear la graphic scale y me falta setear el objectScale
    }

    private void setObjectScaleHeight(int objectScaleHeight) {
        this.activityMainViewBinding.objectScaleView.getLayoutParams().height = objectScaleHeight;
        this.activityMainViewBinding.objectScaleView.getLayoutParams().width = objectScaleHeight;
    }

    private int getObjectScaleHeight() {
        return this.configScaleController.getObjectScaleHeight();
    }

    private int getUnitHeight() {
        return this.configScaleController.getUnitHeight();
    }
}
