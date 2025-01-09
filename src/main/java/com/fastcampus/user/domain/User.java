package com.fastcampus.user.domain;

import java.util.Objects;

public class User {

    private final Long id;
    private final UserInfo info;
    private final UserRelationCounter followerCounter;
    private final UserRelationCounter followingCounter;


    public User(Long id, UserInfo userInfo) {
        this.id = id;
        this.info = userInfo;
        this.followerCounter = new UserRelationCounter();
        this.followingCounter = new UserRelationCounter();
    }

    public void follow(User targetUser) {
        if (this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }

        followingCounter.increase();
        targetUser.increaseFollowerCount();
    }

    public void unfollow(User targetUser) {
        if (this.equals(targetUser)) {
            throw new IllegalArgumentException();
        }

        followingCounter.decrease();
        targetUser.decreaseFollowerCount();
    }

    private void increaseFollowerCount(){
        followingCounter.increase();
    }

    private void decreaseFollowerCount(){
        followingCounter.decrease();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
