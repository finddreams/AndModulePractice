package com.finddreams.module_user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.base.BaseFragment;
import com.finddreams.module_base.event.LoginStateEvent;
import com.finddreams.module_base.utils.RouteUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by lx on 17-10-24.
 */
@Route(path = RouteUtils.User_Fragment_Main)
public class UserMainFragment extends BaseFragment {

    private TextView tv_login_state;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.user_fragment_main, null);
        initView(rootView);
        EventBus.getDefault().register(this);

        return rootView;
    }

    private void initView(View rootView) {
        Button bt_login_state = rootView.findViewById(R.id.bt_login);
        tv_login_state = rootView.findViewById(R.id.tv_login_state);
        bt_login_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RouteUtils.startLoginActivity();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginSuccess(LoginStateEvent event) {
        if (event.isSuccess) {
            tv_login_state.setText("已登录");
        }
    }

}
