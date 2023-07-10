-- Test Data generated using mockaroo.com

-- Markets
INSERT INTO MARKET (id, name) VALUES (1, 'Seattle');
INSERT INTO MARKET (id, name) VALUES (2, 'Chicago');
INSERT INTO MARKET (id, name) VALUES (3, 'Boston');
INSERT INTO MARKET (id, name) VALUES (4, 'Houston');
INSERT INTO MARKET (id, name) VALUES (5, 'Charlotte');

-- Clients
INSERT INTO CLIENT (id, name, industry) VALUES (1, 'Yodo', 'HEALTHCARE');
INSERT INTO CLIENT (id, name, industry) VALUES (2, 'Twimm', 'RETAIL');
INSERT INTO CLIENT (id, name, industry) VALUES (3, 'Jetpulse', 'RETAIL');
INSERT INTO CLIENT (id, name, industry) VALUES (4, 'Mudo', 'MANUFACTURING');
INSERT INTO CLIENT (id, name, industry) VALUES (5, 'Centidel', 'ENERGY');
INSERT INTO CLIENT (id, name, industry) VALUES (6, 'Aimbu', 'FINANCE');
INSERT INTO CLIENT (id, name, industry) VALUES (7, 'Bubblemix', 'TECHNOLOGY');
INSERT INTO CLIENT (id, name, industry) VALUES (8, 'Youopia', 'ENERGY');
INSERT INTO CLIENT (id, name, industry) VALUES (9, 'Dazzlesphere', 'RETAIL');
INSERT INTO CLIENT (id, name, industry) VALUES (10, 'Eadel', 'MANUFACTURING');
INSERT INTO CLIENT (id, name, industry) VALUES (11, 'Ooba', 'ENERGY');
INSERT INTO CLIENT (id, name, industry) VALUES (12, 'Yodoo', 'FINANCE');
INSERT INTO CLIENT (id, name, industry) VALUES (13, 'Ozu', 'FINANCE');
INSERT INTO CLIENT (id, name, industry) VALUES (14, 'Skyba', 'FINANCE');
INSERT INTO CLIENT (id, name, industry) VALUES (15, 'Voonder', 'MANUFACTURING');
INSERT INTO CLIENT (id, name, industry) VALUES (16, 'Buzzster', 'FINANCE');

-- Projects
INSERT INTO PROJECT (id, name, start_date, end_date, client_id, market_id) VALUES (1, 'Cross-platform transitional core', '2023-03-02', '2023-10-03', 7, 1);
INSERT INTO PROJECT (id, name, start_date, end_date, client_id, market_id) VALUES (2, 'Implemented foreground infrastructure', '2023-12-01', '2024-05-15', 5, 4);
INSERT INTO PROJECT (id, name, start_date, end_date, client_id, market_id) VALUES (3, 'Balanced attitude-oriented challenge', '2023-03-27', '2023-10-23', 1, 2);
INSERT INTO PROJECT (id, name, start_date, end_date, client_id, market_id) VALUES (4, 'Integrated directional paradigm', '2023-09-01', '2024-02-16', 6, 3);
INSERT INTO PROJECT (id, name, start_date, end_date, client_id, market_id) VALUES (5, 'Streamlined hybrid infrastructure', '2023-04-20', '2023-11-03', 2, 5);

-- Consultants
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (1, 'Allard', 'Leser', 'SOLUTION_OWNERSHIP', 1);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (2, 'Ermin', 'Hearns', 'DATA_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (3, 'Ozzy', 'Basant', 'QUALITY_ENGINEERING', 3);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (4, 'Deeanne', 'Kynston', 'QUALITY_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (5, 'Jaynell', 'Bosence', 'EXPERIENCE_DESIGN', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (6, 'Billy', 'Laxen', 'DATA_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (7, 'Palmer', 'Gogay', 'QUALITY_ENGINEERING', 1);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (8, 'Aleen', 'Crosbie', 'PLATFORM_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (9, 'Simon', 'Mathewson', 'DATA_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (10, 'Perle', 'Fidgin', 'SOFTWARE_ENGINEERING', 1);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (11, 'Will', 'McMeanma', 'QUALITY_ENGINEERING', 3);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (12, 'Filippa', 'Le Frank', 'QUALITY_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (13, 'Veradis', 'Esposito', 'PLATFORM_ENGINEERING', 5);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (14, 'Lenna', 'Redman', 'PLATFORM_ENGINEERING', 1);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (15, 'Clint', 'Tures', 'QUALITY_ENGINEERING', 1);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (16, 'Berti', 'Beevor', 'EXPERIENCE_DESIGN', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (17, 'Luci', 'Gunter', 'PLATFORM_ENGINEERING', 3);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (18, 'Raymond', 'Reynoollds', 'PLATFORM_ENGINEERING', 4);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (19, 'Ellis', 'Ortells', 'QUALITY_ENGINEERING', 1);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (20, 'Annie', 'Castella', 'DATA_ENGINEERING', 5);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (21, 'Brear', 'Bonfield', 'EXPERIENCE_DESIGN', 1);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (22, 'Merrick', 'Keogh', 'EXPERIENCE_DESIGN', 1);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (23, 'Bonnibelle', 'Exposito', 'PLATFORM_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (24, 'Celestia', 'Story', 'DATA_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (25, 'Zelda', 'Clows', 'DATA_ENGINEERING', 5);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (26, 'Bastian', 'Lawden', 'EXPERIENCE_DESIGN', 4);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (27, 'Skipper', 'Lahy', 'EXPERIENCE_DESIGN', 3);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (28, 'Geri', 'Le Page', 'SOFTWARE_ENGINEERING', 4);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (29, 'Teodor', 'Tewkesberry', 'SOFTWARE_ENGINEERING', 5);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (30, 'Shepherd', 'Grigorini', 'DATA_ENGINEERING', 5);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (31, 'Sarge', 'Moehle', 'EXPERIENCE_DESIGN', 5);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (32, 'Giselle', 'Maine', 'DATA_ENGINEERING', 3);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (33, 'Gilemette', 'Marzello', 'EXPERIENCE_DESIGN', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (34, 'Darlleen', 'Basant', 'DATA_ENGINEERING', 5);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (35, 'Peirce', 'Scawn', 'EXPERIENCE_DESIGN', 1);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (36, 'Cyndy', 'McHarry', 'SOFTWARE_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (37, 'Patrice', 'Yashin', 'QUALITY_ENGINEERING', 1);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (38, 'Jeanne', 'Macknish', 'SOFTWARE_ENGINEERING', 4);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (39, 'Melodie', 'Feary', 'EXPERIENCE_DESIGN', 3);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (40, 'Delphinia', 'Kintzel', 'QUALITY_ENGINEERING', 3);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (41, 'Eddi', 'Jirasek', 'SOFTWARE_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (42, 'Lannie', 'Pittle', 'SOFTWARE_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (43, 'Inesita', 'Worvell', 'DATA_ENGINEERING', 4);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (44, 'Winnie', 'Brenstuhl', 'EXPERIENCE_DESIGN', 1);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (45, 'Rabi', 'Fishbourne', 'EXPERIENCE_DESIGN', 3);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (46, 'Tore', 'Huc', 'DATA_ENGINEERING', 2);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (47, 'Lorenzo', 'Elverston', 'SOFTWARE_ENGINEERING', 3);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (48, 'Siffre', 'Arnolds', 'EXPERIENCE_DESIGN', 3);
insert into CONSULTANT (id, first_name, last_name, capability, project_id) values (49, 'Eveline', 'Cunde', 'EXPERIENCE_DESIGN', 5);
