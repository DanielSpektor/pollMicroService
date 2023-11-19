package com.pollMicroService.service;

import com.pollMicroService.model.Answers;
import com.pollMicroService.model.Questions;

public interface AnswersService {

    String createAnswer(Answers answers);
    Answers getAnswersByQuestionId(int questionId);
    String deleteAnswersById(int questionId);
    String updateAnswersById(int questionId, String answerOption);
}
