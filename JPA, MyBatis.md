한국에서 웹 어플리케이션을 위한 백엔드로 가장 많이 사용되는 프레임워크는 Java기반의 Spring 또는 Springboot라는 것은 

다들 많이 알고있는 사실이다.

Spring은 대규모 기업환경에서 안정성과 신뢰성이 검증된 프레임워크 이기 때문에,

많은 기업에서 스프링을 이용하여 안정적인 서비스를 운영하고있다.

 

이러한 서비스에서 데이터를 저장하고 조회하기위해 데이터베이스를 활용하는 방법으로는, 아직까지 가장 많이 사용하기로 꼽히는

Mybatis와 JPA가 있다.

 

이전에 학원에 다니며 공부할때와 부트캠프에서 배웠을때, 둘다 Mybatis만 사용해왔기 때문에 JPA에 대해선 아직 모르는 부분이 많아서

이번 기회에 제대로 공부해보려고 한다.

 

마침 이번에 받게된 그룹웨어 소스에선 JPA를 사용하여 데이터베이스에 접근하기에 많은 부분을 참고하며 공부해보려 한다.

 

먼저 SQL Mapper기술과 ORM(Object Relational Mapping) 기술에 대해 알아야지 Mybatis와 JPA에 접근하는것이 가능하다

SQL Mapper는 '개발자가 작성한 SQL 실행결과를 객체에 매핑' 시켜주는 프레임워크이며

ORM은 객체와 DB의 데이터를 '자동으로 매핑' 시켜주는 프레임워크를 뜻한다.

여기서 'Mybatis'는 SQL Mapper의 기술을 제공하는것이고, ORM기술을 제공하는것이 'JPA(Java Persistence Api)' 이다

이 두가지 기술은 모두 데이터를 관계형 데이터베이스에 저장하여 영속화(persistence)시킨다는 측면에서는 동일하지만, 접근하는 방식에서

차이가 있다.

 
### Mybatis
 
![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FtwIzg%2FbtsGMFV25jh%2FQdiHMsvmto2mwDxhvjQiy1%2Fimg.jpg)

MyBatis 프레임워크는 반복적인 JDBC 프로그래밍을 단순화한뒤, 불필요한 Boilerplate(재사용...) 코드를 제거하고, Java 소스코드에서 

SQL문을 분리하여 별도의 XML파일로 저장한뒤, 연결시켜주는 기능을 제공한다.

 

MyBatis를 사용하면, 내부에 재사용코드가 구현되어 있고, Mybatis에서 Java메소드와 SQL간에 매핑을 시켜, 

개발자는 Java메소드 선언과 SQL문만 만들면 자동으로 둘을 연결시켜 주게 된다.

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F5AO2M%2FbtsGNO5r0lq%2FFZhwk918tmvu9LROqZL9x0%2Fimg.jpg) 


또한 MyBatis는 코드 제거 및 SQL문 분리 외에, 동적인 SQL(Dynamic SQL)생성 기능을 제공하여 프로그램 실행중에 입력되는 

파라미터에 따라 다른 SQL문을 동적으로 생성해내는 기능을 제공해준다.
 
