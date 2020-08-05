package com.eportal.repository.entity.model;

import com.eportal.repository.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Data
@Entity
@Table(name = "SME_PROFILE")
public class SmeProfile extends BaseEntity {
    @Column(name = "PROFILE_ID", nullable = false)
    private String profileId;

    @Column(name = "COMPANY_NAME_ENG", nullable = true)
    private String companyNameEng;

    @Column(name = "COMPANY_NAME_CHN", nullable = true)
    private String companyNameChn;


    @OneToOne(mappedBy = "smeProfile")
    private Customer customer;
}
