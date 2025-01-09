1. 게시글의 정보를 입력받는다.
2. 유저 유효성 확인 - 존재하는 유저인지
3. 게시글의 유효성 확인 (5자 이상 500자 이하) // Domain
4. db 게시글 저장

```java

public abstract class Content {
    String contentText;

    public Content(String contentText) {
        checkText(contentText);
        this.contentText = contentText;
    }

    protected abstract void checkText(String contentText);

    public String getContentText() {
        return contentText;
    }
}

```
Content를 추상화해서 PostContent, CommentContent가 같은 역할을 수행할 수 있도록 수정했다
덕분에 코드 일관성을 지키면서 검증 로직을 캡슐화할 수 있었다.