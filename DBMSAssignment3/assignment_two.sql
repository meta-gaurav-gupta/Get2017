/* 1. Write a command to display subject wise information on number of books purchased. 
The information should include subject_nm,subject_id,number of books purchased. */
SELECT S.subject_nm , S.subject_id, COUNT(S.subject_nm)
FROM books AS B
INNER JOIN titles AS T ON B.title_id = T.title_id
INNER JOIN subjects AS S ON T.subject_id = S.subject_id
GROUP BY subject_nm;

/* 2. Write a command to display those rows from the book_issue table where a book can be 
returned after two months. That is, the difference in due_dt and issue_dt is greater than two months.*/
SELECT * FROM (
SELECT M.member_name, M.member_id,T.title_name,B.accession_no,BI.issue_dt, BI.due_date,
TIMESTAMPDIFF(MONTH, BI.issue_dt, BI.due_date) AS "Months"
FROM book_issue AS BI
INNER JOIN members AS M ON M.member_id = BI.member_id
INNER JOIN books AS B ON BI.accession_no = B.accession_no
INNER JOIN titles AS T ON B.title_id = T.title_id
ORDER BY M.member_name,T.title_name
) AS IT
WHERE Months > 2;

/* 3. Write a SELECT command to display the list of books having price greater than the minimum price of books purchased so far.*/
SELECT B.accession_no AS "ID", T.title_name AS "Title", B.price AS "Price"
FROM books AS B
INNER JOIN titles AS T ON B.title_id = T.title_id
WHERE B.price > (SELECT MIN(PRICE) 
                 FROM books);
                 