package com.akram.testbdakramhamdi.utils.task;

import android.support.annotation.Nullable;

public interface AppTask<T> {

    T execute();

    void onPostExecute(@Nullable final T result);

    abstract class DoAppTask implements AppTask<Boolean> {

        @Override
        public Boolean execute() {
            onExecute();
            return true;
        }

        @Override
        public void onPostExecute(@Nullable final Boolean result) {
            onPostExecute();
        }

        public abstract void onExecute();

        public abstract void onPostExecute();
    }
}
