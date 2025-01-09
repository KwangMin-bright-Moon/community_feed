package com.fastcampus.post.domain;

import com.fastcampus.common.domain.PositiveIntegerCounter;
import com.fastcampus.post.domain.content.Content;
import com.fastcampus.user.domain.User;

public class Post {
    private final Long id;
    private final User author;
    private final Content content;
    private final PositiveIntegerCounter likeCount;

    public Post(Long id, User author, Content content) {
        if (author == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
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
}
