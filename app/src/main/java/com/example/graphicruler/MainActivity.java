package com.example.graphicruler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.graphicruler.controllers.CalculateFromResultController;
import com.example.graphicruler.controllers.CalculateFromUnityController;
import com.example.graphicruler.databinding.ActivityMainBinding;
import com.example.graphicruler.models.ScalimeterBoard;
import com.example.graphicruler.views.GraphicScaleRecyclerAdapter;
import com.example.graphicruler.views.RulerRecyclerAdapter;


public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ActivityMainBinding activityMainViewBinding;
    private final int scale = 100;
    private final ScalimeterBoard scalimeterBoard = new ScalimeterBoard(this.scale);
    private final CalculateFromUnityController calculateFromUnityController = new CalculateFromUnityController(scalimeterBoard);
    private final CalculateFromResultController calculateFromResultController = new CalculateFromResultController(scalimeterBoard);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainViewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainViewBinding.getRoot();
        setContentView(view);
        hideSystemUI();
        rulerInit();
        graphicScaleInit();
        activityMainViewBinding.unities.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (activityMainViewBinding.unities.hasFocus()){
                    setScaledUnitiesResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        activityMainViewBinding.scaledUnities.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //CAMBIAR NOMBRE A LA CLASE, NO DEBERIA DE SER "FROM RESULT"
                if (activityMainViewBinding.scaledUnities.hasFocus()){
                    setUnitiesResult();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    private void setUnitiesResult(){
        if (this.activityMainViewBinding.scaledUnities.getText().length() == 0) {
            this.activityMainViewBinding.unities.setText("0");
        }
        if (this.activityMainViewBinding.scaledUnities.getText().length() != 0) {
            this.activityMainViewBinding.unities.setText(this.calculateFromResultController.calculateFromResult(Float.parseFloat(String.valueOf(this.activityMainViewBinding.scaledUnities.getText()))));
        }
    }

    private void setScaledUnitiesResult(){
        if (activityMainViewBinding.unities.getText().length() == 0) {
            activityMainViewBinding.scaledUnities.setText("0");
        }
        if (activityMainViewBinding.unities.getText().length() != 0) {
            activityMainViewBinding.scaledUnities.setText(calculateFromUnityController.calculateFromUnity(Float.parseFloat(String.valueOf(activityMainViewBinding.unities.getText()))));
        }
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
        this.activityMainViewBinding.rulerRecyclerView.setLayoutManager(this.setManagerForRulers());
        RulerRecyclerAdapter rulerRecyclerAdapter = new RulerRecyclerAdapter(this);
        this.activityMainViewBinding.rulerRecyclerView.setAdapter(rulerRecyclerAdapter);
        this.activityMainViewBinding.rulerRecyclerView.scrollToPosition(0);
    }

    private void graphicScaleInit() {
        this.activityMainViewBinding.graphicScaleRecyclerView.setLayoutManager(this.setManagerForRulers());
        GraphicScaleRecyclerAdapter graphicScaleRecyclerAdapter = new GraphicScaleRecyclerAdapter(this);
        this.activityMainViewBinding.graphicScaleRecyclerView.setAdapter(graphicScaleRecyclerAdapter);
        this.activityMainViewBinding.graphicScaleRecyclerView.scrollToPosition(0);
    }

    private LinearLayoutManager setManagerForRulers() {
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

    public void showScaleMenu(View view) {
        PopupMenu scalePopupMenu = new PopupMenu(this, view);
        scalePopupMenu.setOnMenuItemClickListener(this);
        scalePopupMenu.inflate(R.menu.scale_menu);
        scalePopupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.activityMainViewBinding.scaleFactor.setText(menuItem.getTitle());
        this.scalimeterBoard.setScale(Integer.parseInt((String) menuItem.getTitle()));
        this.setScaledUnitiesResult();
        this.setUnitiesResult();
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
