CREATE TABLE IF NOT EXISTS  students (
    id          BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    age        INTEGER NOT NULL
);

INSERT INTO students(name, age)
VALUES ('Андрей', 18),
       ('Сергей', 19),
       ('Виктор', 20),
       ('Михаил', 21),
       ('Ольга', 22),
       ('Анна', 23),

       ('Мария', 24),
       ('Светлана', 22),
       ('Елена', 21),
       ('Екатерина', 19),

       ('Андрей', 18),
       ('Виктор', 20),
       ('Алла', 22),
       ('Анна', 23);
