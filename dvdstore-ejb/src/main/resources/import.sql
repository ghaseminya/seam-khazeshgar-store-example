delete from ORDERLINES
delete from ORDERS
delete from USERS
delete from INVENTORY
delete from PRODUCT_CATEGORY
delete from PRODUCT_ACTORS
delete from ACTORS
delete from PRODUCTS
delete from CATEGORIES

INSERT INTO USERS (USERID,DTYPE,USERNAME,PASSWORD,FIRSTNAME,LASTNAME) VALUES (1,'admin','manager','password','Albus', 'Dumblebore')
INSERT INTO USERS (USERID,DTYPE,FIRSTNAME,LASTNAME,ADDRESS1,EMAIL,PHONE,USERNAME,PASSWORD) VALUES (2,'customer','Harry','Potter','4 Privet Drive','h.potter@hogwarts.edu','4608499546','user1','password')
INSERT INTO USERS (USERID,DTYPE,FIRSTNAME,LASTNAME,ADDRESS1,EMAIL,PHONE,USERNAME,PASSWORD) VALUES (3,'customer','Hermione','Granger','5119315633 Dell Way','h.granger@hogwarts.edu','5119315633','user2','password')
INSERT INTO USERS (USERID,DTYPE,FIRSTNAME,LASTNAME,ADDRESS1,EMAIL,PHONE,USERNAME,PASSWORD) VALUES (4,'customer','Ron','Weasley','6297761196 Dell Way','r.weasley@hogwarts.edu','6297761196','user3','password')
INSERT INTO USERS (USERID,DTYPE,FIRSTNAME,LASTNAME,ADDRESS1,EMAIL,PHONE,USERNAME,PASSWORD) VALUES (5,'customer','سید علی','آلطاها','9862764981 Dell Way','ali.aletaha@gmail.com','9862764981','user4','password')
INSERT INTO USERS (USERID,DTYPE,FIRSTNAME,LASTNAME,ADDRESS1,EMAIL,PHONE,USERNAME,PASSWORD) VALUES (6,'customer','Ginny','Weasley','2841895775 Dell Way','g.weasley@hogwarts.edu','2841895775','user5','password')

