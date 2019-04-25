package com.hytch.pos.modules.main.dagger;

import com.hytch.pos.modules.main.IMVP;
import com.hytch.pos.modules.main.impl.MainActivity;
import com.hytch.pos.modules.main.impl.MainModel;
import com.hytch.pos.modules.main.impl.MainPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * author ： xubaipei
 * create date： 2018-12-25
 */
@Module
public class MainModule {
    IMVP.IMainView mView;

    public MainModule() {
    }

    public MainModule(IMVP.IMainView mView) {
        this.mView = mView;
    }

    @Singleton
    @Provides
    public IMVP.IMainView provideView(){
        return mView == null? (IMVP.IMainView) MainActivity.privideViewByKey(MainActivity.class.getName()):mView;
    }

    @Singleton
    @Provides
    public IMVP.IMainModule provideModel(){
        return new MainModel();
    }

    @Singleton
    @Provides
    public IMVP.IMainPresenter providePresenter(){
        return new MainPresenterImpl();
    }
}
