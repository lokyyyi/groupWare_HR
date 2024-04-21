package com.comes.hr.report.entity;


import com.comes.hr.calendar.entity.OperationEntity;
import com.comes.hr.report.dto.ReportDto;
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
@Table(name = "staff_profile_report_history")
public class Report extends OperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id ;
    @Column(name="staff_id")
    private BigInteger sid;
    private String writingDate;
    private String reportName;
    private String submit;
    private String charge;
    private String email;
    private String content;
    private String deleteYn;

    public void update(ReportDto r) {
        if (r.getWritingDate() != null) this.setWritingDate(r.getWritingDate());
        if (r.getReportName() != null) this.setReportName(r.getReportName());
        if (r.getSubmit() != null) this.setSubmit(r.getSubmit());
        if (r.getCharge() != null) this.setCharge(r.getCharge());
        if (r.getEmail() != null) this.setEmail(r.getEmail());
        if (r.getContent() != null) this.setContent(r.getContent());
        if (r.getUpdId() != null) this.setUpdId(r.getUpdId());
        if (r.getDeleteYn() != null) this.setDeleteYn(r.getDeleteYn());
    }
}
