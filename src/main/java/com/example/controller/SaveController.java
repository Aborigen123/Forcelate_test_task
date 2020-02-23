package com.example.controller;

import java.util.Base64;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Response;
import com.example.entity.Articles;
import com.example.entity.User;
import com.example.service.ArticlesService;
import com.example.service.UserService;

import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("save")
public class SaveController {

	@Autowired
	private ArticlesService articlesService;
	@Autowired
	private UserService userService;

	@Value("${jwt.token.secret}")
	private String secret;

	@PostConstruct
	protected void init() {
		secret = Base64.getEncoder().encodeToString(secret.getBytes());
	}

	@PostMapping("/articles")
	public ResponseEntity<?> saveArticles(@RequestHeader("Authorization") String token,
			@RequestBody Articles articles) {

		User user = userService.findUserByEmail(getUsername(token.substring(7)));
		if (user == null) {
			return new ResponseEntity<Response>(new Response("Null"), HttpStatus.BAD_REQUEST);
		}
		articles.setUser(user);
		articlesService.saveArticles(articles);

		return new ResponseEntity<Articles>(articles, HttpStatus.CREATED);
	}

	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}

}
