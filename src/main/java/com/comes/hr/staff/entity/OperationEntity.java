package com.comes.hr.staff.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@DynamicUpdate
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class OperationEntity {
    @CreationTimestamp
    private Date registrationDateTime;
    private String registeredId;
    @UpdateTimestamp
    private Date modifyDateTime;
    private String modifierId;
}
