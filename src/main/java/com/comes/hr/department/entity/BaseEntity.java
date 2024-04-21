package com.comes.hr.department.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@DynamicUpdate
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    private LocalDateTime regDt;	//생성시간정보
    @EqualsAndHashCode.Include
    private String regId;			//??
    @LastModifiedDate
    private LocalDateTime updDt;	//수정시간정보
    @EqualsAndHashCode.Include		//??물어보기
    private String updId;
}
