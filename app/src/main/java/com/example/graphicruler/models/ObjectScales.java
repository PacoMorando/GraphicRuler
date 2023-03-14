package com.example.graphicruler.models;

public enum ObjectScales {
    TABLE_LAMP(0.5f,0.34f,1),
    HUMAN_SCALE(2f,0.6f,2),
    LAMP(5.5f,0.7f,3),
    HOUSE(12f,9f,4);

    private final float height;
    private final float width;
    private final int drawableId;

    ObjectScales(float height, float width, int drawableId){
        this.height = height;
        this.width = width;
        this.drawableId = drawableId;
        //quiza podemos setear el ID al inciar la aplicacion con los ids del R.drawable de cada imagen
    }

    public float getHeight(){
        return this.height;
    }

    public float getWidth(){
        return this.width;
    }

    public int getDrawableId(){
        return this.drawableId;
    }
}
