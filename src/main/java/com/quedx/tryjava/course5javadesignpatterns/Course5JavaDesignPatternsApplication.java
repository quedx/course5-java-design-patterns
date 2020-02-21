package com.quedx.tryjava.course5javadesignpatterns;

import com.quedx.tryjava.course5javadesignpatterns.pipeline.core.PipeFlow;
import com.quedx.tryjava.course5javadesignpatterns.pipeline.core.PipeFlowBase;
import com.quedx.tryjava.course5javadesignpatterns.pipeline.tasks.FileReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Course5JavaDesignPatternsApplication {

	public static void main(String[] args) {

		SpringApplication.run(Course5JavaDesignPatternsApplication.class, args);
		System.out.println("Start ....");
		PipeFlowBase pfb = new PipeFlow();
		pfb.register(new FileReader());

		pfb.process();
	}
}

