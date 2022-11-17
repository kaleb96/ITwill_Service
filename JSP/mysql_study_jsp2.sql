-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: study_jsp2
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
  `idx` int NOT NULL AUTO_INCREMENT,
  `name` varchar(12) DEFAULT NULL,
  `passwd` varchar(16) DEFAULT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `readcount` int DEFAULT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'홍길동','1234','제목','내용','2022-05-27',0),(2,'관리자','1234','공지사항1','공지사항1','2022-05-27',2),(3,'문어','1234','나는 문어!','꿈을 꾸는 문어~','2022-05-27',1),(4,'이제윤','1234','가입인사^^','안녕하세요','2022-05-27',1),(5,'민석','1234','ㅎㅇ요','안녕하세요^^','2022-05-27',1),(6,'ㅇㅈㅇ','1234','강사님','사랑합니다','2022-05-27',1),(7,'우우우','55555555','제목제목','내용내용','2022-05-27',0),(8,'양사장','1234567','양사방','양사장 샤방','2022-05-27',0),(9,'익명','12345678','커피는','맛없다','2022-05-27',1),(10,'이지철','1234','12341234','12341234','2022-05-27',1),(11,'ㅎㅇ','11111111','양사방?','샤방샤방?','2022-05-27',1),(12,'홍길동동','12341234','123213','1232131221312','2022-05-27',0),(13,'지윤','123123','살려줘','jsp good','2022-05-27',1),(14,'허걱이','4565456','허거걱','헉!!!','2022-05-27',1),(15,'김둘리','1234567','고길동 아저씨','밥 주세요.','2022-05-27',1),(16,'춘식이','1234','안녕하세요!','안녕하세요! 춘식이에오!','2022-05-27',1),(17,'문어','12341234','대머리','1232131221312','2022-05-27',1),(18,'손흥민입니다','1234','저 월클 맞습니다','내년에 25골 넣을게요','2022-05-27',1),(19,'아이고난','1234','장풍을 했다!','니하는 플레이 보이 예전에 아더놈 같은데 이제 얼굴까고 하는 갑지','2022-05-27',1),(20,'레미본야스키','1234','행복한 금요일','두둥 주말이 온다!','2022-05-27',2),(21,'짱구','1234','날씨도 좋은데','산책가고 싶어요','2022-05-27',1),(22,'손웅정입니다.','1234','흥민이 월클 아닙니다.','아무튼 아직 아닙니다.','2022-05-27',2),(23,'홍지유','1234','나는 감자','데굴데굴','2022-05-27',1),(24,'화이팅','12345678','글목록','글목록','2022-05-27',1),(25,'짱구','1234','멍멍','날씨도 좋은데 산책가고 싶어요 멍멍','2022-05-27',2),(26,'홍길동','1234','제목','1','2022-05-27',1),(27,'PYJ','123456','학원','냉장고','2022-05-27',3),(28,'이순신','1234','가입인사','^^','2022-05-27',2),(29,'ㅇㅇㅌ','1004','빨리 진도 나가고 싶다','빨리좀해라','2022-05-27',2),(30,'자라나라','080811','꿈나라 쿨쿨','안녕하세요~','2022-05-27',2),(31,'잽싸게 새글씀','1234','헤헷 내가1등이다','11111111','2022-05-27',2),(32,'전두엽','1234','응 아니야','123','2022-05-27',2),(33,'최병장','1234','아앗!','말년에 유격이라니!!','2022-05-27',3),(34,'해리케인','1234','쏘니월클','ㅇㅇ','2022-05-27',4),(35,'점심메뉴','1234','점심머먹어요?','123','2022-05-27',3),(37,'관리자','1234','글쓰기 멈춰!','멈춰!','2022-05-27',3),(38,'금지선','123123','---------------------------','1','2022-05-27',3),(39,'넘음','1231','님아 그강을 건너지마오','123','2022-05-27',3),(40,'살려주세요 ','1122','살려주세요 ','살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 살려주세요 ','2022-05-27',10),(41,'12','1234','배고팡','아잉','2022-05-27',9),(43,'연태쌤','1234','일타강사','최고짱짱맨','2022-05-30',1111),(44,'오오오','1234','좋은아침입니다.','좋은아침이라구요','2022-06-03',10),(46,'관리자','1234','static getConnection()','111','2022-06-03',4),(47,'피카츄','pikapika','잘생긴 내모습','<img src=\"https://w.namu.la/s/31a1061c7c83e9fb94562c5daf1ea0faddc307627d8bf7349fd14b6bdd6d904caf97f22a74e3268408c86c84eaf2115894ac8b77f70c762e337e340b2d4e9e1feacab481c5aea2b833abab4d118decef64ba7921ca3783ff63913c9b3870eddc909f48d65575a17b3623ebaba8f103ca\">','2022-06-03',5),(48,'댕댕이','1234','에어팟을 안 들고 왔어요..','직업기초 뭐하지?','2022-06-03',9),(51,'사랑해','1234','3000만큼','I love you 3000.','2022-06-03',4),(52,'타노스','1234','Endgame','나 타노스아니다','2022-06-03',5),(53,'도전?','1234','100개','해볼까요?','2022-06-03',42);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board_reply`
--

DROP TABLE IF EXISTS `board_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board_reply` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `id` varchar(16) NOT NULL,
  `content` varchar(500) NOT NULL,
  `date` datetime NOT NULL,
  `ref` int NOT NULL,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_reply`
