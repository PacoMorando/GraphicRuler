package com.sas.graphicruler;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import com.sas.graphicruler.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private com.sas.graphicruler.views.View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.sas.graphicruler.databinding.ActivityMainBinding activityMainViewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainViewBinding.getRoot());
        this.view = new com.sas.graphicruler.views.View(activityMainViewBinding, this);
        hideSystemUI();
    }

    private void hideSystemUI() {
       /* View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);*/
        WindowInsetsControllerCompat windowInsetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        windowInsetsController.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());
        WindowCompat.setDecorFitsSystemWindows(getWindow(),false);
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
