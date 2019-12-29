/*CATEGORY*/
INSERT INTO category (url_image)
VALUES ('Flowers');

INSERT INTO category (url_image) 
VALUES ('Vegetables');

INSERT INTO category (url_image)
VALUES ('Trees');

INSERT INTO category (url_image) 
VALUES ('Tools');

/*LANGUAGE*/

INSERT INTO language VALUES (1, 'English', 'en');
INSERT INTO language VALUES (2, 'Français', 'fr');


/*TRANSLATION CATEGORY*/

INSERT INTO translation_category VALUES (1, 1, 'Flowers');
INSERT INTO translation_category VALUES (1, 2, 'Fleurs');
INSERT INTO translation_category VALUES (2, 1, 'Vegetables');
INSERT INTO translation_category VALUES (2, 2, 'Légumes');
INSERT INTO translation_category VALUES (3, 1, 'Trees');
INSERT INTO translation_category VALUES (3, 2, 'Arbres');
INSERT INTO translation_category VALUES (4, 1, 'Tools');
INSERT INTO translation_category VALUES (4, 2, 'Outils');




/*PRODUCTS*/

INSERT INTO product (category_id, price, stock) VALUES (2, 1.9, 30);

INSERT INTO product (category_id, price, stock) VALUES (4, 20.83, 20);

INSERT INTO product (category_id, price, stock) VALUES (2, 1.25, 50);
INSERT INTO product (category_id, price, stock) VALUES (2, 0.42, 30);
INSERT INTO product (category_id, price, stock) VALUES (2, 0.62, 25);

INSERT INTO product (category_id, price, stock, url_image) VALUES (1, 8.5, 15, "rose");
INSERT INTO product (category_id, price, stock, url_image) VALUES (1, 4, 40, "clove-pink");

INSERT INTO product (category_id, price, stock) VALUES (3, 15.25, 15);
INSERT INTO product (category_id, price, stock) VALUES (3, 21, 7);
INSERT INTO product (category_id, price, stock) VALUES (3, 13.75, 10);


INSERT INTO product (category_id, price, stock) VALUES (4, 3.6, 20);
INSERT INTO product (category_id, price, stock) VALUES (4, 12, 30);

INSERT INTO product (category_id, price, stock, url_image) VALUES (1, 7.75, 12, "dragon-flower");

/*TRANSLATION_PRODUCT*/

INSERT INTO  translation_product VALUES (1, 2, 'Tomate', 'Cultivées en serre en Wallonie');
INSERT INTO  translation_product VALUES (1, 1, 'Tomato', 'Cultivated in a greenhouse in Wallonia');

INSERT INTO  translation_product VALUES (2, 2, 'Pelle', 'Un pelle résistante pour démarrer vos cultures');
INSERT INTO  translation_product VALUES (2, 1, 'Shovel', 'A resistant shovel to start your crops');

INSERT INTO  translation_product VALUES (3, 2, 'Graines de tomates', 'Un sachet de graines de tomates');
INSERT INTO  translation_product VALUES (3, 1, 'Tomato seeds', 'A bag of tomato seeds');
INSERT INTO  translation_product VALUES (4, 2, 'Courgette', 'Cultivées en Wallonie');
INSERT INTO  translation_product VALUES (4, 1, 'Courgette', 'Cultivated in Wallonia');
INSERT INTO  translation_product VALUES (5, 2, 'Carotte', 'Cultivées en Wallonie');
INSERT INTO  translation_product VALUES (5, 1, 'Carrot', 'Cultivated in Wallonia');

INSERT INTO  translation_product VALUES (6, 2, 'Rose', 'Petite rose de coulor orange');
INSERT INTO  translation_product VALUES (6, 1, 'Rose', 'Small rose, orange color');
INSERT INTO  translation_product VALUES (7, 2, 'Oeillet', 'Grande fleur coulor rouge');
INSERT INTO  translation_product VALUES (7, 1, 'Clove pink', 'Big flower, red color');

INSERT INTO  translation_product VALUES (8, 2, 'Pommier', 'Cultivées en Wallonie');
INSERT INTO  translation_product VALUES (8, 1, 'Apple tree', 'Cultivated in Wallonia');
INSERT INTO  translation_product VALUES (9, 2, 'Cerisier', 'Cultivés en serre en Wallonie');
INSERT INTO  translation_product VALUES (9, 1, 'Cerasus ', 'Grown in a greenhouse in Wallonia');
INSERT INTO  translation_product VALUES (10, 2, 'Prunier', 'Cultivées en Wallonie');
INSERT INTO  translation_product VALUES (10, 1, 'Plum tree', 'Cultivated in Wallonia');

INSERT INTO  translation_product VALUES (11, 2, 'Gants de travail', 'Deux paires de gants de protection');
INSERT INTO  translation_product VALUES (11, 1, 'Work gloves', 'Two pairs of protective gloves');
INSERT INTO  translation_product VALUES (12, 2, 'Rateau', 'Un rateau pour préparer votre terrain');
INSERT INTO  translation_product VALUES (12, 1, 'Rake', 'A rake to prepare your land');

INSERT INTO  translation_product VALUES (13, 2, 'Mufliers', 'Cultivées en serre en Wallonie de coulor blanche');
INSERT INTO  translation_product VALUES (13, 1, 'Dragon flowers', 'Cultivated in Wallonia, white color');


/*DISCOUNT*/

INSERT INTO discount (percentage, product_id) values(5,12);
INSERT INTO discount (percentage, product_id) values(10,2);
INSERT INTO discount (percentage, product_id) values(10,7);
INSERT INTO discount (percentage, product_id) values(15,8);

/*USER*/