package com.varad.mvpbasics;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.varad.base_module.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private LoginMvpPresenter<LoginView> mLoginMvpPresenter;

    @BindView(R.id.emailEditText)
    EditText emailEditText;

    @BindView(R.id.passwordEditText)
    EditText passwordEditText;

    @BindView(R.id.loginButton)
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUnBinder(ButterKnife.bind(this));

        mLoginMvpPresenter = new LoginPresenter<>(); // Implementation without Dragger

        mLoginMvpPresenter.onAttach(LoginActivity.this);
    }

    @OnClick(R.id.loginButton)
    public void onLoginClick() {
        mLoginMvpPresenter.onLoginClick(
                emailEditText.getText().toString().trim(),
                passwordEditText.getText().toString().trim()
        );
    }

    @Override
    public void OpenMainActivity() {

    }
}
