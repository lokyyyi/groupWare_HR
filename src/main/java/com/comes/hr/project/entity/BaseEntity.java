package com.comes.hr.project.entity;


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
import java.math.BigInteger;
import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "reg_dt", updatable = false)
    private LocalDateTime regDt;

    @CreatedBy
    @Column(name = "reg_id", updatable = false)
    private String regId;

    @UpdateTimestamp
    @Column(name = "upd_dt", updatable = true)
    private LocalDateTime updDt;

    @LastModifiedBy
    @Column(name = "upd_id", updatable = true)
    private String updId;
}
