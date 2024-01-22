CREATE TABLE movies(
    `id` bigint unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `year` int,
    `genre` varchar(50),
    `description` varchar(250),
    `imageUri` varchar(150),
    PRIMARY KEY (`id`)
);