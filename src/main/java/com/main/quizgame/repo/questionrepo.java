package com.main.quizgame.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.quizgame.model.Question;
@Repository
public interface questionrepo extends JpaRepository<Question,Integer> {

}