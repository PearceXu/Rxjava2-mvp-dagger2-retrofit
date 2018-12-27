package com.hytch.pos.modules.main.impl;

import android.content.Context;
import android.os.Bundle;

import com.hytch.pos.R;
import com.hytch.pos.base.activity.BaseActivity;
import com.hytch.pos.modules.main.IMVP;
import com.hytch.pos.modules.main.dagger.DaggerMainConponent;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements IMVP.IMainView {
    @Inject
    IMVP.IMainPresenter mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMainConponent
                .create()
                .inject(this);
        mPresenter.get();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void startLoadding() {
    }

    @Override
    public void stopLoadding() {
    }

    public static IMVP.IMainView provideView(){
        return (IMVP.IMainView)mActivity;
    }
}
