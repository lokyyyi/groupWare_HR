package com.comes.hr.commoncode.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@DynamicUpdate
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)		//AuditingEntityLister클래스가 Callback Listener로 지정되어 entity에서 이벤트가 발생 될 때 마다 특정로직 수행
public class BaseEntity {
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
    private String updId;}
