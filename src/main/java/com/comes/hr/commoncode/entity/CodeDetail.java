package com.comes.hr.commoncode.entity;

import com.comes.hr.commoncode.dto.CodeDetailDto;
import com.comes.hr.staff.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@DynamicUpdate
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //등록일/등록자/수정일/수정자		//단일테이블
public class CodeDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
 //   private BigInteger groupCodeId;
    @Column(name = "group_code_id")
    private BigInteger sid;
    private String groupCode;
    private String code;
    private String codeName;
    private String codeExplanation;
    private Integer	orders;
    private String useYn;

    public void update(CodeDetailDto cDto){
        if(cDto.getGroupCode() != null) this.setGroupCode(cDto.getGroupCode());
        if(cDto.getCode() != null) this.setCode(cDto.getCode());
        if(cDto.getCodeName() != null) this.setCodeName(cDto.getCodeName());
        if(cDto.getCodeExplanation() != null) this.setCodeExplanation(cDto.getCodeExplanation());
        if(cDto.getOrders() != null) this.setOrders(cDto.getOrders());
        if (cDto.getUpdId() != null) this.setUpdId(cDto.getUpdId());
        if(cDto.getUseYn() != null) this.setUseYn(cDto.getUseYn());
    }
}
