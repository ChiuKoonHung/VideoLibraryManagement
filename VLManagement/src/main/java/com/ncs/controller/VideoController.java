package com.ncs.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.ncs.exception.VideoIDMismatchException;
import com.ncs.model.VideoLibrary;
import com.ncs.service.VideoService;

//enable cors
@CrossOrigin
//enable controller annotations and method parameters
@RestController
//configure the mapping of web requests to /video.
@RequestMapping("/video")
public class VideoController {
	
	@Autowired
	VideoService videoService;

	// Get request method for all parameters. Return response code 200.
	@GetMapping
	public ResponseEntity<List<VideoLibrary>> getVideoLibrary() {
		System.out.println("getvideolibrary");
		return new ResponseEntity<List<VideoLibrary>>(videoService.getVideoLibrary(), HttpStatus.OK);		
	}	
	
	// Get request method by parameter Id. Return response code 200.
	@GetMapping("/vid/{id}")
	public ResponseEntity<VideoLibrary> getVideoId(@PathVariable Long id) {
		return new ResponseEntity<VideoLibrary>(videoService.getVideoId(id), HttpStatus.OK);
	}
	
	// Get request method by query parameters id, videoTitle & videoTag in VideoLibrary entity. Return response code 200.
	@GetMapping("/getall")
	public ResponseEntity<List<VideoLibrary>> getAll(@RequestParam Long id, @RequestParam String videoTitle, @RequestParam String videoTag) {
		return new ResponseEntity<List<VideoLibrary>>(videoService.getIdAndVideoTitleAndVideoTag(id, videoTitle, videoTag), HttpStatus.OK);
	}
	
	// Post request with value of the request body matching VideoLibrary entity. Return response code 201.
	@PostMapping
	public ResponseEntity<VideoLibrary> add(@Valid @RequestBody VideoLibrary videolibrary) {
		System.out.println("post");
		return new ResponseEntity<VideoLibrary>(videoService.add(videolibrary), HttpStatus.CREATED);
	}
	
	// Update request method by parameter id. Return response code 200.
	@PutMapping("/update/{id}")
	public ResponseEntity<VideoLibrary> update(@Valid @RequestBody VideoLibrary videolibrary, @PathVariable Long id) {
		if (id != videolibrary.getid()) {
			throw new VideoIDMismatchException();
		}
		return new ResponseEntity<VideoLibrary>(videoService.update(videolibrary), HttpStatus.OK);
	}
	
	// Delete request method by parameter id.
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		videoService.delete(id);
	}
	
	// Get request method by parameter videoTitle to sort title by asc order.
	@GetMapping("/sort")
	public ResponseEntity<List<VideoLibrary>> sortAscByTitle(String videoTitle) {
		return new ResponseEntity<List<VideoLibrary>>(videoService.sortAscByTitle(videoTitle), HttpStatus.OK);		
	}

}
