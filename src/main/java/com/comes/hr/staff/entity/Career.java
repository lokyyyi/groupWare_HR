package com.comes.hr.staff.entity;

import com.comes.hr.staff.dto.CareerDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Career extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name="staff_id")
    private BigInteger sid;
    private String companyName;
    private String position;
    private String contractForm;
    private String performWork;
    private String recognitionRate;
    private String joiningCompanyDate;
    private String resignationDate;
    private String year;
    private String deleteYn;

    public void update(CareerDto edto){
        if(edto.getCompanyName() != null) this.setCompanyName(edto.getCompanyName());
        if(edto.getPosition() != null) this.setPosition(edto.getPosition());
        if(edto.getContractForm() != null) this.setContractForm(edto.getContractForm());
        if(edto.getPerformWork() != null) this.setPerformWork(edto.getPerformWork());
        if(edto.getRecognitionRate() != null) this.setRecognitionRate(edto.getRecognitionRate());
        if(edto.getJoiningCompanyDate() != null) this.setJoiningCompanyDate(edto.getJoiningCompanyDate());
        if(edto.getResignationDate() != null) this.resignationDate = edto.getResignationDate();
        if(edto.getDeleteYn() != null) this.setDeleteYn(edto.getDeleteYn());
        if(edto.getUpdId() != null) this.setUpdId(edto.getUpdId());
    }
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Staff staff;
}
