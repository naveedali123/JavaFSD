package com.company.userfeedback.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.userfeedback.entity.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{

}
