### 요구사항

- [x]  쉼표(,)로 구분된 자동차 이름을 입력받는다.
    - [x]  이름은 5자 이하만 가능하다.
- [x]  이동 횟수를 입력받는다.
- [x]  0~9 사이의 무작위 값을 구한 후 무작위 값이 4 이상인 경우 이동한다.
- [ ]  이동을 마친 후 가장 먼 거리를 움직인 자동차가 승리한다.
    - [ ]  우승자는 한 명 이상일 수 있다.
- [x]  사용자가 잘못된 값을 입력하는 경우 `IllegalArgumentException`를 발생시킨다.
    - [ ]  "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

### 입력

- [x]  `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`를 출력하고 자동차 이름을 입력받는다.
    - [x]  차 이름에 빈칸이 있는 경우 IllegalArgumentException을 던진다.
    - [x]  차 이름이 없는 경우 IllegalArgumentException을 던진다.
    - [x]  차 이름의 길이가 5를 초과하는 경우 IllegalArgumentException을 던진다.
- [x]  `시도할 회수는 몇회인가요?`를 출력하고 시도할 횟수를 입력받는다.
    - [x]  숫자가 아닌경우 IllegalArgumentException을 던진다.
    - [x]  1미만의 숫자를 입력받는 경우 IllegalArgumentException을 던진다.

### 출력

- [x]  실행 결과는 아래에 맞춰 출력한다.
  `
  실행 결과
  pobi : -
  woni :
  jun : -
  `
- [x]  `최종 우승자 : ` 출력 이후 최종 우승자를 출력한다.
    - [x]  최종 우승자가 여러명일 경우 `, `로 구분하여 출력한다.

### domain

- [x]  PlayCount: 게임 진행 횟수에 대한 정보를 가지고 있는 클래스
- [x]  Car: 자동차를 표현하는 클래스

### View

- [x]  InputValidator: 입력을 검증하는 클래스
- [x]  InputView: 입력을 담당하는 클래스
- [x]  OutputView: 출력을 담당하는 클래스

### dto

- [x]  CarNamesDto: 차의 이름을 전달하는 클래스
- [x]  PlayCountDto: 게임 실행 횟수를 전달하는 클래스
- [x]  CarDto: 차에 대한 정보를 가지고 있는 클래스
- [x]  PlayResultDto: 게임 진행에 대한 정보를 전달하는 클래스
- [x]  GameResultDto: 우승자의 정보를 전달하는 클래스
