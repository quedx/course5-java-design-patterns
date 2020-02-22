package com.quedx.tryjava.course5javadesignpatterns.yml.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Metric {
    String name;
    String displayName;
    float slo;
    String sloLabel;
    String unit;
}
