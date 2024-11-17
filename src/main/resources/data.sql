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
                                                   ('Профессиональные аспекты', 'Квалификация, опыт, компетенции и стандарты работы.'),
                                                   ('Личностные качества', 'Черты характера и личные способности, такие как коммуникабельность и стрессоустойчивость.'),
                                                   ('Психологический климат', 'Эмоциональное и психологическое состояние коллектива, уровень доверия и поддержки.'),
                                                   ('Рабочая среда и культура', 'Физические условия работы и корпоративные нормы, традиции и ценности.'),
                                                   ('Влияние времени', 'Управление временем, приоритизация и организация рабочего процесса.');

INSERT INTO characteristic_company (characteristic_id, company_id, value) VALUES
                                                                              (1, 1, 6),
                                                                              (2, 1, 4),
                                                                              (3, 1, 8),
                                                                              (4, 1, 9),
                                                                              (5, 1, 6);

INSERT INTO question (characteristic_id, question) VALUES
                                                           (1, 'Насколько навыки сотрудника соответствуют требованиям должности?'),
                                                           (1, 'Совпадают ли их карьерные цели с миссией компании?'),
                                                           (2, 'Совпадают ли личные ценности сотрудника с корпоративной культурой?'),
                                                           (2, 'Как человек влияет на коллектив – вдохновляет или создает напряжение?'),
                                                           (3, 'Как человек справляется со стрессом?'),
                                                           (3, 'Как сотрудник вписывается в команду?'),
                                                           (4, 'Совпадают ли ожидания сотрудника и компании относительно графика, удаленной работы или переработок?'),
                                                           (4, 'Предпочитает ли человек быстрый и напряженный ритм или более размеренную обстановку?'),
                                                           (5, 'Насколько сотрудничество будет успешным через год или несколько лет?'),
                                                           (5, 'Подходит ли человек для выполнения срочных задач?');

INSERT INTO card_value (card_id, characteristic_id, value) VALUES
    (1, 1, 4),
    (1, 2, 8),
    (1, 3, 5),
    (1, 4, 6),
    (1, 5, 7),
    (2, 1, 9),
    (2, 2, 7),
    (2, 3, 6),
    (2, 4, 8),
    (2, 5, 9),
    (3, 1, 5),
    (3, 2, 9),
    (3, 3, 10),
    (3, 4, 6),
    (3, 5, 7),
    (4, 1, 7),
    (4, 2, 9),
    (4, 3, 6),
    (4, 4, 8),
    (4, 5, 8),
    (5, 1, 10),
    (5, 2, 8),
    (5, 3, 7),
    (5, 4, 9),
    (5, 5, 8),
    (6, 1, 8),
    (6, 2, 8),
    (6, 3, 9),
    (6, 4, 7),
    (6, 5, 8),
    (7, 1, 7),
    (7, 2, 10),
    (7, 3, 8),
    (7, 4, 9),
    (7, 5, 9),
    (8, 1, 9),
    (8, 2, 7),
    (8, 3, 9),
    (8, 4, 10),
    (8, 5, 9),
    (9, 1, 9),
    (9, 2, 8),
    (9, 3, 9),
    (9, 4, 8),
    (9, 5, 8),
    (10, 1, 6),
    (10, 2, 10),
    (10, 3, 10),
    (10, 4, 6),
    (10, 5, 7),
    (11, 1, 7),
    (11, 2, 6),
    (11, 3, 5),
    (11, 4, 9),
    (11, 5, 7),
    (12, 1, 9),
    (12, 2, 9),
    (12, 3, 8),
    (12, 4, 8),
    (12, 5, 9),
    (13, 1, 6),
    (13, 2, 7),
    (13, 3, 10),
    (13, 4, 7),
    (13, 5, 9),
    (14, 1, 6),
    (14, 2, 6),
    (14, 3, 10),
    (14, 4, 9),
    (14, 5, 10),
    (15, 1, 8),
    (15, 2, 10),
    (15, 3, 9),
    (15, 4, 8),
    (15, 5, 10),
    (16, 1, 5),
    (16, 2, 6),
    (16, 3, 10),
    (16, 4, 7),
    (16, 5, 6),
    (17, 1, 5),
    (17, 2, 5),
    (17, 3, 10),
    (17, 4, 10),
    (17, 5, 5),
    (18, 1, 9),
    (18, 2, 9),
    (18, 3, 8),
    (18, 4, 7),
    (18, 5, 10),
    (19, 1, 6),
    (19, 2, 7),
    (19, 3, 10),
    (19, 4, 8),
    (19, 5, 6),
    (20, 1, 10),
    (20, 2, 10),
    (20, 3, 9),
    (20, 4, 10),
    (20, 5, 10),
    (21, 1, 8),
    (21, 2, 9),
    (21, 3, 8),
    (21, 4, 9),
    (21, 5, 9),
    (22, 1, 10),
    (22, 2, 10),
    (22, 3, 10),
    (22, 4, 10),
    (22, 5, 10);
