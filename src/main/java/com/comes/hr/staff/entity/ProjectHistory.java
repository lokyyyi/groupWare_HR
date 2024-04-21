package com.comes.hr.staff.entity;

import com.comes.hr.staff.dto.ProjectHistoryDto;
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
public class ProjectHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name="staff_id")
    private BigInteger sid;
    private BigInteger projectId;
    private String name;
    private String participationStartDate;
    private String participationEndDate;
    private String testTarget;
    private String client;
    private Integer committedPersonnel;
    private String performRole;
    private String detailPerformWork;
    private String deleteYn;

    public void update(ProjectHistoryDto e){
        if(e.getStaffId()!=null) this.setSid(e.getStaffId());
        if(e.getProjectId() != null) this.setProjectId(e.getProjectId());
        if(e.getName() != null) this.setName(e.getName());
        if(e.getParticipationStartDate() != null) this.setParticipationStartDate(e.getParticipationStartDate());
        if(e.getParticipationEndDate() != null) this.setParticipationEndDate(e.getParticipationEndDate());
        if(e.getTestTarget() != null) this.setTestTarget(e.getTestTarget());
        if(e.getClient() != null) this.setClient(e.getClient());
        if(e.getCommittedPersonnel() != null) this.setCommittedPersonnel(e.getCommittedPersonnel());
        if(e.getPerformRole() != null) this.setPerformRole(e.getPerformRole());
        if(e.getDetailPerformWork() != null) this.setDetailPerformWork(e.getDetailPerformWork());
        if(e.getDeleteYn() != null) this.setDeleteYn(e.getDeleteYn());
        if(e.getUpdId() != null) this.setUpdId(e.getUpdId());
        if(e.getRegId() != null) this.setRegId(e.getRegId());
    }
}
