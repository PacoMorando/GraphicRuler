package com.example.graphicruler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.graphicruler.databinding.ActivityMainBinding;
import com.example.graphicruler.views.GraphicScaleRecyclerAdapter;
import com.example.graphicruler.views.RulerRecyclerAdapter;


public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        hideSystemUI();
        rulerInit();
        graphicScaleInit();
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    //ESTOS METODOS SE REPITEN, REFACTORIZAR
    private void rulerInit() {
        this.activityMainBinding.rulerRecyclerView.setLayoutManager(this.setManagerForRulers());
        RulerRecyclerAdapter rulerRecyclerAdapter = new RulerRecyclerAdapter(this);
        this.activityMainBinding.rulerRecyclerView.setAdapter(rulerRecyclerAdapter);
        this.activityMainBinding.rulerRecyclerView.scrollToPosition(0);
    }

    private void graphicScaleInit() {
        this.activityMainBinding.graphicScaleRecyclerView.setLayoutManager(this.setManagerForRulers());
        GraphicScaleRecyclerAdapter graphicScaleRecyclerAdapter = new GraphicScaleRecyclerAdapter(this);
        this.activityMainBinding.graphicScaleRecyclerView.setAdapter(graphicScaleRecyclerAdapter);
        this.activityMainBinding.graphicScaleRecyclerView.scrollToPosition(0);
    }

    private LinearLayoutManager setManagerForRulers(){
        LinearLayoutManager rulerLinearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rulerLinearLayoutManager.setReverseLayout(true);
        rulerLinearLayoutManager.setStackFromEnd(true);
        return rulerLinearLayoutManager;
    }

    //Este es para que se escondan las barras aunque se cambie de focus (que pase la aplicación a segundo plano)
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    public void showScaleMenu(View view) {
        PopupMenu scalePopupMenu = new PopupMenu(this,view);
        scalePopupMenu.setOnMenuItemClickListener(this);
        scalePopupMenu.inflate(R.menu.scale_menu);
        scalePopupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }

}

   /* private void rulerInit() {
        RecyclerView rulerRecyclerView = findViewById(R.id.ruler_recycler_view);
        LinearLayoutManager rulerLinearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        this.activityMainBinding.rulerRecyclerView;
        rulerLinearLayoutManager.setReverseLayout(true);
        rulerLinearLayoutManager.setStackFromEnd(true);
        rulerRecyclerView.setLayoutManager(rulerLinearLayoutManager);
        RulerRecyclerAdapter rulerRecyclerAdapter = new RulerRecyclerAdapter(this);
        rulerRecyclerView.setAdapter(rulerRecyclerAdapter);
        rulerRecyclerView.scrollToPosition(0);
    }*/

 /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemUI();
        rulerInit();
        graphicScaleInit();*/

   /* private void graphicScaleInit() {
        RecyclerView graphicScaleView = findViewById(R.id.graphic_scale_recycler_view);
        LinearLayoutManager graphicScaleLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        graphicScaleLayoutManager.setReverseLayout(true);
        graphicScaleLayoutManager.setStackFromEnd(true);
        graphicScaleView.setLayoutManager(graphicScaleLayoutManager);
        GraphicScaleRecyclerAdapter graphicScaleRecyclerAdapter = new GraphicScaleRecyclerAdapter(this);
        graphicScaleView.setAdapter(graphicScaleRecyclerAdapter);
        graphicScaleView.scrollToPosition(0);
    }*/