insert into ACTORS (ID, NAME) values (1, 'Tom Hanks')
insert into ACTORS (ID, NAME) values (2, 'Katie Holmes')
insert into ACTORS (ID, NAME) values (3, 'Drew Barrymore')
insert into ACTORS (ID, NAME) values (4, 'Daniel Radcliffe')
insert into ACTORS (ID, NAME) values (5, 'Jim Carrey')
insert into ACTORS (ID, NAME) values (6, 'Scarlett Johansson')
insert into ACTORS (ID, NAME) values (7, 'Bill Murray')
insert into ACTORS (ID, NAME) values (8, 'Owen Wilson')
insert into ACTORS (ID, NAME) values (9, 'Luke Wilson')
insert into ACTORS (ID, NAME) values (10, 'Tobey Maguire')
insert into ACTORS (ID, NAME) values (11, 'John Cusak')
insert into ACTORS (ID, NAME) values (12, 'Jack Black')
insert into ACTORS (ID, NAME) values (13, 'Keanu Reeves')
insert into ACTORS (ID, NAME) values (14, 'Christopher Reeve')
insert into ACTORS (ID, NAME) values (15, 'Harrison Ford')
insert into ACTORS (ID, NAME) values (16, 'Kirsten Dunst')
insert into ACTORS (ID, NAME) values (17, 'Elijah Wood')
insert into ACTORS (ID, NAME) values (18, 'Laurence Fishburne')
insert into ACTORS (ID, NAME) values (19, 'Meg Ryan')
insert into ACTORS (ID, NAME) values (20, 'Billy Crystal')
insert into ACTORS (ID, NAME) values (21, 'Wesley Snipes')
insert into ACTORS (ID, NAME) values (22, 'Ewan McGregor')
insert into ACTORS (ID, NAME) values (23, 'Natalie Portman')
insert into ACTORS (ID, NAME) values (24, 'Jon Heder')
insert into ACTORS (ID, NAME) values (25, 'Vince Vaughn')
insert into ACTORS (ID, NAME) values (26, 'Ben Stiller')
insert into ACTORS (ID, NAME) values (27, 'Matt Damon')
insert into ACTORS (ID, NAME) values (28, 'Jodie Foster')
insert into ACTORS (ID, NAME) values (29, 'Matthew McConaughey')
insert into ACTORS (ID, NAME) values (30, 'Ed Harris')
insert into ACTORS (ID, NAME) values (31, 'Ralph Fiennes')
insert into ACTORS (ID, NAME) values (32, 'Gwyneth Paltrow')
insert into ACTORS (ID, NAME) values (33, 'Brad Pitt')
insert into ACTORS (ID, NAME) values (34, 'Angelina Jolie')
insert into ACTORS (ID, NAME) values (35, 'Edward Norton')
insert into ACTORS (ID, NAME) values (36, 'Adam Sandler')
insert into ACTORS (ID, NAME) values (37, 'Johnny Depp')
insert into ACTORS (ID, NAME) values (38, 'Keira Knightley')
insert into ACTORS (ID, NAME) values (39, 'Robin Williams')
insert into ACTORS (ID, NAME) values (40, 'Tom Cruise')
insert into ACTORS (ID, NAME) values (41, 'Bruce Willis')
insert into ACTORS (ID, NAME) values (42, 'Patrick Stewart')
insert into ACTORS (ID, NAME) values (43, 'Halle Berry')
insert into ACTORS (ID, NAME) values (44, 'Jennifer Aniston')
insert into ACTORS (ID, NAME) values (45, 'Julia Stiles')
insert into ACTORS (ID, NAME) values (46, 'Winona Ryder')
insert into ACTORS (ID, NAME) values (47, 'Kate Hudson')
insert into ACTORS (ID, NAME) values (48, 'Uma Thurman')
insert into ACTORS (ID, NAME) values (49, 'Julia Roberts')
insert into ACTORS (ID, NAME) values (50, 'Steve Carell')
insert into ACTORS (ID, NAME) values (51, 'Catherine Keener')
insert into ACTORS (ID, NAME) values (52, 'Franka Potente')
insert into ACTORS (ID, NAME) values (53, 'Catherine Zeta-Jones')
insert into ACTORS (ID, NAME) values (54, 'Tim Robbins')
insert into ACTORS (ID, NAME) values (55, 'Cate Blanchett')
insert into ACTORS (ID, NAME) values (56, 'Orlando Bloom')
insert into ACTORS (ID, NAME) values (57, 'Liv Tyler')
insert into ACTORS (ID, NAME) values (58, 'Ben Affleck')
insert into ACTORS (ID, NAME) values (59, 'Jack Nicholson')
insert into ACTORS (ID, NAME) values (60, 'Meryl Streep')
insert into ACTORS (ID, NAME) values (61, 'John Travolta')
insert into ACTORS (ID, NAME) values (62, 'Cary Grant')
insert into ACTORS (ID, NAME) values (63, 'Woody Allen')
insert into ACTORS (ID, NAME) values (64, 'Will Smith')
insert into ACTORS (ID, NAME) values (65, 'Sean Connery')
insert into ACTORS (ID, NAME) values (66, 'Kevin Costner')
insert into ACTORS (ID, NAME) values (67, 'Arnold Schwarzenegger')
insert into ACTORS (ID, NAME) values (68, 'Audrey Hepburn')
insert into PRODUCTS (PROD_ID, ASIN, TITLE, PRICE, IMAGE_URL, DESCRIPTION) values ('1','630522577X', 'خزشگر ساده', 19000, 'CP.png', 'خزشگر ساده برای انجام خزشهای مختلف در سایت های تجاری و خبری طراحی شده است.این خزشگر دارای پهنای باند یک ماهه ۱۰ گیگابایت می باشد، هسته های خزشگر این پلن ۴ هسته موازی می باشد.');
insert into PRODUCTS (PROD_ID, ASIN, TITLE, PRICE, IMAGE_URL, DESCRIPTION) values ('2','630522578X', 'خزشگر ساده خبر ساز', 24000, 'CP.png', 'خزشگر ساده خبر ساز برای انجام خزشهای مختلف در سایت های خبری طراحی شده است.این خزشگر دارای پهنای باند یک ماهه ۱۰ گیگابایت می باشد، هسته های خزشگر این پلن ۴ هسته موازی می باشد.');
insert into PRODUCTS (PROD_ID, ASIN, TITLE, PRICE, IMAGE_URL, DESCRIPTION) values ('3','630522579X', 'خزشگر ساده قیمت', 30000, 'CP.png', 'خزشگر ساده قیمت برای انجام خزشهای مختلف در سایت های تجاری و ارائه لحظه ای قیمت های مختلف طراحی شده است.این خزشگر دارای پهنای باند یک ماهه ۲۰ گیگابایت می باشد، هسته های خزشگر این پلن ۴ هسته موازی می باشد.');
insert into PRODUCTS (PROD_ID, ASIN, TITLE, PRICE, IMAGE_URL, DESCRIPTION) values ('4', '630522580X', 'خزشگر هوشمند', 80000, 'CP.png', 'خزشگر هوشمند برای انجام خزشهای مختلف در سایت های  مختلف طراحی شده است.این خزشگر دارای پهنای باند یک ماهه ۴۰ گیگابایت می باشد، هسته های خزشگر این پلن ۸ هسته موازی می باشد.');
insert into PRODUCTS (PROD_ID, ASIN, TITLE, PRICE, IMAGE_URL, DESCRIPTION) values ('5', '630522581X', 'خزشگر هوشمند ثبت کننده', 140000, 'CP.png', 'خزشگر هوشمند ثبت کننده برای انجام خزشهای مختلف در سایت های  مختلف و همینطور ثبت دیتا طراحی شده است.این خزشگر دارای پهنای باند یک ماهه ۴۰ گیگابایت می باشد، هسته های خزشگر این پلن ۸ هسته موازی می باشد.');
insert into PRODUCTS (PROD_ID, ASIN, TITLE, PRICE, IMAGE_URL, DESCRIPTION) values ('6', '630522582X', 'خزشگر با خروجی json', 250000, 'CP.png', 'خزشگر با خروجی jsonبرای انجام خزشهای مختلف در سایت های  مختلف و همینطور ارائه دیتای خروجی با فرمت jsonطراحی شده است.این خزشگر دارای پهنای باند یک ماهه ۴۰ گیگابایت می باشد، هسته های خزشگر این پلن ۸ هسته موازی می باشد.');
insert into PRODUCTS (PROD_ID, ASIN, TITLE, PRICE, IMAGE_URL, DESCRIPTION) values ('7', '630522583X', 'خزشگر نامحدود', 460000, 'CP.png', 'خزشگر نامحدود برای انجام انواع خزشهای مختلف در سایت های  مختلف و همینطور ثبت دیتا طراحی شده است.این خزشگر دارای پهنای باند یک ماهه ۱۰۰ گیگابایت می باشد، هسته های خزشگر این پلن ۱۶ هسته موازی می باشد.');
insert into PRODUCTS (PROD_ID, ASIN, TITLE, PRICE, IMAGE_URL, DESCRIPTION) values ('8', '630522584X', 'خزشگر جادویی', 800000, 'CP.png', 'خزشگر جادویی برای انجام خزشهای مختلف در سایت های  مختلف و آنالیز دیتا و همینطور خروجی های خاص منظور طراحی شده است.این خزشگر دارای پهنای باند یک ماهه نامحدود می باشد، هسته های خزشگر این پلن ۳۲ هسته موازی می باشد.');


