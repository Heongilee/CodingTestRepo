-- mydb.person definition

CREATE TABLE `person` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `person_gender` enum('MALE','FEMALE') DEFAULT NULL,
  `person_region` enum('SEOUL','GYEONGGI','CHUNGCHEONG','GANGWON','GYEONGSANG','JEONLA','JEJU') DEFAULT NULL,
  `person_age` int(11) DEFAULT NULL,
  `person_point_amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
