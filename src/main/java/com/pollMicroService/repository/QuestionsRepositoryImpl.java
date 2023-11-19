package com.pollMicroService.repository;

import com.pollMicroService.mapper.QuestionsMapper;
import com.pollMicroService.model.Questions;
import com.pollMicroService.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionsRepositoryImpl implements QuestionsRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
     public String createQuestions(Questions questions) {
        String sql = "INSERT INTO " + Constants.QUESTIONS_TABLE_NAME + " (question, answer_1, answer_2, answer_3, answer_4) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, questions.getQuestion(), questions.getAnswer_1(), questions.getAnswer_2(), questions.getAnswer_3(), questions.getAnswer_4());
        return "Question was added successfully !";
    }

    @Override
    public Questions getQuestionById(int questionId) {
        String sql = "SELECT FROM " + Constants.QUESTIONS_TABLE_NAME + " WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new QuestionsMapper(), questionId);
    }

    @Override
    public String deleteQuestionById(int questionId) {
        String sql = "DELETE FROM " + Constants.QUESTIONS_TABLE_NAME + " WHERE id = ?";
        if(jdbcTemplate.update(sql, questionId) == 1) {
            return "Question with id " + questionId + " was deleted";
        } else {
            return "Question with id " + questionId + " wasn't found !";
        }
    }

    @Override
    public String updateQuestionById(int questionId, String question) {
        String sql = "UPDATE " + Constants.QUESTIONS_TABLE_NAME + "SET question = ? WHERE id = ?";
        if(jdbcTemplate.update(sql, questionId, question) == 1) {
            return "Question with id " + questionId + " changed to " + question;
        } else {
            return "Question with id " + questionId + " wasn't found";
        }
    }
}
