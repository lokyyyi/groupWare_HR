package com.comes.hr.staff.entity;

import com.comes.hr.staff.dto.CareerDto;
import com.comes.hr.staff.dto.StaffTempDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class StaffTemp extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String content;
    private String useYn;

    public void update(StaffTempDto edto){
        if(edto.getContent() != null) this.setContent(edto.getContent());
        if(edto.getUseYn() != null) this.setUseYn(edto.getUseYn());
        if(edto.getUpdId() != null) this.setUpdId(edto.getUpdId());
    }
}