예를들어
```Java
package com.main.trip.fixied.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.main.trip.fixied.model.dto.AreaCodeDto;
import com.main.trip.fixied.model.dto.CHUser;
import com.main.trip.fixied.model.dto.ContentList;
import com.main.trip.fixied.model.dto.Favorite;
import com.main.trip.fixied.model.dto.FavoriteList;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {

	@Select(" SELECT * FROM AREACODE WHERE AREACODE = #{areacode} ")
	public AreaCodeDto codeOut(int areacode);

	@Insert(" INSERT INTO CHUSER VALUES(#{uid}, #{uemail}, #{uname}, #{unickname}, #{uprofile}) ")
	public int signUp(CHUser dto);

	@Select(" SELECT CONTENTID FROM CONTENTLIST ")
	public List<Integer> contentSelectAll();

	@Insert(" INSERT INTO CONTENTLIST VALUES(#{contentid}, #{ctitle}, #{caddr}, #{ctel}, #{ceventstartdate}, #{ceventenddate}, #{cfirstimage}, #{csecondimage}, #{clatitude}, #{clongitude} ,#{contenttypeid}) ")
	public int addContentList(ContentList contentlist);

	@Insert(" INSERT INTO FAVORITE VALUES(#{uid}, #{ftitle}, #{fid}, #{fstart}, #{fend}, #{farea}, #{fdate} ,#{fnotepad}) ")
	public int addFavorite(Favorite favorite);

	@Select(" SELECT FID FROM FAVORITE WHERE FTITLE = #{ftitle} ")
	public Integer getFid(String ftitle);

	@Insert(" INSERT INTO FAVORITELIST VALUES(#{fid}, #{contentid}) ")
	public int addFavoriteList(FavoriteList favoriteList);

	@Select(" SELECT * FROM CHUSER WHERE UID = #{userid} ") // 프로필 불러오기
	public CHUser loadProfile(String userid);

	@Select(" SELECT * FROM FAVORITE WHERE UID = #{userid} ORDER BY FDATE DESC") // 즐겨찾기 불러오기
	public ArrayList<Favorite> loadFavorites(String userid);

	@Select(" SELECT TA.CONTENTID, CTITLE, CADDR, CTEL, CEVENTSTARTDATE, CEVENTENDDATE, CFIRSTIMAGE, CSECONDIMAGE, CLATITUDE, CLONGITUDE , CONTENTTYPEID FROM CONTENTLIST TA JOIN (SELECT CONTENTID FROM FAVORITELIST WHERE FID = #{favorFid} )TB ON TA.CONTENTID = TB.CONTENTID; ")
	public ArrayList<ContentList> loadFavoriteList(String favorFid);

	@Select(" SELECT * FROM AREACODE WHERE AREACODE = #{MainAreaCode} ")
	public AreaCodeDto getLongLat(String MainAreaCode);

	@Delete(" DELETE FROM CHUSER WHERE UID = #{uid} ")
	public int deleteUser(String uid);

	@Select(" SELECT UID FROM CHUSER ")
	public ArrayList<String> selectUidAll();

	@Select("SELECT * FROM FAVORITE WHERE FID= #{favorFid}")
	public Favorite getFavorArea(String favorFid);

	@Select(" SELECT FNOTEPAD FROM FAVORITE WHERE FID = #{favorFid} ")
	public String getFavorNotepad(String favorFid);
	
	@Update(" UPDATE CHUSER SET UPROFILE = #{uprofile} WHERE UID = #{uid} ")
	public int updateProfile(@Param("uid") String uid, @Param("uprofile") String uprofile);

}
```

이전에 본인이 만들었던 프로젝트에서 Mapper부분만 가져온 것이다.
 

여기서 해당 메소드로 SQL문을 불러온 뒤 사용자가 입력한 파라미터 대로 동적인 SQL이 생성이된다.


한마디로 MyBatis는 개발자가 작성한 SQL문을 Java객체로 자동 매핑 시켜주는 프레임워크라고 할 수 있다.

JPA는 여기서 한발 더 나아가서 위처럼 번거로이 SQL문을 따로 다 작성해두지 않고도, 자동으로 SQL문을 생성해주고,

DB데이터와 Java객체를 매핑 시켜주는 기술이다.

SQL문장 작성이 필요없기에 MyBatis보다 한 단계 더 자동화 되어 더욱 편리함을 주기에, 새로이 시작하는 스타트업계에서는 

MyBatis보다 JPA사용을 조금 더 선호하는 경향을 보이고있다고 들었다.

 

### JPA(Java Persistence API)

JPA는 ORM(Object-Relational Mapping)을 구현하는 자바 표준 스펙으로, 개발자가 객체지향 프로그래밍 언어에서 사용하는 객체 모델과

관계형 데이터베이스의 테이블 간의 매핑을 자동으로 처리해 줍니다.


JPA는 MyBatis와 같이 SQL문과 Java코드를 연계하는 접근방식이 아니라 Java객체와 DB엔티티 자체를 그대로 매핑해서 처리할 수 있는

접근방식을 채택한 기술이다.

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbxY8TE%2FbtsGNNZPNaV%2FXQHtFQ6o2FXK4aMSp5uCJ0%2Fimg.jpg)

해당 이미지에서 보면, Java객체인 Student 클래스가 ORM매핑을 통하여 DB테이블에 영속화(Persistence)되고, 반대로 영속화 된 데이터가

다시 Java객체로 변환되는 과정을 나타내고있다.

ORM은 이렇게 Java객체를 DB테이블로 영속화 시켜주는 기술을 의미한다.

 
이렇게 ORM기술을 실제로 구현해서 만들어진 프레임워크가 바로 Hibernate이다. 이렇게 JPA스펙을 구현한 기술은 물론 Hibernate 이외에

