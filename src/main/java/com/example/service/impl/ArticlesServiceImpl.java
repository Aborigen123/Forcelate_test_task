package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Articles;
import com.example.entity.emuneration.Color;
import com.example.repository.ArticlesRepository;
import com.example.service.ArticlesService;

@Service
public class ArticlesServiceImpl implements ArticlesService {

	private final ArticlesRepository articlesRepository;

	@Autowired
	public ArticlesServiceImpl(ArticlesRepository articlesRepository) {
		this.articlesRepository = articlesRepository;
	}

	@Override
	public void saveArticles(Articles articles) {
		articlesRepository.save(articles);
	}

	@Override
	public List<Articles> findAllUserByColor(Color color) {

		return articlesRepository.findAllUserByColor(color);
	}

	@Override
	public Color colorCheck(String colorString) {
		if (colorString == null) {
			return null;
		}

		Color color = null;
		Colorequals: {
			for (Color c : Color.values()) {

				if (c.name().equals(colorString.toUpperCase())) {
					color = c;
					break Colorequals;
				}

			}
		}

		if (color == null) {
			return null;
		}

		return color;
	}

}
