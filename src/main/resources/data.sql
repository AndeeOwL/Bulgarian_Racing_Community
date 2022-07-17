INSERT INTO users (email, first_name, last_name, password, username)
VALUES ('petko@petkov','Petko','Petkov',12345678,'petkopetkov');

INSERT INTO users (email, first_name, last_name, password, username)
VALUES ('ivan@ivanov','Ivan','Ivanov',12345678,'ivanivanov');


INSERT INTO vehicles (brand,description,engine_size,engine_type,hp,mile_standing,model,nm,photo,quarter_mile_standing,top_speed,vehicle_type,year_of_production,zero_to_hundred,user_entity_id)
VALUES ('BMW', 'My first car', 3000, 'DIESEL',184,40,'E46',600,'https://thumbs.img-sprzedajemy.pl/1000x901c/6a/a4/e4/e46-20d-swap-30d-200-gniazdo-aux-brodnica-sprzedam-526202929.jpg',13.3,240,'CAR','12.12.2002',6.2,1);

INSERT INTO vehicles (brand,description,engine_size,engine_type,hp,mile_standing,model,nm,photo,quarter_mile_standing,top_speed,vehicle_type,year_of_production,zero_to_hundred,user_entity_id)
VALUES ('Mercedes', 'Chip tuned', 3200, 'DIESEL',260,35,'E320',700,'https://7cars.bg/wp-content/uploads/2019/11/CC178A83-9A1D-439E-B45B-D2B60843425C-876x535.jpeg',13,260,'CAR','12.12.2006',5.5,2);

INSERT INTO vehicles (brand,description,engine_size,engine_type,hp,mile_standing,model,nm,photo,quarter_mile_standing,top_speed,vehicle_type,year_of_production,zero_to_hundred,user_entity_id)
VALUES ('Audi', 'My daily car', 1800, 'PETROL',180,40,'A4',300,'https://upload.wikimedia.org/wikipedia/commons/3/37/Audia4b6.jpg',15.6,220,'CAR','12.12.2004',7.3,3);

INSERT INTO products (description, name, photo, price, user_entity_id)
VALUES ('first product','Garret T4','https://ae01.alicdn.com/kf/HTB14rlvLFXXXXc_XFXXq6xXFXXXm/8037121-garrett-gt30-turbo-gtx30-turbocharger-garrett-t3-t4-divided-optional-housing-turbo-garrett-turbo-parts.jpg_Q90.jpg_.webp',500,1);

INSERT INTO products (description, name, photo, price, user_entity_id)
VALUES ('second product','Mercedes keychain','https://image.made-in-china.com/318f0j00mEIYgMzfJPcS/video.webp',10,2);

INSERT INTO products (description, name, photo, price, user_entity_id)
VALUES ('Third product','Turbo keychain','https://cdn.shopify.com/s/files/1/0651/6385/4073/products/Sd3977c438aa64d93b435ddad7d591320B_1024x1024.jpg?v=1654469406',10,3);

INSERT INTO events (description, location, name, price, time, user_entity_id)
VALUES ('first event', 'Panair Plovdiv', 'BMW FEST',15,'2022-10-10',1);

INSERT INTO events (description, location, name, price, time, user_entity_id)
VALUES ('second event', 'Kaloyanovo pista drakon', 'Mercedes Meeting',10,'2022-09-10',2);

INSERT INTO events (description, location, name, price, time, user_entity_id)
VALUES ('third event', 'Gazprom mitnica', 'Motorcycle meeting',0,'2022-10-30',3);

INSERT INTO articles (text, user_entity_id, title)
VALUES ('this is my first post',1,'Hello this is my first post here');

INSERT INTO articles (text, user_entity_id, title)
VALUES ('Im glad to be here thank you',2,'Greetings');

INSERT INTO articles (text, user_entity_id, title)
VALUES ('my car wont start what to do',3,'Car issue help');

