package com.airpass.test3.repository;

import com.airpass.test3.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    //JpaRepository 제네릭에 해당 엔티티 클래스 파일과 프라이머리키의 자료형 쓴다



}
