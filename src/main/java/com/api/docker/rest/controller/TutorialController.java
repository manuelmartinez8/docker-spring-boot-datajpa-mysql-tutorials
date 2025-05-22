package com.api.docker.rest.controller;

 
import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.docker.rest.dto.TutorialDTO;
import com.api.docker.rest.model.Tutorial;
import com.api.docker.rest.rerpository.TutorialRepository;
import com.api.docker.rest.service.TutorialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
 
@Tag(name = "Crud for Tutorial", description = "Tutorial management APIs II")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {

	@Autowired
	TutorialRepository tutorialRepository;
	
	@Autowired
	private TutorialService service;

	@GetMapping("/tutoriales")
	public ResponseEntity<List<TutorialDTO>> getAllTutorials(@RequestParam(required = false) String title) {
		try {			
			List<TutorialDTO> tutorials = service.findAll(title);
			
			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 @Operation(
		      summary = "Retrieve a Tutorial by Id",
		      description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
		      tags = { "tutorials", "get" })
		  @ApiResponses({
		      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Tutorial.class), mediaType = "application/json") }),
		      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
		      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

	@GetMapping("/tutoriales/{id}")
	public ResponseEntity<TutorialDTO> getTutorialById(@PathVariable("id") long id) {		
		TutorialDTO tutorial = service.findById(id);
		 if (tutorial != null) {
			return new ResponseEntity<>(tutorial, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/tutoriales")
	public ResponseEntity<TutorialDTO> createTutorial(@RequestBody TutorialDTO tutorial) {
		try {			 
			return new ResponseEntity<>(service.createTutorial(tutorial), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/tutoriales/{id}")
	public ResponseEntity<TutorialDTO> updateTutorial(@PathVariable("id") long id, @RequestBody TutorialDTO tutorial) {
		try {
			return new ResponseEntity<>(service.updateById(id, tutorial), HttpStatus.OK);
		}  catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tutoriales/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			tutorialRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/tutoriales")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			tutorialRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/tutoriales/published")
	public ResponseEntity<List<TutorialDTO>> findByPublished() {
		try {
			List<TutorialDTO> tutorials = service.findByPublished();
			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
