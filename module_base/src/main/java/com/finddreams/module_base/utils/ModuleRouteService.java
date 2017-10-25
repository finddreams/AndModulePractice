package com.finddreams.module_base.utils;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by lx on 17-10-25.
 */

public class ModuleRouteService {
    public static String getUserAddress(String userId) {
        IUserModuleService userModuleService = ARouter.getInstance().navigation(IUserModuleService.class);
        if (userModuleService != null) {
           return userModuleService.getUserAddress(userId);
        }
        return "";
    }
}
