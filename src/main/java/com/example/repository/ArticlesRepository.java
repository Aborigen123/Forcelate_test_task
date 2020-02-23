package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Articles;
import com.example.entity.emuneration.Color;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Long>{

	
	@Query("SELECT a FROM Articles a RIGHT JOIN User u ON a.user = u.id WHERE a.color = :color ")
	List<Articles> findAllUserByColor(@Param ("color") Color color);
}
