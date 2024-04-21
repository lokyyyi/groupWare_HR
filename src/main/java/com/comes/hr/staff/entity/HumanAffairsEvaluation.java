package com.comes.hr.staff.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class HumanAffairsEvaluation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger staffId;
    private String evaluationYear;
    private String departmentName;
    private String departmentName2;
    private String departmentName3;
    private String position;
    private String officialResponsibilities;
    private String totalscoreSelf;
    private String totalscorePeer;
    private String qualitativeEvaluationSelf;
    private String qualitativeEvaluationPeer;
    private String evaluationDateSelf;
    private String evaluationDatePeer;
    private String selfEvaluation;
    private String peerEvaluation;
    private String deleteYn;
    private String generalReview;

    public void update(HumanAffairsEvaluation e){
        if(e.getEvaluationYear() != null) this.setEvaluationYear(e.getEvaluationYear());
        if(e.getDepartmentName() != null) this.setDepartmentName(e.getDepartmentName());
        if(e.getDepartmentName2() != null) this.setDepartmentName2(e.getDepartmentName2());
        if(e.getDepartmentName3() != null) this.setDepartmentName3(e.getDepartmentName3());
        if(e.getPosition() != null) this.setPosition(e.getPosition());
        if(e.getOfficialResponsibilities() != null) this.setOfficialResponsibilities(e.getOfficialResponsibilities());
        if(e.getTotalscoreSelf() != null) this.setTotalscoreSelf(e.getTotalscoreSelf());
        if(e.getTotalscorePeer() != null) this.setTotalscorePeer(e.getTotalscorePeer());
        if(e.getQualitativeEvaluationSelf() != null) this.setQualitativeEvaluationSelf(e.getQualitativeEvaluationSelf());
        if(e.getQualitativeEvaluationPeer() != null) this.setQualitativeEvaluationPeer(e.getQualitativeEvaluationPeer());
        if(e.getDeleteYn() != null) this.setDeleteYn(e.getDeleteYn());
        if(e.getEvaluationDateSelf() != null) this.setEvaluationDateSelf(e.getEvaluationDateSelf());
        if(e.getEvaluationDatePeer() != null) this.setEvaluationDatePeer(e.getEvaluationDatePeer());
        if(e.getSelfEvaluation()!=null) this.setSelfEvaluation(e.getSelfEvaluation());
        if(e.getPeerEvaluation()!=null) this.setPeerEvaluation(e.getPeerEvaluation());
        if(e.getUpdId() != null) this.setUpdId(e.getUpdId());
        if(e.getRegId() != null) this.setRegId(e.getRegId());
        if(e.getGeneralReview()!=null) this.setGeneralReview(e.getGeneralReview());
    }
}
