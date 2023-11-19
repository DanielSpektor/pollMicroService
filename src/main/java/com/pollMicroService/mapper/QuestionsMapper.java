package com.pollMicroService.mapper;

import com.pollMicroService.model.Questions;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionsMapper implements RowMapper<Questions> {
    @Override
    public Questions mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Questions(
                rs.getInt("id"),
                rs.getString("question"),
                rs.getString("answer_1"),
                rs.getString("answer_2"),
                rs.getString("answer_3"),
                rs.getString("answer_4"));
    }
}
