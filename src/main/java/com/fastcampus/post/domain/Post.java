package com.fastcampus.post.domain;

import com.fastcampus.post.domain.content.Content;
import com.fastcampus.user.domain.User;

public class Post {
    private final Long id;
    private final User author;
    private final Content content;

    public Post(Long id, User author, Content content) {
        if (author == null) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.author = author;
        this.content = content;
    }
}
