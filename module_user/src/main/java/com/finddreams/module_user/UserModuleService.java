package com.finddreams.module_user;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.finddreams.module_base.utils.IUserModuleService;
import com.finddreams.module_base.utils.RouteUtils;

/**
 * Created by lx on 17-10-25.
 * 跨模块的服务调用
 */
@Route(path = RouteUtils.Service_User)
public class UserModuleService implements IUserModuleService {
    @Override
    public String getUserAddress(String userId) {
        return UserService.getUserAddress(userId);
    }

    @Override
    public void init(Context context) {

    }
}
