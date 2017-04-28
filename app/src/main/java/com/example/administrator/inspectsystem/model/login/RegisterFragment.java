package com.example.administrator.inspectsystem.model.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.inspectsystem.R;
import com.example.administrator.inspectsystem.base.BaseFragment;
import com.example.administrator.inspectsystem.utils.TimeButton;

import butterknife.BindView;

/**
 * Created time : 2017/4/26 14:27.
 *
 * @author HY
 */

public class RegisterFragment extends BaseFragment {
    @BindView(R.id.edt_register_username)
    protected EditText mEdtUsername;
    @BindView(R.id.edt_register_code)
    protected EditText mEdtCode;
    @BindView(R.id.edt_register_password)
    protected EditText mEdtPwd;
    @BindView(R.id.time_btn)
    protected TimeButton mTimeBtn;
    @BindView(R.id.img_check)
    protected ImageView mImgCheck;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTimeBtn.onCreate();
    }

    @Override
    protected void initView() {
        mImgCheck.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN://显示密码
                        mEdtPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        return true;
                    case MotionEvent.ACTION_UP://隐藏密码
                        mEdtPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_register;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTimeBtn.onDestroy();
    }

    public String getUsername() {
        return mEdtUsername.getText().toString();
    }

    public String getPassword() {
        return mEdtPwd.getText().toString();
    }

    public String getCode() {
        return mEdtCode.getText().toString();
    }

}
