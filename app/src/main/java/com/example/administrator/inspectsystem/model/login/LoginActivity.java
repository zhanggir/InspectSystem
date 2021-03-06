package com.example.administrator.inspectsystem.model.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.inspectsystem.MainActivity;
import com.example.administrator.inspectsystem.R;
import com.example.administrator.inspectsystem.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.cursor1)
    protected ImageView mCursor1;
    @BindView(R.id.cursor2)
    protected ImageView mCursor2;
    @BindView(R.id.btn_login)
    protected Button mBtnLogin;

    private com.example.administrator.inspectsystem.model.login.LoginFragment mLoginFragment;
    private com.example.administrator.inspectsystem.model.login.RegisterFragment mRegisterFragment;
    private Fragment mCurrentFragment;//当前显示的Fragment

    @Override
    protected void init(Bundle savedInstanceState) {
        retrieveFragment();
        switchFragment(mLoginFragment);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.tv_login, R.id.tv_register, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                mCursor1.setVisibility(View.VISIBLE);
                mCursor2.setVisibility(View.INVISIBLE);

                mBtnLogin.setText(R.string.text_login);

                switchFragment(mLoginFragment);
                break;
            case R.id.tv_register:
                mCursor1.setVisibility(View.INVISIBLE);
                mCursor2.setVisibility(View.VISIBLE);

                mBtnLogin.setText(R.string.text_register);

                switchFragment(mRegisterFragment);
                break;
            case R.id.btn_login:
                toActivity(MainActivity.class);
                break;
            default:
                throw new UnsupportedOperationException("Unsupport Operation");
        }
    }

    //恢复由于系统设置改变时的Fragment
    private void retrieveFragment() {
        FragmentManager manager = getSupportFragmentManager();
        mLoginFragment = (com.example.administrator.inspectsystem.model.login.LoginFragment) manager.findFragmentByTag(com.example.administrator.inspectsystem.model.login.LoginFragment.class.getName());
        mRegisterFragment = (com.example.administrator.inspectsystem.model.login.RegisterFragment) manager.findFragmentByTag(com.example.administrator.inspectsystem.model.login.RegisterFragment.class.getName());
        if (null == mLoginFragment)
            mLoginFragment = new com.example.administrator.inspectsystem.model.login.LoginFragment();
        if (null == mRegisterFragment)
            mRegisterFragment = new com.example.administrator.inspectsystem.model.login.RegisterFragment();
    }

    /**
     * 切换Fragment
     *
     * @param target 目标Fragment
     */
    private void switchFragment(Fragment target) {
        if (mCurrentFragment == target) return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (mCurrentFragment != null) {
            transaction.hide(mCurrentFragment);
        }
        if (target.isAdded()) {
            //需要添加到FargmentManager里，才能显示
            transaction.show(target);
        } else {
            //为了便于找到Fragment，设置一个tag
            String tag = target.getClass().getName();

            //通知Fragment设置tag
            transaction.add(R.id.login_container, target, tag);
        }
        transaction.commit();

        mCurrentFragment = target;
    }
}
