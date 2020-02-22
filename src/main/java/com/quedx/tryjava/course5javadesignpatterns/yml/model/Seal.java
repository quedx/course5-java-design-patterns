package com.quedx.tryjava.course5javadesignpatterns.yml.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Seal<T> {
    int id;
    String name;
    String displayName;
    boolean enabled;
    List<Metric> metricList;
    T inputParams;
}
