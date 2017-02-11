package com.bwie.touchdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.touchdemo.view.RegionClickView;
import com.bwie.touchdemo.view.RemoteControlMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setContentView(new RemoteControlMenu(this));
    }
}
