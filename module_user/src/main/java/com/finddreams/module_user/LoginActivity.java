package com.finddreams.module_user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.base.BaseActivity;
import com.finddreams.module_base.event.LoginStateEvent;
import com.finddreams.module_base.utils.RouteUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by lx on 17-10-25.
 */
@Route(path = RouteUtils.User_Activity_Login)
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    Button btLoginSuccess;
    Button btLoginFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_login);
        initView();
        setTitle("登录模块");
    }

    private void initView() {
        btLoginSuccess = findViewById(R.id.bt_login_success);
        btLoginFail = findViewById(R.id.bt_login_fail);
        btLoginFail.setOnClickListener(this);
        btLoginSuccess.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.bt_login_success:
//                break;
//            case R.id.bt_login_fail:
//                break;
//        }
        int id = view.getId();
        if (id == R.id.bt_login_success) {
            EventBus.getDefault().post(new LoginStateEvent(true));
        } else if (id == R.id.bt_login_fail) {
            EventBus.getDefault().post(new LoginStateEvent(false));
        }
        finish();
    }
}
