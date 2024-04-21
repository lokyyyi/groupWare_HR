package com.comes.hr.department.entity;

import com.comes.hr.department.dto.DepartmentDto;
import com.comes.hr.staff.dto.CareerDto;
import com.comes.hr.staff.entity.BaseEntity;
import com.comes.hr.staff.entity.Education;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Department extends BaseEntity {
    @Id		//primaryKey(String, Date, BigDecimal, BigInteger)
    @GeneratedValue(strategy = GenerationType.IDENTITY)		//생성전략 정의를 위하여??
    @Column(name="id")	//객체필드를 테이블의 컬럼에 매핑시켜주는 어노테이션
    private BigInteger id;
    @Column(name = "parent_department_id")
    private BigInteger parentDepartmentId;
    private String departmentName;
    private int orders;
    private String useYn;
    private int level;
    private int functionDefine;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_department_id")	//FK
    @OrderBy(value="orders")
    private List<Department> lowDept;


    public void update(DepartmentDto edto){
        if(edto.getParentDepartmentId() != null) this.setParentDepartmentId(edto.getParentDepartmentId());
//        if(edto.getParentDepartmentId() != null) this.setPDeptId(edto.getParentDepartmentId());
        if(edto.getDepartmentName() != null) this.setDepartmentName(edto.getDepartmentName());
        if(edto.getOrders() > 0) this.setOrders(edto.getOrders());
        if(edto.getUseYn() != null) this.setUseYn(edto.getUseYn());
        if(edto.getLevel() > 0) this.setLevel(edto.getLevel());
        if(edto.getUpdId() != null) this.setUpdId(edto.getUpdId());
        if(edto.getFunctionDefine()>0) this.setFunctionDefine(edto.getFunctionDefine());
//        if(edto.getFixYn() != null) this.setFixYn(edto.getFixYn());
    }
}
