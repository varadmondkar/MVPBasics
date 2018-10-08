package com.varad.mvpbasics;

import com.varad.base_module.MvpPresenter;

/**
 * Created by varad on 08/10/18.
 */
public interface LoginMvpPresenter<V extends LoginView> extends MvpPresenter<V> {
    void onLoginClick(String email, String password);
}
