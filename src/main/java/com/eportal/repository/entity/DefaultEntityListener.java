package com.eportal.repository.entity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

public class DefaultEntityListener {
    @PrePersist
    public void prePersist(BaseEntity entity) {
        Calendar currentTime = Calendar.getInstance();
        String rmId = getActionPerformer();
        entity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        entity.setCreatedBy(rmId);
        if (entity.getCreationTime() == null) {
            entity.setCreationTime(new Timestamp(currentTime.getTimeInMillis()));
        }
        entity.setLastUpdatedBy(rmId);
        if (entity.getLastUpdatedTime() == null) {
            entity.setLastUpdatedTime(new Timestamp(currentTime.getTimeInMillis()));
        }
    }

    @PreUpdate
    public void preUpdate(BaseEntity entity) {
        Calendar currentTime = Calendar.getInstance();
        String rmId = getActionPerformer();
        entity.setLastUpdatedBy(rmId);
        entity.setLastUpdatedTime(new Timestamp(currentTime.getTimeInMillis()));
    }

    private String getActionPerformer() {
        return "system";
    }
}
