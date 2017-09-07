/* 1. Write a SELECT command to display total number of students, total number of faculty and total 
number of others in library information system in a single row. */

SELECT COUNT(IF(category="S",1,null)) AS "Students", 
	   COUNT(IF(category="F",1,null)) AS "Faculty", 
	   COUNT(IF(category!="S" AND category !="F",1,null)) AS "Others"
FROM members;

/* 2. Display the information of those titles that have been issued more than 2 times. */
SELECT B.title_id AS "Title ID", 
	   T.title_name AS "Title Name", 
	   A.author_nm AS "Author", 
	   S.subject_nm AS "Subject",
	   P.publisher_nm AS "Publisher"
FROM books AS B
INNER JOIN titles AS T ON B.title_id = T.title_id
INNER JOIN title_author AS TA ON T.title_id = TA.title_id
INNER JOIN authors AS A ON TA.author_id = A.author_id
INNER JOIN subjects AS S ON T.subject_id = S.subject_id
INNER JOIN publishers AS P ON T.publisher_id = P.publisher_id
WHERE B.accession_no IN (
                        SELECT BI.accession_no
                        FROM book_issue AS BI
                        GROUP BY accession_no
                        HAVING COUNT(BI.accession_no) > 2
                        )


/* 3. Write a command to display information on books issued to members of category other than "F" (Faculty).*/
SELECT M.member_name AS "ISSUED BY", 
	   B.title_id AS "TITLE ID", 
	   T.title_name AS "TITLE", 
	   A.author_nm AS "Author", 
	   S.subject_nm AS "Subject",
	   P.publisher_nm AS "Publisher"
FROM book_issue AS BI
INNER JOIN members AS M ON BI.member_id = M.member_id AND M.category <> "F"
INNER JOIN books AS B ON B.accession_no = BI.accession_no
INNER JOIN titles AS T ON B.title_id = T.title_id
INNER JOIN title_author AS TA ON T.title_id = TA.title_id
INNER JOIN authors AS A ON TA.author_id = A.author_id
INNER JOIN subjects AS S ON T.subject_id = S.subject_id
INNER JOIN publishers AS P ON T.publisher_id = P.publisher_id


/* 4. Write a command to display information on those authors for which at least one book has been purchased. */
SELECT B.title_id AS "Title ID" , 
	   T.title_name AS "Title" , 
	   A.author_nm as "Author"
FROM books AS B
INNER JOIN titles AS T ON B.title_id = T.title_id
INNER JOIN title_author AS TA ON T.title_id = TA.title_id
INNER JOIN authors AS A ON TA.author_id = A.author_id


