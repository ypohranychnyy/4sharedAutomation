package com.codeborne.selenide_DailyCheck.DailyCheck;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;


public class FailerListener extends RunListener {
    private boolean isFailed = false;

    @Override
    public void testFailure(Failure failure) throws Exception {
        isFailed = true;
    }

    public boolean isTestFailed() {
        return isFailed;
    }
}