EclipsLik, DataNucleus등이 있지만,  사실상 표준으로 사용되는 것은 Hibernate이다.


위에서 보았던 MyBatis처럼 SQL문을 직접 작성해둘 필요없이, DB가 바뀌더라도 Hibernate에서 적합한 SQL문을 생성해준다.


예를들어 현재 분석하고있는 소스의 코드 일부를 보면

```Java
package com.comes.hr.staff.repository;

import com.comes.hr.staff.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
    public List<Career> findById(BigInteger id);

    public List<Career> findTop6BySidAndDeleteYnOrderByResignationDateDesc(BigInteger staffId, String deleteYn);
}
```

**public List<Career> findById(BigInteger id);**


위의 메소드는 Id값을 기반으로 Career엔티티를 찾아서 반환해주는 Select문을 의미한다.


**public List<Career> findTop6BySidAndDeleteYnOrderByResignationDateDesc(BigInteger staffId, String deleteYn);**


위의 메소드는 staffId와 deleteYn을 기반으로 Career엔티티를 최대 6개까지 반환하며, 결과는 resignationData를 기준으로 내림차순으로

정렬이 되는 select문을 의미한다

 

이처럼 JPA는 메소드 이름으로 SQL문을 대신할 수 있다는 것이다

 

### 장단점 정리

**MyBatis**는 SQL에 대한 직접적인 제어를 제공하므로, 개발자가 SQL을 작성하고 최적화 할 수 있으며, 복잡한 쿼리 또는 

특정한 데이터베이스에 최적화된 쿼리 작성이 필요한 경우에 적합하게 선택될 수 있다.

또한 SQL쿼리 작성을 잘 하는 사람이라면 JPA에 비해 학습 또한 용이하고, 쉽게 사용이 가능하여 성능이 좋은 

SQL문을 작성 할 수 있다.

 

하지만 CRUD의 단순한 작업에 반복적으로 코드를 만들어야 하는 단점이 있다.

이러한 방식은 개발 생산성이 떨어지며, 코드에대한 유지보수 또한 힘들어 질 수 있다.

또한 특정 DB를 기준으로 SQL문이 작성되어 있어서, DB가 변경이 되면 SQL문을 전체 다 확인하고 수정하는 작업을 거쳐야한다.

 

**JPA**는 표준화된 인터페이스를 가지고있어 특정 제품에 종속되지않기에, 개발자 간의 협업에 용이하고, 일관된 방식으로 개발이 가능하다.

또한 별도의 SQL문 작성이 없어도 데이터베이스와 객체 간의 매핑이 이루어지며, 객체지향언어인 Java와 어울리게 사용이 가능하다.

 

또한 사용하는 DB의 종류에 관계없이 JPA에서 자동으로 적합한 SQL Dialect(방언)을 만들어주기에, DB가 변경이 되어도 SQL문을 다시

수정하고 작성할 필요가 없다.

 

하지만 간단히 배우고 사용할 수 있는 MyBatis와 다르게 다양한 스펙과 작성법(@Entity, @Table, @Column, @id, @OneToMany, @ManyToOn .... )들을 학습해야하며, JPA적용으로 생기는 다양한 이슈인

즉시 로딩(EAGER LOADING), 지연 로딩(LASY LOADING), 영속성 전이(CascadeType), 복합키 매핑(@Embededld, @IdClass)등에 대한

해결방법을 익혀야 하므로 MyBatis보다 배우기가 어렵다는 단점이 있다.

 

또한 간단하게 SQL문을 생성해주기는 하지만 복잡한 쿼리나, 여러개의 테이블을 Join해서 데이터 결과를 가져와야 하는 경우에, JPA는 

용이하지 않기 때문에 정확한 결과를 얻을 수 없을수도 있다, 즉 일반적인 간단한 CRUD에는 문제가 없지만

복잡한 쿼리에서는 SQL문을 어떻게 튜닝하냐에 따라 성능의 차이가 크게 날 여지가 있기에, JPA 사용 시 이러한 부분을 주의해야 한다.

 

간단하게 정리하면

 

복잡한 쿼리와 SQL제어가 필요한 경우에는 MyBatis,

간단한 매핑 및 객체지향적 접근이 필요하거나, 다양한 데이터베이스에 대응해야 하는경우에는 JPA를 사용하는것이 용이하다고 볼 수 있다.

 

### 참고

https://www.elancer.co.kr/blog/view?seq=231
