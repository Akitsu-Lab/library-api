DROP DATABASE IF EXISTS book;
CREATE DATABASE book DEFAULT CHARACTER SET utf8;

USE book;

DROP TABLE IF EXISTS BOOK;

CREATE TABLE `BOOK`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `title`   varchar(128) DEFAULT Null,
    `pages`   int(11),
    `content` TEXT,
    PRIMARY KEY (`id`)
);

INSERT INTO BOOK
VALUES (1, 'Java', 332, 'Javaについて');
INSERT INTO BOOK
VALUES (2, 'SpringBoot', 80, 'SpringBootについて');
INSERT INTO BOOK
VALUES (3, 'Git', 12, 'Gitについて');
