package com.ncs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.exception.VideoNotFoundException;
import com.ncs.model.VideoLibrary;
import com.ncs.repository.VideoRepository;


@Service
public class VideoService {
	
	@Autowired
	VideoRepository videoRepository;
	
	public List<VideoLibrary> getVideoLibrary() {
		return videoRepository.findAll();
	}
	
	public List<VideoLibrary> getIdAndVideoTitleAndVideoTag(Long id, String videoTitle, String videoTag) {
		return videoRepository.findByidAndvideoTitleAndvideoTag(id, videoTitle, videoTag);		
	}
	
	public VideoLibrary getVideoId(Long id) {
		return videoRepository.findById(id).orElseThrow(VideoNotFoundException::new); 
	}
	
	public List<VideoLibrary> getVideoByTitle(String videoTitle) {
		return videoRepository.findByvideoTitle(videoTitle);		
	}
	
	public List<VideoLibrary> getVideoByTag(String videoTag) {
		return videoRepository.findByvideoTag(videoTag);		
	}
	
	public VideoLibrary add(VideoLibrary videolibrary) {
		return videoRepository.saveAndFlush(videolibrary);
	}
	
	public VideoLibrary update(VideoLibrary videolibrary) {
		return videoRepository.saveAndFlush(videolibrary);
	}
	
	public void delete(Long id) {
		VideoLibrary found = getVideoId(id);
		videoRepository.delete(found);
	}
	
//	public List<VideoLibrary> sortAscByDate() {
//		return videoRepository.findAllByOrderByDateAsc();
//	}

//	public List<VideoLibrary> sortAscByTitle() {
//		return videoRepository.findAllByOrderByTitleAsc();
//	}
	public List<VideoLibrary> sortAscByTitle(String videoTitle) {
	return videoRepository.findByvideoTitleOrderByDateAsc(videoTitle);
}
}
