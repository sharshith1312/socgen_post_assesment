package com.iiht.training.ratings.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.ratings.dto.PoliticalPartyDto;
import com.iiht.training.ratings.entity.PoliticalParty;
import com.iiht.training.ratings.exceptions.PoliticalPartyNotFoundException;
import com.iiht.training.ratings.repository.PoliticalPartyRepository;
import com.iiht.training.ratings.service.PoliticalPartyService;

@Service
public class PoliticalPartyServiceImpl implements PoliticalPartyService {

	@Autowired
	private PoliticalPartyRepository politicalPartyRepository;

	public PoliticalParty dtoToEntity(PoliticalPartyDto politicalPartyDto){
        PoliticalParty politicalParty = new PoliticalParty();
        politicalParty.setPartyName(politicalPartyDto.getPartyName());
        politicalParty.setFounderName(politicalPartyDto.getFounderName());
        
        return politicalParty;
    }

    public PoliticalPartyDto EntityToDto(PoliticalParty politicalParty){ 
        PoliticalPartyDto politicalPartyDto=new PoliticalPartyDto();
        politicalPartyDto.setPoliticalPartyId(politicalParty.getPoliticalPartyId());
        politicalPartyDto.setPartyName(politicalParty.getPartyName());
        politicalPartyDto.setFounderName(politicalParty.getFounderName());
        return politicalPartyDto;
    }

	@Override
	public PoliticalPartyDto registerParty(PoliticalPartyDto politicalPartyDto) {

		PoliticalParty politicalParty = dtoToEntity(politicalPartyDto);
		
		// politicalParty.setFounderName(politicalPartyDto.getFounderName());
		// politicalParty.setPartyName(politicalPartyDto.getPartyName());
		
		PoliticalParty savedPoliticalParty = politicalPartyRepository.save(politicalParty);
		PoliticalPartyDto savedPoliticalPartyDto=EntityToDto(savedPoliticalParty);
		
		
		return savedPoliticalPartyDto;
	}

	@Override
	public PoliticalPartyDto updateParty(PoliticalPartyDto politicalPartyDto) {
		Optional<PoliticalParty> optionalPoliticalParty = politicalPartyRepository.findById(politicalPartyDto.getPoliticalPartyId());
		if(optionalPoliticalParty.isPresent()){
			PoliticalParty politicalParty = optionalPoliticalParty.get();
			politicalParty.setFounderName(politicalPartyDto.getFounderName());
			politicalParty.setPartyName(politicalPartyDto.getPartyName());
			politicalPartyRepository.save(politicalParty);
		} else{
			throw new PoliticalPartyNotFoundException();
		}
		return politicalPartyDto;
	}

	@Override
	public boolean deleteParty(Long partyId) {
		Optional<PoliticalParty> optionalPoliticalParty = politicalPartyRepository.findById(partyId);
		if(optionalPoliticalParty.isPresent()){
			politicalPartyRepository.delete(optionalPoliticalParty.get());
			return true;
		} else{
			throw new PoliticalPartyNotFoundException();
		}

	}

	@Override
	public PoliticalPartyDto getPartyById(Long partyId) {
		Optional<PoliticalParty> optionalPoliticalParty = politicalPartyRepository.findById(partyId);
		if(optionalPoliticalParty.isPresent()){
			PoliticalParty politicalParty = optionalPoliticalParty.get();
			PoliticalPartyDto politicalPartyDto = new PoliticalPartyDto();
			politicalPartyDto.setFounderName(politicalParty.getFounderName());
			politicalPartyDto.setPartyName(politicalParty.getPartyName());
			politicalPartyDto.setPoliticalPartyId(politicalParty.getPoliticalPartyId());
			return politicalPartyDto; 
		} else{
			throw new PoliticalPartyNotFoundException();
		}
		
	}

	@Override
	public List<PoliticalPartyDto> getAllParties() {
		
		List<PoliticalParty> politicalPartiesAsEntlist = politicalPartyRepository.findAll();
        List<PoliticalPartyDto> listAsDto=new ArrayList<>();
        for (PoliticalParty poliEnt : politicalPartiesAsEntlist ) {
            PoliticalPartyDto item=EntityToDto(poliEnt);
            listAsDto.add(item);
        }
        System.out.println(listAsDto);
		return listAsDto;
	}


}
