
CREATE TABLE IF NOT EXISTS `aluno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `idade` int(3) NOT NULL,
  `matricula` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);
