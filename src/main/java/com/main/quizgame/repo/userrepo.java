package com.main.quizgame.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.quizgame.model.user;
@Repository
public interface userrepo  extends JpaRepository<user,String> {

}
