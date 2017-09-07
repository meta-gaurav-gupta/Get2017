/* 1. Write a SELECT command to display name of those members
who belong to the category as to which member
“Jon Snow” belongs.
*/
INSERT INTO `members` (`member_name`, `addressline1`, `addressline2`, `category`) VALUES('Jon Snow','Winterfell','North','F');

SELECT * 
FROM members
WHERE category = (
	SELECT category
	FROM members
	WHERE member_name = "Jon Snow"
	);


/* 2. Write a SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date.
*/
SELECT BI.issue_dt, T.title_name, M.member_name, BI.due_date
FROM book_issue AS BI
INNER JOIN books AS B ON B.accession_no = BI.accession_no
INNER JOIN titles AS T ON T.title_id = B.title_id
INNER JOIN members AS M ON M.member_id = BI.member_id
WHERE NOT EXISTS (SELECT BR.accession_no
	FROM book_return AS BR
	WHERE BI.issue_dt = BR.issue_dt 
	AND 
	BI.accession_no = BR.accession_no
	);
             
/* 3. Write a SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due
date.
*/
SELECT BI.issue_dt, T.title_name, M.member_name, BI.due_date
FROM book_issue AS BI
INNER JOIN books AS B ON B.accession_no = BI.accession_no
INNER JOIN titles AS T ON T.title_id = B.title_id
INNER JOIN members AS M ON M.member_id = BI.member_id
WHERE EXISTS (SELECT BR.accession_no
	FROM book_return AS BR
	WHERE TIMESTAMPDIFF(SECOND,BI.due_date,BR.return_dt) < 0 AND BI.issue_dt = BR.issue_dt AND BI.accession_no = BR.accession_no
	);

/* 4. Write a SELECT command to display information of those books
whose price is equal to the most expensive book purchased so far.
*/
SELECT B.accession_no AS "ID", T.title_name AS "Title", B.price AS "Price"
FROM books AS B
INNER JOIN titles AS T ON B.title_id = T.title_id
WHERE B.price = (
	SELECT MAX(PRICE) 
    FROM books
    );

/* 5. Write a SELECT command to display the second maximum price
of a book. */
SELECT B.accession_no AS "ID", T.title_name AS "Title", B.price AS "Price"
FROM books AS B
INNER JOIN titles AS T ON B.title_id = T.title_id
WHERE B.price < (
	SELECT MAX(PRICE) 
    FROM books
    )
ORDER BY B.price DESC
LIMIT 1;

