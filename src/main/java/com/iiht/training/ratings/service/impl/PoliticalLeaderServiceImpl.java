package com.iiht.training.ratings.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.ratings.dto.PoliticalLeaderDto;
import com.iiht.training.ratings.repository.PoliticalLeaderRepository;
import com.iiht.training.ratings.service.PoliticalLeaderService;

@Service
public class PoliticalLeaderServiceImpl implements PoliticalLeaderService {

	@Autowired
	private PoliticalLeaderRepository repository;

	@Override
	public PoliticalLeaderDto registerPoliticalLeader(PoliticalLeaderDto leaderDto) {
		return null;
	}

	@Override
	public PoliticalLeaderDto updatePoliticalLeader(PoliticalLeaderDto leaderDto) {
		return null;
	}

	@Override
	public boolean deletePoliticalLeader(Long politicalLeaderId) {
		return false;
	}

	@Override
	public PoliticalLeaderDto getPoliticalLeaderById(Long politicalLeaderId) {
		return null;

	}

	@Override
	public List<PoliticalLeaderDto> getAllPoliticalLeaders() {
		return null;
	}

	@Override
	public List<PoliticalLeaderDto> getPoliticalLeadersByPartyId(Long politicalLeaderId) {
		return null;

	}

}
