-- mydb.post definition

CREATE TABLE `post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `post_content` varchar(255) DEFAULT NULL,
  `post_title` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `FKkenxtm1pl4w6rchuhelil8lf4` (`person_id`),
  CONSTRAINT `FKkenxtm1pl4w6rchuhelil8lf4` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
