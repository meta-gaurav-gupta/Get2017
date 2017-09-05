/* insert dummy data in members table */
INSERT INTO `members` (`member_name`, `addressline1`, `addressline2`, `category`) VALUES('Gaurav Gupta','Vijay Nagar','Alwar','M');
INSERT INTO `members` (`member_name`, `addressline1`, `addressline2`, `category`) VALUES('Rahul Kumar','Shivaji Park','Sikar','M');
INSERT INTO `members` (`member_name`, `addressline1`, `addressline2`, `category`) VALUES('Neha Sharma','Raja Park','Alwar','F');
INSERT INTO `members` (`member_name`, `addressline1`, `addressline2`, `category`) VALUES('Rahul Gupta','Lajpat Nagar','Delhi','M');
INSERT INTO `members` (`member_name`, `addressline1`, `addressline2`, `category`) VALUES('Bhawna Garg','Sitapura','Jaipur','F');

/* insert dummy data in subjects */
INSERT INTO `subjects` (`subject_name`) VALUES('C++');
INSERT INTO `subjects` (`subject_name`) VALUES('Analog Electronics');
INSERT INTO `subjects` (`subject_name`) VALUES('India Today Mazgazine');
INSERT INTO `subjects` (`subject_name`) VALUES('Structure Planning');
INSERT INTO `subjects` (`subject_name`) VALUES('Strength of Material');

/* insert dummy data in publishers */
INSERT INTO `publishers` (`publisher_name`) VALUES('Genius Publication');
INSERT INTO `publishers` (`publisher_name`) VALUES('N.K. Publication');
INSERT INTO `publishers` (`publisher_name`) VALUES('Aashirwad Publication');
INSERT INTO `publishers` (`publisher_name`) VALUES('CBC publication');
INSERT INTO `publishers` (`publisher_name`) VALUES('Wiley Publishing');

/* insert dummy data in authors */
INSERT INTO `authors` (`author_name`) VALUES('ABRAHAM SILBERSCHATZ');
INSERT INTO `authors` (`author_name`) VALUES('Neelkanth Sharma');
INSERT INTO `authors` (`author_name`) VALUES('Sudesh Garg');
INSERT INTO `authors` (`author_name`) VALUES('K.C. Sarangi');
INSERT INTO `authors` (`author_name`) VALUES('A. A. Sinha');

/* insert dummy data in titles*/
INSERT INTO `titles` (`title_name`, `subject_id`,  `publisher_id`) VALUES('Object Oriented Programming with C++','1','1');
INSERT INTO `titles` (`title_name`, `subject_id`,  `publisher_id`) VALUES('A handbook to Analog Electronics','2','2');
INSERT INTO `titles` (`title_name`, `subject_id`,  `publisher_id`) VALUES('A vision to New India','3','3');
INSERT INTO `titles` (`title_name`, `subject_id`,  `publisher_id`) VALUES('Complete Reference to Structure Planning','4','4');
INSERT INTO `titles` (`title_name`, `subject_id`,  `publisher_id`) VALUES('SOM for Beginner','5','5');

/*  insert dummy data in title_author */
INSERT INTO `title_author` (`title_id`, `author_id`) VALUES(2,'1');
INSERT INTO `title_author` (`title_id`, `author_id`) VALUES(3,'2');
INSERT INTO `title_author` (`title_id`, `author_id`) VALUES(4,'3');
INSERT INTO `title_author` (`title_id`, `author_id`) VALUES(5,'4');
INSERT INTO `title_author` (`title_id`, `author_id`) VALUES(1,'5');

/* insert dummy data in books */
INSERT INTO `books` (`title_id`, `purchase_dt`, `price`, `status`) VALUES ('2', NOW(), '279.85', '0');
INSERT INTO `books` (`title_id`, `purchase_dt`, `price`, `status`) VALUES ('3', NOW(), '670.50', '1');
INSERT INTO `books` (`title_id`, `purchase_dt`, `price`, `status`) VALUES ('3', NOW(), '345.34', '0');
INSERT INTO `books` (`title_id`, `purchase_dt`, `price`, `status`) VALUES ('4', NOW(), '124.55', '1');
INSERT INTO `books` (`title_id`, `purchase_dt`, `price`, `status`) VALUES ('5', NOW(), '883.00', '0');

/* insert dummy data in book_issue*/
INSERT INTO `book_issue` (`issue_dt`, `accession_no`, `member_id`, `due_date`) VALUES (CURRENT_TIMESTAMP, '1', '1', NOW() + INTERVAL 15 DAY);
INSERT INTO `book_issue` (`issue_dt`, `accession_no`, `member_id`, `due_date`) VALUES (CURRENT_TIMESTAMP, '2', '2', NOW() + INTERVAL 15 DAY);
INSERT INTO `book_issue` (`issue_dt`, `accession_no`, `member_id`, `due_date`) VALUES (CURRENT_TIMESTAMP, '3', '3', NOW() + INTERVAL 15 DAY);
INSERT INTO `book_issue` (`issue_dt`, `accession_no`, `member_id`, `due_date`) VALUES (CURRENT_TIMESTAMP, '4', '4', NOW() + INTERVAL 15 DAY);
INSERT INTO `book_issue` (`issue_dt`, `accession_no`, `member_id`, `due_date`) VALUES (CURRENT_TIMESTAMP, '5', '5', NOW() + INTERVAL 15 DAY);

/* insert dummy data in book_return*/
INSERT INTO `book_return` (`return_dt`, `accession_no`, `member_id`, `issue_dt`) VALUES (CURRENT_TIMESTAMP, '1', '1', NOW());
INSERT INTO `book_return` (`return_dt`, `accession_no`, `member_id`, `issue_dt`) VALUES (CURRENT_TIMESTAMP, '2', '2', NOW());
INSERT INTO `book_return` (`return_dt`, `accession_no`, `member_id`, `issue_dt`) VALUES (CURRENT_TIMESTAMP, '3', '3', NOW());
INSERT INTO `book_return` (`return_dt`, `accession_no`, `member_id`, `issue_dt`) VALUES (CURRENT_TIMESTAMP, '4', '4', NOW());
INSERT INTO `book_return` (`return_dt`, `accession_no`, `member_id`, `issue_dt`) VALUES (CURRENT_TIMESTAMP, '5', '5', NOW());