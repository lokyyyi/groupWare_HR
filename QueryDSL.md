## 목표
QueryDSL의 사용방법과 장점들을 배워본다.  

## QueryDSL  
Spring Data JPA가 기본적으로 제공해주는 CRUD메서드 및 쿼리 메서드 기능을 사용할때, 간단한 작업은 작성하는데에

큰 무리가 없지만 실무에서는 복잡한 로직의 쿼리를 사용해야하는 경우가 빈번하게 발생한다. 

기본적인 쿼리작업 이외에 다른 로직을 사용할때 필연적으로 JPQL을 사용하게 됩니다.  

JPQL예시
![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FOEzxr%2FbtsG3fWyw2d%2FM4u7K3URHfAw2C35rlo0z1%2Fimg.png)  

위의 사진처럼 크게 복잡하지않은 쿼리에서는 JPQL을 사용하여도 크게 문제가 생기지않지만, 위에서도 말한것처럼 실무에서는 복잡하고

동적인 쿼리의 사용이 불가피하며, 문자열로 작성되는 JPQL의 특성상 컴파일시점에서 오류를 잡아낼 수 없습니다.  

 

이러한 문제들을 어느정도 해소하기 위하여 만들어진 프레임워크가 바로 QueryDSL입니다.

QueryDSL은 정적타입을 사용하여 SQL쿼리를 생성해주는 프레임워크이며 장점은 크게 4가지로 보여집니다.  

 

**1. 문자가 아닌 코드로 쿼리를 작성함으로써, 컴파일 시점에 문법 오류를 쉽게 확인할 수 있다.**

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdqRPFh%2FbtsG3AzjqDL%2FRi6MXukiXHb7PrkQHRbQLk%2Fimg.png)

위의 사진처럼 QueryDSL는 코드로 쿼리를 작성하기에 작성도중 오타나 실수로인해 오류를 미리 잡아낼 수 있습니다.  

**2. 자동완성 등 IDE의 도움을 받을 수 있습니다.**  

물론 코드로 작성하기에 IDE가 제공하는 자동완성과 같은 기능을 활용하여 작성가능합니다.

**3. 동적인 쿼리를 작성하는데에 큰 장점을 가지고있다.**  

예를들어 if문이나 switch문과 같은 제어구조를 사용하여 쿼리를 동적으로 조합하거나, 자주 사용되는 쿼리조건이나 제약조건을

별도의 메서드로 추출하여 재사용할 수 있습니다.

**4. 가독성이 뛰어나다.**  

상당한 양의 쿼리를 처음보는 상황이라면, 능숙한 사람도 빠르게 구조를 파악하기 쉽지않습니다. 하지만

QueryDSL의 사용이 능숙해진다면, 필요한 부분을 나눠서 빠르게 쿼리의 의도를 파악하기 쉽습니다.  



**물론** QueryDSL을 사용하기 위해서는 다소 번거로운 Gradle설정법 및 사용법들을 새롭게 익혀야한다는 단점이 존재합니다.

하지만 어느정도 JPQL과 Java를 사용해본 사람이라면 QueryDSL을 이해하는데에는 큰 어려움이 없을것으로 생각됩니다.

 

## 설정
```Java
buildscript {
   dependencies {
      classpath("gradle.plugin.com.ewerk.gradle.plugins:querydsl-plugin:1.0.10")
   }
}

plugins {
	id 'org.springframework.boot' version '2.6.4'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'com.ewerk.gradle.plugins.querydsl' version '1.0.10'
	id 'java'
}

group = 'com.comes'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '1.8'

apply plugin: "com.ewerk.gradle.plugins.querydsl"

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}
	
repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation group: 'io.jsonwebtoken', name: 'jjwt', version: '0.9.1'
	implementation group: 'org.springdoc', name: 'springdoc-openapi-ui', version: '1.6.6'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.mapstruct:mapstruct:1.4.2.Final'
	annotationProcessor "org.mapstruct:mapstruct-processor:1.4.2.Final"
	annotationProcessor 'org.projectlombok:lombok-mapstruct-binding:0.2.0'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'org.postgresql:postgresql'
	annotationProcessor 'org.projectlombok:lombok'

	implementation 'com.querydsl:querydsl-core'
	implementation 'com.querydsl:querydsl-jpa'

	annotationProcessor "com.querydsl:querydsl-apt:${dependencyManagement.importedProperties['querydsl.version']}:jpa"
	annotationProcessor "jakarta.persistence:jakarta.persistence-api"
	annotationProcessor "jakarta.annotation:jakarta.annotation-api"


	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
	useJUnitPlatform()
}

//def querydslDir = "src/main/generated/queryDsl"

def querydslDir = "$buildDir/generated/querydsl"

querydsl {
    jpa = true
    querydslSourcesDir = querydslDir
}
sourceSets {
    main.java.srcDir querydslDir
}
configurations {
    querydsl.extendsFrom compileClasspath
}

compileQuerydsl {
    options.annotationProcessorPath = configurations.querydsl
}


// Default는 dev 로 지정
ext.profile = (!project.hasProperty('profile') || !profile) ? 'dev' : profile

// 리소스 폴더 지정
sourceSets {
    main {
        resources {
            srcDirs "src/main/resources", "src/main/resources-${profile}"
        }
    }
}
build.gradle
```

기본적으로 QueryDSL은 프로젝트 내의 @Entity 어노테이션을 선언한 클래스들을 탐색하고 JPAAnnotationProcessor를 사용하여

build.gradle에 설정된 경로에다가 Q클래스를 생성하고, 그렇게 만들어진 Q클래스들을 프로덕션 코드에서 임포트하여 사용합니다.  

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F7wC5p%2FbtsG4XgqhbT%2FSCT9VmYDFVmLJcRlIdYLp1%2Fimg.png)