insert into PRODUCT_ACTORS (PROD_ID,ACTOR_ID) values (1, 68)
insert into CATEGORIES (CATEGORY, NAME) values (1, 'خزش خبری');
insert into PRODUCT_CATEGORY (PROD_ID, CATEGORY) values (1, 1);
insert into CATEGORIES (CATEGORY, NAME) values (2, 'خزش فروشگاهی');
insert into PRODUCT_CATEGORY (PROD_ID, CATEGORY) values (1, 2);
insert into CATEGORIES (CATEGORY, NAME) values (3, 'خزش آنالیز دیتا');
insert into PRODUCT_CATEGORY (PROD_ID, CATEGORY) values (1, 3);
insert into CATEGORIES (CATEGORY, NAME) values (4, 'خزش نرخ ارز');
insert into PRODUCT_CATEGORY (PROD_ID, CATEGORY) values (1, 4);
insert into CATEGORIES (CATEGORY, NAME) values (5, 'خزش بورس');
insert into PRODUCT_CATEGORY (PROD_ID, CATEGORY) values (1, 5);
insert into CATEGORIES (CATEGORY, NAME) values (6, 'خزش ثبت دیتا');
insert into PRODUCT_CATEGORY (PROD_ID, CATEGORY) values (1, 6);
insert into INVENTORY (INV_ID, PROD_ID, QUAN_IN_STOCK, SALES) values (1, 1, 84, 0);
insert into INVENTORY (INV_ID, PROD_ID, QUAN_IN_STOCK, SALES) values (2, 2, 84, 0);
insert into INVENTORY (INV_ID, PROD_ID, QUAN_IN_STOCK, SALES) values (3, 3, 84, 0);
insert into INVENTORY (INV_ID, PROD_ID, QUAN_IN_STOCK, SALES) values (4, 4, 84, 0);
insert into INVENTORY (INV_ID, PROD_ID, QUAN_IN_STOCK, SALES) values (5, 5, 84, 0);
insert into INVENTORY (INV_ID, PROD_ID, QUAN_IN_STOCK, SALES) values (6, 6, 84, 0);
insert into INVENTORY (INV_ID, PROD_ID, QUAN_IN_STOCK, SALES) values (7, 7, 84, 0);
insert into INVENTORY (INV_ID, PROD_ID, QUAN_IN_STOCK, SALES) values (8, 8, 84, 0);
