package com.comes.hr.staff.entity;

import com.comes.hr.staff.dto.CareerDto;
import com.comes.hr.staff.dto.CertificateLicenseDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CertificateLicense extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name="staff_id")
    private BigInteger sid;
    private String name;
    private String placeIssue;
    private String acquisitionNumber;
    private String acquisitionDate;
    private String deleteYn;

    public void update(CertificateLicenseDto edto){
        if(edto.getName() != null) this.setName(edto.getName());
        if(edto.getPlaceIssue() != null) this.setPlaceIssue(edto.getPlaceIssue());
        if(edto.getAcquisitionNumber() != null) this.setAcquisitionNumber(edto.getAcquisitionNumber());
        if(edto.getAcquisitionDate() != null) this.setAcquisitionDate(edto.getAcquisitionDate());
        if(edto.getDeleteYn() != null) this.setDeleteYn(edto.getDeleteYn());
        if(edto.getUpdId() != null) this.setUpdId(edto.getUpdId());
    }


//    @ManyToOne(fetch = FetchType.LAZY)
//    private Staff staff;
}
