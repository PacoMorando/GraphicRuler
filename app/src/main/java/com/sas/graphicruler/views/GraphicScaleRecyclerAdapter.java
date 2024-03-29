package com.sas.graphicruler.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sas.graphicruler.R;


public class GraphicScaleRecyclerAdapter extends RecyclerView.Adapter<GraphicScaleRecyclerAdapter.GraphicScaleViewHolder> {
    private final Context context;
    private final GraphicRulerSetter graphicRulerSetter;

    public GraphicScaleRecyclerAdapter(GraphicRulerSetter rulerSetter) {
        this.context = com.sas.graphicruler.views.Context.getInstance();
        this.graphicRulerSetter = rulerSetter;
    }

    @NonNull
    @Override
    public GraphicScaleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.molecule_graphic_scale, parent, false);
        return new GraphicScaleRecyclerAdapter.GraphicScaleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GraphicScaleViewHolder holder, int position) {
        holder.unitGraphicScaleNumberView.setText(String.valueOf(this.graphicRulerSetter.getPositionValue(position)));
        setUnitScaleHeight(holder);
        setViewMargins(holder);
    }

   private void setUnitScaleHeight(@NonNull GraphicScaleViewHolder holder) {
        holder.unitGraphicScaleView.setLayoutParams(
                new LinearLayout.LayoutParams(
                        holder.unitGraphicScaleView.getLayoutParams().width,
                        this.graphicRulerSetter.getUnitRulerHeight(holder.getAdapterPosition())));
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

    @Override
    public int getItemCount() {
        return 6;
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
