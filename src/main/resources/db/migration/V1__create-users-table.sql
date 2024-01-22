CREATE TABLE users (
    `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'Chave primária',
    `login` varchar(80) NOT NULL,
    `password` varchar(150) NOT NULL,
    `role` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
);