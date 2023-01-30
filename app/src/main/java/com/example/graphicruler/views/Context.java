package com.example.graphicruler.views;

class Context {
     static android.content.Context context;

     static void init (android.content.Context context){
        Context.context = context;
    }

     static android.content.Context getInstance(){
        return Context.context;
    }
}
