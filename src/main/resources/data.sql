CREATE TABLE questions (
    id int NOT NULL AUTO_INCREMENT,
    question varchar(255) NOT NULL,
    answer_1 varchar(255) NOT NULL,
    answer_2 varchar(255) NOT NULL,
    answer_3 varchar(255) NOT NULL,
    answer_4 varchar(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE answers (
    id int NOT NULL AUTO_INCREMENT,
    question_id int NOT NULL,
    answer_option varchar(255) NOT NULL,
    user_id int NOT NULL,
    FOREIGN KEY(question_id) REFERENCES questions(id)
);

INSERT INTO questions (question, answer_1, answer_2, answer_3, answer_4)
VALUES ('What you prefer doing in your free time?', 'Play basketball', 'Watch news', 'Read a book', 'Take a walk'),
       ('What your preferred snack?', 'Chocolate', 'Ice cream', 'Soda', 'Chips'),
       ('Where you love to travel?', 'Forest', 'Zoo', 'Downtown', 'Mall');

