package com.king.achartenginedemo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.king.achartenginedemo.R;
import com.king.achartenginedemo.utils.ChartUtils;

import org.achartengine.GraphicalView;

import java.util.Random;

/**
 * 点单往左更新
 */
public class SinglePointLeftActivity extends AppCompatActivity {

    private LinearLayout mChaet_ll;
    private ChartUtils mChartUtils;
    private final int POINT_GENERATE_PERIOD = 20; //单位是ms
    Random random = new Random();// 定义随机类

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mChartUtils.updateChartSinglePointLeft(msg.what);
        }
    };
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            int result = random.nextInt(31);// 返回[0,31)集合中的整数，注意不包括31
            mChartUtils.updateChartSinglePointLeft(result);
            mHandler.postDelayed(this, POINT_GENERATE_PERIOD);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_point_left);

        mChaet_ll = (LinearLayout) findViewById(R.id.chart_ll);
        mChartUtils = new ChartUtils(this, "", -100, 0, 0, 30, R.color.wathet, R.color.wathet);
        GraphicalView mChart = mChartUtils.getChart();
        mChaet_ll.addView(mChart);

    }

    public void onStart(View view) {
        mHandler.postDelayed(mRunnable, POINT_GENERATE_PERIOD);


    }

    public void onStop(View view) {
        mHandler.removeCallbacksAndMessages(null);
    }
}
