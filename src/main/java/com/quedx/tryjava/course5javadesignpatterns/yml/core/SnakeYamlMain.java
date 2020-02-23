package com.quedx.tryjava.course5javadesignpatterns.yml.core;

import org.yaml.snakeyaml.Yaml;

import java.io.StringWriter;

public class SnakeYamlMain {

    public static void writeToYml() {
        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        yaml.dump(SealBuilder.newSeal(), writer);
        String expectedYaml = "!!com.baeldung.snakeyaml.Customer {age: 45, contactDetails: null, firstName: Greg,\n  homeAddress: null, lastName: McDowell}\n";

        String outString = writer.toString();
        System.out.println("seal : " + writer.toString());
    }

    public static void main(String[] args) {
        writeToYml();

    }
}
