package com.api.docker.rest.util;

import java.util.List;
import java.util.stream.Collectors;

import com.api.docker.rest.dto.TutorialDTO;
import com.api.docker.rest.model.Tutorial;

public class TutorialesMapper {
	
	public static TutorialDTO toDto(Tutorial tutorial) {
		return new TutorialDTO(tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished());
	}
	
	public static List<TutorialDTO> toDtoList(List<Tutorial> tutorial){
		return tutorial.stream()
				.map(TutorialesMapper::toDto)
				.collect(Collectors.toList());
		
	}

}
