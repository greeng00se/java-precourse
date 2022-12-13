### 요구사항

- 우테코에서 운영하는 과정은 현재 백엔드 과정과 프론트엔드 과정이 있다.
- 각 과정은 5단계로 나누어 진행이 되는데 이를 레벨이라고 한다.
- 미션을 수행하며 각 레벨에서 전달하고자 하는 내용을 학습하는데 이 과정을 페어 프로그래밍으로 진행한다.
- 미션을 시작하기 전 페어를 매칭하는데 다양한 페어를 만나기 위해서 같은 레벨 동안은 같은 페어를 만나지 않는다.

### 페어매칭 구현방법

- 크루들의 이름 목록을 List<String> 형태로 준비한다.
- 크루 목록의 순서를 랜덤으로 섞는다. 이 때 `camp.nextstep.edu.missionutils.Randoms`의 shuffle 메서드를 활용해야 한다.
- 랜덤으로 섞인 페어 목록에서 페어 매칭을 할 때 앞에서부터 순서대로 두명씩 페어를 맺는다.
- 홀수인 경우 마지막 남은 크루는 마지막 페어에 포함시킨다.
- 같은 레벨에서 이미 페어로 만난적이 있는 크루끼리 다시 페어로 매칭 된다면 크루 목록의 순서를 다시 랜덤으로 섞어서 매칭을 시도한다.
- 3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없으면 에러 메시지를 출력한다.

### 페어매칭

- [ ] 미션을 함께 수행할 페어를 두명씩 매칭한다.
- [ ] 페어 매칭 대상이 홀수인 경우 한 페어는 3인으로 구성한다.
- [ ] 같은 레벨에서 이미 페어를 맺은 크루와는 다시 페어로 매칭될 수 없다.
- [ ] 안내 문구를 출력 후 매칭을 진행한다.
- [ ] 아니오를 선택할 경우 코스, 레벨, 미션을 다시 선택한다.

### 페어매칭 조회

- [ ] 과정, 레벨, 미션을 선택하면 해당 미션의 페어 정보를 출력한다.
- [ ] 매칭 이력이 없으면 매칭 이력이 없다고 안내한다.
    - [ ] [ERROR] 매칭 이력이 없습니다.

### 과정, 레벨, 미션 정보

- 과정
    - 백엔드
    - 프론트엔드
- 레벨
    - 레벨1
    - 레벨2
    - 레벨3
    - 레벨4
    - 레벨5
- 미션
    - 레벨1 - 자동차경주, 로또, 숫자야구게임
    - 레벨2 - 장바구니, 결제, 지하철노선도
    - 레벨3 - 없음
    - 레벨4 - 성능개선, 배포
    - 레벨5 - 없음

### 입출력

- [x] 프로그램을 시작하면 기능의 종류를 출력하고 그 중 하나의 입력을 받는다.

```
기능을 선택하세요.
1. 페어 매칭
2. 페어 조회
3. 페어 초기화
   Q. 종료
```

- [x] 과정와 미션을 출력하고 매칭하고자 하는 과정, 레벨, 미션을 입력 받는다.

```
#############################################
과정: 백엔드 | 프론트엔드
미션:
  - 레벨1: 자동차경주 | 로또 | 숫자야구게임
  - 레벨2: 장바구니 | 결제 | 지하철노선도
  - 레벨3:
  - 레벨4: 성능개선 | 배포
  - 레벨5:
############################################
과정, 레벨, 미션을 선택하세요.
ex) 백엔드, 레벨1, 자동차경주
```

- [x] 매칭이 정상적으로 수행되면 결과가 출력된다.

```
페어 매칭 결과입니다.
용팔 : 대만
대협 : 덕규
치수 : 준호
태웅 : 백호
달재 : 태산
한나 : 수겸
태섭 : 대남
준섭 : 소연
현준 : 호열
구식 : 경태
```