package com.iiht.training.ratings.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.ratings.dto.PoliticalLeaderDto;
import com.iiht.training.ratings.entity.PoliticalLeader;
import com.iiht.training.ratings.exceptions.PoliticalLeaderNotFoundException;
import com.iiht.training.ratings.repository.PoliticalLeaderRepository;
import com.iiht.training.ratings.service.PoliticalLeaderService;

@Service
public class PoliticalLeaderServiceImpl implements PoliticalLeaderService {

	@Autowired
	private PoliticalLeaderRepository repository;
	public PoliticalLeader dtoToEntity(PoliticalLeaderDto politicalLeaderDto){
        PoliticalLeader politicalLeader = new PoliticalLeader();
        politicalLeader.setPoliticalLeaderId(politicalLeaderDto.getPoliticalLeaderId());
        politicalLeader.setPoliticalPartyId(politicalLeaderDto.getPoliticalPartyId());
        politicalLeader.setCandidateName(politicalLeaderDto.getCandidateName());
        politicalLeader.setCandidateState(politicalLeaderDto.getCandidateState());
        return politicalLeader;
    }

    public PoliticalLeaderDto EntityToDto(PoliticalLeader politicalLeader){ 
        PoliticalLeaderDto politicalLeaderDto = new PoliticalLeaderDto();
        politicalLeaderDto.setPoliticalLeaderId(politicalLeader.getPoliticalLeaderId());
        politicalLeaderDto.setPoliticalPartyId(politicalLeader.getPoliticalPartyId());
        politicalLeaderDto.setCandidateName(politicalLeader.getCandidateName());
        politicalLeaderDto.setCandidateState(politicalLeader.getCandidateState());
        return politicalLeaderDto;
    }
	@Override
	public PoliticalLeaderDto registerPoliticalLeader(PoliticalLeaderDto leaderDto) {
		PoliticalLeader politicalLeader = dtoToEntity(leaderDto);
        PoliticalLeader savedLeader = repository.save(politicalLeader);
       
        PoliticalLeaderDto politicalLeaderDto=EntityToDto(savedLeader);
        
        return politicalLeaderDto;
		
	}

	@Override
	public PoliticalLeaderDto updatePoliticalLeader(PoliticalLeaderDto leaderDto) {
		Optional<PoliticalLeader> optionalLeader = repository.findById(leaderDto.getPoliticalLeaderId());

		if(optionalLeader.isPresent()){
			PoliticalLeader leader = optionalLeader.get();
			leader.setPoliticalLeaderId(leaderDto.getPoliticalPartyId());
			leader.setCandidateName(leaderDto.getCandidateName());
			leader.setCandidateState(leaderDto.getCandidateState());
			PoliticalLeader savedLeader = repository.save(leader);
			return EntityToDto(savedLeader);
		}
		else{
			throw new PoliticalLeaderNotFoundException();
		}
		
	}

	@Override
	public boolean deletePoliticalLeader(Long politicalLeaderId) {
		Optional<PoliticalLeader> optionalLeader = repository.findById(politicalLeaderId);

		if(optionalLeader.isPresent()){
			PoliticalLeader leader = optionalLeader.get();
			repository.delete(leader);
			return true;
		}else{
			throw new PoliticalLeaderNotFoundException();
		}
		
	}

	@Override
	public PoliticalLeaderDto getPoliticalLeaderById(Long politicalLeaderId) {
		Optional<PoliticalLeader> optionalLeader = repository.findById(politicalLeaderId);
		
		if(optionalLeader.isPresent()){
			PoliticalLeader politicalLeader = optionalLeader.get();

			return EntityToDto(politicalLeader);
		}
		else{
			throw new PoliticalLeaderNotFoundException();
		}
		

	}

	@Override
	public List<PoliticalLeaderDto> getAllPoliticalLeaders() {
		List<PoliticalLeader> leaders = repository.findAll();
		List<PoliticalLeaderDto> leadersDTO = new ArrayList<PoliticalLeaderDto>();
		
		for(PoliticalLeader leader : leaders){
			leadersDTO.add(EntityToDto(leader));
		}
		return leadersDTO;
	}

	@Override
	public List<PoliticalLeaderDto> getPoliticalLeadersByPartyId(Long politicalPartyId) {
		List<PoliticalLeader> leaders= repository.findByPoliticalPartyId(politicalPartyId);
		List<PoliticalLeaderDto> leadersDTO = new ArrayList<PoliticalLeaderDto>();
		
		for(PoliticalLeader leader : leaders){
			leadersDTO.add(EntityToDto(leader));
		}
		return leadersDTO;

	}

}
