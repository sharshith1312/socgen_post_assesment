package com.iiht.training.ratings.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.ratings.dto.DevelopmentDto;
import com.iiht.training.ratings.repository.DevelopmentRepository;
import com.iiht.training.ratings.service.DevelopmentService;

@Service
public class DevelopmentServiceImpl implements DevelopmentService {

	@Autowired
	private DevelopmentRepository repository;

	@Override
	public DevelopmentDto createDevelopment(DevelopmentDto developmentDto) {
		return null;
	}

	@Override
	public DevelopmentDto updateDevelopment(DevelopmentDto developmentDto) {
		return null;
	}

	@Override
	public boolean deleteDevelopment(Long developmentId) {
		return false;
	}

	@Override
	public DevelopmentDto getDevelopmentById(Long developmentId) {
		return null;
	}

	@Override
	public List<DevelopmentDto> getAllDevelopments() {
		return null;
	}

	@Override
	public List<DevelopmentDto> getAllDevelopmentsByLeaderId(Long politicalLeaderId) {
		return null;
	}

}
