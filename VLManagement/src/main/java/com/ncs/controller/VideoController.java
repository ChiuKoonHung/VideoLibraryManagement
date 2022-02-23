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

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/video")
public class VideoController {
	
	@Autowired
	VideoService videoService;
	
	@GetMapping
	public ResponseEntity<List<VideoLibrary>> getVideoLibrary() {
		return new ResponseEntity<List<VideoLibrary>>(videoService.getVideoLibrary(), HttpStatus.OK);		
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<VideoLibrary> getVideoId(@PathVariable Long id) {
		return new ResponseEntity<VideoLibrary>(videoService.getVideoId(id), HttpStatus.OK);
	}
	
	@GetMapping("/{videoTitle}")
	public ResponseEntity<List<VideoLibrary>> getVideoTitle(@PathVariable String videoTitle) {
		return new ResponseEntity<List<VideoLibrary>>(videoService.getVideoByTitle(videoTitle), HttpStatus.OK);
	}
	
	@GetMapping("/{getVideoTag}")
	public ResponseEntity<List<VideoLibrary>> getVideoByTag(@PathVariable String videoTag) {
		return new ResponseEntity<List<VideoLibrary>>(videoService.getVideoByTag(videoTag), HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<VideoLibrary>> getAll(@RequestParam Long id, @RequestParam String videoTitle, @RequestParam String videoTag) {
		return new ResponseEntity<List<VideoLibrary>>(videoService.getIdAndVideoTitleAndVideoTag(id, videoTitle, videoTag), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<VideoLibrary> add(@Valid @RequestBody VideoLibrary videolibrary) {
		return new ResponseEntity<VideoLibrary>(videoService.add(videolibrary), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<VideoLibrary> update(@Valid @RequestBody VideoLibrary videolibrary, @PathVariable Long id) {
		if (id != videolibrary.getid()) {
			throw new VideoIDMismatchException();
		}
		return new ResponseEntity<VideoLibrary>(videoService.update(videolibrary), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		videoService.delete(id);
	}
	
//	@GetMapping("/sort-date")
//	public ResponseEntity<List<VideoLibrary>> sortAscByDate() {
//		return new ResponseEntity<List<VideoLibrary>>(videoService.sortAscByDate(), HttpStatus.OK);		
//	}
	@GetMapping("/sort")
	public ResponseEntity<List<VideoLibrary>> sortAscByTitle(String videoTitle) {
		return new ResponseEntity<List<VideoLibrary>>(videoService.sortAscByTitle(videoTitle), HttpStatus.OK);		
	}

}
