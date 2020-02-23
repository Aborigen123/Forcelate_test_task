package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.domain.Response;
import com.example.entity.emuneration.Color;
import com.example.service.ArticlesService;
import com.example.service.UserService;

@RestController
@RequestMapping("select")
public class SelectController {

	private final UserService userService;
	private final ArticlesService articlesService;

	@Autowired
	public SelectController(UserService userService, ArticlesService articlesService) {
		this.userService = userService;
		this.articlesService = articlesService;
	}

	@GetMapping("/age/{ageValue}")
	public ResponseEntity<?> getByAge(@PathVariable("ageValue") Integer age) {

		if (age == null) {
			return new ResponseEntity<Response>(new Response("Null"), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(userService.findUserByMoreAge(age), HttpStatus.FOUND);
	}

	@GetMapping("/color/{colorValue}")
	public ResponseEntity<?> getByColor(@PathVariable("colorValue") String colorString) {

		Color color = articlesService.colorCheck(colorString);

		if (color == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This color is incorrect: [RED, BLUE, GREEN]");
		}

		return new ResponseEntity<>(articlesService.findAllUserByColor(color), HttpStatus.FOUND);
	}

	@GetMapping("/uniquename")
	public ResponseEntity<?> getUniqueName() {

		return new ResponseEntity<>(userService.findUniqueNameMoreThree(), HttpStatus.OK);
	}
}
