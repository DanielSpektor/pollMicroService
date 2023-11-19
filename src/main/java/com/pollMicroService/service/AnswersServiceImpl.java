package com.pollMicroService.service;

import com.pollMicroService.model.Answers;
import com.pollMicroService.repository.AnswersRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswersServiceImpl implements AnswersService{

    @Autowired
    private AnswersRepositoryImpl answersRepository;

    @Override
    public String createAnswer(Answers answers) {
        return answersRepository.createAnswer(answers);
    }

    @Override
    public Answers getAnswersByQuestionId(int questionId) {
        return answersRepository.getAnswersByQuestionId(questionId);
    }

    @Override
    public String deleteAnswersById(int questionId) {
        return answersRepository.deleteAnswersById(questionId);
    }

    @Override
    public String updateAnswersById(int questionId, String answerOption) {
        return answersRepository.updateAnswersById(questionId, answerOption);
    }
}
