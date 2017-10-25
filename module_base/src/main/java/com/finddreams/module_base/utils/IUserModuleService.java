package com.finddreams.module_base.utils;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by lx on 17-10-25.
 */

public interface IUserModuleService extends IProvider {
    String getUserAddress(String userId);
}
