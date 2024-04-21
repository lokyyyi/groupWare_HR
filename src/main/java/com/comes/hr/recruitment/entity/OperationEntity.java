package com.comes.hr.recruitment.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class OperationEntity {

    @CreatedDate
    @Column(name = "reg_dt", nullable = false, updatable = false)
    private LocalDateTime regDt;

    @CreatedBy
    @Column(name = "reg_id", nullable = false, updatable = false)
    private String regId;

    @UpdateTimestamp
    @Column(name = "upd_dt", nullable = true, updatable = true)
    private LocalDateTime updDt;

    @LastModifiedBy
    @Column(name = "upd_id", nullable = true, updatable = true)
    private String updId;
}
