## 목표
그룹웨어 소스를 공부하며 처음 접해보는 JPA의 어노테이션들의 기능을 이해하기.

 

### @Entity
@Entity 어노테이션은 DB의 테이블과 1:1로 매칭되는 객체 단위이며, Entity객체 하나하나가 테이블에서 하나의 레코드 값을 의미한다.

그렇기에 객체의 인스턴스를 구분하기 위하여,  유일한 키 값을 가지는데, 이것을 @Id어노테이션으로 표기 할 수 있다.

 

가지고있는 소스에서는 SpringBoot 설정에서 spring.jpa.hibernate.ddl-auto설정이 false로 되어있지만, 혹시 create나 update로 되어있을

경우에는 Spring프로젝트가 시작이 될 때 EntityManager가 자동으로 DDL을 수행하여 테이블을 생성함.

 

데이터베이스상에서 보편적으로 사용되는 명명법은 UnderScore가 원칙이기 때문에 @Table의 name속성으로 테이블 이름을 명명해주는

경우가 많다, 그렇지 않다면 Entity클래스의 이름 그대로 CamelCase를 유지한체로 테이블이 생성이된다.

 

### @Column
@Column 어노테이션은 Entity클래스안에 내부변수로 정의가 되며, 별다른 옵션을 지정하지 않는다면 생략이 가능합니다.

위에서 말한 SpringBoot의 spring.jpa.hibernate.ddl-auto설정이 create혹은 update로 되어있을경우 최초로 한번 컬럼이 생성되거나, 

Entity클래스와 비교하여 존재하지 않는 컬럼을 추가로 생성해주지만. 데이터타입이 변경되거나, 길이가 변경 되었을때 자동으로 

반영해주지 않기때문에, 속성이 변경되면 기존 테이블을 drop 후 새롭게 create하던지 개별로 alter table을 통해 직접 ddl구문을 적용해야함

name속성으로 이름, length속성으로 길이를 명시 할 수 있으며, length속성을 기입하지 않는다면 자동으로 기본길이인 255가 지정이 됩니다.

 

### @Id
DB의 테이블은 기본적으로 유일한 값을 가지며. 그것을 PK(Primary Key)라고 하는데, JPA에서도 Entity 클래스 상에 해당 PK를 명시적으로

표시를 해야합니다. 그 방법으로 @Id어노테이션을 사용하여 해당 컬럼이 PK임을 지정해야합니다.

 

### @GeneratedValue
PK 컬럼의 데이터형식이 정해져있는것은 아니지만, 구분이 가능한 유일한 값을 가지고 있어야하며, 데이터경합으로 인해 발생되는 데드락

같은 현상을 방지하기 위해 대부분 BigInteger 즉 Java의 Long을 주로 사용합니다.

 

***데드락(deadlock) - 모든 프로세스가 다른 프로세스가 사용중인 있는 자원을 기다리는 상황에서, 마지막 프로세스가 첫 프로세스가 사용 중인 자원을 쓰기 위해 대기중인 상황. 쉽게 말해서 대기가 꼬리를 물고 사이클이 된 것.***

 

보편적으로 사용이되는 DB인 MYSQL, ORACLE에서는 Long 타입의 키값을 생성하는 방식이 조금 다른데, 

MYSQL은 auto increment, ORACLE은 sequence방식을 사용합니다.

따라서 사용하는 DB에 따라 @GeneratedValue어노테이션의 strategy속성에 변화를 주어야 합니다.

 

-auto increment

새로운 레코드가 생성이 될 때마다 자동으로 마지막 PK값에서 +1을 해주는 방식이며, @GeneratedValue 어노테이션의 strategy속성을 

Generation.Type.IDENTITY로 지정해 auto increment컬럼인것을 EntityManager에게 알려줍니다.

 

-sequence

sequence ORACLE 객체를 생성해둔 뒤 해당 sequence를 호출할 때 마다 기존값의 +1이 된 값을 반환해주는 방식이며, strategy속성을

