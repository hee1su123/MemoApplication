package com.selfstudy.timelinememo.domain;

import com.selfstudy.timelinememo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor // username 과 text 가 nullable = false 인데 이게 있어도 되나?
public class Memo extends TimeStamped {
    // 아이디 번호
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;

    // 메모 작성자
    @Column(nullable = false)
    String username;

    // 메모 내용
    @Column(nullable = false)
    String text;

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.text = requestDto.getText();
    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.text = requestDto.getText();
    }
}
