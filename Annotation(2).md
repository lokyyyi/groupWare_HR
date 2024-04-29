 
![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcC0111%2FbtsG13Vu8SV%2FB6FWSRD6P5aN0mbywAR8s0%2Fimg.png)  

## 단방향, 양방향  
- 테이블은 외래키 하나로 양방향 쿼리가 가능해서 방향이란 개념이 존재하지 않습니다.
- 객체는 참조용 필드를 가지고 있는 객체만 연관된 객체를 조회할 수 있습니다.
- 단방향 : 객체관계에서 한쪽만 참조하는 것
- 양방향 : 객체관계에서 양쪽이 서로 참조하는 것  

## 연관관계의 주인  
데이터베이스는 외래키 하나로 두 개의 테이블의 연관관계를 맺습니다.

데이터베이스의 연관관계를 관리하는 지점은 외래키 하나인 반면에 엔티티를 양방향으로 매핑하면 두 개의 객체는 서로 참조하여 조회가 가능합니다.

연관관계의 주인을 설정하는것은 두 객체중 하나를 정해서 데이터베이스의 외래키를 관리하는것을 의미합니다.

실제로 위쪽에서 간단하게 주문시스템의 테이블을 나타내보았는데, 해당 테이블의 엔티티를 보면 양방향으로 매핑이 되어있습니다.

 
![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FoukCp%2FbtsG0ecuNbD%2Fmb8KbBF3SGbf4wmTPvvmv0%2Fimg.png)  
Order Entity
![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdV5xiL%2FbtsGZXu2eeZ%2FgapMgBXc49wHBgb9NXib11%2Fimg.png)  
OrderItem Entity
![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdVlmTU%2FbtsG3BRuyYU%2FqRcwdSYE44Xzuydq76d5Q1%2Fimg.png)  
Item Entity  

하지만 위의 3가지 엔티티에서 보다시피 데이터베이스에는 존재하지않는 참조용 필드가 존재하는것을 볼 수가 있습니다.

## 연관관계의 주인을 정하는 방법  
일대다, 다대일 인 경우 다가 연관관계의 주인이된다
일대일 인 경우, 주로 많이 사용하는 테이블이 연관관계의 주인이 된다
다대다의 경우엔 두 테이블을 연결해주는 테이블을 추가하여 일대다 - 다대일 관계를 만들어야한다(실무에서 거의 사용하지 않는다.)  

## @ManyToOne   

다대일 매핑이며, 무조건 연관관계의 주인이기에 mappedBy속성이 없다. 

또한 주인이기에 @JoinColumn어노테이션을 사용하여, 참조하는 테이블의 기본키값을 명시해 주어야 한다.  

## @OneToMany  

보통 다대일 양방향 상황에서 일쪽의 엔티티에서 '다' 를 참조하기위하여 List로 만들어서 관리한다

또한 엔티티상에만 존재하는 양방향 참조형 필드이기에 주인이 되는 엔티티의 참조하는 필드를 mappedBy해주어야 한다.  

## @Embedded, @Embeddable  
중복되는 프로퍼티를 쉽게 reusable하게 정의하고 사용할 수 있습니다. 따라서 코드의 가독성과 경제성이 증가한다는 장점이 있습니다.

하지만 @Embedded된 속성이 많은경우 해당 엔티티를 조회할 때 모든 내장속성을 로드해야 하므로 조회 성능에 영향을 줄 수 있습니다.

그러므로 설계할 때 도메인 모델의 복잡성, 성능의 요구사항 등을 잘 고려하여 내장클래스와 별도의엔티티 중 알맞은 것을 선택하여야 한다.  

## 참조
https://hoestory.tistory.com/28

https://velog.io/@ghkdwp018/Embeded-Embedable