또한 만들어진 Q클래스의 내부를 살펴보면 Q타입의 인스턴스 상수가 미리 정의 되어있음을 확인이 가능합니다.

```Java
package com.comes.hr.calendar.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCalendars is a Querydsl query type for Calendars
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCalendars extends EntityPathBase<Calendars> {

    private static final long serialVersionUID = -2004457342L;

    public static final QCalendars calendars = new QCalendars("calendars");

    public final QOperationEntity _super = new QOperationEntity(this);

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    public final StringPath memorialDate = createString("memorialDate");

    public final StringPath memorialDiv = createString("memorialDiv");

    public final StringPath memorialName = createString("memorialName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDt = _super.regDt;

    //inherited
    public final StringPath regId = _super.regId;

    public final NumberPath<java.math.BigInteger> staffPoolId = createNumber("staffPoolId", java.math.BigInteger.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updDt = _super.updDt;

    //inherited
    public final StringPath updId = _super.updId;

    public final StringPath useYn = createString("useYn");

    public QCalendars(String variable) {
        super(Calendars.class, forVariable(variable));
    }

    public QCalendars(Path<? extends Calendars> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCalendars(PathMetadata metadata) {
        super(Calendars.class, metadata);
    }

}
 
```

## JPQL과 비교  

```Java
public List<DepartmentStaffsDto> findStaffByDeptIdJPQL(BigInteger departmentId) {
    String jpql = "SELECT NEW com.comes.hr.department.dto.DepartmentStaffsDto("
            + "sd.sid, sd.id, s.hangulName, s.hangulNameNumber, s.deptName1, s.deptName2, s.deptName3, s.position, "
            + "s.joiningCompanyDate, (SELECT cd.codeName FROM CodeDetail cd WHERE cd.code = s.position), "
            + "sd.officeHeldConcurrentlyPrincipalSortation, sd.officialResponsibilities, "
            + "(SELECT cd.codeName FROM CodeDetail cd WHERE cd.code = sd.officialResponsibilities)"
            + ") "
            + "FROM StaffDepartment sd "
            + "JOIN sd.staff s "
            + "LEFT JOIN sd.department d "
            + "LEFT JOIN d.parentDepartmentId d2 "
            + "LEFT JOIN d2.parentDepartmentId d3 "
            + "WHERE sd.useYn = 'Y' "
            + "AND sd.departmentId = :departmentId "
            + "AND s.deleteYn = 'N' "
            + "AND s.servedState != 'OFFICESTATUS02'";

    return entityManager.createQuery(jpql, DepartmentStaffsDto.class)
            .setParameter("departmentId", departmentId)
            .getResultList();
}
```
  
위의 코드는 주어진 부서ID에 해당하는 부서의 직원들을 검색하는 메소드 이며 아래는 해당 코드를 QueryDSL로 작성한 것 입니다.  

```Java
public List<DepartmentStaffsDto> findStaffByDeptIdQuerydsl(BigInteger departmentId) {

        QDepartment department = QDepartment.department;
        QDepartment department2 = QDepartment.department;
        QDepartment department3 = QDepartment.department;

        List<DepartmentStaffsDto> departmentStaffsDtos = queryFactory.from(staffDepartment)
                .join(staff).on(staffDepartment.sid.eq(staff.id).and(staff.deleteYn.eq("N").and(staff.servedState.ne("OFFICESTATUS02"))))
                .join(department).on(staffDepartment.departmentId.eq(department.id))
                .leftJoin(department2).on(department.parentDepartmentId.eq(department2.id))
                .leftJoin(department3).on(department2.parentDepartmentId.eq(department3.id))
                .select(Projections.constructor(DepartmentStaffsDto.class,
                        Expressions.as(staffDepartment.sid, "staffId"),
                        staffDepartment.id,
                        staff.hangulName,
                        staff.hangulNameNumber,
                        Expressions.as(staff.deptName1, "deptName1"),
                        Expressions.as(staff.deptName2, "deptName2"),
                        Expressions.as(staff.deptName3, "deptName3"),
                        Expressions.as(staff.position, "position"),
                        Expressions.as(staff.joiningCompanyDate, "joiningCompanyDate"),
                        ExpressionUtils.as(
                                select(codeDetail.codeName)
                                        .from(codeDetail)
                                        .where(codeDetail.code.eq(staff.position))
                                , "positionName"
                        ),
                        Expressions.as(staffDepartment.officeHeldConcurrentlyPrincipalSortation, "officeHeldConcurrentlyPrincipalSortation"),
                        Expressions.as(staffDepartment.officialResponsibilities, "officialResponsibilities"),
                        ExpressionUtils.as(
                                select(codeDetail.codeName)
                                        .from(codeDetail)
                                        .where(codeDetail.code.eq(staffDepartment.officialResponsibilities))
                                , "officialResponsibilitiesName"
                        ))
                )
                .where(staffDepartment.useYn.eq("Y")
                        .and(staffDepartment.departmentId.eq(departmentId)))
                .fetch();

        return departmentStaffsDtos;
       }
 ```

코드기반으로 쿼리를 작성하여 컴파일시 문법오류를 쉽게 찾아낼 수 있으며, where절이나 다른 부분에 조건들을 간단하게 추가함으로써

조건을 동적으로 변경할 수 있으며, Java의 타입 시스템을 활용하였기에 오타나 잘못된 타입에 담아서 에러가 나는 상황을 방지할수 있습니다.


## 참조
https://tecoble.techcourse.co.kr/post/2021-08-08-basic-querydsl/
