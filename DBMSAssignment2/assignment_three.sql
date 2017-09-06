DROP DATABASE IF EXISTS eCommerce;

CREATE DATABASE eCommerce;

USE eCommerce;

CREATE TABLE IF NOT EXISTS Product_Categories(
    cat_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cat_name VARCHAR(30) NOT NULL,
    cat_parent_id INT NULL,
    FOREIGN KEY (cat_parent_id) REFERENCES Product_Categories(cat_id)
);

INSERT INTO `product_categories` (`cat_name`, `cat_parent_id`) VALUES ('Mobiles & Tablets', NULL),
																	  ('Mobiles', '1'),
																	  ('Smart Phones', '2'),
																	  ('Featured Phones', '2'),
																	  ('Tablets', '1'),
																	  ('2G', '5'),
																	  ('3G', '5'),
																	  ('Accessories', '1'),
																	  ('Cases & Covers', '1'),
																	  ('Computers', NULL),
																	  ('Desktop', '10'),
																	  ('Laptop', '10'),
																	  ('Laptop Accessories', '10'),
																	  ('Keyboard', '13'),
																	  ('Mouse', '13'),
																	  ('Headphones', '13'),
																	  ('Printers', '10'),
																	  ('Inkjet', '17'),
																	  ('Laser', '17'),
																	  ('Home Appliances', NULL),
																	  ('TVs', '20'),
																	  ('LED', '21'),
																	  ('LCD', '21'),
																	  ('Plasma', '21'),
																	  ('Washing Machines', '20'),
																	  ('Full Automatic', '26'),
																	  ('Top Load', '27'),
																	  ('Front Load', '27'),
																	  ('Semi Automatic', '26');

/* 2. display all the categories along with its parent category. */
SELECT C1.cat_id AS "Category ID", C1.cat_name AS "Category Name" , IFNULL(C2.cat_name,"TOP CATEGORY") AS "Parent Category"
FROM product_categories AS C1
LEFT JOIN product_categories AS C2 ON C1.cat_parent_id = C2.cat_id
ORDER BY C2.cat_name ASC;

/* 3. display only TOP Categories*/
SELECT C1.cat_id AS "Category ID", C1.cat_name AS "Category Name" , IFNULL(C2.cat_name,"TOP CATEGORY") AS "Parent Category"
FROM product_categories AS C1
LEFT JOIN product_categories AS C2 ON C1.cat_parent_id = C2.cat_id
WHERE C1.cat_parent_id IS NULL;



       
       
    
/*INNER JOIN product_categories AS C2 ON C2.cat_parent_id = C1.cat_id; */

