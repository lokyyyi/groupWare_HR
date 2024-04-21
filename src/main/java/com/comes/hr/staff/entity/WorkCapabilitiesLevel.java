package com.comes.hr.staff.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class WorkCapabilitiesLevel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger staffId;
    private String registrationDate;
    private String departmentName;
    private String departmentName2;
    private String departmentName3;
    private String position;
    private String officialResponsibilities;
    private String evaluation;
    private String deleteYn;

    public void update(WorkCapabilitiesLevel e){
        if(e.getDepartmentName() != null) this.setDepartmentName(e.getDepartmentName());
        if(e.getDepartmentName2() != null) this.setDepartmentName2(e.getDepartmentName2());
        if(e.getDepartmentName3() != null) this.setDepartmentName3(e.getDepartmentName3());
        if(e.getPosition() != null) this.setPosition(e.getPosition());
        if(e.getOfficialResponsibilities() != null) this.setOfficialResponsibilities(e.getOfficialResponsibilities());
        if(e.getEvaluation() != null) this.setEvaluation(e.getEvaluation());
        if(e.getDeleteYn() != null) this.setDeleteYn(e.getDeleteYn());
        if(e.getRegistrationDate() != null) this.setRegistrationDate(e.getRegistrationDate());
        if(e.getUpdId() != null) this.setUpdId(e.getUpdId());
        if(e.getRegId() != null) this.setRegId(e.getRegId());
    }
}
