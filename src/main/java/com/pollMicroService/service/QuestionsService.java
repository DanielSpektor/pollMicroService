package com.pollMicroService.service;

import com.pollMicroService.model.Questions;

public interface QuestionsService {

    String createQuestions(Questions questions);
    Questions getQuestionById(int questionId);
    String deleteQuestionById(int questionId);
    String updateQuestionById(int questionId, String question);
}
