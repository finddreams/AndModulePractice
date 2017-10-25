package com.finddreams.module_gooddetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.base.BaseActivity;
import com.finddreams.module_base.utils.ModuleRouteService;
import com.finddreams.module_base.utils.RouteUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liuxiang on 2017/10/24.
 */
@Route(path = RouteUtils.GoodDetail_Activity_Main)
public class GoodDetailActivity extends BaseActivity {
    TextView tvGoodName;
    TextView tv_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gooddetail_activity_main);
        tvGoodName=findViewById(R.id.tv_good_name);
        tv_address=findViewById(R.id.tv_address);
        initData();
        setTitle("商品详情模块");

    }

    private void initData() {
        Intent intent = getIntent();
        String goodName = intent.getStringExtra("goodName");
        tvGoodName.setText(goodName);
        tv_address.setText("用户所在地址:"+ ModuleRouteService.getUserAddress("123"));
    }
}
