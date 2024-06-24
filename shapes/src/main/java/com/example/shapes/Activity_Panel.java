package com.example.shapes;

import android.os.Bundle;

import com.example.common.Activity_PanelBase;

public class Activity_Panel extends Activity_PanelBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerBase = new DataManagerShapes();
        super.onCreate(savedInstanceState);


    }

}