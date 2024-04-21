package com.comes.hr.department.entity;

import com.comes.hr.department.dto.HumanAffairsAppointmentDetailDto;
import com.comes.hr.department.dto.TempHumanAffairsAppointmentDetailDto;
import com.comes.hr.staff.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class TempHumanAffairsAppointmentDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private BigInteger id;
    private BigInteger staffId;
    @Column(name="human_affairs_appointment_id")
    private BigInteger haaId;
    private String departmentNameBefore;
    private BigInteger departmentIdBefore;
    private String departmentNameAfter;
    private BigInteger departmentIdAfter;
    private String positionNameBefore;
    private String positionIdBefore;
    private String positionNameAfter;
    private String positionIdAfter;
    private String officialResponsibilitesNameBefore;
    private String officialResponsibilitesIdBefore;
    private String officialResponsibilitesNameAfter;
    private String officialResponsibilitesIdAfter;
    private String officeHeldConcurrentlyPrincipalSortation;
    private String hangulName;
    private String departmentNameBefore2;
    private String departmentNameBefore3;
    private String departmentNameAfter2;
    private String departmentNameAfter3;
    private BigInteger staffDeptId;
    public void update(TempHumanAffairsAppointmentDetailDto edto){
        if(edto.getDepartmentNameBefore() != null) this.setDepartmentNameBefore(edto.getDepartmentNameBefore());
        if(edto.getDepartmentIdBefore() != null) this.setDepartmentIdBefore(edto.getDepartmentIdBefore());
        if(edto.getDepartmentNameAfter() != null) this.setDepartmentNameAfter(edto.getDepartmentNameAfter());
        if(edto.getDepartmentIdAfter() != null) this.setDepartmentIdAfter(edto.getDepartmentIdAfter());
        if(edto.getPositionNameBefore() != null) this.setPositionNameBefore(edto.getPositionNameBefore());
        if(edto.getPositionIdBefore() != null) this.setPositionIdBefore(edto.getPositionIdBefore());
        if(edto.getPositionNameAfter() != null) this.setPositionNameAfter(edto.getPositionNameAfter());
        if(edto.getPositionIdAfter() != null) this.setPositionIdAfter(edto.getPositionIdAfter());
        if(edto.getOfficialResponsibilitesNameBefore() != null) this.setOfficialResponsibilitesNameBefore(edto.getOfficialResponsibilitesNameBefore());
        if(edto.getOfficialResponsibilitesIdBefore() != null) this.setOfficialResponsibilitesIdBefore(edto.getOfficialResponsibilitesIdBefore());
        if(edto.getOfficialResponsibilitesNameAfter() != null) this.setOfficialResponsibilitesNameAfter(edto.getOfficialResponsibilitesNameAfter());
        if(edto.getOfficialResponsibilitesIdAfter() != null) this.setOfficialResponsibilitesIdAfter(edto.getOfficialResponsibilitesIdAfter());
        if(edto.getOfficeHeldConcurrentlyPrincipalSortation() != null) this.setOfficeHeldConcurrentlyPrincipalSortation(edto.getOfficeHeldConcurrentlyPrincipalSortation());
        if(edto.getUpdId() != null) this.setUpdId(edto.getUpdId());
        if(edto.getHangulName() != null) this.setHangulName(edto.getHangulName());
        if(edto.getDepartmentNameBefore2() != null) this.setDepartmentNameBefore2(edto.getDepartmentNameBefore2());
        if(edto.getDepartmentNameAfter2() != null) this.setDepartmentNameAfter2(edto.getDepartmentNameAfter2());
        if(edto.getDepartmentNameBefore3() != null) this.setDepartmentNameBefore3(edto.getDepartmentNameBefore3());
        if(edto.getDepartmentNameAfter3() != null) this.setDepartmentNameAfter3(edto.getDepartmentNameAfter3());
        if(edto.getStaffDeptId() != null) this.setStaffDeptId(edto.getStaffDeptId());
    }
}
