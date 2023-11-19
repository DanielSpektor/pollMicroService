package com.pollMicroService.repository;

import com.pollMicroService.mapper.AnswersMapper;
import com.pollMicroService.model.Answers;
import com.pollMicroService.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AnswersRepositoryImpl implements AnswersRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String createAnswer(Answers answers) {
        String sql = "INSERT INTO " + Constants.ANSWERS_TABLE_NAME + " (questionId, answerOption, userId) VALUES(?,?,?)";
        jdbcTemplate.update(sql, answers.getQuestionId(), answers.getAnswerOption(), answers.getUserId());
        return "User made his choice !";
    }

    @Override
    public Answers getAnswersByQuestionId(int questionId) {
        String sql = "SELECT FROM " + Constants.ANSWERS_TABLE_NAME + " WHERE questionId = ?";
        return jdbcTemplate.queryForObject(sql, new AnswersMapper(), questionId);
    }

    @Override
    public String deleteAnswersById(int questionId) {
        String sql = "DELETE FROM " + Constants.ANSWERS_TABLE_NAME + " WHERE questionId = ?";
        if(jdbcTemplate.update(sql, questionId) == 1){
            return "Answer to the question with id " + questionId + " was deleted";
        } else {
            return "Answer to the question with id " + questionId + " wasn't found";
        }
    }

    @Override
    public String updateAnswersById(int questionId, String answerOption) {
        String sql = "UPDATE " + Constants.ANSWERS_TABLE_NAME + "SET answerOption = ? WHERE questionId = ?";
        if(jdbcTemplate.update(sql, questionId, answerOption) == 1) {
            return "Answer to question with id " + questionId + " changed to " + answerOption;
        } else {
            return "Answer to question with id " + questionId + " wasn't found";
        }
    }
}
