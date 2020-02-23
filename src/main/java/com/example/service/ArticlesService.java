package com.example.service;

import java.util.List;

import com.example.entity.Articles;
import com.example.entity.emuneration.Color;

public interface ArticlesService {

	void saveArticles(Articles articles);

	List<Articles> findAllUserByColor(Color color);
	
	Color colorCheck(String string);
}
