package com.eportal.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Configuration
@ConfigurationProperties("serai")
@Data
public class CreditCalculationConfig {
    private List<CompanyType> companyTypes;
    private List<ScoreModel> numOfEmployees;
    private List<ScoreModel> timeInBusinesses;

    @Data
    public static class CompanyType {
        private String type;
        private Integer score;
    }

    @Data
    public static class ScoreModel {
        private Integer from;
        private Integer to = Integer.MAX_VALUE;
        private Integer score;
    }
}
