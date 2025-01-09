package com.fastcampus.post.domain;

import com.fastcampus.common.domain.PositiveIntegerCounter;
import com.fastcampus.post.domain.content.Content;
import com.fastcampus.user.domain.User;

import static com.fastcampus.post.domain.PostPublicationStatus.*;

public class Post {
    private final Long id;
    private final User author;
    private final Content content;
    private final PositiveIntegerCounter likeCount;
    private PostPublicationStatus status;

    public Post(Long id, User author, Content content) {
        if (author == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
        this.status = PUBLIC;
    }


    public void like(User user) {
        if (this.author.equals(user)) {
            throw new IllegalArgumentException();
        }

        likeCount.increase();
    }

    public void unLike() {
        likeCount.decrease();
    }

    public void updatePost(User user, String updateContent, PostPublicationStatus status) {
        if (!this.author.equals(user)) {
            throw new IllegalArgumentException();
        }

        this.status = status;
        this.content.updateContent(updateContent);
    }
}
