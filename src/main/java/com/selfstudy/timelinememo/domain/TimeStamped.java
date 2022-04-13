package com.selfstudy.timelinememo.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public abstract class TimeStamped {
    // 작성 시간
    @CreatedDate
    private LocalDateTime createdTime;

    // 수정 시간
    @LastModifiedDate
    private LocalDateTime modifiedTime;

}
