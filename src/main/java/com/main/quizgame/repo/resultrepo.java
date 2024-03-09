package com.main.quizgame.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.quizgame.model.Result;
@Repository
public interface resultrepo extends JpaRepository<Result,Integer> {

}
