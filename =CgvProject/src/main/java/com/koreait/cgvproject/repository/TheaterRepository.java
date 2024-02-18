package com.koreait.cgvproject.repository;

import com.koreait.cgvproject.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

    List<Theater> findAllByAreacode(Long areacode);

    Theater findByTcode(Long tcode);

    Theater findByTname(String tname);
}
