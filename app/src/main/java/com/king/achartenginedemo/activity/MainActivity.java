package com.king.achartenginedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.king.achartenginedemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * 单点指定X轴往左
     * @param view
     */
    public void onSinglePointLeft(View view){
        startActivity(new Intent(this,SinglePointLeftActivity.class));

    }

    /**
     * 单点指定X轴往右
     * @param view
     */
    public void onSinglePointRight(View view){
        startActivity(new Intent(this,SinglePointRightActivity.class));

    }

    /**
     * 集合指定X轴往左
     * @param view
     */
    public void onListPointLeft(View view){
        startActivity(new Intent(this,ListPointLeftActivity.class));
    }

    /**
     * 集合指定X轴往右
     * @param view
     */
    public void onListPointRight(View view){
        startActivity(new Intent(this,ListPointRightActivity.class));
    }
}
