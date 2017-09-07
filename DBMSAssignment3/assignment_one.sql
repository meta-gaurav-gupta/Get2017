/* 1. Write a command to display information on books issued for more than two months. 
The information should include member_nm, member id, title_nm, accession no, issue_dt, 
due dt, and issued for how many months and be sorted on member_nm, and within member_nm 
on title_nm.  */

SELECT * FROM (
SELECT M.member_name, M.member_id,T.title_name,B.accession_no,BI.issue_dt, BI.due_date,
TIMESTAMPDIFF(MONTH, BI.issue_dt, CURRENT_TIMESTAMP) AS "Months"
FROM book_issue AS BI
INNER JOIN members AS M ON M.member_id = BI.member_id
INNER JOIN books AS B ON BI.accession_no = B.accession_no
INNER JOIN titles AS T ON B.title_id = T.title_id
ORDER BY M.member_name,T.title_name
) AS IT
WHERE Months > 2;

/* 2. Write a command to display those rows from members table haying maximum length for member name.
Information should contain member_nm and length of member_nm.  */
SELECT member_name, LENGTH(member_name) AS "Length" 
FROM members
WHERE LENGTH(member_name) = (SELECT MAX(LENGTH(member_name)) AS "Length"
FROM members);

/* 3. Write a command to display count of number of books issued so far. */
SELECT COUNT(issue_dt) AS "Total Issued Books"
FROM book_issue;


