package com.eportal.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
@EntityListeners({DefaultEntityListener.class})
@Data
public class BaseEntity implements Serializable {
    @Id
    @Column(name="RECORD_ID")
    private String id;

    @Column(name="CREATED_BY", nullable=false)
    private String createdBy;

    @Column(name="LAST_UPDATED_BY", nullable=false)
    private String lastUpdatedBy;

    @Column(name="CREATION_TIME", nullable=false)
    private Timestamp creationTime;

    @Column(name="LAST_UPDATED_TIME", nullable=false)
    private Timestamp lastUpdatedTime;
}
