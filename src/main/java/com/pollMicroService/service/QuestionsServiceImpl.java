package com.pollMicroService.service;

import com.pollMicroService.model.Questions;
import com.pollMicroService.repository.QuestionsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsServiceImpl implements QuestionsService{

    @Autowired
    private QuestionsRepositoryImpl questionsRepository;


    @Override
    public String createQuestions(Questions questions) {
        return questionsRepository.createQuestions(questions);
    }

    @Override
    public Questions getQuestionById(int questionId) {
        return questionsRepository.getQuestionById(questionId);
    }

    @Override
    public String deleteQuestionById(int questionId) {
        return questionsRepository.deleteQuestionById(questionId);
    }

    @Override
    public String updateQuestionById(int questionId, String question) {
        return questionsRepository.updateQuestionById(questionId, question);
    }
}
