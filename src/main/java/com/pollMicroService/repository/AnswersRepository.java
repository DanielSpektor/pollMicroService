package com.pollMicroService.repository;

import com.pollMicroService.model.Answers;
import com.pollMicroService.model.Questions;

public interface AnswersRepository {

    String createAnswer(Answers answers);
    Answers getAnswersByQuestionId(int questionId);
    String deleteAnswersById(int questionId);
    String updateAnswersById(int questionId, String answerOption);

}
