package com.pollMicroService.controller;

import com.pollMicroService.model.Questions;
import com.pollMicroService.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @PostMapping
    public String createQuestions(@RequestBody Questions questions) {
        return questionsService.createQuestions(questions);
    }

    @GetMapping
    public Questions getQuestionById(@RequestParam int questionId) {
        return questionsService.getQuestionById(questionId);
    }

    @DeleteMapping
    public String deleteQuestionById(@RequestParam int questionId) {
        return questionsService.deleteQuestionById(questionId);
    }

    @PutMapping
    public String updateQuestionById(@RequestBody Questions questions) {
        if(questions.getQuestionId() == 0 || questions.getQuestion() == null) {
            return "Can't change something to nothing";
        } else {
            return questionsService.updateQuestionById(questions.getQuestionId(), questions.getQuestion());
        }
    }

}
