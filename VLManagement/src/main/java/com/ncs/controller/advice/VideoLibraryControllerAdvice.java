package com.ncs.controller.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ncs.exception.ErrorResponse;
import com.ncs.exception.VideoIDMismatchException;
import com.ncs.exception.VideoNotFoundException;

@RestControllerAdvice
public class VideoLibraryControllerAdvice {

	 @ExceptionHandler(VideoNotFoundException.class)
	 @ResponseStatus(code = HttpStatus.NOT_FOUND)
	 public ResponseEntity<ErrorResponse> handleTodoNotFound(VideoNotFoundException e)
	 {
		 
		 ErrorResponse er= new ErrorResponse("404", "Video with the specified ID Not found!", new Date());
		  return new ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND);
	 }
	 @ExceptionHandler(VideoIDMismatchException.class)
	 @ResponseStatus(code = HttpStatus.BAD_REQUEST)
	 public ResponseEntity<ErrorResponse> handleVideoIDMismatch(VideoIDMismatchException e)
	 {
		 
		 ErrorResponse er= new ErrorResponse("400", "ID specified doesn't match!", new Date());
		  return new ResponseEntity<ErrorResponse>(er,HttpStatus.BAD_REQUEST);
	 }
}

