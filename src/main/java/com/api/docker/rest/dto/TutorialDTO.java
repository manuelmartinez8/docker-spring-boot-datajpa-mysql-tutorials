package com.api.docker.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 

 
public class TutorialDTO { 
 
	private String title;	 
	private String description; 
	private boolean published;
	
	
	public TutorialDTO(String title, String description, boolean published) {
		super();
		this.title = title;
		this.description = description;
		this.published = published;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	
	

}
