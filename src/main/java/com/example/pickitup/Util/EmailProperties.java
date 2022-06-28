package com.example.pickitup.Util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "email") // 설정 파일에서 email: 로 시작하는 properties
@Configuration
public class EmailProperties {
    private String name;
    private String link;
    private Long validTime;
}