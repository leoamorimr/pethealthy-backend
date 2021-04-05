INSERT INTO person (id, first_name, last_name, birth_date)
VALUES (1,'Renato', 'Andrade Ramos', '1970-07-05'),
       (2,'Leonardo', 'Amorim Ramos', '1989-02-01');

INSERT INTO pet (id, name, color, birth_date, person_id)
VALUES (1, 'Kim', 'Black/Brown', '2009-01-01',1),
       (2, 'Gaia', 'Brown', '2009-01-01',1),
       (3, 'Mel', 'Black/Brown', '2009-01-01',2);
