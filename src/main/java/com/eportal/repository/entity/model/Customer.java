package com.eportal.repository.entity.model;

import com.eportal.repository.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@SuppressWarnings("ALL")
@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity {
    @Column(name = "INVITATION_CODE", unique = true, nullable = false)
    private String invitationCode;

    @Column(name = "INVITATION_CODE_EXPIRY_TIME", nullable = false)
    private Timestamp invitationCodeExpiryTime;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
    private SmeProfile smeProfile;
}
