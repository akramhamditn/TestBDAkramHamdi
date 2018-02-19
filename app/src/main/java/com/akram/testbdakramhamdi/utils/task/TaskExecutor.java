package com.akram.testbdakramhamdi.utils.task;

import android.support.annotation.NonNull;

/**
 * Created by akram on 19/02/2018.
 */
public interface TaskExecutor {

    <T> void async(@NonNull final AppTask<T> task);
}
