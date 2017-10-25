package com.finddreams.shoppingcart;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lx on 17-10-24.
 */
@Route(path = RouteUtils.ShoppingCart_Fragment_Main)
public class ShoppingCartMainFragment extends BaseFragment {
    TextView tv_loginstate;
    TextView tvGoodname;
    Button btGotoGooddetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.shoppingcart_fragment_main, null);
        initView(rootView);
        EventBus.getDefault().register(this);
        return rootView;
    }

    private void initView(View rootView) {
        tvGoodname = rootView.findViewById(R.id.tv_goodname);
        tv_loginstate = rootView.findViewById(R.id.tv_loginstate);
        btGotoGooddetail = rootView.findViewById(R.id.bt_goto_gooddetail);
        final String goodName = tvGoodname.getText().toString();
        btGotoGooddetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RouteUtils.startGoodDetailActivity(goodName);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginSuccess(LoginStateEvent event) {
        if (event.isSuccess) {
            tv_loginstate.setText("已登录");
        }
    }
}
