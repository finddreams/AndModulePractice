package com.finddreams.module_home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.finddreams.module_base.base.BaseActivity;
import com.finddreams.module_base.utils.RouteUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lx on 17-10-24.
 */

public class HomeActivity extends BaseActivity {
    //    @BindView(R2.id.ll_main)
    FrameLayout llMain;
    //    @BindView(R2.id.rb_home)
    RadioButton rbHome;
    //    @BindView(R2.id.rb_find)
    RadioButton rbFind;
    //    @BindView(R2.id.rb_shoppingcart)
    RadioButton rbShoppingcart;
    //    @BindView(R2.id.rb_user)
    RadioButton rbUser;
    //    @BindView(R2.id.rg_tab)
    RadioGroup rgTab;
    private Fragment curFragment;
    private FragmentManager supportFragmentManager;
    private Fragment mHomeFragment;
    private Fragment findFragment;
    private Fragment shoppingcartFragment;
    private Fragment userFragment;
    public static final String TAG_FRAGMENT_HOME="home";
    public static final String TAG_FRAGMENT_FIND="find";
    public static final String TAG_FRAGMENT_CART="cart";
    public static final String TAG_FRAGMENT_USER="user";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);
        supportFragmentManager = getSupportFragmentManager();
        initView();

    }

    private void initView() {
        rbHome = findViewById(R.id.rb_home);
        rbFind = findViewById(R.id.rb_find);
        rbShoppingcart = findViewById(R.id.rb_shoppingcart);
        rbUser = findViewById(R.id.rb_user);
        rgTab=findViewById(R.id.rg_tab);
        // 底部tab切换监听
        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switchTab(checkedId);
            }
        });
        switchTab(R.id.rb_home);
    }

    private void switchTab(int checkedId) {
        FragmentTransaction ft = supportFragmentManager.beginTransaction();
        hideAllFragment(ft);
        if (checkedId == R.id.rb_home) {
            mHomeFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_HOME);
            if (mHomeFragment == null) {
                mHomeFragment = RouteUtils.getHomeFragment();
                if (mHomeFragment != null) {
                    ft.add(R.id.ll_main, mHomeFragment, TAG_FRAGMENT_HOME);
                }
            }
            curFragment = mHomeFragment;
        } else if (checkedId == R.id.rb_find) {
            findFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_FIND);
            if (findFragment == null) {
                findFragment = RouteUtils.getFindFragment();
                if (findFragment != null) {
                    ft.add(R.id.ll_main, findFragment, TAG_FRAGMENT_FIND);
                }
            }
            curFragment = findFragment;
        } else if (checkedId == R.id.rb_shoppingcart) {
            shoppingcartFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_CART);
            if (shoppingcartFragment == null) {
                shoppingcartFragment = RouteUtils.getShoppingCartFragment();
                if (shoppingcartFragment != null) {
                    ft.add(R.id.ll_main, shoppingcartFragment, TAG_FRAGMENT_CART);
                }
            }
            curFragment = shoppingcartFragment;
        } else if (checkedId == R.id.rb_user) {
            userFragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_USER);
            if (userFragment == null) {
                userFragment = RouteUtils.getUserFragment();
                if (userFragment != null) {
                    ft.add(R.id.ll_main, userFragment, TAG_FRAGMENT_USER);
                }
            }
            curFragment = userFragment;
        }
        if (curFragment != null) {
            ft.show(curFragment).commit();
        }
    }

    private void hideAllFragment(FragmentTransaction ft) {
        Fragment fragment;
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_HOME);
        if (fragment != null) {
            ft.hide(fragment);
        }
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_FIND);
        if (fragment != null) {
            ft.hide(fragment);
        }
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_CART);
        if (fragment != null) {
            ft.hide(fragment);
        }
        fragment = supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_USER);
        if (fragment != null) {
            ft.hide(fragment);
        }
    }
}
