# ticket-gacha
# 프로젝트 목표🙂
- 인터파크, 티몬과 같은 티켓 예매 시스템 개발하기
- 대용량 트래픽 처리를 고려한 기능 구현하기
- 객체지향 이론과 클린 코드 원칙을 바탕으로 코드 작성하기
- 테스트 코드 및 문서화를 통해 보다 안정적인 소프트웨어를 개발하기
- 선택한 방법에 대해 `왜?`라는 질문을 하여, 그 방법이 타당하고 필요한지 생각하기

# 이렇게 개발했어요

## Git-flow 사용
<img src=".assets/git-flow.png" width="50%" height="50%"/>

- 저희는 Git-flow 전략에서 master, develop, feature 브랜치를 이용한 전략을 가져가기로 했습니다.
- github Issues에 먼저 개발할 기능을 등록한 후 해당 이슈 번호로 feature 브랜치를 생성합니다.
- 기능을 모두 개발하면 develop 브랜치에 PR을 생성한 뒤 팀원의 코드리뷰를 받고 merge를 진행합니다.
- [참고자료 - 우아한형제들 기술블로그 : 우린 Git-flow를 사용하고 있어요](https://techblog.woowahan.com/2553/)

## 기술스택
- Spring boot 3.0.4
- Java 17
- Gradle
- JPA

## ERD
![ERD](.assets/ERD.PNG)
