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

import com.iiht.training.ratings.dto.PoliticalPartyDto;
import com.iiht.training.ratings.service.PoliticalPartyService;

@RestController
@RequestMapping("/parties")
public class PoliticalPartyController {

	@Autowired
	private PoliticalPartyService politicalPartyService;

	@RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<?> registerPoliticalLeader(@Valid @RequestBody PoliticalPartyDto politicalparty){
		PoliticalPartyDto party_add=politicalPartyService.registerParty(politicalparty);
        return new ResponseEntity<Object>(party_add, HttpStatus.OK);
    }

	@RequestMapping(value="", method = RequestMethod.PUT)
    public ResponseEntity<?> updateParty(@Valid @RequestBody PoliticalPartyDto politicalparty){
		PoliticalPartyDto party_update=politicalPartyService.updateParty(politicalparty);
        return new ResponseEntity<Object>(party_update, HttpStatus.OK);
    }
    
	@RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPoliticalLeaders(){
       List<PoliticalPartyDto> Parties = politicalPartyService.getAllParties();
       return new ResponseEntity<Object>(Parties, HttpStatus.OK);
    }
    
	@RequestMapping(value="/{politicalPartyId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPartyById(@PathVariable long politicalPartyId){
        PoliticalPartyDto party = politicalPartyService.getPartyById(politicalPartyId);
       return new ResponseEntity<Object>(party, HttpStatus.OK);
    }

	@RequestMapping(value = "/{politicalPartyId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable long politicalPartyId){

        boolean deleted = politicalPartyService.deleteParty(politicalPartyId);

        return new ResponseEntity<Object>(deleted, HttpStatus.OK);
    }

}
