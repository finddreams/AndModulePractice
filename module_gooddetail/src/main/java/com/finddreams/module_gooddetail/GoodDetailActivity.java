package com.finddreams.module_gooddetail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.base.BaseActivity;
import com.finddreams.module_base.utils.RouteUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liuxiang on 2017/10/24.
 */
@Route(path = RouteUtils.GoodDetail_Activity_Main)
public class GoodDetailActivity extends BaseActivity {
//    @BindView(R2.id.tv_good_name)
    TextView tvGoodName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gooddetail_activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String goodName = intent.getStringExtra("goodName");
        tvGoodName.setText(goodName);
    }
}
