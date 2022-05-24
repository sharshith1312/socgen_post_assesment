package com.iiht.training.ratings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.ratings.service.PoliticalPartyService;

@RestController
@RequestMapping("/parties")
public class PoliticalPartyController {

	@Autowired
	private PoliticalPartyService politicalPartyService;

	
}
