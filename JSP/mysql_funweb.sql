-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: funweb
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `idx` int NOT NULL,
  `name` varchar(20) NOT NULL,
  `pass` varchar(16) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `date` date NOT NULL,
  `readcount` int NOT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (2,'관리자','1234','공지사항2','공지','2022-06-13',0),(3,'짱구','1234','안녕하새우','짱구에오','2022-06-13',2),(4,'거북이','1234','내가 하는 말이','듣기 거북해?','2022-06-13',1),(5,'연태쌤','1234','일타강사','우리학원 최고 미남\r\n짱짱맨','2022-06-13',0),(6,'1','1','1','1','2022-06-13',0),(7,'나 우디르 아니다','1234','나 우디르다','나 우디르아니다','2022-06-13',2),(8,'4123','4132','4132','4321','2022-06-13',1),(9,'?','1234','?','?','2022-06-13',0),(10,'허걱','1234','여기 익명 게시판 맞죠?','이지철 바보','2022-06-13',1),(11,'달팽이','123','늦어서 죄송합니다','죄송합니다\r\n죄송합니다\r\n죄송합니다\r\n죄송합니다\r\n죄송합니다\r\n죄송합니다\r\n죄송합니다\r\n죄송합니다\r\n죄송합니다\r\n죄송합니다\r\n죄송합니다','2022-06-13',1),(12,'맛집헌터','1234','여기 맛집이네요','감사합니다','2022-06-13',2),(13,'밥묵자','1234','Jumsimmukja','밥묵자','2022-06-13',1),(14,'여우','1234','나는 너무','귀여우','2022-06-13',1),(15,'텀블러','1234','물','미지근함','2022-06-13',0),(16,'123','asdk1234y6ak21','456','123','2022-06-13',0),(17,'옴뇸뇸','1234','오늘 점심','뭐 드세용??','2022-06-13',3),(18,'약쟁이','1234','두통! 치통! 생리통엔!','맞다 타이레놀~','2022-06-13',2),(19,'홍길동','12345','글','내용','2022-06-13',1),(20,'작성중','1111','000dd000','dfd','2022-06-13',2),(21,'쿼바디스','1234','쿠오바디스 아이다','신이시여 어디로 가나이까?','2022-06-13',2),(22,'강사','1234','수업내용','수업','2022-06-13',2),(23,'치키','12345678','마이 네임 이즈','마이네임이즈 치키\r\n마이네임이즈 차차\r\n마이네임이즈 붐붐\r\n마이네임이즈 라라','2022-06-13',1),(24,'관리자','1234','안내문','안내끝','2022-06-13',0),(25,'다시 온 약쟁이','1234','판피린 F','감기 조심하세요~~','2022-06-13',3),(26,'감기','1234','콜록 콜록','조퇴각','2022-06-13',2),(27,'선생님','1234','있잖아요','잘생겼어요','2022-06-13',3),(28,'강감찬','1234','월요병','월요일..힘들어..','2022-06-13',1),(29,'ㅠㅠ','1234','코로나','조심하세요','2022-06-13',1),(31,'관리자','1234','공지사항인데 내용이 좀 많습니다. 그래서 제목부분이 너무 긴 공지사항입니다.','...........','2022-06-17',4);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file_board`
--

DROP TABLE IF EXISTS `file_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file_board` (
  `idx` int NOT NULL,
  `name` varchar(20) NOT NULL,
  `pass` varchar(16) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `real_file` varchar(100) NOT NULL,
  `original_file` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `readcount` int NOT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_board`
--

