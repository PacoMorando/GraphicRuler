# GraphicRuler
![Logo Image](https://raw.githubusercontent.com/PacoMorando/multiplatform-master-mind/000eafa3432b8c41652b23501e721779465e03c4/docs/grapich-ruler/port-graphic-ruler.svg)

### Index
- **[Description](#description)**
- **[User Interface](#user-interface)**
- **[Application development](#application-development)**

## Description
An application that uses the system information of the device to draw a ruler with 'physical' accuracy. 

Although there are already other applications in the Play Store that emulate a real-value ruler, the existing ones appear to be designed for general users and generic uses. That's why I decided to design and develop a tool more focused on the way architects and designers use this type of tool.

The key aspects for focusing the design were:

- A set of commonly used and easily configurable scales.
- A calculator for converting values.
- Graphic scales for visual reference.
- A simple and user-friendly interface.

## User Interface
|  |  |
|---|---|
| ![app screenshot](https://raw.githubusercontent.com/PacoMorando/multiplatform-master-mind/master/docs/grapich-ruler/graphic_ruler_ss1.webp) | ![app screenshot](https://raw.githubusercontent.com/PacoMorando/multiplatform-master-mind/master/docs/grapich-ruler/graphic_ruler_ss2.webp)|

|  |  |
|---|---|
| ![app screenshot](https://raw.githubusercontent.com/PacoMorando/multiplatform-master-mind/master/docs/grapich-ruler/graphic_ruler_ss3.webp) | ![app screenshot](https://raw.githubusercontent.com/PacoMorando/multiplatform-master-mind/master/docs/grapich-ruler/graphic_ruler_ss4.webp)|

## Application development

 The development was an exercise I carried out while studying software architecture (MV*) and software design theory. This is the main reason why the code may seem 'over-designed' or excessively structured. My goal was to put into practice object-oriented design concepts, as well as the distribution of responsibilities and interaction among the packages that make up an MVC architecture.

The application uses the device's resources to calculate real measurements based on pixel density and device pixel height.

        
```
package com.sas.graphicruler.views;

class Context {...

  static float getDeviceHeight() {
    return Context.getInstance().getResources().getDisplayMetrics().ydpi;
  }
    static int getTotalScreenHeightInInches() {
      return (int) Math.ceil(Context.getInstance().getResources().getDisplayMetrics().heightPixels/Context.getDeviceHeight() + 1);
      //"+1" is a factor because the getDisplayMetrics().heightPixels is not considering the height pixel from the UI bars
  }
  static float getRealTotalScreenHeightInInches() {
      return Context.getInstance().getResources().getDisplayMetrics().heightPixels/Context.getDeviceHeight();
  }
}

```
Because this application displays a ruler based on the metric system, the data obtained in inches is converted and managed from the application's core packages (models). The intention is for the tool to support the English system in the future and to be able to add new scales.