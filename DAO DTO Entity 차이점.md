## 목표

1. DAO(Data Access Object)란 무엇인지 이해한다.

2. DTO(Data Transfer Object)란 무엇인지 이해한다.

3. Entity Class란 무엇인지 이해한다.

 

### DAO(Data Access Object)

1. 실제로 DB에 접근하는 객체

2. Service와 DB를 연결하는 고리의 역할을 한다.

3. SQL을 사용하여 DB에 접근한 후 적절한 CRUD API를 제공한다.

    - JPA대부분의 기본적인 CRUD 메소드를 제공하고 있다.

 

### DTO(Data Transfer Object)

1. 계층간의 데이터 교환을 위한 객체(Java Beans)이다.

   - DB에서 데이터를 얻어 Service나 Controller등으로 보낼 때 사용하는 객체를 의미함.

   - 로직이 없는 순수한 데이터 객체이며 getter/setter 메소드만 갖는다.

   - 그러나 DB에서 꺼낸 값을 임의로 변경할 일이 없기 때문에 DTO클래스는 getter만을 갖는것이 보통이다. (대신 생성자에서 값을 할당함)

2. Request와 Response용 DTO는 View를 위한 클래스이다

   - toEntity() 메소드를 통하여 DTO에서 필요한 부분을 이용하여 Entity로 만든다.

   - 또한 Controller Layer 에서 Response DTO 형태로 Client에게 전달함.

 
3. DTO예시

```Java
package com.comes.hr.staff.dto;

import lombok.*;

import java.math.BigInteger;

@Data
@ToString
@Builder
public class CareerDto {
    private BigInteger id;
    private BigInteger staffId;
    private String companyName;
    private String position;
    private String contractForm;
    private String performWork;
    private String recognitionRate;
    private String joiningCompanyDate;
    private String resignationDate;
    private String year;
    private String deleteYn;
    private String regId;
    private String updId;
}
```
 
### Entity Class
1. 실제 DB의 테이블과 매칭이 될 클래스

   - @Entity, @Column, @Id 어노테이션 활용

2. 최대한 외부에서 Entity 클래스의 getter 메소드를 사용하지 않도록 해당 클래스 안에서 필요한 로직을 구현해야함

3. Entity 클래스와 DTO클래스를 분리하는 이유

   - View Layer과 DB Layer의 역할을 철저하게 분리하기 위해서

   - 테이블과 매핑되는 Entity클래스가 변겨오디면 여러 클래스에 영향을 끼치게 되지만, View와 통신하는 DTO클래스는

     자주 변경이 되므로 분리해야함 

4. Entity Class 예시

```Java
package com.comes.hr.staff.entity;

import com.comes.hr.staff.dto.CareerDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Career extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name="staff_id")
    private BigInteger sid;
    private String companyName;
    private String position;
    private String contractForm;
    private String performWork;
    private String recognitionRate;
    private String joiningCompanyDate;
    private String resignationDate;
    private String year;
    private String deleteYn;

    public void update(CareerDto edto){
        if(edto.getCompanyName() != null) this.setCompanyName(edto.getCompanyName());
        if(edto.getPosition() != null) this.setPosition(edto.getPosition());
        if(edto.getContractForm() != null) this.setContractForm(edto.getContractForm());
        if(edto.getPerformWork() != null) this.setPerformWork(edto.getPerformWork());
        if(edto.getRecognitionRate() != null) this.setRecognitionRate(edto.getRecognitionRate());
        if(edto.getJoiningCompanyDate() != null) this.setJoiningCompanyDate(edto.getJoiningCompanyDate());
        if(edto.getResignationDate() != null) this.resignationDate = edto.getResignationDate();
        if(edto.getDeleteYn() != null) this.setDeleteYn(edto.getDeleteYn());
        if(edto.getUpdId() != null) this.setUpdId(edto.getUpdId());
    }
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Staff staff;
}
```
 

참고
https://gmlwjd9405.github.io/2018/12/25/difference-dao-dto-entity.html
