package com.comes.hr.staff.entity;

import com.comes.hr.staff.dto.ServedHistoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
public class ServedHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger staffId;
    private String sortation;
    private String reason;
    private String startDate;
    private String endDate;
    private String deleteYn;
    private String departmentName;
    private String departmentName2;
    private String departmentName3;
    private String position;
    private String officialResponsibilities;

    public void update(ServedHistoryDto edto){
        if(edto.getSortation() != null) this.setSortation(edto.getSortation());
        if(edto.getReason() != null) this.setReason(edto.getReason());
        if(edto.getStartDate() != null) this.setStartDate(edto.getStartDate());
        if(edto.getEndDate() != null) this.setEndDate(edto.getEndDate());
        if(edto.getDeleteYn() != null) this.setDeleteYn(edto.getDeleteYn());
        if(edto.getUpdId() != null) this.setUpdId(edto.getUpdId());
        if(edto.getDepartmentName() != null) this.setDepartmentName(edto.getDepartmentName());
        if(edto.getDepartmentName2() != null) this.setDepartmentName2(edto.getDepartmentName2());
        if(edto.getDepartmentName3() != null) this.setDepartmentName3(edto.getDepartmentName3());
        if(edto.getPosition() !=null ) this.setPosition(edto.getPosition());
        if(edto.getOfficialResponsibilities() != null) this.setOfficialResponsibilities(edto.getOfficialResponsibilities());
    }
}
