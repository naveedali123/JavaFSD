package com.company.userfeedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.userfeedback.entity.Feedback;
import com.company.userfeedback.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	public void addFeedback(Feedback feedback) {
		
		feedbackRepository.save(feedback);
	}
}
