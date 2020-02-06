 
-- INSERT INTO credentials(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
-- INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
  
-- INSERT INTO authority (id,username, authority) VALUES (1,'guest', 'ROLE_USER');
-- INSERT INTO authority (id,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');
-- INSERT INTO authority (id,username, authority) VALUES (3,'admin', 'ROLE_USER');

-- INSERT INTO address (city, country, state,street,zipCode) VALUES ('Asmara', 'Eritrea', 'Makel','203','1299');
 
-- INSERT INTO  `members` (firstName, lastName,dateOfBirth,phone,addressId,member_id) VALUES ('Curious','George','12/12/12','12345678',1,'admin');
-- INSERT INTO `members` (firstName, lastName,dateOfBirth,phone,addressId,member_id) VALUES ('Allen','Rench','12/12/12','87654321',1,'guest');

 

INSERT INTO credentials(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);

INSERT INTO authority (id,username, authority) VALUES (1,'guest', 'ROLE_USER');
INSERT INTO authority (id,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');
INSERT INTO authority (id,username, authority) VALUES (3,'admin', 'ROLE_USER');

INSERT INTO address (city, country, state,street,zipCode) VALUES ('Asmara', 'Eritrea', 'IA','203','1299');


INSERT INTO  `members` (id,firstName, lastName,phone,addressId,member_id) VALUES (1,'Curious','George','12345678',1,'admin');
INSERT INTO `members` (id,firstName, lastName,phone,addressId,member_id) VALUES (2,'Allen','Rench','87654321',1,'guest');
INSERT INTO `catagory` (name,description) VALUES ('electronics','smart one');
INSERT INTO `catagory` (name,description) VALUES ('outfits','long sleev Top');
INSERT INTO catagory (name, description) VALUES ('Electronics', 'That pretty much work by electricity');

INSERT INTO `catagory` (name,description) VALUES ('outfits','long sleev Top');

INSERT INTO `product` (name , amount ,price,cId) VALUES ("SamsungTV",500,2000,1);
INSERT INTO `product` (name , amount ,price,cId) VALUES ("Iphone12",500,900,1);
INSERT INTO `product` (name , amount ,price,cId) VALUES ("SamsungTV2",500,2000,1);
INSERT INTO `product` (name , amount ,price,cId) VALUES ("Iphone13",500,900,1);
INSERT INTO `product` (name , amount ,price,cId) VALUES ("Iphone8",500,900,1);
INSERT INTO `product` (name , amount ,price,cId) VALUES ("Trousers",500,900,2);
INSERT INTO `product` (name , amount ,price,cId) VALUES ("Shorts",500,900,2);
INSERT INTO `product` (name , amount ,price,cId) VALUES ("Trouser2",500,100,2);
INSERT INTO `product` (name , amount ,price,cId) VALUES ("Trouser3",500,900,2);
INSERT INTO `product` (name , amount ,price,cId) VALUES ("hat",500,900,2);

INSERT INTO `orders` ( orderId , member_id ,status) VALUES (1,1,"COMPLETED");
INSERT INTO `orders` ( orderId , member_id ,status) VALUES (2,2,"COMPLETED");
INSERT INTO `orders` ( orderId , member_id ,status) VALUES (3,1,"COMPLETED");
INSERT INTO `orders` ( orderId , member_id ,status) VALUES (4,2,"COMPLETED");


INSERT INTO `cartitem` ( id , order_id , amount ,product_id) VALUES (1,1,1,1);
INSERT INTO `cartitem` ( id , order_id , amount ,product_id) VALUES (2,1,1,2);
INSERT INTO `cartitem` ( id , order_id , amount ,product_id) VALUES (3,1,1,3);
INSERT INTO `cartitem` ( id , order_id , amount ,product_id) VALUES (4,2,1,1);
INSERT INTO `cartitem` ( id , order_id , amount ,product_id) VALUES (5,3,1,3);
INSERT INTO `cartitem` ( id , order_id , amount ,product_id) VALUES (6,4,1,2);