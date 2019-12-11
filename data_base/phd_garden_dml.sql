
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

INSERT INTO language VALUES (1, 'Français', 'fr');
INSERT INTO language VALUES (2, 'English', 'en');

/*TRANSLATION CATEGORY*/

INSERT INTO translation_category VALUES (1, 1, 'Flowers');
INSERT INTO translation_category VALUES (1, 2, 'Fleurs');
INSERT INTO translation_category VALUES (2, 1, 'Vegetables');
INSERT INTO translation_category VALUES (2, 2, 'Légumes');
INSERT INTO translation_category VALUES (3, 1, 'Trees');
INSERT INTO translation_category VALUES (3, 2, 'Arbres');
INSERT INTO translation_category VALUES (4, 1, 'Tools');
INSERT INTO translation_category VALUES (4, 2, 'Outils');