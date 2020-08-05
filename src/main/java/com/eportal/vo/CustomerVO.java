package com.eportal.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@ToString
public class CustomerVO {
    private String email;
    private String invitationCode;
    private String otp;
}
