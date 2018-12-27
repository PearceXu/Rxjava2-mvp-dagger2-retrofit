package com.hytch.pos.modules.main.impl;

import com.hytch.pos.modules.main.IMVP;
import com.hytch.pos.modules.main.dagger.DaggerMainConponent;
import com.hytch.pos.net.API.ApiService;
import com.hytch.pos.net.ApiClient;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import my.xubaipei.devlib.SubscriberOnNextListener;
import my.xubaipei.devlib.subscribers.ComSubscriber;

/**
 * author ： xubaipei
 * create date： 2018-12-25
 */
public class MainPresenterImpl implements IMVP.IMainPresenter {
    @Inject
    IMVP.IMainView mView;

    @Inject
    IMVP.IMainModule mModule;

    public MainPresenterImpl() {
        DaggerMainConponent
                .create()
                .inject(this);
    }

    @Override
    public void get() {
        ApiClient.getApiService(ApiService.MainService.class)
                .getInfo("北京")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ComSubscriber<>(mView.getContext(), new SubscriberOnNextListener<String>() {
                    @Override
                    public void onNext(String s) {

                    }
                },null));
        mModule.saveData();
    }
}
