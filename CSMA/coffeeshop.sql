drop database if exists coffeeshop;	
CREATE DATABASE coffeeshop;
SET SQL_SAFE_UPDATES = 0;
USE coffeeshop;
CREATE TABLE Accounts(
Acc_Id	INT	AUTO_INCREMENT,
Full_Name	NVARCHAR(255)	UNIQUE,
Gender	INT 	NOT NULL,
Address	NVARCHAR(255)	NOT NULL,
Phone_Number VARCHAR(40)	UNIQUE,
Email	VARCHAR(255)	UNIQUE,
Birth_Date	DATETIME	NOT NULL,
Acc_Status	INT	NOT NULL,
Position VARCHAR(40)	NOT NULL,
User_Name	VARCHAR(255)	NOT NULL,
User_Password	VARCHAR(255)	NOT NULL,
PRIMARY KEY (Acc_Id)
);
INSERT INTO `coffeeshop`.`accounts` (`Acc_Id`, `Full_Name`, `Gender`, `Address`, `Phone_Number`, `Email`, `Birth_Date`, `Acc_Status`, `Position`, `User_Name`, `User_Password`) VALUES ('1', 'Nguyen Xuan Manh', '1', '282 Linh Nam', '0966853865', 'manhnx.nde19078@vtc.edu.vn', '2001/10/01', '1', '1', 'admin', '123456');
INSERT INTO `coffeeshop`.`accounts` (`Acc_Id`, `Full_Name`, `Gender`, `Address`, `Phone_Number`, `Email`, `Birth_Date`, `Acc_Status`, `Position`, `User_Name`, `User_Password`) VALUES ('2', 'Vu Van Thanh', '1', 'Ha Noi', '0956421578', 'thanhvv.nde19052@vtc.edu.vn', '1996/01/15', '1', '2', 'staff', '123456');


CREATE TABLE Cafe(
Cafe_Id	INT	AUTO_INCREMENT ,
Cafe_Name	NVARCHAR(255)	UNIQUE,
Cafe_Price	DECIMAL(13,2)	NOT	NULL,
Cafe_Amount	INT NOT NULL,
Cafe_Status	INT NOT NULL,
PRIMARY KEY (Cafe_Id)
);

INSERT INTO `coffeeshop`.`cafe` (`Cafe_Id`, `Cafe_Name`, `Cafe_Price`, `Cafe_Amount`, `Cafe_Status`) VALUES ('1', 'Cafe da', '10000', '100', '1');
INSERT INTO `coffeeshop`.`cafe` (`Cafe_Id`, `Cafe_Name`, `Cafe_Price`, `Cafe_Amount`, `Cafe_Status`) VALUES ('2', 'Cafe sua', '10000', '100', '1');
INSERT INTO `coffeeshop`.`cafe` (`Cafe_Id`, `Cafe_Name`, `Cafe_Price`, `Cafe_Amount`, `Cafe_Status`) VALUES ('3', 'Cafe den', '10000', '100', '1');
INSERT INTO `coffeeshop`.`cafe` (`Cafe_Id`, `Cafe_Name`, `Cafe_Price`, `Cafe_Amount`, `Cafe_Status`) VALUES ('4', 'Sinh to bo', '15000', '100', '1');
INSERT INTO `coffeeshop`.`cafe` (`Cafe_Id`, `Cafe_Name`, `Cafe_Price`, `Cafe_Amount`, `Cafe_Status`) VALUES ('5', 'Sinh to dua hau', '15000', '100', '1');
INSERT INTO `coffeeshop`.`cafe` (`Cafe_Id`, `Cafe_Name`, `Cafe_Price`, `Cafe_Amount`, `Cafe_Status`) VALUES ('6', 'Coca', '12000', '100', '1');
INSERT INTO `coffeeshop`.`cafe` (`Cafe_Id`, `Cafe_Name`, `Cafe_Price`, `Cafe_Amount`, `Cafe_Status`) VALUES ('7', 'Red bull', '15000', '100', '1');
INSERT INTO `coffeeshop`.`cafe` (`Cafe_Id`, `Cafe_Name`, `Cafe_Price`, `Cafe_Amount`, `Cafe_Status`) VALUES ('8', 'Sting', '12000', '100', '1');
INSERT INTO `coffeeshop`.`cafe` (`Cafe_Id`, `Cafe_Name`, `Cafe_Price`, `Cafe_Amount`, `Cafe_Status`) VALUES ('9 ', 'lavie', '6000', '100', '1');
INSERT INTO `coffeeshop`.`cafe` (`Cafe_Id`, `Cafe_Name`, `Cafe_Price`, `Cafe_Amount`, `Cafe_Status`) VALUES ('10', 'Cam ep', '10000', '100', '1');

