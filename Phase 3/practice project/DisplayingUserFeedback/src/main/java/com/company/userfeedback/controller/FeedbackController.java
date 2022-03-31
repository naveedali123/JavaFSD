package com.company.userfeedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.company.userfeedback.entity.Feedback;
import com.company.userfeedback.service.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	
	
	@PostMapping("/submitFeedback")
	public ModelAndView saveFeedback(ModelMap model, @RequestParam("comments") String comments, @RequestParam("ratings") String ratings) {
		
		ModelAndView modelAndView = new ModelAndView();
	    
		int feedbackRatings = Integer.parseInt(ratings);
		
		Feedback feedback = new Feedback();
		
		if(comments.isEmpty() || ratings.isEmpty()) {
			
			modelAndView.setViewName("error.html");
			
		}else {
			
			feedback.setComments(comments);
			feedback.setRatings(feedbackRatings);
			
			feedbackService.addFeedback(feedback);
			
			modelAndView.setViewName("successfulUpdate.html");
		}
		
		return modelAndView;
	}
}
