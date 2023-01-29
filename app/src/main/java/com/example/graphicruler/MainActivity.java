package com.example.graphicruler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

import android.util.DisplayMetrics;
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
        view.viewInit();


        DisplayMetrics metrics = getResources().getDisplayMetrics();
        activityMainViewBinding.screenData.setText(metrics.toString() +
                        "\n heightPixels: " + metrics.heightPixels +
                        "\n widthPixels: " + metrics.widthPixels +
                        "\n ydpi : " + metrics.ydpi +
                        "\n ydpi/2.54 : " + metrics.ydpi / 2.54 +
                        "\n densityDpi : " + metrics.densityDpi +
                        "\n ALT MATCHPARENT : " + activityMainViewBinding.mainScreen.getLayoutParams().height +
                        "\n density : " + metrics.density
        );
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

    public void showScaleMenu(View view) {//Este metodo no estoy seguro que le corresponda estar aqui, probar con databiding pasarlo la clase View
        PopupMenu scalePopupMenu = new PopupMenu(this, view);
        scalePopupMenu.setOnMenuItemClickListener(this);
        scalePopupMenu.inflate(R.menu.scale_menu);
        scalePopupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.view.setScale(menuItem);
        return false;
    }

    //Este es para que se escondan las barras aunque se cambie de focus (que pase la aplicación a segundo plano)
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }
}
