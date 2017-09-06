SELECT I.member_id AS "Member ID",M.member_name AS Name,I.accession_no AS "Accession ID",I.issue_dt AS "Issue Date",R.return_dt AS "Return Date"
FROM book_issue AS I
LEFT JOIN book_return AS R ON I.issue_dt = R.issue_dt AND I.accession_no = R.accession_no AND I.member_id = R.member_id
LEFT JOIN members AS M ON I.member_id = M.member_id 
ORDER BY I.issue_dt ASC, M.member_name ASC;
