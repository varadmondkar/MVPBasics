package com.varad.mvpbasics;

import android.os.Bundle;

import com.varad.base_module.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showLoading();
    }
}
