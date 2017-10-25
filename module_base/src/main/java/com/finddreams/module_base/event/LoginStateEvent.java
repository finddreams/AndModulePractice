package com.finddreams.module_base.event;

/**
 * Created by lx on 17-10-24.
 */

public class LoginStateEvent {
    public boolean isSuccess;

    public LoginStateEvent(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
