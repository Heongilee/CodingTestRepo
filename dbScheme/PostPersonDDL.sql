-- mydb.post_person definition

CREATE TABLE `post_person` (
  `person_id` bigint(20) NOT NULL,
  `post_id` bigint(20) NOT NULL,
  `is_accepted` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`person_id`,`post_id`),
  KEY `FK_post_person_post` (`post_id`),
  CONSTRAINT `FK_post_person_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `FK_post_person_post` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
