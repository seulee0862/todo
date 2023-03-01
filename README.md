# TODO-Project

## Setting
- Springboot 2.7.9
- Java 11 version

## 기능 요구사항
- 할일 조회하기
- 할일 만들기
- 할일 수정하기
    - 할일 내용 수정 하기
    - 할일 달성 여부 체크하기
- 할일 삭제하기
- 예외 페이지 만들기

## API Info
### GET /todo
모든 할일 조회하기
- OUT<br>
  todo_info{<br>
  todo_no : <br>
  todo_name : <br>
  todo_content :<br>
  todo_success : <br>
  }

### GET /todo/{todo_no}
할일 상세조회 하기

- OUT <br>
  todo_no{<br>
  todo_name<br>
  todo_content<br>
  todo_success<br>
  exception_message<br>
  }<br>
- STATUS :
    - todo_no 없음 -> 400
    - 성공 -> 200

### POST /todo
할일 만들기
- IN<br>
  {<br>
  todo_name<br>
  todo_content<br>
  }<br>
- OUT<br>
  {<br>
  exception_message<br>
  }
- 예외
    - todo_name 또는 todo_content 누락-> 400
    - 성공 -> 200

### PATCH /todo/{todo_no}
할일 수정하기
- IN{<br>
  {<br>
  todo_name<br>
  todo_content<br>
  todo_success<br>
  }<br>
- OUT<br>{
  exception_message<br>
  }
- 예외
    - todo_name 또는 todo_content 누락-> 400
    - todo_success N 또는 Y가 아님 -> 400
    - todo_no 없음 -> 400
    - 성공 -> 200

### DELETE /todo/{todo_no}
할일 삭제하기
- OUT<br>{<br>
  exception_message<br>
  }<br>
- 예외
    - todo_no 없음 -> 400
    - 성공 -> 200

## DB
h2 database

### 변수 정보
- todo_no number(10) PK : 투두 고유아이디
- todo_name varchar(20): 투두 이름
- todo_content varchar(100) : 투두 내용
- todo_content varchar(1) default 'N' : 투두 달성 여부 (N : 미달성, Y :달성)

## 추가 구현하면 좋은 점
- 프론트 구현
- nosql db 사용해보기
- 동기방식으로 구현 (/todo_sync/~)
- TDD
