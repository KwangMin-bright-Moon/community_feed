1. 댓글의 정보를 입력받기
2. 유저의 유효성 확인 - 존재하는지
3. 게시글의 유효성 확인 - 존재하는지
4. 댓글 유효성 검사 // Domain
   - 100자 초과면 에러를 반환
5. db 댓글 저장

댓글 유효성 검사 부분이 개시글 검증 부분과 유사하다.
검증하는 걸 추상화 하고 이걸 다형성을 이용해 구현하면 변경 사항에 유연하게 대처할 수 있다.
