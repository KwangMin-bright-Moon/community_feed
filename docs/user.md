1. 유저의 정보를 입력을 받음 // Controller
2. 유저의 유효성 정보를 확인 (이름 빈 값인지)
3. 유저 정보 저장 // Repository


이름 빈 값인지 확인하는 경우 vo를 활용할 경우 다른 곳에서 재사용 할 수 있다.


유즈 케이스를 보고 행동을 추출 할 것 (책임 주도 설계)
어떤 레이어에게 책임을 줄 지 생각하기, 비즈니스 요구사항이 변함에 따라 repository 에 위임한 걸 도메인에 가져 올 수도 있다.

팔로우 유즈 케이스를 보면서 아래와 같이 정리 
1. 팔로우 유저, 팔로우 당하는 유저 입력을 받고 불러오기 // Controller, Service
2. 팔로우 여부 확인하기 // Repository
    - 팔로우 상태라면, 에러를 반환하기 // Service
3. 자기 자신이라면 에러를 반환하기 // Domain
4. 팔로우 유저 카운트 변경 // Domain
5. 팔로잉 유저 카운트 변경 // Domain
6. 팔로우 여부 저장 및 유저 변경 사항 저장 // Repository

유저가 카운터를 증가시키고 감소시키는 로직을 수행하기 보다는
나중에 재사용할 수 있도록 userRelationCounter 라는 vo를 생성해서
책임을 위임해도 좋겠다.


```java
 public void follow(User targetUser) {
        if (this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }

        followingCounter.increase();
        targetUser.followerCounter.increase();
    }
```
객체 지향 생활체조의 디미터의 법칙에서는 친구하고만 대화하라는 말이 있다.
자신의 소유 객체하고만 대화해야하지 그 내부 속 까지 들여다 보면서 대화하면
캡슐화가 깨지는 문제가 발생