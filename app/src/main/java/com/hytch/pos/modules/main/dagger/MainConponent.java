package com.hytch.pos.modules.main.dagger;

import com.hytch.pos.modules.main.impl.MainActivity;
import com.hytch.pos.modules.main.impl.MainModel;
import com.hytch.pos.modules.main.impl.MainPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * author ： xubaipei
 * create date： 2018-12-25
 */
@Singleton
@Component(modules = {MainModule.class})
public interface MainConponent {
    void inject(MainActivity activity);
    void inject(MainPresenterImpl presenter);
    void inject(MainModel model);
}
