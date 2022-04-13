package com.selfstudy.timelinememo.service;

import com.selfstudy.timelinememo.domain.Memo;
import com.selfstudy.timelinememo.repository.MemoRepository;
import com.selfstudy.timelinememo.dto.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public void update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ID doesn't exists")
        );
        memo.update(requestDto);
    }
}
