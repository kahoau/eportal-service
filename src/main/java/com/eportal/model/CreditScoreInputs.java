package com.eportal.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditScoreInputs {
    @ApiModelProperty(value = "Number of Employees. Note that it has to start from 1 employee (i.e. cannot be less than 1)",example = "16", required = true)
    private Integer numberOfEmployees;

    @ApiModelProperty(
            value = "Company Type",
            example = "Sole Proprietorship|Limited Liabilty Company|Partnership|Others",
            required = true)
    private String companyType;

    @ApiModelProperty(value = "Number of years operated. Note that it has to start from 0 (i.e. cannot be less than 0)",example = "5", required = true)
    private Integer numberOfYearsOperated;
}
