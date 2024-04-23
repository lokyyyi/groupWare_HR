## Groupware 시스템 분석 및 DB설계

한 지인의 도움으로 당장 사용이 되어도 될것처럼 보이는 퀄리티를 가진 groupware 소스를 얻게 되었고

해당 시스템을 분석해 볼 기회가 생겼다.
 

소스를 받은 뒤 1주일 가량 코드 전체를 하나하나 뜯어보며 groupware시스템이 어떠한 흐름으로 굴러가는지 분석해보았고, 

어느정도 감을 잡은 뒤, 첫번째로 한 일은 해당 엔터티 클래스들을 모두 모아 실제로 DB에 어떤식으로 테이블이 구성이 될 지 ERD Cloud를 활용하여 만들어 보았다.

 
### 분류

코드를 분석하며 실제로 DB에 저장이 될 엔터티를 분류 해보니 7개정도로 분류 할 수 있었다.


1. Department(부서)

2. Staff(유저)

3. Project(프로젝트)

4. Recruitment(채용)

5. Calender(일정)

6. Commoncode(코드그룹)

7. Report(보고서)

 
완벽하게 관계까지 정리하는것은 아직 못하였지만 단순히 테이블을 그려보았을 때 아래와 같이 나오게 된다.

 
### Department(부서)

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FnbjP2%2FbtsGPPI6Uyw%2FKZNd6IeZq0VkFwUDJ4feW1%2Fimg.png)

### Staff(유저)

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbksawq%2FbtsGNDQpUbT%2FsyO16SO8cszxGhchEa9kF0%2Fimg.png)

### Project(프로젝트)

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FPBTMd%2FbtsGPSsi3Ru%2FcdIIbPDyrf9PgN4VKUo1Y1%2Fimg.png)
 
### Recruitment(채용)

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbvVydu%2FbtsGNaVsHW3%2FGqAHXjRfWXIjQqJ2kjb9Rk%2Fimg.png)

### Calender(일정)

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FmicVB%2FbtsGNzghy0x%2FI1bP7PJegWSHeKpliZWWQK%2Fimg.png)
 
### Commoncode(코드그룹)

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FmDyC0%2FbtsGPR7Z82m%2Fjs6L3uaIKRj7usyVg4kkKk%2Fimg.png)

### Report(보고서)

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbEaN42%2FbtsGMUejzDi%2Fek0egRC3UBoCa9VTLWn4jK%2Fimg.png)
 
### 전체

![img](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FH6nQt%2FbtsGMMOff5D%2FLI9wkYiGdTN9ZU7fJ8weG1%2Fimg.png)

