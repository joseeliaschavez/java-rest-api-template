-- Test Data generated using mockaroo.com

-- Movies
insert into MOVIE (id, title, release_date, tmdb_id) values (1, 'The Matrix', '1999-03-30', 603);
insert into MOVIE (id, title, release_date, tmdb_id) values (2, 'Total Recall', '1990-06-01', 861);
insert into MOVIE (id, title, release_date, tmdb_id) values (3, 'Johnny Mnemonic', '1995-05-26', 9886);
insert into MOVIE (id, title, release_date, tmdb_id) values (4, 'Blade Runner', '1982-06-25', 78);
insert into MOVIE (id, title, release_date, tmdb_id) values (5, 'Ghost in the Shell', '2017-03-29', 315837);
insert into MOVIE (id, title, release_date, tmdb_id) values (6, 'The Terminator', '1984-10-26', 218);

-- Actors
insert into ACTOR (id, full_name, tmdb_id) values (1, 'Keanu Reeves', 6384);
insert into ACTOR (id, full_name, tmdb_id) values (2, 'Laurence Fishburne', 2975);
insert into ACTOR (id, full_name, tmdb_id) values (3, 'Carrie-Anne Moss', 530);
insert into ACTOR (id, full_name, tmdb_id) values (4, 'Hugo Weaving', 1331);

INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (5, 'Arnold Schwarzenegger', 1100);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (6, 'Rachel Ticotin', 10768);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (7, 'Sharon Stone', 4430);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (8, 'Ronny Cox', 780);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (9, 'Michael Ironside', 11086);

INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (10, 'Dina Meyer', 2133);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (11, 'Takeshi Kitano', 3317);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (12, 'Ice-T', 21411);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (13, 'Dolph Lundgren', 16644);

INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (14, 'Harrison Ford', 3);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (15, 'Rutger Hauer', 585);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (16, 'Sean Young', 586);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (17, 'Edward James Olmos', 587);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (18, 'M. Emmet Walsh', 588);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (19, 'Daryl Hannah', 589);

INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (20, 'Scarlett Johansson', 1245);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (21, 'Michael Pitt', 10692);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (22, 'Pilou Asbæk', 90060);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (23, 'Chin Han', 101015);

INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (24, 'Michael Biehn', 2712);
INSERT INTO ACTOR (id, full_name, tmdb_id) VALUES (25, 'Linda Hamilton', 2713);

-- Cast
insert into MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) values (1, 'Thomas A. Anderson / Neo', 1, 1, '52fe425bc3a36847f80181c1');
insert into MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) values (2, 'Morpheus', 1, 2, '52fe425bc3a36847f801818d');
insert into MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) values (3, 'Trinity', 1, 3, '52fe425bc3a36847f8018191');
insert into MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) values (4, 'Agent Smith', 1, 4, '52fe425bc3a36847f8018195');

INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (5, 'Douglas Quaid / Hauser', 2, 5, '52fe4283c3a36847f8024e9b');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (6, 'Melina', 2, 6, '52fe4283c3a36847f8024ea3');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (7, 'Lori', 2, 7, '52fe4283c3a36847f8024e9f');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (8, 'Vilos Cohaagen', 2, 8, '52fe4283c3a36847f8024ea7');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (9, 'Richter', 2, 9, '52fe4283c3a36847f8024eab');

INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (10, 'Johnny Mnemonic', 3, 1, '52fe4541c3a36847f80c3d27');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (11, 'Jane', 3, 10, '52fe4541c3a36847f80c3d2b');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (12, 'Takahashi', 3, 11, '52fe4541c3a36847f80c3d2f');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (13, 'J-Bone', 3, 12, '52fe4541c3a36847f80c3d33');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (14, 'Street Preacher', 3, 13, '52fe4541c3a36847f80c3d3b');

INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (15, 'Rick Deckard', 4, 14, '52fe4214c3a36847f800259f');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (16, 'Roy Batty', 4, 15, '52fe4214c3a36847f80025a3');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (17, 'Rachael', 4, 16, '52fe4214c3a36847f80025a7');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (18, 'Gaff', 4, 17, '52fe4214c3a36847f80025ab');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (19, 'Bryant', 4, 18, '5402bd1bc3a3684360004649');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (20, 'Pris', 4, 19, '52fe4214c3a36847f80025b3');

INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (21, 'Major Mira Killian / Motoko Kusanagi', 5, 20, '54db4267c3a3681237001701');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (22, 'Chief Daisuke Aramaki', 5, 11, '56da2456c3a3680c8900016d');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (23, 'Kuze / Hideo', 5, 21, '56c331179251414a860027ce');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (24, 'Batou', 5, 22, '56c331059251414a0e001a04');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (25, 'Togusa', 5, 23, '57bec5a6c3a36838d9003a15');

INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (26, 'The Terminator', 6, 5, '52fe4228c3a36847f8008581');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (27, 'Kyle Reese', 6, 24, '52fe4228c3a36847f800851f');
INSERT INTO MOVIE_CAST (id, character_name, movie_id, actor_id, tmdb_credit_id) VALUES (28, 'Sarah Connor', 6, 25, '52fe4228c3a36847f8008523');
