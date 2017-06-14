//====================================================================
//
//      Copyright (C) 2016-2017 王辰龙
//      All rights reserved
//
//      Created by 王辰龙
//      https://github.com/SpikeKing
//
//====================================================================

package org.wangchenlong.wcl_activity_lifecycle_demo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // Log输出的标签，用于在logcat中过滤
    private static final String TAG = "DEBUG-WCL: " + MainActivity.class.getSimpleName();

    @Bind(R.id.main_b_translucent)
    Button mBTranslucent; // 透明页面
    @Bind(R.id.main_b_second)
    Button mBSecond; // 第二个页面

    private static final String EXTRA_TEXT = "extra_text"; // 用于在Activity中模拟状态的存储

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); // 绑定ButterKnife，并初始化

        mBTranslucent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TranslateActivity.class));
            }
        });

        mBSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        // 获取EXTRA_TEXT的状态存储信息
        if (savedInstanceState != null) {
            String txt = savedInstanceState.getString(EXTRA_TEXT);
            Log.e(TAG, "[onCreate]savedInstanceState: " + txt);
        }

        Log.e(TAG, "onCreate"); // 调用提示
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // 恢复状态
        if (savedInstanceState != null) {
            String txt = savedInstanceState.getString(EXTRA_TEXT);
            Log.e(TAG, "[onRestoreInstanceState]savedInstanceState: " + txt);
        }

        Log.e(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG, "onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // 写入状态
        if (outState != null) {
            outState.putString(EXTRA_TEXT, "C.L.Wang");
        }

        Log.e(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "屏幕水平", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "屏幕竖直", Toast.LENGTH_SHORT).show();
        }
    }
}
