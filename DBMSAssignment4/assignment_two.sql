/* 1. Create a View which can be used to display member name and
all issue details of the member using a simple SELECT command. */
CREATE OR REPLACE VIEW member_information_view
AS
SELECT M.member_name AS "Member Name", BI.accession_no AS "Accession No.", BI.issue_dt AS "Issue Date", T.title_name AS "Book Title"
FROM book_issue AS BI
INNER JOIN members AS M ON M.member_id = BI.member_id
INNER JOIN books AS B ON BI.accession_no = B.accession_no
INNER JOIN titles AS T ON T.title_id = B.title_id;

SELECT * FROM 
member_information_view;

/* 2.  Create a View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O. */
CREATE OR REPLACE VIEW full_details
AS
SELECT member_name, member_id, 
CASE category
    WHEN "F" THEN "Faculty"
    WHEN "S" THEN "Student"
    ELSE "Other"
END AS "category"
FROM members;


SELECT * FROM 
full_details;

/* 3.  Create a View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date. */

CREATE OR REPLACE VIEW book_transection_details
AS
SELECT S.subject_nm, T.title_name, M.member_name, M.category, BI.issue_dt, BI.due_date, IFNULL(BR.return_dt,"NULL") AS "Return Date"
FROM book_issue AS BI
INNER JOIN members AS M ON M.member_id = BI.member_id
INNER JOIN books AS B ON BI.accession_no = B.accession_no
INNER JOIN titles AS T ON B.title_id = T.title_id
LEFT JOIN book_return AS BR ON BI.issue_dt = BR.issue_dt AND BI.accession_no = BR.accession_no
INNER JOIN subjects AS S ON T.subject_id = S.subject_id;

SELECT * 
FROM book_transection_details;

