package com.api.docker.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.docker.rest.dto.TutorialDTO;
import com.api.docker.rest.model.Tutorial;
import com.api.docker.rest.rerpository.TutorialRepository;
import com.api.docker.rest.util.TutorialesMapper;

 

@Service 
public class TutorialService {
	
	@Autowired
	private  TutorialRepository repository;
	
 
	
	public List<TutorialDTO> findAll(String title){
		List<Tutorial> tutorials = new ArrayList<Tutorial>();
		if(title == null) {
			repository.findAll().forEach(tutorials::add);
		}else {
			repository.findByTitleContaining(title).forEach(tutorials::add);
		}	
		List<TutorialDTO> dtoList = tutorials.stream()
									.map(t -> new TutorialDTO(t.getTitle(), t.getDescription(), t.isPublished()))
									.collect(Collectors.toList());
		return  dtoList;
	}
	
	public TutorialDTO findById(Long id) {
		Optional<Tutorial> tutorialData = repository.findById(id);
		if (tutorialData.isPresent()) {
			Tutorial tutorial = tutorialData.get();
			TutorialDTO dto = new TutorialDTO(tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished());
			return dto;
		}
		return null;
	}
	
	public TutorialDTO createTutorial(TutorialDTO tutorialDto) {
		if(tutorialDto != null) {
			Tutorial tutorial = new Tutorial(tutorialDto.getTitle(),tutorialDto.getDescription(),false);			
			return TutorialesMapper.toDto(repository.save(tutorial));
		}		
		return null;
	}
	
	public TutorialDTO updateById(Long id, TutorialDTO tutorialDto) {
		Optional<Tutorial> tutorialData = repository.findById(id);
		if (tutorialData.isPresent()) {
			Tutorial _tutorial = tutorialData.get();
			 _tutorial.setTitle(tutorialDto.getTitle());
			 _tutorial.setDescription(tutorialDto.getDescription());
			 _tutorial.setPublished(tutorialDto.isPublished());
			 repository.save(_tutorial);
			 
			TutorialDTO dto = new TutorialDTO(
					_tutorial.getTitle(),
					_tutorial.getDescription(),
					_tutorial.isPublished()
					  );
			return dto;
		}
		return null;
	}
	
	public List<TutorialDTO> findByPublished(){
		List<Tutorial> tutorials = repository.findByPublished(true);
		List<TutorialDTO> dtoList;
		if (tutorials.isEmpty()) {
			return null;
		}else {
			 dtoList = tutorials.stream()
					.map(t -> new TutorialDTO(t.getTitle(), t.getDescription(), t.isPublished()))
					.collect(Collectors.toList());
			return dtoList;
		}		
	}
	
	

}
