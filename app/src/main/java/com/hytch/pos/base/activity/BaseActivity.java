package com.hytch.pos.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import my.xubaipei.devlib.LoadingView;
import my.xubaipei.devlib.dialogs.CustomProgress;

/**
 * author ： xubaipei
 * create date： 2018-12-27
 */
public abstract class BaseActivity extends AppCompatActivity implements LoadingView {

    protected static BaseActivity mActivity;
    CustomProgress mCustomProgress;
    public abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(getLayoutId());
        mCustomProgress = new CustomProgress(this);
    }

    @Override
    protected void onDestroy() {
        mActivity = null;
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
}
