package com.comes.hr.staff.entity;

import com.comes.hr.staff.dto.EducationTrainingDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class EducationTraining extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger staffId;
    private String sortation;
    private String agencyPlace;
    private String content;
    private String startDate;
    private String endDate;
    private String completionSortation;
    private String deleteYn;
    private String reason;

    public void update(EducationTrainingDto e){
        if(e.getSortation() != null) this.setSortation(e.getSortation());
        if(e.getAgencyPlace() != null) this.setAgencyPlace(e.getAgencyPlace());
        if(e.getContent() != null) this.setContent(e.getContent());
        if(e.getStartDate() != null) this.setStartDate(e.getStartDate());
        if(e.getEndDate() != null) this.setEndDate(e.getEndDate());
        if(e.getCompletionSortation() != null) this.setCompletionSortation(e.getCompletionSortation());
        if(e.getDeleteYn() != null) this.setDeleteYn(e.getDeleteYn());
        if(e.getUpdId() != null) this.setUpdId(e.getUpdId());
        if(e.getRegId() != null) this.setRegId(e.getRegId());
        if(e.getReason() != null) this.setReason(e.getReason());
    }
}
