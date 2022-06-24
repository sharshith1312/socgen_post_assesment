package com.iiht.training.ratings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.iiht.training.ratings.dto.PoliticalLeaderDto;
import com.iiht.training.ratings.service.PoliticalLeaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/leaders")
public class PoliticalLeaderController {

	@Autowired
	private PoliticalLeaderService politicalLeaderService;

	@RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<?> registerPoliticalLeader(@Valid @RequestBody PoliticalLeaderDto politicalLeader){
		PoliticalLeaderDto leader_add=politicalLeaderService.registerPoliticalLeader(politicalLeader);
        return new ResponseEntity<Object>(leader_add, HttpStatus.OK);
    }

	@RequestMapping(value="", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePoliticalLeader(@Valid @RequestBody PoliticalLeaderDto politicalLeader){
		PoliticalLeaderDto leader_update=politicalLeaderService.updatePoliticalLeader(politicalLeader);
        return new ResponseEntity<Object>(leader_update, HttpStatus.OK);
    }
    
	@RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPoliticalLeaders(){
       List<PoliticalLeaderDto> leaders = politicalLeaderService.getAllPoliticalLeaders();
       return new ResponseEntity<Object>(leaders, HttpStatus.OK);
    }

    @RequestMapping(value="/{politicalLeaderId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPoliticalLeaderById(@PathVariable long politicalLeaderId){
		PoliticalLeaderDto leaderById = politicalLeaderService.getPoliticalLeaderById(politicalLeaderId);
		return new ResponseEntity<Object>(leaderById, HttpStatus.OK);
    }

	@RequestMapping(value="/by-party-id/{politicalPartyId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPoliticalLeaders(@PathVariable long politicalPartyId){
        List<PoliticalLeaderDto> leaders = politicalLeaderService.getPoliticalLeadersByPartyId(politicalPartyId);
       return new ResponseEntity<Object>(leaders, HttpStatus.OK);
    }

	@RequestMapping(value = "/{politicalPartyId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable long politicalPartyId){

        boolean deleted = politicalLeaderService.deletePoliticalLeader(politicalPartyId);

        return new ResponseEntity<Object>(deleted, HttpStatus.OK);
    }
}
