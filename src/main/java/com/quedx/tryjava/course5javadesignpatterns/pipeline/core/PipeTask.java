package com.quedx.tryjava.course5javadesignpatterns.pipeline.core;

import com.quedx.tryjava.course5javadesignpatterns.pipeline.model.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public abstract class PipeTask<I, O> {

    @Autowired
    @Qualifier("executorService")
    ExecutorService executorService;

    @PostConstruct
    void init() {
        executorService.submit(task);
    }

    Callable<Output> task = () -> {
        return process();
    };

    public abstract Output process();
}
