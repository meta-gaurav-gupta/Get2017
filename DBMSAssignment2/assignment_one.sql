/* 1. write a SELECT command to display all the columns of members table. */ 
SELECT COLUMN_NAME
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = 'members';


/*2. write a SELECT command to display member_name, member_id and category column of member table. */
SELECT COLUMN_NAME
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = 'members' 
AND COLUMN_NAME = "member_id" 
OR COLUMN_NAME = "member_name"
OR COLUMN_NAME = "category";

/*3. write a SELECT command to display member_name, member_id and category column of member table where category is F */
SELECT `member_id`, `member_name`, `category`
FROM members
WHERE category = "F";

/*4. write a command to display various categories of members. */
SELECT DISTINCT category
FROM members;

/*5. write a SELECT command to display member name and their categories in the descending order of member name. */
SELECT `member_name`, `category`
FROM members
ORDER BY `member_name` DESC;

/*6. write a SELECT command to display all the titles, their subjects and publishers. */
SELECT title_name, subject_name , publisher_name
FROM titles AS T
INNER JOIN subjects AS S ON T.subject_id = S.subject_id
INNER JOIN publishers AS P ON T.publisher_id = P.publisher_id;

/*7. write a SELECT command to display the number of member present in each category . The result should include category
and number of members include in this category */
SELECT category, COUNT(category)
FROM members
GROUP BY category;

/*8. write a SELECT command to display names of those members who belongs the category as to which member "Keshav Sharma" belongs. */
/* Using IN operator and Nested Quaries */
SELECT member_name
FROM members
WHERE category IN (SELECT category
                    FROM members
                    WHERE member_name = "Keshav Sharma");

/*Using Joins*/
SELECT M1.member_name
FROM members AS M1
INNER JOIN members AS M2 ON 
M2.member_name = "Keshav Sharma" 
AND 
M1.category = M2.category;

/*9. write a select command to display information on all the books issued.the result should include issue_dt, accession_no, member_id,
and return_dt. if book has not returned , the column return date should be blank.*/

SELECT I.issue_dt,I.accession_no,I.member_id,R.return_dt
FROM book_issue AS I
LEFT JOIN book_return AS R ON 
I.issue_dt = R.issue_dt 
AND 
I.accession_no = R.accession_no 
AND 
I.member_id = R.member_id;