--

LOCK TABLES `board_reply` WRITE;
/*!40000 ALTER TABLE `board_reply` DISABLE KEYS */;
INSERT INTO `board_reply` VALUES (1,'admin','댓글','2022-06-08 09:50:23',53),(2,'admin','안녕하세요','2022-06-08 10:22:37',53),(3,'admin','댓글','2022-06-08 10:27:24',53);
/*!40000 ALTER TABLE `board_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `name` varchar(12) NOT NULL,
  `id` varchar(16) NOT NULL,
  `passwd` varchar(16) NOT NULL,
  `jumin` varchar(14) NOT NULL,
  `email` varchar(50) NOT NULL,
  `job` varchar(10) NOT NULL,
  `gender` char(1) NOT NULL,
  `content` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `jumin` (`jumin`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('진호익','aaa123','11111111','123456-1111111','aaa@aaa.aaa','기타','남',''),('관리자','admin','1234','000000-0000000','admin@admin.com','개발자','남','관리자'),('홍길동','hong','11111111','111111-1111111','hong@hong.com','개발자','남','aaaa');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test` (
  `idx` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1),(30),(15),(5);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test2`
--

DROP TABLE IF EXISTS `test2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test2` (
  `name` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test2`
--

LOCK TABLES `test2` WRITE;
/*!40000 ALTER TABLE `test2` DISABLE KEYS */;
INSERT INTO `test2` VALUES ('홍길동'),('이순신');
/*!40000 ALTER TABLE `test2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test3`
--

DROP TABLE IF EXISTS `test3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test3` (
  `idx` int DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test3`
--

LOCK TABLES `test3` WRITE;
/*!40000 ALTER TABLE `test3` DISABLE KEYS */;
INSERT INTO `test3` VALUES (2,'이순신'),(3,'강감찬'),(4,'김태희'),(0,'관리자');
/*!40000 ALTER TABLE `test3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test8_1`
--

DROP TABLE IF EXISTS `test8_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test8_1` (
  `name` varchar(10) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `hobby` varchar(10) DEFAULT NULL,
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test8_1`
--

LOCK TABLES `test8_1` WRITE;
/*!40000 ALTER TABLE `test8_1` DISABLE KEYS */;
INSERT INTO `test8_1` VALUES ('홍길동',20,'남','여행/독서/게임/'),('이순신',44,'남','여행/게임/'),('강감찬',30,'남','게임/'),('김태희',35,'여','여행/독서/'),('전지현',30,'여','여행/독서/'),('관리자',0,'남','여행/독서/게임/'),('송혜교',40,'여','여행/독서/게임/');
/*!40000 ALTER TABLE `test8_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test8_2`
--

DROP TABLE IF EXISTS `test8_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test8_2` (
  `name` varchar(12) NOT NULL,
  `id` varchar(16) NOT NULL,
  `passwd` varchar(16) NOT NULL,
  `jumin` varchar(14) NOT NULL,
  `email` varchar(50) NOT NULL,
  `job` varchar(10) NOT NULL,
  `gender` char(1) NOT NULL,
  `hobby` varchar(10) NOT NULL,
  `content` varchar(2000) NOT NULL,
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `jumin` (`jumin`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test8_2`
--

LOCK TABLES `test8_2` WRITE;
/*!40000 ALTER TABLE `test8_2` DISABLE KEYS */;
INSERT INTO `test8_2` VALUES ('관리자','admin','1234','000000-0000000','admin@admin.com','개발자','남','여행/독서/','관리용'),('홍길동','hong','hong1234','901010-1234568','hong@hong.com','개발자','남','여행/독서/게임/','그냥'),('강감찬','kang','kang1234','701010-1234123','kang@naver.com','관리자','남','독서/게임/','그냥1111222'),('김태희','kimth','kimth123','881122-2222222','kimth@gmail.com','개발자','여','여행/독서/게임/','그냥1111222'),('이순신','leess','leess1234','801010-1234567','lee@lee.com','DB엔지니어','남','여행/게임/','그냥1111');
/*!40000 ALTER TABLE `test8_2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-22  9:36:25
