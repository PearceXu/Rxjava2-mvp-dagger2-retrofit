package com.hytch.pos.modules.main;

import android.content.Context;

import my.xubaipei.devlib.LoadingView;

/**
 * author ： xubaipei
 * create date： 2018-12-25
 */
public interface IMVP {
    interface IMainPresenter {
        void get();
    }
    interface IMainView extends LoadingView {
        Context getContext();
    }
    interface IMainModule {
        void saveData();
    }
}
