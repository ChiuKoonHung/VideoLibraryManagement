package com.ncs.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.model.VideoLibrary;

@Repository
public interface VideoRepository extends JpaRepository<VideoLibrary, Long> {
	
	@Query("select t from VideoLibrary t where t.id = ?1 and t.videoTitle = ?2 and t.videoTag = ?3")
	public List<VideoLibrary> findByidAndvideoTitleAndvideoTag(Long id, String videoTitle, String videoTag);
	
	@Query("select t from VideoLibrary t where t.id = ?1")
	public VideoLibrary getVideoId(Long id);		
		
	@Query("select t from VideoLibrary t where t.videoTitle = ?1 order by t.createdDate asc")
	List<VideoLibrary> findByvideoTitleOrderByDateAsc(String videoTitle);
}
