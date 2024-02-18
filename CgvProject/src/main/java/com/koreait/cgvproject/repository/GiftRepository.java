package com.koreait.cgvproject.repository;

import com.koreait.cgvproject.entity.Gift;
import com.koreait.cgvproject.entity.GiftPayment;
import com.koreait.cgvproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {

    List<Gift> findByCategoryOrderByGcode(String cno);
    List<Gift> findByMainonOrderByGcode(Integer mainon);
    List<Gift> findAllByMainonGreaterThan(Integer mainon);
    List<Gift> findByGcode(Long gcode);
}
