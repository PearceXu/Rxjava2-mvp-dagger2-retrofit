package com.hytch.pos.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.HashMap;

import my.xubaipei.devlib.LoadingView;
import my.xubaipei.devlib.dialogs.CustomProgress;

/**
 * author ： xubaipei
 * create date： 2018-12-27
 */
public abstract class BaseActivity extends AppCompatActivity implements LoadingView {

    CustomProgress mCustomProgress;
    public static HashMap<String, Activity> mActivitys = new HashMap<>();

    public abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivitys.put(this.getClass().getName(),this);
        setContentView(getLayoutId());
        mCustomProgress = new CustomProgress(this);
    }

    @Override
    protected void onDestroy() {
        mActivitys.remove(this.getClass().getName());
        super.onDestroy();
    }

    @Override
    public void startLoadding() {
        if (mCustomProgress != null){
            mCustomProgress.show();
        }
    }

    @Override
    public void stopLoadding() {
        if (mCustomProgress != null){
            mCustomProgress.dismiss();
        }
    }

    public void showToast(String tip){
        Toast.makeText(this,tip,Toast.LENGTH_SHORT).show();
    }

    public void showToast(int resId){
        Toast.makeText(this,getString(resId),Toast.LENGTH_SHORT).show();
    }

    public static Activity privideViewByKey(String key){
        return mActivitys.get(key);
    }
}
