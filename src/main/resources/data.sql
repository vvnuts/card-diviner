INSERT INTO company (name, phone, email, address)
VALUES
    ('Сбербанк', '+7 (800) 555-55-50', 'info@sberbank.ru', 'Москва, ул. Вавилова, 19');

INSERT INTO company (name, phone, email, address)
VALUES
    ('Тинькофф', '+7 (800) 100-10-10', 'support@tinkoff.ru', 'Москва, ул. Покровка, 47');

INSERT INTO company (name, phone, email, address)
VALUES
    ('МТС', '+7 (800) 250-88-88', 'info@mts.ru', 'Москва, ул. Льва Толстого, 16');

INSERT INTO company (name, phone, email, address)
VALUES
    ('Билайн', '+7 (800) 700-80-00', 'support@beeline.ru', 'Москва, ул. Спиридоновка, 29');

INSERT INTO company (name, phone, email, address)
VALUES
    ('Моторолла', '+1 (800) 331-6450', 'support@motorola.com', 'США, Чикаго, 222 W Merchandise Mart Plaza');

INSERT INTO role (name) VALUES ('HR');
INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('EMPLOYEE');

INSERT INTO users (name, phone) VALUES ('John Doe', '123-456-7890');
INSERT INTO users (name, phone) VALUES ('Jane Smith', '987-654-3210');
INSERT INTO users (name, phone) VALUES ('Alice Johnson', '555-123-4567');
INSERT INTO users (name, phone) VALUES ('Bob Brown', '555-765-4321');

INSERT INTO user_with_role (user_id, role_id) VALUES (1, 1);  -- John Doe - HR
INSERT INTO user_with_role (user_id, role_id) VALUES (2, 2);  -- Jane Smith - ADMIN
INSERT INTO user_with_role (user_id, role_id) VALUES (4, 2);  -- Bob Brown - ADMIN
INSERT INTO user_with_role (user_id, role_id) VALUES (3, 3);  -- Alice Johnson - EMPLOYEE

INSERT INTO characteristic (name, description) VALUES
                                                   ('Целеполагание', 'Способность ставить и достигать цели'),
                                                   ('Стремление к обучению', 'Желание развиваться и осваивать новые знания'),
                                                   ('Командная работа', 'Умение работать в коллективе и поддерживать коллег'),
                                                   ('Ответственность', 'Готовность брать на себя ответственность за результаты'),
                                                   ('Креативность', 'Способность генерировать новые идеи и подходы');