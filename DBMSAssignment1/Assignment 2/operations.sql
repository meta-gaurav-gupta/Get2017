/* shows all the table in lis database*/
SHOW TABLES;

/* Alter definitions of following LIS tables to provide the default constraints: set default value of issue_dat to Current Timestamp  */
ALTER TABLE book_issue
MODIFY COLUMN issue_dt  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

CREATE TRIGGER ins_update_end
     BEFORE INSERT ON book_issue
     FOR EACH ROW SET NEW.`due_date` = NOW() + INTERVAL 15 DAY;
     


/* Write a command to remove Members table of the LIS database. */
SET @@foreign_key_checks = 0;
DROP TABLE members;
SET @@foreign_key_checks = 1;