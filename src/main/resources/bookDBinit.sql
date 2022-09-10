DROP DATABASE IF EXISTS BOOK;
CREATE DATABASE BOOK DEFAULT CHARACTER SET utf8;

USE BOOK;

DROP TABLE IF EXISTS book;

CREATE TABLE `book`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `title`   varchar(128) DEFAULT Null,
    `pages`   int(11),
    `content` TEXT,
    PRIMARY KEY (`id`)
);

INSERT INTO book
VALUES (1, 'Java', 332, 'Javaについて');
INSERT INTO book
VALUES (2, 'SpringBoot', 80, 'SpringBootについて');
INSERT INTO book
VALUES (3, 'Git', 12, 'Gitについて');
