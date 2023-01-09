package com.example.graphicruler.controllers;

import com.example.graphicruler.models.ScalimeterBoard;

public abstract class Controller {
    protected ScalimeterBoard scalimeterBoard;

    public Controller(ScalimeterBoard scalimeterBoard) {
        this.scalimeterBoard = scalimeterBoard;
    }
}
