package com.iiht.training.ratings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.ratings.service.PoliticalLeaderService;

@RestController
@RequestMapping("/leaders")
public class PoliticalLeaderController {

	@Autowired
	private PoliticalLeaderService politicalLeaderService;

	
}
