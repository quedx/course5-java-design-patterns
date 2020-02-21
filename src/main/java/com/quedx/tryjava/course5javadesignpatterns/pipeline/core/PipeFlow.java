package com.quedx.tryjava.course5javadesignpatterns.pipeline.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.quedx.tryjava.course5javadesignpatterns.pipeline.common.PipeConstant.DEFAULT_TASK_COUNT;
import static com.quedx.tryjava.course5javadesignpatterns.pipeline.common.PipeConstant.MAX_CONCURRENT_TASK_COUNT;

@Component
public class PipeFlow implements PipeFlowBase {
    List<PipeTask> pipeTaskList = new ArrayList<>(DEFAULT_TASK_COUNT);

    @Bean
    @Qualifier("executorService")
    public ExecutorService getExecutorService() {
        return Executors.newFixedThreadPool(MAX_CONCURRENT_TASK_COUNT);
    }

    @Override
    public void register(PipeTask task) {
        pipeTaskList.add(task);
    }

    @Override
    public void process() {
        // TBD
    }


}
