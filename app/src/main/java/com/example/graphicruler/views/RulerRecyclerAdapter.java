package com.example.graphicruler.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graphicruler.R;

public class RulerRecyclerAdapter extends RecyclerView.Adapter<RulerRecyclerAdapter.RulerViewHolder> {
    private final Context context;
    private float unitRulerHeight;

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
        holder.unitRulerView.setLayoutParams();
    }

    @Override
    public int getItemCount() {
        return 40;
    }

    public void setScaledHeight(int scale) {
        this.unitRulerHeight = (float) (this.context.getResources().getDisplayMetrics().ydpi / 2.54);
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
