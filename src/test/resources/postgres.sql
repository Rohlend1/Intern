-- Insert queries
-- Insert actors
INSERT INTO actor (first_name, last_name, gender, country, birth_date, age)
VALUES ('Paul', 'Walker', 0, 'USA', CURRENT_DATE, 40),
       ('Jim', 'Carry', 0, 'USA', CURRENT_DATE, 58),
       ('Megan', 'Fox', 1, 'China', CURRENT_DATE, 33),
       ('Steven', 'Rogers', 0, 'Canada', CURRENT_DATE, 35),
       ('Keanu', 'Reeves', 0, 'Russia', CURRENT_DATE, 48);

-- Insert users
INSERT INTO users (username) VALUES ('Ark'), ('Smile'), ('Frog'), ('Axe'), ('Punisher!');

-- Insert subscribes
INSERT INTO subscribe (subscriber, subscribedto) VALUES (1, 2), (3, 4), (1, 5);

-- Insert reviews
INSERT INTO review (content, created_at, updated_at, owner) VALUES
    ('Super', '2018-01-01 01:15:00', NULL, 1),
    ('It was so boring', '2017-06-04 21:11:00', CURRENT_TIMESTAMP, 1),
    ('Worst movie I''ve ever seen', '2019-02-24 18:47:00', NULL, 3),
    ('Yeah, it was amazing', '2016-08-16 13:09:00', CURRENT_TIMESTAMP, 5);

-- Insert comments
INSERT INTO comment (description, created_at, updated_at, owner , review, reply_to) VALUES
('Wow', '2023-01-01 01:15:00', NULL, 1, 1, NULL),
('Awesome', '2021-12-27 14:38:00', CURRENT_TIMESTAMP, 1, 1, NULL),
('So bad', '2020-11-17 18:59:00', CURRENT_TIMESTAMP, 4, 1, NULL),
('Disgusting', '2020-09-21 01:15:00', CURRENT_TIMESTAMP, 2, 2,NULL),
('Great', '2021-10-19 23:47:00', CURRENT_TIMESTAMP, 4, 3, NULL),
('Terrible', '2022-07-10 17:23:00', CURRENT_TIMESTAMP, 3, 4, NULL),
('Agree', '2023-04-28 12:20:00', NULL, 3, 1, 1),
('I''m not advise this', '2023-04-28 08:25:00', '2023-04-30 12:20:00', 1, 2, 2),
('Of course -_-', '2023-03-16 11:40:00', '2023-05-10 02:58:00', 4, 1, 1),
('Yeah, u re right', '2022-04-28 12:20:00', '2023-01-28 12:20:00', 5, 1, 1),
('I give it an 8 out of 10', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2, 1, 3),
('Сomplete stupidity', '2023-04-28 12:20:00', NULL, 2, 2, 4),
('It''s a masterpiece', '2023-06-12 14:14:00', NULL, 3, 3, 5),
('The truth', CURRENT_TIMESTAMP, NULL, 3, 4, 6);


-- Insert film companies
INSERT INTO film_company (name, date_of_foundation) VALUES
    ('WB', '1960-04-15'),
    ('21 Century', '1899-12-25'),
    ('Blumhouse', '1999-01-30');

-- Insert movies
INSERT INTO movie (title, date_of_release, film_company, duration, box_office) VALUES
    ('Fast and furious', '1980-12-20', 1, 120,2000000),
    ('The mask', '2007-10-12', 2, 105, 35000000),
    ('Captain America', '2013-07-08', 3, 110, 400000000),
    ('MOCK1', CURRENT_DATE, 1, 110, 400000000),
    ('MOCK2', CURRENT_DATE, 2, 110, 400000000);

-- Insert genres
INSERT INTO genre (name) VALUES ('Action'), ('Romance'), ('Drama'), ('Horror');

INSERT INTO actor_movie (actor_id, movie_id) VALUES
   (1, 1), (2, 1), (3, 1),
   (2, 2), (3, 2), (4, 2), (5, 2),
   (1, 3), (2, 3), (3, 3), (4, 3), (5, 3),
   (1, 4),
   (1, 5);

-- Insert genre-movie relationships
INSERT INTO movie_genre (genre_id, movie_id) VALUES
   (1, 1), (1, 2),
   (2, 1), (2, 2), (2, 3),
   (3, 2), (3, 3),
   (4, 1), (4, 3);



