package com.quedx.tryjava.course5javadesignpatterns.yml.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ElasticSearchParams {
    String url;
    String username;
    String password;
    String searchIndex;
}
