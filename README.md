## 기능 목록

#### 0. 게임 초기 설정 `INITIALIZE_APPLICATION`

- [x] 메인 화면 출력
- [x] 메인 기능 선택

#### 1. 주문 등록 `ORDER_REGISTRATION`

- [x] 테이블 목록 출력
- [x] 테이블 선택 입력
- [x] 메뉴 출력
- [x] 등록할 메뉴 선택 입력
- [x] 메뉴 수량 입력
    - [x] 예외) 한 메뉴를 100개 이상 구매시 예외 처리
- [x] 해당 테이블에 메뉴, 수량, 금액 등록
- [x] **주문한 테이블에 표시**
- [x] 주문 등록 완료시 메인 화면 출력

#### 2. 결제하기 `PAYMENT`

- [x] 테이블 목록 출력
- [x] 테이블 선택
- [x] 테이블 주문 내역에 메뉴, 수량, 금액 출력
    - [x] 치킨 종류 메뉴의 수량 합이 10개가 넘을 경우 **10,000원씩 할인**
    - e.g. 10개는 10,000원 할인, 20개는 20,000원 할인
- [x] 결제 진행 멘트 출력
- [x] 결제 방식 선택
    - [x] 현금 결제는 **5% 추가 할인**
- [x] 최종 결제할 금액 출력
- [x] 결제한 테이블의 별표 해제

#### 3. 프로그램 종료 `APPLICATION_EXIT`

- [x] 프로그램 종료


- [x] 주문 혹은 결제가 불가능한 경우 그 이유를 보여 주고, 다시 주문 혹은 결제가 가능하도록 해야 한다.

# java-chicken-2019

## 미션 개요

- 치킨집 사장님이 사용하는 간단한 포스(POS) 프로그램을 구현한다.
    - **주문 등록, 결제하기, 프로그램 종료** 기능을 가진다.

- 메뉴 기본 정보가 주어지며 **메뉴 번호, 종류, 이름, 가격**을 가진다.

- 테이블 기본 정보가 주어지며 **테이블 번호**를 가진다.

- 한 테이블에서 주문할 수 있는 **한 메뉴의 최대 수량은 99개**이다.

- 주문이 등록된 테이블은 **결제가 이루어지기 전까지 테이블 목록에 별도로 표시**한다.

## 기능 요구사항

- 주문 내역에 대한 계산을 할 때는 **결제 유형에 따라 할인율**이 달라진다.
    - 치킨 종류 메뉴의 수량 합이 **10개가 넘 경우, 10,000원씩 할인**된다.
        - e.g. 10개는 10,000원 할인, 20개는 20,000원 할인
    - **현금 결제는 5%가 할인**되며 **할인된 금액에서 한 번 더 할인**이 가능하다.
- 주문 혹은 결제가 불가능한 경우 그 이유를 보여 주고, 다시 주문 혹은 결제가 가능하도록 해야 한다.
- 최종 결제 금액을 보여준다.

## 프로그램 실행 결과

```
## 메인화면
1 - 주문등록
2 - 결제하기
3 - 프로그램 종료

## 원하는 기능을 선택하세요.
1

## 테이블 목록
┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓
| 1 || 2 || 3 || 5 || 6 || 8 |
┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛

## 테이블을 선택하세요.
1

[치킨] 1 - 후라이드 : 16000원
[치킨] 2 - 양념치킨 : 16000원
[치킨] 3 - 반반치킨 : 16000원
[치킨] 4 - 통구이 : 16000원
[치킨] 5 - 간장치킨 : 17000원
[치킨] 6 - 순살치킨 : 17000원
[음료] 21 - 콜라 : 1000원
[음료] 22 - 사이다 : 1000원

## 등록할 메뉴를 선택하세요.
1

## 메뉴의 수량을 입력하세요.
1

## 메인화면
1 - 주문등록
2 - 결제하기
3 - 프로그램 종료

## 원하는 기능을 선택하세요.
1

## 테이블 목록
┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓
| 1 || 2 || 3 || 5 || 6 || 8 |
┗ # ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛

## 테이블을 선택하세요.
1

[치킨] 1 - 후라이드 : 16000원
[치킨] 2 - 양념치킨 : 16000원
[치킨] 3 - 반반치킨 : 16000원
[치킨] 4 - 통구이 : 16000원
[치킨] 5 - 간장치킨 : 17000원
[치킨] 6 - 순살치킨 : 17000원
[음료] 21 - 콜라 : 1000원
[음료] 22 - 사이다 : 1000원

## 등록할 메뉴를 선택하세요.
21

## 메뉴의 수량을 입력하세요.
1

## 메인화면
1 - 주문등록
2 - 결제하기
3 - 프로그램 종료

## 원하는 기능을 선택하세요.
2

## 테이블 목록
┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓
| 1 || 2 || 3 || 5 || 6 || 8 |
┗ # ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛

## 테이블을 선택하세요.
1

## 주문 내역
메뉴 수량 금액
후라이드 1 16000
콜라 1 1000

## 1번 테이블의 결제를 진행합니다.
## 신용 카드는 1번, 현금은 2번
1

## 최종 결제할 금액
17000원

## 메인화면
1 - 주문등록
2 - 결제하기
3 - 프로그램 종료
...
```

- 참고 블로그 및 깃허브
    - [블로그](https://velog.io/@kouz/%EC%9A%B0%EC%95%84%ED%95%9C-%ED%85%8C%ED%81%AC%EC%BD%94%EC%8A%A4-2%EA%B8%B0-%EC%98%A4%ED%94%84%EB%9D%BC%EC%9D%B8-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EB%A6%AC%EB%B7%B0-%EB%B0%98%EC%84%B1-3dk4pax3p7)
    - [깃허브](https://github.com/KJunseo/java-chicken-2019/tree/KJunseo)
