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

// LOS ADAPTERS SE PUEDEN REFACTORIZAR CON BUILDERS

public class GraphicScaleRecyclerAdapter extends RecyclerView.Adapter<GraphicScaleRecyclerAdapter.GraphicScaleViewHolder> {
    private final Context context;

    public GraphicScaleRecyclerAdapter() {
        this.context = com.example.graphicruler.views.Context.getInstance();
    }

    @NonNull
    @Override
    public GraphicScaleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.molecule_graphic_scale, parent, false);
        return new GraphicScaleRecyclerAdapter.GraphicScaleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GraphicScaleViewHolder holder, int position) {
        holder.unitGraphicScaleNumberView.setText(String.valueOf(unitNumber(position)));
        setUnitScaleHeight(holder);
        setViewMargins(holder);
    }

    private void setUnitScaleHeight(@NonNull GraphicScaleViewHolder holder) {
        holder.unitGraphicScaleView.setLayoutParams(
                new LinearLayout.LayoutParams(
                        holder.unitGraphicScaleView.getLayoutParams().width,
                        holder.unitGraphicScaleView.getLayoutParams().height * unitHeight(holder.getAdapterPosition())));
    }

    private void setViewMargins(@NonNull GraphicScaleViewHolder holder) {
        if (holder.getAdapterPosition() % 2 == 0) {
            LinearLayout.LayoutParams scaleViewParams = (LinearLayout.LayoutParams) holder.unitGraphicScaleView.getLayoutParams();
            scaleViewParams.setMargins(holder.unitGraphicScaleView.getLayoutParams().width,
                    scaleViewParams.topMargin,
                    scaleViewParams.rightMargin,
                    scaleViewParams.bottomMargin);
            holder.unitGraphicScaleView.setLayoutParams(scaleViewParams);
            LinearLayout.LayoutParams scaleNumberViewParams = (LinearLayout.LayoutParams) holder.unitGraphicScaleNumberView.getLayoutParams();
            scaleNumberViewParams.setMargins(
                    -holder.unitGraphicScaleView.getLayoutParams().width,
                    scaleNumberViewParams.topMargin,
                    scaleNumberViewParams.rightMargin,
                    scaleNumberViewParams.bottomMargin);
            holder.unitGraphicScaleNumberView.setLayoutParams(scaleNumberViewParams);
        }
    }

    private int unitHeight(int position) {
        if (position > 1) {
            if (position == 2) {
                return 3;
            }
            if (position == 3) {
                return 5;
            }
            if (position == 4) {
                return 10;
            }
            if (position == 5) {
                return 30;
            }
            if (position == 6) {
                return 50;
            }

        }
        return 1;
    }

    private int unitNumber(int position) {
        if (position == 3) {
            return 5;
        }
        if (position == 4) {
            return 10;
        }
        if (position == 5) {
            return 20;
        }
        if (position == 6) {
            return 40;
        }
        return position;
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public static class GraphicScaleViewHolder extends RecyclerView.ViewHolder {
        TextView unitGraphicScaleNumberView;
        ImageView unitGraphicScaleView;

        public GraphicScaleViewHolder(@NonNull View itemView) {
            super(itemView);
            this.unitGraphicScaleNumberView = itemView.findViewById(R.id.unit_graphic_scale_number);
            this.unitGraphicScaleView = itemView.findViewById(R.id.unit_graphic_scale);
        }
    }
}
