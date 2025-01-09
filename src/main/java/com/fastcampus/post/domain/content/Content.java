package com.fastcampus.post.domain.content;

import com.fastcampus.post.domain.common.DateTimeInfo;

public abstract class Content {
    String contentText;
    final DateTimeInfo dateTimeInfo;

    public Content(String contentText) {
        checkText(contentText);
        this.contentText = contentText;
        this.dateTimeInfo = new DateTimeInfo();
    }

    public void updateContent(String contentText) {
        checkText(contentText);
        this.contentText = contentText;
        this.dateTimeInfo.updateEditDateTime();
    }

    protected abstract void checkText(String contentText);

    public String getContentText() {
        return contentText;
    }
}
