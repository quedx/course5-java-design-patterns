package com.quedx.tryjava.course5javadesignpatterns.yml.core;

import com.quedx.tryjava.course5javadesignpatterns.yml.model.ElasticSearchParams;
import com.quedx.tryjava.course5javadesignpatterns.yml.model.Metric;
import com.quedx.tryjava.course5javadesignpatterns.yml.model.Seal;
import org.yaml.snakeyaml.Yaml;

import java.io.StringWriter;
import java.util.Arrays;

public class SealBuilder {

    public static Seal<ElasticSearchParams> newSeal() {

        Metric m1 = new Metric("m1", "md1", 99.01f, "label1", "%");
        Metric m2 = new Metric("m2", "md2", 99.02f, "label2", "none");
        ElasticSearchParams e1 = new ElasticSearchParams("url", "u1", "p1", "searchIndex");

        Seal<ElasticSearchParams> seal =
                new Seal(1, "s1", "sd1", true,
                        Arrays.asList( m1, m2 ),
                        e1
                        ) ;
        return  seal;
    }

}
