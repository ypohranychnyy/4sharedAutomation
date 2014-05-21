package com.codeborne.selenide_DailyCheck.DailyCheck;


import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.HashMap;

/**
 * Предоставляет возможность автоматического перезапуска тестов,
 * завершившихся неудачей
 */
public class RerunFailedRunner extends BlockJUnit4ClassRunner {

    /**
     * Для фиксирования количества попыток выполнения тестов
     */
    private HashMap<FrameworkMethod, Integer> rerunMethods =
            new HashMap<FrameworkMethod, Integer>();

    public RerunFailedRunner(Class<?> klass)
            throws InitializationError {
        super(klass);
    }

    @Override
    protected void runChild(FrameworkMethod method, RunNotifier notifier) {
        FailerListener listener = new FailerListener();
        // подключаем listener для определения результата теста
        notifier.addListener(listener);
        int retryCount = 2;
        for (int i = 1; i <= retryCount; i++) {
            rerunMethods.put(method, i);
            // здесь подключаются RunListener для логирования
            super.runChild(method, notifier);
            // здесь отключаются
            if (!listener.isTestFailed()) {
                // если тест выполнился успешно, больше не запускаем
                break;
            }
        }
        notifier.removeListener(listener);
    }

    /**
     * Изменяем имя метода для отображения в отчете
     */
    @Override
    protected String testName(FrameworkMethod method) {
        Integer attempt = rerunMethods.get(method);
        if (attempt != null && attempt > 1) {
            return method.getName() + attempt;
        } else {
            return method.getName();
        }
    }
}

