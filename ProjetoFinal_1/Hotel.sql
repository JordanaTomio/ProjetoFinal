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
DROP DATABASE IF EXISTS `hotel_ipet`;
CREATE DATABASE IF NOT EXISTS `hotel_ipet` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hotel_ipet`;


-- Copiando estrutura para tabela hotel_ipet.agendamento_cuidador
DROP TABLE IF EXISTS `agendamento_cuidador`;
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela hotel_ipet.agendamento_cuidador: ~5 rows (aproximadamente)
DELETE FROM `agendamento_cuidador`;
/*!40000 ALTER TABLE `agendamento_cuidador` DISABLE KEYS */;
INSERT INTO `agendamento_cuidador` (`CD_AG_CUIDADOR`, `NM_CLIENTE`, `DT_EINS_AG_CUIDADOR`, `DT_ZWEI_AG_CUIDADOR`, `OBS_Agendamento`, `TP_Agendamento`, `NM_CUIDADOR`) VALUES
	(1, 'Jordana', '10/10', '15/10', '0', 'Nada', 'Elizabeth Bennet'),
	(20, 'Teste', '10/10', '10/10', '', NULL, 'Elizabeth Bennet'),
	(21, 'Teste', '10/10', '10/10', '', NULL, 'Elizabeth Bennet'),
	(22, 'teste', '10/10', '10/10', '', NULL, 'Elizabeth Bennet'),
	(23, 'tt', '10/10', '10/10', '', NULL, 'Elizabeth Bennet'),
	(24, 'tt', '10/10', '10/10', '', NULL, 'Elizabeth Bennet'),
	(25, 'tt', '10/10', '10/10', '', NULL, 'Elizabeth Bennet'),
	(26, 'tt', '10/10', '10/10', '', NULL, 'Elizabeth Bennet'),
	(27, 'Testando', '10/10', '10/10', 'Cachorrro', NULL, 'Elizabeth Bennet'),
	(28, 'teeestando', '10/10', '10/10', '', 'Cachorro', 'Elizabeth Bennet'),
	(29, 'teeestando', '10/10', '10/10', '', 'Gato', 'Elizabeth Bennet'),
	(30, 'Jordana Tomio', '10/10', '10/10', 'N', 'Cachorro', 'Elizabeth Bennet');
/*!40000 ALTER TABLE `agendamento_cuidador` ENABLE KEYS */;


-- Copiando estrutura para tabela hotel_ipet.cuidadores
DROP TABLE IF EXISTS `cuidadores`;
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
	(2, 'Charlotte Lucas', NULL, '27'),
	(3, 'Fitzwilliam Darcy', NULL, '28'),
	(4, 'Charles Bingley', NULL, '25'),
	(5, 'Lydia Wickham', NULL, '18');
/*!40000 ALTER TABLE `cuidadores` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