select*from Cafe where  Cafe.Cafe_Name like'%caf%';
CREATE TABLE Orders(
Order_Id	INT AUTO_INCREMENT ,
Acc_Id	INT ,
Order_Date 	varchar(11)	NOT NULL, 
Order_table int not null,
PRIMARY KEY (Order_Id),
FOREIGN KEY (Acc_Id) REFERENCES Accounts(Acc_Id) ON DELETE CASCADE
);



CREATE TABLE OrderDetails(
Order_Id	INT	NOT NULL,
Cafe_Id	INT NOT NULL,
Amount	INT NOT NULL,
Price DECIMAL(13,2) NOT NULL,
constraint pk_OrderDetails PRIMARY KEY (Order_Id, Cafe_Id),
 FOREIGN KEY (Order_Id) REFERENCES Orders(Order_Id) ,
FOREIGN KEY (Cafe_Id) REFERENCES Cafe(Cafe_Id) 
);


-- CREATE TABLE Size(
-- Size_Id	INT AUTO_INCREMENT,
-- Size_Type	VARCHAR(40)	NOT NULL,
-- PRIMARY KEY (Size_Id)
-- );
-- INSERT INTO `coffeeshop`.`size` (`Size_Id`, `Size_Type`) VALUES ('1', 'M');
-- INSERT INTO `coffeeshop`.`size` (`Size_Id`, `Size_Type`) VALUES ('2', 'L');
-- INSERT INTO `coffeeshop`.`size` (`Size_Id`, `Size_Type`) VALUES ('3', 'Ly');
-- INSERT INTO `coffeeshop`.`size` (`Size_Id`, `Size_Type`) VALUES ('4', 'Lon');
-- INSERT INTO `coffeeshop`.`size` (`Size_Id`, `Size_Type`) VALUES ('5 ', 'chai');


-- CREATE TABLE Cafe_Size(
-- Cafe_Id	INT NOT NULL,
-- Size_Id	INT NOT NULL,
-- PRIMARY KEY(cafe_Id, Size_Id),
-- FOREIGN KEY(Cafe_Id) REFERENCES Cafe(Cafe_Id) ON DELETE CASCADE,
-- FOREIGN KEY(Size_Id) REFERENCES Size(Size_Id) ON DELETE CASCADE
-- );
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('1', '1');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('1', '2');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('2', '1');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('2', '2');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('3', '1');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('3', '2');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('4', '3');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('5', '3');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('6', '4');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('7', '4');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('8', '4');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('9', '5');
-- INSERT INTO `coffeeshop`.`cafe_size` (`Cafe_Id`, `Size_Id`) VALUES ('10', '3');


