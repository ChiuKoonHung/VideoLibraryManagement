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
	
	//To search for all method parameters in entity
	public List<VideoLibrary> getVideoLibrary() {
		return videoRepository.findAll();
	}
	
	//To search and match id, videoTitle & videoTag in entity
	public List<VideoLibrary> getIdAndVideoTitleAndVideoTag(Long id, String videoTitle, String videoTag) {
		return videoRepository.findByidAndvideoTitleAndvideoTag(id, videoTitle, videoTag);		
	}
	
	//To search and match id in entity
	public VideoLibrary getVideoId(Long id) {
		return videoRepository.findById(id).orElseThrow(VideoNotFoundException::new); 
	}
	
	//To add into entity
	public VideoLibrary add(VideoLibrary videolibrary) {
		return videoRepository.saveAndFlush(videolibrary);
	}
	
	//To update entity
	public VideoLibrary update(VideoLibrary videolibrary) {
		return videoRepository.saveAndFlush(videolibrary);
	}
	
	//To delete by id
	public void delete(Long id) {
		VideoLibrary found = getVideoId(id);
		videoRepository.delete(found);
	}
	
	//To sort videoTitle by asc order
	public List<VideoLibrary> sortAscByTitle(String videoTitle) {
	return videoRepository.findByvideoTitleOrderByDateAsc(videoTitle);
    }
}