Generation.Type.SEQUENCE로 지정해 sequence를 사용하여 PK값을 사용하겠다고 지정합니다.
```java
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="project")
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name="id", updatable = false, nullable = false)
    private BigInteger id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "type", nullable = false, length = 10)
    private String type;

    @Column(name = "perform_period", nullable = true)
    private String performPeriod;

    @Column(name = "description", nullable = true, length = 2000)
    private String description;
```
### @Enumerated
@Enumerated어노테이션은 java내에서 enum형태로 미리 정의되어있는 코드값이나 구분값을 데이터타입으로 사용하고자 할 때 사용됌.

속성으로는 ORDINAL, STRING이 있는데 ORDINAL은 순서가 컬럼값으로 사용되고, STRING은 문자열 자체가 컬럼의 값으로 사용이됌.

 
```java
enum UseYN {
	Y,N
}
@Enumerated(EnumType.ORDINAL)
@Column(name = "Use_Yn")
private UseYN numYn;	//0,1값으로 저장

@Enumerated(EnumType.STRING)
@Column(name = "Use_Yn")
private UseYN;		//'Y','N'값으로 저장
```
### @Transient
만약 Entity 객체에 속성으로서 지정이 되어 있지만 DB상에 필요없는 속성이라면 @Transient 어노테이션을 이용해서 해당 속성을 DB에서 이용하지 않겠다 라고 정의하고 영속대상에서 제외 할 수 있습니다. 이렇게 하면 해당 속성을 Entity 객체에 임시로 값을 담는 용도로

사용 가능 합니다

### @DynamicUpdate
JPA의 기능으로는 엔티티의 상태를 변경시켜주는 것만으로 update쿼리를 실행 시킬 수 있다. 이때 발생하는 쿼리는 모든 컬럼을 대상으로

update를 실행하게된다.

 

예를들어 id값, name값, age값 총 세가지의 컬럼을 가진 엔티티객체가 있다고 가정하였을 때, setAge(50) 과 같은 방법등으로 상태변경을 

하게되면 update [table] set [table]age=?, [table]name=? where [table]id=? 와 비슷한 쿼리가 날아가게 될 것이다.

이처럼 변경된 값은 age하나뿐이지만 name까지 update쿼리에 같이 날아가게 된다.

 

이러할때 변경되는 값만 수정하기위하여 사용하는 어노테이션이 @DynamicUpdate이다.
```java
@Entity
@DynamicUpdate		//변경된 컬럼만 업데이트 한다.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //등록일/등록자/수정일/수정자
@Table(name = "calendar")
public class Calendars extends OperationEntity {
 ```

위처럼 클래스 위쪽에 @Entity어노테이션과 마찬가지로 똑같이 달아주게되면 정상적으로 변경되는 컬럼만 update하게 된다.

 

그래서 이 @DynamicUpdate는 언제 사용해야할까? 보편적으로 3가지 상황이 있다.

- 컬럼이 많을 때

어떻게 보면 가장 기본적이고 단순한 이유다. 컬럼이 많거나 컬럼의 크기가 클때 사용하면 좋다. 다만 "많다" 라는건 상당히 추상적이므로 잘 판단해야할 것 같다. 지극히 개인적으로 15~20개 정도로 기준을 잡고있다.

 

- 테이블에 인덱스가 많을 때

컬럼이 많을 때와 비슷한 이유이다. 인덱스가 걸려있는 컬럼은 변경이 발생하면 인덱스를 재정렬하게 되는데, 인덱스가 많으면 많을수록 update 쿼리에 영향을 주게된다. 값이 변경되지 않았다면 굳이 update 를 하지 않는게 update 쿼리 성능에 도움을 주게된다.

 

- 데이터베이스가 컬럼 락을 지원할 때

널리 사용하는 DBMS(oracle, mysql)는 컬럼 락을 지원하지 않기에 그다지 와닿지 않을 수 있다. 참고한 자료에서는 yugabyte 라는 데이터베이스를 얘기하고 있는데, 컬럼 락을 지원하는 DBMS 에서 사용하기 적절하다.

 

@ManyToOne

@OneToMany

@JoinColumn

@EmbededId

위 네가지는 다음 게시물에서 다루도록 하겠다.

 

참고

https://multifrontgarden.tistory.com/299https://www.icatpark.com/entry/JPA-%EA%B8%B0%EB%B3%B8-Annotation-%EC%A0%95%EB%A6%AC
