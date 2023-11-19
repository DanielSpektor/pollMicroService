package com.pollMicroService.controller;

import com.pollMicroService.model.Answers;
import com.pollMicroService.model.Questions;
import com.pollMicroService.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswersController {

    @Autowired
    private AnswersService answersService;

    @PostMapping
    public String createAnswer(@RequestBody Answers answers) {
        return answersService.createAnswer(answers);
    }

    @GetMapping
    public Answers getAnswersByQuestionId(@RequestParam int questionId) {
        return answersService.getAnswersByQuestionId(questionId);
    }

    @DeleteMapping
    public String deleteAnswersById(@RequestParam int questionId) {
        return answersService.deleteAnswersById(questionId);
    }

    @PutMapping
    public String updateAnswersById(@RequestBody Answers answers) {
        if(answers.getQuestionId() == 0 || answers.getAnswerOption() == null) {
            return "Can't change something to nothing";
        } else {
            return answersService.updateAnswersById(answers.getQuestionId(), answers.getAnswerOption());
        }
    }
}
