package com.iiht.training.ratings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.validation.Valid;

import com.iiht.training.ratings.dto.DevelopmentDto;
import com.iiht.training.ratings.service.DevelopmentService;

@RestController
@RequestMapping("/developments")
public class DevelopmentController {

	@Autowired
	private DevelopmentService developmentService;
	@RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<?> createDevelopment(@Valid @RequestBody DevelopmentDto development){
		DevelopmentDto development_add=developmentService.createDevelopment(development);
        return new ResponseEntity<Object>(development_add, HttpStatus.OK);
    }

	@RequestMapping(value="", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDevelopment(@Valid @RequestBody DevelopmentDto development){
		DevelopmentDto development_update=developmentService.updateDevelopment(development);
        return new ResponseEntity<Object>(development_update, HttpStatus.OK);
    }
    
	@RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDevelopments(){
       List<DevelopmentDto> developments = developmentService.getAllDevelopments();
       return new ResponseEntity<Object>(developments, HttpStatus.OK);
	}
	@RequestMapping(value="/{developmentId}", method = RequestMethod.GET)
	public ResponseEntity<?> getDevelopmentById(@PathVariable long developmentId){
		DevelopmentDto development = developmentService.getDevelopmentById(developmentId);
		return new ResponseEntity<Object>(development, HttpStatus.OK);
	}

	@RequestMapping(value="/by-leader-id/{politicalLeaderId}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllDevelopmentsByLeaderId(@PathVariable long politicalLeaderId){
		List<DevelopmentDto> developments = developmentService.getAllDevelopmentsByLeaderId(politicalLeaderId);
		return new ResponseEntity<Object>(developments, HttpStatus.OK);
	}

	@RequestMapping(value = "/{developmentId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteDevelopment(@PathVariable long developmentId){

		boolean deleted = developmentService.deleteDevelopment(developmentId);

		return new ResponseEntity<Object>(deleted, HttpStatus.OK);
	}
	
}
