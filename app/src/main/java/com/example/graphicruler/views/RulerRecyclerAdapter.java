package com.example.graphicruler.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graphicruler.R;

public class RulerRecyclerAdapter extends RecyclerView.Adapter<RulerRecyclerAdapter.RulerViewHolder> {
    private final Context context;
    private int unitRulerHeight;

    public RulerRecyclerAdapter() {
        this.context = com.example.graphicruler.views.Context.getInstance();
    }

    @NonNull
    @Override
    public RulerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.molecule_ruler_test, parent, false);//Este es el fatoryMetod
        return new RulerViewHolder(view);//RulerViewHolder(this.moleculeForCurrentScaleView);
    }

    @Override
    public void onBindViewHolder(@NonNull RulerViewHolder holder, int position) {
        holder.unitNumberView.setText(String.valueOf(position));
        this.setUnitRulerViewScreenDimensions(holder.unitRulerView);
    }

    private void setUnitRulerViewScreenDimensions(LinearLayout unitRulerView) {//este parametro era un ImageView?
        unitRulerView.getLayoutParams().height = this.unitRulerHeight;
    }

    @Override
    public int getItemCount() {
        return 40;
    }

    public void setScaledHeight(int unitRulerHeight) {
        this.unitRulerHeight = unitRulerHeight;
    }

    static class RulerViewHolder extends RecyclerView.ViewHolder {
        TextView unitNumberView;
        //ImageView unitRulerView;
        LinearLayout unitRulerView;

        public RulerViewHolder(@NonNull View itemView) {
            super(itemView);
            // this.unitNumberView = itemView.findViewById(R.id.unit_number);
            this.unitNumberView = itemView.findViewById(R.id.unit_number_test);
            //this.unitRulerView = itemView.findViewById(R.id.unit_ruler);
            this.unitRulerView = itemView.findViewById(R.id.unit_ruler_test);
        }
    }
}