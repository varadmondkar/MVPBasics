package com.varad.mvpbasics;

import com.varad.base_module.BasePresenter;
import com.varad.base_module.Utils.CommonUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by varad on 08/10/18.
 */
public class LoginPresenter<V extends LoginView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    private static final String TAG = LoginPresenter.class.getSimpleName();

    @Override
    public void onLoginClick(final String email, final String password) {

        if (email == null || email.isEmpty()) {
            getBaseView().showShortToastMessage("Please enter your email address");
            return;
        }

        if (!CommonUtils.isEmailValid(email)) {
            getBaseView().showShortToastMessage("Please enter valid email address");
            return;
        }

        if (password == null || password.isEmpty()) {
            getBaseView().showShortToastMessage("Please enter a strong password");
            return;
        }

        getBaseView().showLoading();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                getBaseView().hideLoading();

                // Add some Data Model here for authentication process
                if (email.equals("varad@gmail.com") && password.equals("varad")) {
                    getBaseView().onError("Login Success!!");
                } else {
                    getBaseView().onError("Login failed");
                    return;
                }
            }
        }, 1500);
    }
}
