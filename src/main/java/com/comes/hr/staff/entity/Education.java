package com.comes.hr.staff.entity;

import com.comes.hr.staff.dto.EducationDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Builder
public class Education extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
//    private BigInteger staffId;
    @Column(name="staff_id")
    private BigInteger sid;
    private String schoolSortation;
    private String schoolName;
    private String entranceSchoolDate;
    private String graduationDate;
    private String graduationSortation;
    private String degreeSortation;
    private String major;
    private String minor;
    private String deleteYn;
    private String universitySortation;
    private String degreeName;
    private String entranceSortation;

    public void update(EducationDto edto){
        if(edto.getSchoolSortation() != null) this.setSchoolSortation(edto.getSchoolSortation());
        if(edto.getSchoolName() != null) this.setSchoolName(edto.getSchoolName());
        if(edto.getEntranceSchoolDate() != null) this.setEntranceSchoolDate(edto.getEntranceSchoolDate());
        if(edto.getGraduationDate() != null) this.setGraduationDate(edto.getGraduationDate());
        if(edto.getGraduationSortation() != null) this.setGraduationSortation(edto.getGraduationSortation());
        if(edto.getDegreeSortation() != null) this.setDegreeSortation(edto.getDegreeSortation());
        if(edto.getMajor() != null) this.setMajor(edto.getMajor());
        if(edto.getMinor() != null) this.setMinor(edto.getMinor());
        if(edto.getDeleteYn() != null) this.setDeleteYn(edto.getDeleteYn());
        if(edto.getUpdId() != null) this.setUpdId(edto.getUpdId());
        if(edto.getUniversitySortation() != null) this.setUniversitySortation(edto.getUniversitySortation());
        if(edto.getDegreeName() != null) this.setDegreeName(edto.getDegreeName());
        if(edto.getEntranceSortation()!= null) this.setEntranceSortation(edto.getEntranceSortation());
    }
}
