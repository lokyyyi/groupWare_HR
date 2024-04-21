package com.comes.hr.commoncode.entity;

import com.comes.hr.commoncode.dto.CodeDetailDto;
import com.comes.hr.commoncode.dto.CodeGroupDto;
import com.comes.hr.commoncode.mapper.CodeDetailMapper;
import com.comes.hr.staff.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@DynamicUpdate
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //등록일/등록자/수정일/수정자
public class CodeGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String groupCode;
    private String groupCodeName;
    private String explanation;
    private String useYn;

    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="group_code_id")
    private List<CodeDetail> codeDetails =new ArrayList<>();

    public void addCodeDetail(CodeDetail codeDetail){
        if(codeDetails == null){ codeDetails = new ArrayList<>();}
        this.codeDetails.add(codeDetail);
    }

    public void update (CodeGroupDto c){
        if (c.getGroupCodeName() != null) this.setGroupCodeName(c.getGroupCodeName());
        if (c.getGroupCode() != null) this.setGroupCode(c.getGroupCode());
        if (c.getExplanation() != null) this.setExplanation(c.getExplanation());
        if (c.getUpdId() != null) this.setUpdId(c.getUpdId());
        if (c.getUseYn() != null) this.setUseYn(c.getUseYn());

        if(c.getCodeDetailDtos() != null && c.getCodeDetailDtos().size() > 0){
            for(CodeDetailDto codeDetailDto : c.getCodeDetailDtos()){
                if(codeDetailDto.getId() == null) {
                    CodeDetail codeDetail = CodeDetailMapper.INSTANCE.codeDetailDtoToEntity(codeDetailDto);
                    this.codeDetails.add(codeDetail);

                } else {
                    for(CodeDetail codeDetail : codeDetails){
                        if (codeDetail.getId().equals(codeDetailDto.getId())) {
                            codeDetail.update(codeDetailDto);
                        }
                    }
                }
            }
        }
    }
}