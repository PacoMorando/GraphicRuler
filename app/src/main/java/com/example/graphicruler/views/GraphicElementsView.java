package com.example.graphicruler.views;

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

    public GraphicElementsView(ScalimeterBoard scalimeterBoard, ActivityMainBinding activityMainViewBinding) {
        this.activityMainViewBinding = activityMainViewBinding;
        this.rulerRecyclerAdapter = new RulerRecyclerAdapter();
        this.graphicScaleRecyclerAdapter = new GraphicScaleRecyclerAdapter();
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
        this.rulerRecyclerAdapter.setScaledHeight(this.getUnitHeight());//este es el que tengo que pasar como parametro para no tener que crear un nuevo ConfigScaleController
        this.rulerRecyclerAdapter.notifyDataSetChanged();
        this.activityMainViewBinding.rulerRecyclerView.scrollToPosition(0);
    }

    private int getUnitHeight() {
        return this.configScaleController.getUnitHeight(Context.getInstance().getResources().getDisplayMetrics().ydpi);//Aqui hay un metodo para el singleton
    }
}
