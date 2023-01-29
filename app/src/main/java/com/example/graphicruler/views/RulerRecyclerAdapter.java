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
    private int unitRulerHeight; //este no debe de ir incialiczado, el valor se debe pasar al iniciar la app

    public RulerRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RulerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.molecule_ruler, parent, false);
        return new RulerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RulerViewHolder holder, int position) {
        holder.unitNumberView.setText(String.valueOf(position));
        this.setUnitRulerViewScreenDimensions(holder.unitRulerView);
    }

    private void setUnitRulerViewScreenDimensions(ImageView unitRulerView) {
        unitRulerView.setLayoutParams(new LinearLayout.LayoutParams(this.unitRulerWidth(), this.unitRulerHeight));
        // un metodo para el height y falta un metodo para el width
    }

    private int unitRulerWidth() {
        return Math.toIntExact(Math.round(this.unitRulerHeight * 0.6));
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
        ImageView unitRulerView;

        public RulerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.unitNumberView = itemView.findViewById(R.id.unit_number);
            this.unitRulerView = itemView.findViewById(R.id.unit_ruler);
        }
    }
}
