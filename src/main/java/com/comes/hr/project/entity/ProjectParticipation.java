package com.comes.hr.project.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="project_prtcp")
public class ProjectParticipation extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private BigInteger id;

    @Column(name = "staff_id", nullable = false)
    private BigInteger staffId;

//    @Column(name = "final_education", nullable = false)
//    private String finalEducation;

    @Column(name = "prtcp_start_date", nullable = true)
    private String participationStartDate;

    @Column(name = "prtcp_end_date", nullable = true)
    private String participationEndDate;

    @Column(name = "charge_work", nullable = true, length = 100)
    private String chargeWork;

    @Column(name = "rate", nullable = true, length = 100)
    private String rate;

    @Column(name = "project_id", nullable = true,updatable = false)
    private BigInteger projectId;

    @Column(name = "delete_yn", nullable = true, length = 1)
    private String deleteYn;

    @Builder
    public ProjectParticipation(BigInteger id, BigInteger projectId, BigInteger staffId,
                                String participationStartDate, String participationEndDate, String rate, String chargeWork,String deleteYn,String regId,String updId){
        this.id = id;
   //     this.finalEducation = finalEducation;
        this.projectId = projectId;
        this.staffId = staffId;
        this.participationStartDate= participationStartDate;
        this.participationEndDate = participationEndDate;
        this.rate = rate;
        this.chargeWork = chargeWork;
        this.deleteYn = deleteYn;
        this.setRegId(regId);
        this.setUpdId(updId);
    }
}