-- CREATE TABLE Image(
-- Image_Id	INT AUTO_INCREMENT,
-- Image_Url	VARCHAR(1000) NOT NULL,
-- PRIMARY KEY(Image_Id)
-- );
-- INSERT INTO `coffeeshop`.`image` (`Image_Id`, `Image_Url`) VALUES ('1', 'https://www.google.com.vn/search?tbm=isch&q=cafe%20%C4%91%C3%A1#imgrc=iQKgA9udBrP1LM');
-- INSERT INTO `coffeeshop`.`image` (`Image_Id`, `Image_Url`) VALUES ('2', 'https://www.google.com.vn/search?q=cafe+s%E1%BB%AFa&tbm=isch&ved=2ahUKEwigwtSzwbXrAhUYEKYKHeZaCT8Q2-cCegQIABAA&oq=cafe+s%E1%BB%AFa&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BAgAEEM6BAgjECc6BQgAELEDOgcIABCxAxBDOgYIABAFEB46BggAEAgQHjoGCAAQChAYOgQIABAYUInYAliB5gJghOgCaARwAHgAgAFviAHDBpIBAzYuM5gBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=opJEX6DpEpigmAXmtaX4Aw#imgrc=VCOJSF3-AJSBAM');
-- INSERT INTO `coffeeshop`.`image` (`Image_Id`, `Image_Url`) VALUES ('3', 'https://www.google.com.vn/search?q=cafe+s%E1%BB%AFa&tbm=isch&ved=2ahUKEwigwtSzwbXrAhUYEKYKHeZaCT8Q2-cCegQIABAA&oq=cafe+s%E1%BB%AFa&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BAgAEEM6BAgjECc6BQgAELEDOgcIABCxAxBDOgYIABAFEB46BggAEAgQHjoGCAAQChAYOgQIABAYUInYAliB5gJghOgCaARwAHgAgAFviAHDBpIBAzYuM5gBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=opJEX6DpEpigmAXmtaX4Aw#imgrc=HOhrJZ3o4AILJM');
-- INSERT INTO `coffeeshop`.`image` (`Image_Id`, `Image_Url`) VALUES ('4', 'https://www.google.com.vn/search?q=sinh+t%E1%BB%91+b%C6%A1&tbm=isch&ved=2ahUKEwiP9aPKwbXrAhVH4pQKHQCUDh8Q2-cCegQIABAA&oq=sinh+t%E1%BB%91+&gs_lcp=CgNpbWcQARgAMgQIABBDMgQIABBDMgQIABBDMgQIABBDMgQIABBDMgQIABBDMgQIABBDMgIIADICCAAyAggAOgQIIxAnOgUIABCxAzoICAAQsQMQgwFQlqQCWOutAmCdtgJoAnAAeAKAAdgBiAGwDZIBBTAuOC4ymAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=0ZJEX8_ILcfE0wSAqLr4AQ#imgrc=STQQ4tDENqK-sM');
-- INSERT INTO `coffeeshop`.`image` (`Image_Id`, `Image_Url`) VALUES ('5', 'https://www.google.com.vn/search?q=sinh+t%E1%BB%91+d%C6%B0a+h%E1%BA%A5u&tbm=isch&ved=2ahUKEwiG_-7dwbXrAhWOAKYKHaClCpkQ2-cCegQIABAA&oq=sinh+t%E1%BB%91+d%C6%B0&gs_lcp=CgNpbWcQARgAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADoECCMQJzoECAAQGFDBcVjQfWCihAFoAnAAeACAAXCIAbAEkgEDNC4ymAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=-pJEX4aaMo6BmAWgy6rICQ#imgrc=ceWKgNRjXH1yeM');
-- INSERT INTO `coffeeshop`.`image` (`Image_Id`, `Image_Url`) VALUES ('6', 'https://www.google.com.vn/search?q=coca+cola&tbm=isch&ved=2ahUKEwjP_8LmwbXrAhUAxIsBHZxBByQQ2-cCegQIABAA&oq=coca&gs_lcp=CgNpbWcQARgBMgcIABCxAxBDMgUIABCxAzIFCAAQsQMyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAOgQIIxAnOgQIABBDUNaCAViahgFgwJQBaABwAHgAgAGOAYgBwQOSAQMxLjOYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=DJNEX8_JO4CIr7wPnIOdoAI#imgrc=MeAgw3LuRGgmpM');
-- INSERT INTO `coffeeshop`.`image` (`Image_Id`, `Image_Url`) VALUES ('7', 'https://www.google.com.vn/search?q=red+bull&tbm=isch&ved=2ahUKEwiIyo_wwbXrAhWVyIsBHY2kAYUQ2-cCegQIABAA&oq=red&gs_lcp=CgNpbWcQARgAMgcIABCxAxBDMgUIABCxAzIFCAAQsQMyBwgAELEDEEMyBQgAELEDMgUIABCxAzIFCAAQsQMyBAgAEEMyBQgAELEDMgUIABCxAzoECCMQJzoCCABQh2hYhGpgnHFoAHAAeACAAYUBiAHRApIBAzAuM5gBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=IZNEX8i1BpWRr7wPjcmGqAg#imgrc=MxTHzktvpOIaVM');
-- INSERT INTO `coffeeshop`.`image` (`Image_Id`, `Image_Url`) VALUES ('8', 'https://www.google.com.vn/search?q=sting&tbm=isch&ved=2ahUKEwjxjMv3wbXrAhVH95QKHdpfAdsQ2-cCegQIABAA&oq=sting&gs_lcp=CgNpbWcQAzIFCAAQsQMyBAgAEEMyBAgAEEMyBAgAEEMyBQgAELEDMgIIADICCAAyAggAMgIIADICCAA6BAgjECc6BwgAELEDEENQtGRY1mpgiGxoAHAAeACAAb8BiAHZBJIBAzEuNJgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=MJNEX_G0Lsfu0wTav4XYDQ#imgrc=nbkLhw7cJ1y-vM');
-- INSERT INTO `coffeeshop`.`image` (`Image_Id`, `Image_Url`) VALUES ('9', 'https://www.google.com.vn/search?q=lavie&tbm=isch&ved=2ahUKEwiuotX-wbXrAhUrJaYKHbT4CqMQ2-cCegQIABAA&oq=lavie&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BAgjECc6BQgAELEDOgQIABBDUMOWAli-pAJgxq0CaABwAHgAgAFoiAHTA5IBAzQuMZgBAKABAaoBC2d3cy13aXotaW1nwAEB&sclient=img&ei=P5NEX-6GJavKmAW08auYCg#imgrc=wrK1eCxPma_DKM');
-- INSERT INTO `coffeeshop`.`image` (`Image_Id`, `Image_Url`) VALUES ('10', 'https://www.google.com.vn/search?q=cam+%C3%A9p&tbm=isch&ved=2ahUKEwi-hcKRwrXrAhVEAaYKHer_AU8Q2-cCegQIABAA&oq=cam+%C3%A9p&gs_lcp=CgNpbWcQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BAgjECc6BAgAEEM6CAgAELEDEIMBOgUIABCxAzoGCAAQBRAeUMxdWL1lYLdoaAJwAHgAgAGFAYgB7QaSAQMxLjeYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=Z5NEX_61CMSCmAXq_4f4BA#imgrc=TLrRApil9njyZM');


