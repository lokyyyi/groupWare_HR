package com.comes.hr.department.entity;

import com.comes.hr.department.dto.HumanAffairsAppointmentDto;
import com.comes.hr.department.dto.TempHumanAffairsAppointmentDetailDto;
import com.comes.hr.department.mapper.TempHumanAffairsAppointmentDetailMapper;
import com.comes.hr.staff.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class HumanAffairsAppointment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)		//구조 다시한번 살펴보기
    @Column(name="id")
    private BigInteger id;
    private String title;
    private String documentNumber;
    private String reorganizationDate;
    private String appointmentDate;
    private String reorganizationContent;
    private String noticeLink;
    private String tempSaveYn;
    private String procState;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name="human_affairs_appointment_id")
    private List<HumanAffairsAppointmentDetail> humanAffairsAppointmentDetails;
    public void addHumanAffairsAppointmentDetail(HumanAffairsAppointmentDetail humanAffairsAppointmentDetail){
        if(this.humanAffairsAppointmentDetails == null) this.humanAffairsAppointmentDetails = new ArrayList<>();
        this.humanAffairsAppointmentDetails.add(humanAffairsAppointmentDetail);
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name="human_affairs_appointment_id")
    private List<TempHumanAffairsAppointmentDetail> tempHumanAffairsAppointmentDetails;
    public void addTempHumanAffairsAppointmentDetail(TempHumanAffairsAppointmentDetail tempHumanAffairsAppointmentDetail){
        if(this.tempHumanAffairsAppointmentDetails == null) this.tempHumanAffairsAppointmentDetails = new ArrayList<>();
        this.tempHumanAffairsAppointmentDetails.add(tempHumanAffairsAppointmentDetail);
    }
    public void removeAllTemp(){
        this.tempHumanAffairsAppointmentDetails.removeAll(tempHumanAffairsAppointmentDetails);
    }

    public void update(HumanAffairsAppointmentDto edto){
        if(edto.getTitle() != null) this.setTitle(edto.getTitle());
        if(edto.getDocumentNumber() != null) this.setDocumentNumber(edto.getDocumentNumber());
        if(edto.getReorganizationDate() != null) this.setReorganizationDate(edto.getReorganizationDate());
        if(edto.getAppointmentDate() != null) this.setAppointmentDate(edto.getAppointmentDate());
        if(edto.getReorganizationContent() != null) this.setReorganizationContent(edto.getReorganizationContent());
        if(edto.getNoticeLink() != null) this.setNoticeLink(edto.getNoticeLink());
        if(edto.getTempSaveYn() != null) this.setTempSaveYn(edto.getTempSaveYn());
        if(edto.getUpdId() != null) this.setUpdId(edto.getUpdId());

        if(edto.getTempHumanAffairsAppointmentDetailDtos() != null){
            for(TempHumanAffairsAppointmentDetailDto tempHumanAffairsAppointmentDetailDto : edto.getTempHumanAffairsAppointmentDetailDtos()){
                if(tempHumanAffairsAppointmentDetailDto.getId() != null){
                    for(TempHumanAffairsAppointmentDetail tempHumanAffairsAppointmentDetail : this.tempHumanAffairsAppointmentDetails){
                        if(tempHumanAffairsAppointmentDetail.getId().equals(tempHumanAffairsAppointmentDetailDto.getId())){
                            tempHumanAffairsAppointmentDetail.update(tempHumanAffairsAppointmentDetailDto);
                        }
                    }
                }else{
                    if(this.tempHumanAffairsAppointmentDetails ==null) this.tempHumanAffairsAppointmentDetails = new ArrayList<>();
                    TempHumanAffairsAppointmentDetail tempHumanAffairsAppointmentDetail1 = TempHumanAffairsAppointmentDetailMapper.INSTANCE.dtoToEntity(tempHumanAffairsAppointmentDetailDto);
                    this.tempHumanAffairsAppointmentDetails.add(tempHumanAffairsAppointmentDetail1);
                }
            }
        }

    }
}
