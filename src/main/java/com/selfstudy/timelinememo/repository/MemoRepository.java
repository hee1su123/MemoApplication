package com.selfstudy.timelinememo.repository;

import com.selfstudy.timelinememo.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
