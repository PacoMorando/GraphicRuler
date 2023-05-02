package com.example.graphicruler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import android.widget.PopupMenu;

import com.example.graphicruler.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private com.example.graphicruler.views.View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.graphicruler.databinding.ActivityMainBinding activityMainViewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainViewBinding.getRoot());
        this.view = new com.example.graphicruler.views.View(activityMainViewBinding, this);
        hideSystemUI();
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

    public void showScaleMenu(View view) {
        PopupMenu scalePopupMenu = new PopupMenu(this, view);
        scalePopupMenu.setOnMenuItemClickListener(this);
        scalePopupMenu.inflate(R.menu.scale_menu);
        scalePopupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.view.setScale(Float.parseFloat(String.valueOf(menuItem)));
        return false;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }
}
