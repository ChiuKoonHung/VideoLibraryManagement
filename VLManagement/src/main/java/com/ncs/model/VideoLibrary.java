package com.ncs.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;

@Entity
public class VideoLibrary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotEmpty (message = "Video title cannot be empty!")
	@Column(name = "VIDEO_TITLE")
	private String videoTitle;
	
	@NotEmpty (message = "Video tag cannot be empty!")
	@Size (min=2, max=10, message = "Video tag between 2 to 10")
	@Column(name = "VIDEO_TAG")
	private String videoTag;
	
	@NotEmpty (message = "Video link cannot be empty!")
	@Column(name = "VIDEO_LINK")
	@URL
	private String videoLink;
	
	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE")	
	private LocalDateTime updatedDate;
	
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getVideoTag() {
		return videoTag;
	}
	public void setVideoTag(String videoTag) {
		this.videoTag = videoTag;
	}
	public String getVideoLink() {
		return videoLink;
	}
	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	public VideoLibrary() {}
	
	public VideoLibrary(Long id, String videoTitle, String videoTag, String videoLink, LocalDateTime createdDate,
			LocalDateTime updatedDate) {
		super();
		this.id = id;
		this.videoTitle = videoTitle;
		this.videoTag = videoTag;
		this.videoLink = videoLink;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	
	
}
