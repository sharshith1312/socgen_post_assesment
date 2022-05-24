package com.iiht.training.ratings.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.ratings.dto.PoliticalPartyDto;
import com.iiht.training.ratings.repository.PoliticalPartyRepository;
import com.iiht.training.ratings.service.PoliticalPartyService;

@Service
public class PoliticalPartyServiceImpl implements PoliticalPartyService {

	@Autowired
	private PoliticalPartyRepository politicalPartyRepository;

	@Override
	public PoliticalPartyDto registerParty(PoliticalPartyDto politicalPartyDto) {
		return null;
	}

	@Override
	public PoliticalPartyDto updateParty(PoliticalPartyDto politicalPartyDto) {
		return null;
	}

	@Override
	public boolean deleteParty(Long partyId) {
		return false;
	}

	@Override
	public PoliticalPartyDto getPartyById(Long partyId) {
		return null;
	}

	@Override
	public List<PoliticalPartyDto> getAllParties() {
		return null;
	}


}
