-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.6.12-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.3.0.4989
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para hotel_ipet
CREATE DATABASE IF NOT EXISTS `hotel_ipet` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hotel_ipet`;


-- Copiando estrutura para tabela hotel_ipet.agendamento_cuidador
CREATE TABLE IF NOT EXISTS `agendamento_cuidador` (
  `CD_AG_CUIDADOR` int(11) NOT NULL AUTO_INCREMENT,
  `NM_CLIENTE` varchar(50) DEFAULT '0',
  `DT_EINS_AG_CUIDADOR` varchar(5) DEFAULT '0',
  `DT_ZWEI_AG_CUIDADOR` varchar(5) DEFAULT '0',
  `OBS_Agendamento` varchar(200) DEFAULT 'Nada',
  `TP_Agendamento` varchar(50) DEFAULT 'Nada',
  `NM_CUIDADOR` varchar(50) NOT NULL,
  PRIMARY KEY (`CD_AG_CUIDADOR`),
  KEY `CD_CUIDADOR` (`NM_CUIDADOR`),
  CONSTRAINT `FK_agendamento_cuidador_cuidadores` FOREIGN KEY (`NM_CUIDADOR`) REFERENCES `cuidadores` (`NM_CUIDADOR`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela hotel_ipet.agendamento_cuidador: ~0 rows (aproximadamente)
DELETE FROM `agendamento_cuidador`;
/*!40000 ALTER TABLE `agendamento_cuidador` DISABLE KEYS */;
INSERT INTO `agendamento_cuidador` (`CD_AG_CUIDADOR`, `NM_CLIENTE`, `DT_EINS_AG_CUIDADOR`, `DT_ZWEI_AG_CUIDADOR`, `OBS_Agendamento`, `TP_Agendamento`, `NM_CUIDADOR`) VALUES
	(31, 'Lady Miss De Bourgh', '04/09', '05/09', 'Não come ração Birbo!', 'Gato', 'Fitzwilliam Darcy');
/*!40000 ALTER TABLE `agendamento_cuidador` ENABLE KEYS */;


-- Copiando estrutura para tabela hotel_ipet.cuidadores
CREATE TABLE IF NOT EXISTS `cuidadores` (
  `CD_CUIDADOR` int(11) NOT NULL AUTO_INCREMENT,
  `NM_CUIDADOR` varchar(50) DEFAULT NULL,
  `DS_CUIDADOR` varchar(200) DEFAULT NULL,
  `NS_CUIDADOR` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`CD_CUIDADOR`),
  KEY `NM_CUIDADOR` (`NM_CUIDADOR`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela hotel_ipet.cuidadores: ~5 rows (aproximadamente)
DELETE FROM `cuidadores`;
/*!40000 ALTER TABLE `cuidadores` DISABLE KEYS */;
INSERT INTO `cuidadores` (`CD_CUIDADOR`, `NM_CUIDADOR`, `DS_CUIDADOR`, `NS_CUIDADOR`) VALUES
	(1, 'Elizabeth Bennet', 'Sou completamente apaixonada por cães e gatos, responsável e mandarei constantes fotos e vídeos para mostrar-lhe como seu pet está, para que não haja preocupações. ', '23'),
	(2, 'Charlotte Lucas', 'Amo cães e gatos, tenho um cão (dócil), moro em uma casa com quintal grande e bem cercado para seu pet poder brincar sem mais preocupações, também posso leva-lo para passear.', '27'),
	(3, 'Fitzwilliam Darcy', 'Amo animais, tenho um cão, ele é dócil e gosta de brincar, seu pet terá companhia e estará bem cuidado, se preferir também posso levar seu pet para passear junto com o meu cãozinho.', '28'),
	(4, 'Charles Bingley', 'Estou de férias do trabalho, moro com meu cãozinho(amigável) em uma casa com quintal grande e cercado, ele terá com quem brincar, enquanto registro tudo no celular e mando para o seu dono.', '25'),
	(5, 'Lydia Wickham', 'Olá, estou desempregada, quero ajudar meus pais em casa finaceiramente,e amo animais,então me disponibilizo para cuidar, dar atenção e carinho para seu pet, vou registrar e enviar fotos para seu dono.', '18');
/*!40000 ALTER TABLE `cuidadores` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
