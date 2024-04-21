package com.comes.hr.staff.entity;

import com.comes.hr.staff.dto.EducationDto;
import com.comes.hr.staff.dto.StaffDepartmentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StaffDepartment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name="staff_id")
    private BigInteger sid;
    private BigInteger departmentId;
    private String officialResponsibilities;
    private String officeHeldConcurrentlyPrincipalSortation;
    private String appointmentDate;
    private String useYn;

    public void update(StaffDepartmentDto edto){
        if(edto.getDepartmentId() != null) this.setDepartmentId(edto.getDepartmentId());
        if(edto.getOfficialResponsibilities() != null) this.setOfficialResponsibilities(edto.getOfficialResponsibilities());
        if(edto.getOfficeHeldConcurrentlyPrincipalSortation() != null) this.setOfficeHeldConcurrentlyPrincipalSortation(edto.getOfficeHeldConcurrentlyPrincipalSortation());
        if(edto.getAppointmentDate() != null) this.setAppointmentDate(edto.getAppointmentDate());
        if(edto.getUseYn() != null) this.setUseYn(edto.getUseYn());
        if(edto.getUpdId() != null) this.setUpdId(edto.getUpdId());
    }
}
