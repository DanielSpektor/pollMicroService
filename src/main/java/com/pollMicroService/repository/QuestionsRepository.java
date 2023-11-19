package com.pollMicroService.repository;

import com.pollMicroService.model.Questions;

public interface QuestionsRepository {

    String createQuestions(Questions questions);
    Questions getQuestionById(int questionId);
    String deleteQuestionById(int questionId);
    String updateQuestionById(int questionId, String question);

}
