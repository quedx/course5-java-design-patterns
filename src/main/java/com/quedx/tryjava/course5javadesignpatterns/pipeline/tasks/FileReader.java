package com.quedx.tryjava.course5javadesignpatterns.pipeline.tasks;

import com.quedx.tryjava.course5javadesignpatterns.pipeline.core.PipeTask;
import com.quedx.tryjava.course5javadesignpatterns.pipeline.model.Input;
import com.quedx.tryjava.course5javadesignpatterns.pipeline.model.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileReader extends PipeTask<Input, Output> {
    private static Logger logger = LoggerFactory.getLogger(FileReader.class);

    @Override
    public Output process() {
        logger.info(FileReader.class.getName() + " process invoked");
        return null;
    }
}