-- CREATE TABLE Cafe_Image(
-- Cafe_Id	INT NOT NULL,
-- Image_Id INT NOT NULL,
-- PRIMARY KEY(Cafe_Id, Image_Id),
-- FOREIGN KEY(Cafe_Id) REFERENCES Cafe(Cafe_Id) ON DELETE CASCADE,
-- FOREIGN KEY(Image_Id) REFERENCES Image(Image_Id)	ON DELETE CASCADE
-- );
-- INSERT INTO `coffeeshop`.`cafe_image` (`Cafe_Id`, `Image_Id`) VALUES ('1', '1');
-- INSERT INTO `coffeeshop`.`cafe_image` (`Cafe_Id`, `Image_Id`) VALUES ('2', '2');
-- INSERT INTO `coffeeshop`.`cafe_image` (`Cafe_Id`, `Image_Id`) VALUES ('3', '3');
-- INSERT INTO `coffeeshop`.`cafe_image` (`Cafe_Id`, `Image_Id`) VALUES ('4', '4');
-- INSERT INTO `coffeeshop`.`cafe_image` (`Cafe_Id`, `Image_Id`) VALUES ('5', '5');
-- INSERT INTO `coffeeshop`.`cafe_image` (`Cafe_Id`, `Image_Id`) VALUES ('6', '6');
-- INSERT INTO `coffeeshop`.`cafe_image` (`Cafe_Id`, `Image_Id`) VALUES ('7', '7');
-- INSERT INTO `coffeeshop`.`cafe_image` (`Cafe_Id`, `Image_Id`) VALUES ('8', '8');
-- INSERT INTO `coffeeshop`.`cafe_image` (`Cafe_Id`, `Image_Id`) VALUES ('9', '9');
-- INSERT INTO `coffeeshop`.`cafe_image` (`Cafe_Id`, `Image_Id`) VALUES ('10', '10');


