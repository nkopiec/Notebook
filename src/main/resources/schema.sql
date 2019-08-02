CREATE SCHEMA IF NOT EXISTS `admin`;

CREATE TABLE IF NOT EXISTS admin.users (
    id INT AUTO_INCREMENT,
    login VARCHAR(35) NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled TINYINT(1) NOT NULL,
    role VARCHAR(35) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO admin.users (login, password, enabled, role) VALUES ('admin', '$2a$10$KQix8wnxIu9jXUWE.2OwGutWRCVUbiy9p4RAWy30cYYzZcsXmpiRW', 1, 'ROLE_ADMIN');
INSERT INTO admin.users (login, password, enabled, role) VALUES ('user', '$2a$10$KQix8wnxIu9jXUWE.2OwGutWRCVUbiy9p4RAWy30cYYzZcsXmpiRW', 1, 'ROLE_USER');

CREATE TABLE IF NOT EXISTS admin.notes (
    id INT AUTO_INCREMENT,
    title VARCHAR(20) NOT NULL,
    text VARCHAR(1000) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO admin.notes (title, text) VALUES ('Meeting', 'Business meeting in shop center');
INSERT INTO admin.notes (title, text) VALUES ('Birthday', 'In Tuesday there is birthday of Anna');
