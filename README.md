## 스터디 2주차  : 모델2 게시판 구현하기

#### JSP, 자바 서블릿, 마이배티스(JDBC), 마리아DB를 활용해 게시판구현하기
<br />

### 기능

- [ ] 홈페이지 게시글 전체보기

  - [ ] 게시글 제목 80자 넘을경우 '...' 표시
  - [ ] 검색 게시글 건수 표시
  - [x] 페이지네이션 구현
  - [x] 날짜/카테고리/내용 검색
  - [ ] 게시글 이동해도 검색조건은 초기화X'

- [ ] 게시글 등록/수정/삭제하기

  - [ ] 프론트/서버에서 모두 유효성 검증

- [ ] 개별 게시글 페이지

  - [ ] 파일 업로드 구현

<br/>
<br/>
<br/>
<br/>

___

### 공부할 것

- [x] 자바 클래스패스 
- [ ] 멀티파트 폼데이터 동작 과정
- [ ] statement와 preparedStatement 차이
  - [ ] SQL인젝션
  - [ ] 크로스사이트스크립팅
- [ ] 자바의 call by refrence
  - [ ] Primitive type, Reference type
 - [x] 체크 예외(Checked Exception)와 언체크 예외(Unchecked Exception)  

___
#### 어려웠던 부분 (원인파악필요)
- Servlet 프로젝트 생성
  - 인텔리제이 프로젝트를 생성할때 java EE servlet, web을 추가해주어야 정상적으로 진행가능했다.
- MyBatis config xml 작성할 때 드라이버를
  - org.mariadb.jdbc:mariadb-java-client:3.0.6로 입력해 드라이버세팅 불가했다.
  - org.mariadb.jdbc.Driver 로 고쳐주면서 해결
- logger 인스턴스로 콘솔에 로그띄워지지가 않음.
- 마이배티스 매퍼에서 createAt을 now() value가 아닌 파라미터 값으로 넣어주면 날짜가 1988로 변환돼 에러가 난다.