LOCK TABLES `file_board` WRITE;
/*!40000 ALTER TABLE `file_board` DISABLE KEYS */;
INSERT INTO `file_board` VALUES (1,'관리자','1234','식별자 작성 규칙','수업 파일입니다.','식별자 작성 규칙.txt','식별자 작성 규칙.txt','2022-06-21',0),(2,'관리자','1234','식별자 작성 규칙(수정)','수정본입니다.','식별자 작성 규칙1.txt','식별자 작성 규칙.txt','2022-06-21',0),(3,'o((>ω< ))o','1234','선생님','최고다요','dbeaver.exe','dbeaver.exe','2022-06-21',0),(4,'43124312','4321413243','4321343421','432343124','2강_웨일_링크.txt','2강_웨일_링크.txt','2022-06-21',0),(5,'익명','1234','안녕하세요','이지철 바보','2.jpg','2.jpg','2022-06-21',0),(6,'ㅇㅇ','1234','1','11','cos.jar','cos.jar','2022-06-21',0),(7,'512353','532521','5321','5312432','가상머신 다운로드 링크.txt','가상머신 다운로드 링크.txt','2022-06-21',0),(8,'관리자','1234','관리자입니다','관리자아닌데요?','관리자 맞다니까요.txt','관리자 맞다니까요.txt','2022-06-21',0),(9,'돈까스','1234','돈까스냠냠','맛있을듯 ㅇㅇ','2강_웨일_링크1.txt','2강_웨일_링크.txt','2022-06-21',0),(10,'ヾ(•ω•`)o','1234','점심시간','배고파용','2강_웨일_링크2.txt','2강_웨일_링크.txt','2022-06-21',0),(11,'점심','1234','점심','점심','windows-setup-rurple1.0rc3.exe','windows-setup-rurple1.0rc3.exe','2022-06-21',0),(12,'ヾ(≧▽≦*)o','1234','배고파요','배고파서 집중이안되요...','sea.jpg','sea.jpg','2022-06-21',0),(13,'Jsp programmar','1234','JSP','화이팅','jsp logo1.png','jsp logo.png','2022-06-21',0),(14,'또 온 약쟁이','1234','알보칠','빨간약 짱짱','images.jfif','images.jfif','2022-06-21',0),(15,'프리티걸','1234','시선강탈','사랑해요.','사랑해요 연태님.txt','사랑해요 연태님.txt','2022-06-21',0),(16,'냥냥이','2222','고양이 합창','냥냥냥이냥냥~!','고양이.txt','고양이.txt','2022-06-21',0),(17,'베어그릴스','1234','돈까스는 훌륭한 단백질공급원입니다.','하지만 지금은 제 점심이지요','0615 - 네임서버(NameSever).txt','0615 - 네임서버(NameSever).txt','2022-06-21',0),(18,'마석도','1234','너....','잡히기만 해봐라\r\n공 개 처 형','2강_웨일_링크3.txt','2강_웨일_링크.txt','2022-06-21',0),(19,'단소살인마','1234','너 뉘기야 ','마석도','노르웨이숲.jpg','노르웨이숲.jpg','2022-06-21',0),(20,'티벳여우','1234','물은 물이요 산은 산이로다','~.~','노르웨이숲1.jpg','노르웨이숲.jpg','2022-06-21',0),(21,'강형욱','1234','반복되고 강조되는 소리는','반복되고 강조되는 소리는강아지를불안하게해요','12668ddbdd9c502ef1dbc1d5cb74ec108d4abb59.jpg','12668ddbdd9c502ef1dbc1d5cb74ec108d4abb59.jpg','2022-06-21',0),(22,'재롱','1234','재롱이에오','안농하세오','puppy.jpg','puppy.jpg','2022-06-21',0),(23,'강감찬','1234','점심시간 1분 남았당','얏호!','노르웨이숲2.jpg','노르웨이숲.jpg','2022-06-21',0),(24,'스펀지밥','1234','해피수요일','수요일 좋아~','image.png','image.png','2022-06-22',0),(25,'도비','1234','도비는 자유에요!','Dobby is free!','whale.exe','whale.exe','2022-06-22',0);
/*!40000 ALTER TABLE `file_board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` varchar(16) NOT NULL,
  `pass` varchar(16) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('admin','1234','관리자','admin@admin.com','부산','051-803-0909','010-0000-0000','2022-06-10');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-22  9:24:07
