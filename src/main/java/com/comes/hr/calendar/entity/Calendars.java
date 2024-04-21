package com.comes.hr.calendar.entity;

import com.comes.hr.calendar.dto.CalendarDto;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.mapstruct.Builder;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@DynamicUpdate		//변경된 컬럼만 업데이트 한다.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //등록일/등록자/수정일/수정자
@Table(name = "calendar")
public class Calendars extends OperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String memorialDiv;
    private String memorialDate;
    private String memorialName;
    private BigInteger staffPoolId;
    private String useYn;

    public void update(CalendarDto c) {
        if (c.getMemorialDiv() != null) this.setMemorialDiv(c.getMemorialDiv());
        if (c.getMemorialDate() != null) this.setMemorialDate(c.getMemorialDate());
        if (c.getMemorialName() != null) this.setMemorialName(c.getMemorialName());
        if (c.getStaffPoolId() != null) this.setStaffPoolId(c.getStaffPoolId());
        if (c.getUpdId() != null) this.setUpdId(c.getUpdId());
        if (c.getUseYn() != null) this.setUseYn(c.getUseYn());
    }
}
