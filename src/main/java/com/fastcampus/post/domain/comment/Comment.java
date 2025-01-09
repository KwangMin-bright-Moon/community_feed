package com.fastcampus.post.domain.comment;

import com.fastcampus.common.domain.PositiveIntegerCounter;
import com.fastcampus.post.domain.Post;
import com.fastcampus.post.domain.content.Content;
import com.fastcampus.user.domain.User;

public class Comment {
    private final Long id;
    private final User author;
    private final Post post;
    private final Content content;
    private final PositiveIntegerCounter likeCount;

    public Comment(Long id, User author, Post post, Content content) {
        if (author == null) {
            throw new IllegalArgumentException();
        }

        if (post == null) {
            throw new IllegalArgumentException();
        }

        if (content == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.author = author;
        this.post = post;
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
