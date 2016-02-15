package me.chunyu.spike.wcl_activity_lifecycle_demo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * 透明Activity
 * <p/>
 * Created by wangchenlong on 16/2/15.
 */
public class TranslateActivity extends AppCompatActivity {
    private static final String TAG = "DEBUG-WCL: " + TranslateActivity.class.getSimpleName();

    @Override public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        Log.e(TAG, "onCreate");
    }

    @Override protected void onPause() {
        super.onPause();

        Log.e(TAG, "onPause");
    }

    @Override protected void onStop() {
        super.onStop();

        Log.e(TAG, "onStop");
    }

    @Override protected void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "onDestroy");
    }
}
