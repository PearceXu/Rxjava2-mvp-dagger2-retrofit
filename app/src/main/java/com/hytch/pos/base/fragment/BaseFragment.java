package com.hytch.pos.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * author ： xubaipei
 * create date： 2018-12-27
 */
public class BaseFragment extends Fragment {
    public static HashMap<String, Fragment> mFragments = new HashMap<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragments.put(getClass().getName(),this);
    }

    @Override
    public void onDestroy() {
        mFragments.remove(getClass().getName());
        super.onDestroy();

    }
}
