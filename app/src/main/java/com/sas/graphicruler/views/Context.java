package com.sas.graphicruler.views;

class Context {
    static android.content.Context context;

    static void init(android.content.Context context) {
        Context.context = context;
    }

    static android.content.Context getInstance() {
        return Context.context;
    }

    static float getDeviceHeight() {
        //return Context.getInstance().getResources().getDisplayMetrics().ydpi;
        return Context.getInstance().getResources().getDisplayMetrics().densityDpi;
    }

    static int getTotalScreenHeightInInches() {
        return (int) Math.ceil(Context.getInstance().getResources().getDisplayMetrics().heightPixels / Context.getDeviceHeight() + 1);
        //"+1" is a factor because the getDisplayMetrics().heightPixels is not considering the height pixel from the UI bars
    }
}
