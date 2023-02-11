package com.example.graphicruler.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graphicruler.R;

public class RulerRecyclerAdapter extends RecyclerView.Adapter<RulerRecyclerAdapter.RulerViewHolder> {
    private final Context context;
   // private int unitRulerHeight;
    private RulerSetter rulerSetter;

    public RulerRecyclerAdapter() {
        this.context = com.example.graphicruler.views.Context.getInstance();
    }

    @NonNull
    @Override
    public RulerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(rulerSetter.getView(), parent, false);
        return new RulerViewHolder(view,this.rulerSetter);//RulerViewHolder(this.moleculeForCurrentScaleView);
    }

    @Override
    public void onBindViewHolder(@NonNull RulerViewHolder holder, int position) {
        //holder.unitNumberView.setText(String.valueOf(position));
        holder.unitNumberView.setText(this.rulerSetter.getPositionValue(position));
        //this.setUnitRulerViewScreenDimensions(holder.unitRulerView);
        this.setUnitRulerViewScreenDimensions(holder.unitRulerView);
    }

    private void setUnitRulerViewScreenDimensions(LinearLayout unitRulerView) {//este es un metodo del rulerSetter???
        unitRulerView.getLayoutParams().height = this.rulerSetter.getUnitRulerHeight();
    }

    @Override
    public int getItemCount() {
        return this.rulerSetter.getItemCount();//falta desarrollar este metodo
    }

    public void setRuler(RulerSetter rulerSetter) {
        this.rulerSetter = rulerSetter;
    }
   /* public void setRuler(int unitRulerHeight) {// ESTE METODO SE DEBE BORRAR UNA VEZ ARREGLADA LA LINEA 27 DE GraphElmViw
        this.unitRulerHeight = unitRulerHeight;
    }*/

    static class RulerViewHolder extends RecyclerView.ViewHolder {
        TextView unitNumberView;
        LinearLayout unitRulerView;

        public RulerViewHolder(@NonNull View itemView, RulerSetter rulerSetter) {
            super(itemView);
            this.unitNumberView = itemView.findViewById(rulerSetter.getUnitNumberView());
            this.unitRulerView = itemView.findViewById(rulerSetter.getUnitRulerView());
        }
    }
}