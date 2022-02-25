DROP TABLE IF EXISTS USER;
CREATE TABLE USER(ID INT auto_increment PRIMARY KEY, NAME VARCHAR(255), SURNAME VARCHAR(255), EMAIL VARCHAR(255), PASSWORD VARCHAR(255), ADDRESS VARCHAR(255));


INSERT INTO User (id, name, surname, email, password, address) VALUES (1, 'Sara', 'Cifola', 'sara.cifola@gmail.com', 'demo', 'via Milano');
INSERT INTO User (id, name, surname, email, password, address) VALUES (2, 'Valentina', 'Rossi', 'valentina.rossi@gmail.com', 'demo', 'via Padova');
INSERT INTO User (id, name, surname, email, password, address) VALUES (3, 'Marco', 'Bianchi', 'marco.bianchi@gmail.com', 'demo', 'via Roma');
INSERT INTO User (id, name, surname, email, password, address) VALUES (4, 'Andrea', 'Rossi', 'andrea.rossi@gmail.com', 'demo', 'via Ancona');
INSERT INTO User (id, name, surname, email, password, address) VALUES (5, 'Elena', 'Neri', 'elena.neri@gmail.com', 'demo', 'via Bologna');
INSERT INTO User (id, name, surname, email, password, address) VALUES (6, 'Sara', 'Bosco', 'sara.bosco@email.com', 'demo', 'via Roma');

