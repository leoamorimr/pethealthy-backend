DROP TABLE IF EXISTS pethealthy;

CREATE TABLE person
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(250) NOT NULL,
    birthDate DATE (250) NOT NULL
);

INSERT INTO person (id, name, birthDate)
VALUES (1,'Renato', '1970-07-05'),
       (2,'Leonardo', '1989-02-01');

CREATE TABLE pet
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(250) NOT NULL,
    birthDate DATE (250) NOT NULL,
    person_id INT NOT NULL,
    CONSTRAINT FK_PET_PERSON FOREIGN KEY (PERSON_ID) REFERENCES person(id)
);

INSERT INTO pet ( name, birthDate,person_id)
VALUES ('Kim', '2009-01-01',1),
       ('Gaia', '2009-01-01',1),
       ('Mel', '2009-01-01',2);

