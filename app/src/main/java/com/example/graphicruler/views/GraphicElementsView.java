package com.example.graphicruler.views;


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
        //this.graphicsInit();//este metodo lo lanzo desde fuera
    }

    public void graphicsInit(RulerSetter rulerSetter) {
        this.configScaleController.setUnitHeight(Context.getDeviceHeight());
        this.setScale(rulerSetter);// a menos de que lance este metodo despues de crearlo
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

    public void setScale(RulerSetter rulerSetter) {
        this.setObjectScaleHeight(this.getObjectScaleHeight());
        this.rulerRecyclerAdapter.setRuler(rulerSetter);
        this.rulerRecyclerAdapter.notifyDataSetChanged();//quiza este metodo va dentro del adater
        this.activityMainViewBinding.rulerRecyclerView.scrollToPosition(0);
        //this.graphicScaleRecyclerAdapter.setRuler(rulerSetter); FALTA ESTE METODO
    }
    /*public void setScale() { //ESTE METODO SE DEBE ELIMINAR TRAS ARREGLAR LA LINEA 27
        this.setObjectScaleHeight(this.getObjectScaleHeight());
        this.rulerRecyclerAdapter.setRuler(this.getUnitHeight());//Este metodo deberan ser setRuler(rulerSetter);
        this.rulerRecyclerAdapter.notifyDataSetChanged();//quiza este metodo va dentro del adater
        this.activityMainViewBinding.rulerRecyclerView.scrollToPosition(0);
        //this.graphicScaleRecyclerAdapter.setRuler(rulerSetter); FALTA ESTE METODO
    }*/

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
