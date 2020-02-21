package com.quedx.tryjava.course5javadesignpatterns.pipeline.core;

public interface PipeFlowBase {

    void register(PipeTask task);

    void process();
}
