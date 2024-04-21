package com.comes.hr.recruitment.entity;

import com.comes.hr.recruitment.dto.RecruitmentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@DynamicUpdate
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //등록일/등록자/수정일/수정자
@Table(name="recruitment")
public class Recruitment extends OperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name="name", unique=true)
    private String hangulName;
    private String photoPath;;
    private String careerSortation;
    private Integer careerPeriodYear;
    private Integer careerPeriodMonth;
    private String finalEdctn;
    private String grdtnClsfc;
    private String birthYear;
    private String gender;
    private String dmstcFrgnCd;
    private String nationality;
    private String zipcode;
    private String sido;
    private String address;
    private String mobilePhoneNum;
    private String homePhoneNum;

    @Column(name = "attach_path_1")
    private String attachPath1;
    @Column(name = "attach_path_2")
    private String attachPath2	    ;
    @Column(name = "attach_path_3")
    private String attachPath3;
    @Column(name = "attach_path_4")
    private String  attachPath4	;
    @Column(name = "attach_path_5")
    private String attachPath5;

    private String email	          ;
    private String supportDiv	      ;
    private String supportChnl	      ;
    private String recruitDiv	      ;
    private String interviewMthd	  ;
    private String applicationDate	  ;
    private String interviewDt     ;
    private String interviewState	  ;
    private String interviewStateRsn  ;
    private String hopeWorkPlace	  ;
    private String remarks	          ;
    private String useYn;
    private Integer nameNumber        ;

    public void update(RecruitmentDto r){
        if(r.getHangulName() !=null) this.setHangulName(r.getHangulName());
        if(r.getPhotoPath() !=null) this.setPhotoPath(r.getPhotoPath());
        if(r.getCareerSortation() !=null) this.setCareerSortation(r.getCareerSortation());
        if(r.getCareerPeriodYear() !=null) this.setCareerPeriodYear(r.getCareerPeriodYear());
        if(r.getCareerPeriodMonth() !=null) this.setCareerPeriodMonth(r.getCareerPeriodMonth());
        if(r.getFinalEdctn() !=null) this.setFinalEdctn(r.getFinalEdctn());
        if(r.getGrdtnClsfc() !=null) this.setGrdtnClsfc(r.getGrdtnClsfc());
        if(r.getBirthYear() !=null) this.setBirthYear(r.getBirthYear());
        if(r.getGender() !=null) this.setGender(r.getGender());
        if(r.getDmstcFrgnCd() !=null) this.setDmstcFrgnCd(r.getDmstcFrgnCd());
        if(r.getNationality() !=null) this.setNationality(r.getNationality());
        if(r.getZipcode() !=null) this.setZipcode(r.getZipcode());
        if(r.getSido() !=null) this.setSido(r.getSido());
        if(r.getAddress() !=null) this.setAddress(r.getAddress());
        if(r.getMobilePhoneNum() !=null) this.setMobilePhoneNum(r.getMobilePhoneNum());
        if(r.getHomePhoneNum() !=null) this.setHomePhoneNum(r.getHomePhoneNum());
        if(r.getAttachPath1() !=null) this.setAttachPath1(r.getAttachPath1());
        if(r.getAttachPath2() !=null) this.setAttachPath2(r.getAttachPath2());
        if(r.getAttachPath3() !=null) this.setAttachPath3(r.getAttachPath3());
        if(r.getAttachPath4() !=null) this.setAttachPath4(r.getAttachPath4());
        if(r.getAttachPath5() !=null) this.setAttachPath5(r.getAttachPath5());
        if(r.getEmail() !=null) this.setEmail(r.getEmail());
        if(r.getSupportDiv() !=null) this.setSupportDiv(r.getSupportDiv());
        if(r.getSupportChnl() !=null) this.setSupportChnl(r.getSupportChnl());
        if(r.getRecruitDiv() !=null) this.setRecruitDiv(r.getRecruitDiv());
        if(r.getInterviewMthd() !=null) this.setInterviewMthd(r.getInterviewMthd());
        if(r.getApplicationDate() !=null) this.setApplicationDate(r.getApplicationDate());
        if(r.getInterviewDt() !=null) this.setInterviewDt(r.getInterviewDt());
        if(r.getInterviewState() !=null) this.setInterviewState(r.getInterviewState());
        if(r.getInterviewStateRsn() !=null) this.setInterviewStateRsn(r.getInterviewStateRsn());
        if(r.getHopeWorkPlace() !=null) this.setHopeWorkPlace(r.getHopeWorkPlace());
        if(r.getRemarks() !=null) this.setRemarks(r.getRemarks());
        if(r.getUseYn() !=null) this.setUseYn(r.getUseYn());
        if(r.getUpdId() != null) this.setUpdId(r.getUpdId());
        if(r.getRegId() != null) this.setRegId(r.getRegId());
    }

}
