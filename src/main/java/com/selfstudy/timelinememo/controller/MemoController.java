package com.selfstudy.timelinememo.controller;

import com.selfstudy.timelinememo.domain.Memo;
import com.selfstudy.timelinememo.repository.MemoRepository;
import com.selfstudy.timelinememo.dto.MemoRequestDto;
import com.selfstudy.timelinememo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    // DB 에서 모든 메모를 가져와서 돌려줘야함.
    @GetMapping("/memos")
    public List<Memo> readMemos() {
        return memoRepository.findAll();
    }

    // 전달 받은 requestDto 를 사용해 DB 에 새로운 정보 저장
    @PostMapping("/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }

    // 왜 Controller 에서 그냥 update 진행하지 않고 Service 에 들어가서 update 진행하지? -> 잦은 수정에 따른 불편함 해소 / 너무 많은 양의 코드 방지
    @PutMapping("/memos/{id}")
    public void updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
    }

    @DeleteMapping("/memos/{id}")
    public void deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
    }

}
