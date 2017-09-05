DROP DATABASE IF EXISTS lis;
CREATE DATABASE lis;
USE lis;

CREATE TABLE members(
    member_id INT(10) NOT NULL AUTO_INCREMENT,
    member_name VARCHAR(40) NOT NULL,
    addressline1 VARCHAR(50) NOT NULL,
    addressline2 VARCHAR(50) NULL,
    category VARCHAR(1) CHECK(category IN ("M","F")),
    PRIMARY KEY(member_id)
);

CREATE TABLE subjects(
    subject_id INT(10) NOT NULL AUTO_INCREMENT,
    subject_name VARCHAR(50) NOT NULL,
    PRIMARY KEY(subject_id)
);

CREATE TABLE publishers(
    publisher_id INT(10) NOT NULL AUTO_INCREMENT,
    publisher_name VARCHAR(50) NOT NULL,
    PRIMARY KEY(publisher_id)
);

CREATE TABLE authors(
    author_id INT(10) NOT NULL AUTO_INCREMENT,
    author_name VARCHAR(50) NOT NULL,
    PRIMARY KEY(author_id)
);

CREATE TABLE titles(
    title_id INT(10) NOT NULL AUTO_INCREMENT,
    title_name VARCHAR(50) NOT NULL,
    subject_id INT(10) NOT NULL,
    publisher_id INT(10) NOT NULL,
    PRIMARY KEY(title_id),
    FOREIGN KEY(subject_id) REFERENCES subjects(subject_id) ON DELETE CASCADE,
    FOREIGN KEY(publisher_id) REFERENCES publishers(publisher_id) ON DELETE CASCADE
);

CREATE TABLE title_author(
    title_id INT(10) NOT NULL,
    author_id INT(10) NOT NULL,
    PRIMARY KEY(title_id, author_id),
    FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(author_id) REFERENCES authors(author_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE books(
    accession_no INT(10) NOT NULL AUTO_INCREMENT,
    title_id INT(10),
    purchase_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    price DOUBLE(6,2),
    status ENUM("0","1"),
    PRIMARY KEY(accession_no),
    FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE book_issue(
    issue_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    accession_no INT(10) NOT NULL,
    member_id INT(10) NOT NULL,
    due_date TIMESTAMP NULL,
    PRIMARY KEY (issue_dt,accession_no,member_id),
    FOREIGN KEY (accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE, 
    FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE book_return(
    return_dt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    accession_no INT(10) NOT NULL,
    member_id INT(10) NOT NULL,
    issue_dt TIMESTAMP NOT NULL,
    PRIMARY KEY (return_dt,accession_no,member_id),
    FOREIGN KEY (accession_no) REFERENCES books(accession_no) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (member_id) REFERENCES members(member_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (issue_dt) REFERENCES book_issue(issue_dt) ON DELETE CASCADE ON UPDATE CASCADE
);
