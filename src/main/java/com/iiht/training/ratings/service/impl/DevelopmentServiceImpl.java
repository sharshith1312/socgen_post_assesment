package com.iiht.training.ratings.service.impl;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.ratings.dto.DevelopmentDto;
import com.iiht.training.ratings.entity.Development;
import com.iiht.training.ratings.exceptions.DevelopmentNotFoundException;
import com.iiht.training.ratings.repository.DevelopmentRepository;
import com.iiht.training.ratings.service.DevelopmentService;

@Service
public class DevelopmentServiceImpl implements DevelopmentService {

	@Autowired
	private DevelopmentRepository repository;

	@Override
	public DevelopmentDto createDevelopment(DevelopmentDto developmentDto) {
		Development development = new Development();
		development.setActivity(developmentDto.getActivity());
		development.setActivityMonth(developmentDto.getActivityMonth());
		development.setActivityYear(developmentDto.getActivityYear());
		development.setBudget(developmentDto.getBudget());
		development.setPoliticalLeaderId(developmentDto.getPoliticalLeaderId());
		development.setState(developmentDto.getState());
		development.setTitle(developmentDto.getTitle());

		Development savedDevelopment = repository.save(development);

		developmentDto.setDevelopmentId(savedDevelopment.getDevelopmentId());
		return developmentDto;
	}

	@Override
	public DevelopmentDto updateDevelopment(DevelopmentDto developmentDto) {
		Optional<Development> optionalDevelopment = repository.findById(developmentDto.getDevelopmentId());
		if(optionalDevelopment.isPresent()){
			Development development = optionalDevelopment.get();
			development.setActivity(developmentDto.getActivity());
			development.setActivityMonth(developmentDto.getActivityMonth());
			development.setActivityYear(developmentDto.getActivityYear());
			development.setBudget(developmentDto.getBudget());
			development.setPoliticalLeaderId(developmentDto.getPoliticalLeaderId());
			development.setState(developmentDto.getState());
			development.setTitle(developmentDto.getTitle());
			repository.save(development);
		} else{
			throw new DevelopmentNotFoundException();
		}
		return developmentDto;
	}

	@Override
	public boolean deleteDevelopment(Long developmentId) {
		Optional<Development> optionalDevelopment = repository.findById(developmentId);
		if(optionalDevelopment.isPresent()){
			repository.delete(optionalDevelopment.get());
			return true;
		} else{
			throw new DevelopmentNotFoundException();
		}
	}

	@Override
	public DevelopmentDto getDevelopmentById(Long developmentId) {
		Optional<Development> optionalDevelopment = repository.findById(developmentId);
		if(optionalDevelopment.isPresent()){
			Development development = optionalDevelopment.get();
			DevelopmentDto developmentDto = new DevelopmentDto();
			
			developmentDto.setActivity(development.getActivity());
			developmentDto.setActivityMonth(development.getActivityMonth());
			developmentDto.setActivityYear(development.getActivityYear());
			developmentDto.setBudget(development.getBudget());
			developmentDto.setDevelopmentId(development.getDevelopmentId());
			developmentDto.setPoliticalLeaderId(development.getPoliticalLeaderId());
			developmentDto.setState(development.getState());
			developmentDto.setTitle(development.getTitle());

			return developmentDto; 
		} else{
			throw new DevelopmentNotFoundException();
		}
	}

	@Override
	public List<DevelopmentDto> getAllDevelopments() {
		List<Development> developmentList = repository.findAll();
		List<DevelopmentDto> list = developmentList.stream().map(development -> {
			DevelopmentDto developmentDto = new DevelopmentDto();
			developmentDto.setActivity(development.getActivity());
			developmentDto.setActivityMonth(development.getActivityMonth());
			developmentDto.setActivityYear(development.getActivityYear());
			developmentDto.setBudget(development.getBudget());
			developmentDto.setDevelopmentId(development.getDevelopmentId());
			developmentDto.setPoliticalLeaderId(development.getPoliticalLeaderId());
			developmentDto.setState(development.getState());
			developmentDto.setTitle(development.getTitle());
			return developmentDto;
		}).collect(Collectors.toList());
		return list;
	}

	@Override
	public List<DevelopmentDto> getAllDevelopmentsByLeaderId(Long politicalLeaderId) {
		List<Development> developmentList = repository.findByPoliticalLeaderId(politicalLeaderId);
		List<DevelopmentDto> list = developmentList.stream().map(development -> {
			DevelopmentDto developmentDto = new DevelopmentDto();
			developmentDto.setActivity(development.getActivity());
			developmentDto.setActivityMonth(development.getActivityMonth());
			developmentDto.setActivityYear(development.getActivityYear());
			developmentDto.setBudget(development.getBudget());
			developmentDto.setDevelopmentId(development.getDevelopmentId());
			developmentDto.setPoliticalLeaderId(development.getPoliticalLeaderId());
			developmentDto.setState(development.getState());
			developmentDto.setTitle(development.getTitle());
			return developmentDto;
		}).collect(Collectors.toList());
		return list;
	}

}