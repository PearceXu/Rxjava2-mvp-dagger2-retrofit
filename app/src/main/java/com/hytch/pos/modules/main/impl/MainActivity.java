package com.hytch.pos.modules.main.impl;

import android.content.Context;
import android.os.Bundle;

import com.hytch.pos.R;
import com.hytch.pos.base.activity.BaseActivity;
import com.hytch.pos.modules.main.IMVP;
import com.hytch.pos.modules.main.dagger.DaggerMainConponent;
import com.hytch.pos.modules.main.dagger.MainModule;

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
        // 第二种注入方式
//        DaggerMainConponent
//                .builder()
//                .mainModule(new MainModule(this))
//                .build()
//                .inject(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.get();
    }

    @Override
    public void startLoadding() {
    }

    @Override
    public void stopLoadding() {
    }


}
