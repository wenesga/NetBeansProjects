








CREATE TABLE IF NOT EXISTS `livros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `editora` varchar(50) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `isbn` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);