-- CREATE TABLE Material(
-- Material_Id	INT AUTO_INCREMENT,
-- Material_Name	NVARCHAR(255)	NOT NULL,
-- Amount	INT NOT NULL,
-- Date_Added DATETIME NOT NULL,
-- Material_Status	INT NOT NULL,
-- PRIMARY KEY(Material_Id)
-- );
-- INSERT INTO `coffeeshop`.`material` (`Material_Id`, `Material_Name`, `Amount`, `Date_Added`, `Material_Status`) VALUES ('1', 'cafe', '10', '2020-08-25', '1');
-- INSERT INTO `coffeeshop`.`material` (`Material_Id`, `Material_Name`, `Amount`, `Date_Added`, `Material_Status`) VALUES ('2', 'sua', '4', '2020-08-25', '1');
-- INSERT INTO `coffeeshop`.`material` (`Material_Id`, `Material_Name`, `Amount`, `Date_Added`, `Material_Status`) VALUES ('3', 'đường', '10', '2020-08-25', '1');
-- INSERT INTO `coffeeshop`.`material` (`Material_Id`, `Material_Name`, `Amount`, `Date_Added`, `Material_Status`) VALUES ('4', 'bơ', '10', '2020-08-25', '1');
-- INSERT INTO `coffeeshop`.`material` (`Material_Id`, `Material_Name`, `Amount`, `Date_Added`, `Material_Status`) VALUES ('5', 'dưa hấu', '10', '2020-08-25', '1');
-- INSERT INTO `coffeeshop`.`material` (`Material_Id`, `Material_Name`, `Amount`, `Date_Added`, `Material_Status`) VALUES ('6', 'cam vàng', '10', '2020-08-25', '1');


-- CREATE TABLE Recipe(
-- Cafe_Id	INT NOT NULL,
-- Material_Id	INT NOT NULL,
-- Content	FLOAT,
-- PRIMARY KEY(Cafe_Id, Material_Id),
-- FOREIGN KEY(Cafe_Id) REFERENCES Cafe(Cafe_Id) ON DELETE CASCADE,
-- FOREIGN KEY(Material_Id) REFERENCES Material(Material_Id) ON DELETE CASCADE
-- );
-- INSERT INTO `coffeeshop`.`recipe` (`Cafe_Id`, `Material_Id`, `Content`) VALUES ('1', '1', '0.03');
-- INSERT INTO `coffeeshop`.`recipe` (`Cafe_Id`, `Material_Id`, `Content`) VALUES ('1', '3', '0.02');
-- INSERT INTO `coffeeshop`.`recipe` (`Cafe_Id`, `Material_Id`, `Content`) VALUES ('2', '1', '0.03');
-- INSERT INTO `coffeeshop`.`recipe` (`Cafe_Id`, `Material_Id`, `Content`) VALUES ('2', '2', '0.02');
-- INSERT INTO `coffeeshop`.`recipe` (`Cafe_Id`, `Material_Id`, `Content`) VALUES ('3', '1', '0.03');
-- INSERT INTO `coffeeshop`.`recipe` (`Cafe_Id`, `Material_Id`, `Content`) VALUES ('4', '4', '10');
-- INSERT INTO `coffeeshop`.`recipe` (`Cafe_Id`, `Material_Id`, `Content`) VALUES ('4', '2', '0.03');
-- INSERT INTO `coffeeshop`.`recipe` (`Cafe_Id`, `Material_Id`, `Content`) VALUES ('5', '5', '10');
-- INSERT INTO `coffeeshop`.`recipe` (`Cafe_Id`, `Material_Id`, `Content`) VALUES ('5', '2', '0.03');
-- INSERT INTO `coffeeshop`.`recipe` (`Cafe_Id`, `Material_Id`, `Content`) VALUES ('10', '6', '20');

-- PROCEDURE 
DELIMITER $$
CREATE PROCEDURE insertOrder(in acc_id int , in order_table int , in order_date varchar(11))
BEGIN 
	insert into orders(acc_id,order_table,order_date) values(Acc_id,order_table,order_date);
END $$
DELIMITER ;

-- end insertOrder
DELIMITER $$
CREATE PROCEDURE insertOrderDetail(in order_id int , in cafe_id int , in amount int , in price double)
BEGIN 
	insert into orderdetails values(order_id,cafe_id,amount,price);
END $$
DELIMITER ;
-- end insertOrderDetail





