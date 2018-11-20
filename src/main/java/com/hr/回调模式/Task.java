package com.hr.回调模式;

/**
 * @author BUCHU
 * @Title: Task
 * @ProjectName java-spring
 * @Description: TODO
 * @date 2018/10/109:54
 */
public abstract class Task {
    public final void executeWith(Callback callback) {
        execute();
        if (callback != null) {
            callback.call();
        }
    }

    /**
     *
     */
    public abstract void execute();
}
