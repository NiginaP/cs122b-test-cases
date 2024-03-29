DELETE FROM session_status WHERE status_id > 0;
DELETE FROM privilege_level WHERE plevel > 0;
DELETE FROM user_status WHERE status_id > 0;

DELETE FROM user WHERE status > 0;
DELETE FROM session WHERE status > 0;

INSERT INTO session_status (status_id, status) 
VALUES 
	(1, 'ACTIVE'),
	(2, 'CLOSED'),
	(3, 'EXPIRED'),
	(4, 'REVOKED');

INSERT INTO privilege_level (plevel, pname) 
VALUES 
	(1, 'ROOT'),
	(2, 'ADMIN'),
	(3, 'EMPLOYEE'),
	(4, 'SERVICE'),
	(5, 'USER');

INSERT INTO user_status (status_id, status) 
VALUES 
	(1, 'ACTIVE'),
	(2, 'CLOSED'),
	(3, 'LOCKED'),
	(4, 'REVOKED');
    
INSERT INTO user (email, status, plevel, salt, pword)
VALUES
	('AlreadyInUse@uci.edu', 1, 5, 'f2a6f4e7', '4a7a582e436fa93a38f77fdf6e2c0b404bcc720ee5adfda8b4624dd33dbfae97c2e9e58ade9786cb612bb9363a89094ba92325e8357638ce35466adff14fb40a'),
	('ActiveSession@uci.edu', 1, 5, 'f2a6f4e7', '4a7a582e436fa93a38f77fdf6e2c0b404bcc720ee5adfda8b4624dd33dbfae97c2e9e58ade9786cb612bb9363a89094ba92325e8357638ce35466adff14fb40a'),
	('ExpiredSession@uci.edu', 1, 5, 'f2a6f4e7', '4a7a582e436fa93a38f77fdf6e2c0b404bcc720ee5adfda8b4624dd33dbfae97c2e9e58ade9786cb612bb9363a89094ba92325e8357638ce35466adff14fb40a'),
	('ClosedSession@uci.edu', 1, 5, 'f2a6f4e7', '4a7a582e436fa93a38f77fdf6e2c0b404bcc720ee5adfda8b4624dd33dbfae97c2e9e58ade9786cb612bb9363a89094ba92325e8357638ce35466adff14fb40a'),
	('RevokedSession@uci.edu', 1, 5, 'f2a6f4e7', '4a7a582e436fa93a38f77fdf6e2c0b404bcc720ee5adfda8b4624dd33dbfae97c2e9e58ade9786cb612bb9363a89094ba92325e8357638ce35466adff14fb40a'),
	('NotFoundSession@uci.edu', 1, 5, 'f2a6f4e7', '4a7a582e436fa93a38f77fdf6e2c0b404bcc720ee5adfda8b4624dd33dbfae97c2e9e58ade9786cb612bb9363a89094ba92325e8357638ce35466adff14fb40a'),
	('UserLevel@uci.edu', 1, 5, 'f2a6f4e7', '4a7a582e436fa93a38f77fdf6e2c0b404bcc720ee5adfda8b4624dd33dbfae97c2e9e58ade9786cb612bb9363a89094ba92325e8357638ce35466adff14fb40a'),
	('ServiceLevel@uci.edu', 1, 4, 'f2a6f4e7', '4a7a582e436fa93a38f77fdf6e2c0b404bcc720ee5adfda8b4624dd33dbfae97c2e9e58ade9786cb612bb9363a89094ba92325e8357638ce35466adff14fb40a'),
	('EmployeeLevel@uci.edu', 1, 3, 'f2a6f4e7', '4a7a582e436fa93a38f77fdf6e2c0b404bcc720ee5adfda8b4624dd33dbfae97c2e9e58ade9786cb612bb9363a89094ba92325e8357638ce35466adff14fb40a'),
	('AdminLevel@uci.edu', 1, 2, 'f2a6f4e7', '4a7a582e436fa93a38f77fdf6e2c0b404bcc720ee5adfda8b4624dd33dbfae97c2e9e58ade9786cb612bb9363a89094ba92325e8357638ce35466adff14fb40a');
    
INSERT INTO session (session_id, email, status, time_created, last_used, expr_time)
VALUES 
('15b99dfdec7e615846abe541b535ab7fb5af17f263e577dfeb4ebd4618d043e9161f3f753afb972a12d775d31568010a77be008b883084b3afa663b11d1cf2cc','ActiveSession@uci.edu',1, CURRENT_TIME(), CURRENT_TIME(), DATE_ADD(CURRENT_TIME(), INTERVAL 1 HOUR)),
('cdf061488306a2f2e3d97260564eaa3be5a17defc514a690a9b41b4fa7335757b66c4da6e4bdd6570cc77033dd887ab62ca53cea452247461dedca35737c126f','ExpiredSession@uci.edu',3, CURRENT_TIME(), CURRENT_TIME(), DATE_ADD(CURRENT_TIME(), INTERVAL 1 HOUR)),
('8a5c59cceac13d6d8a4ea43e0178aedf9dbec9cb86a0d7b3b4bf7fd3d0780b501b801bab816a7edc45cc06cb0f57b6a933eace485350db9e7a4f4b5d8eda2ffb','ClosedSession@uci.edu',2, CURRENT_TIME(), CURRENT_TIME(), DATE_ADD(CURRENT_TIME(), INTERVAL 1 HOUR)),
('15b99dfdec7e615846abe541b535ab7fb5af17f263e577dfeb4ebd4618d043e9161f3f753afb972a12d775d31568010a77be008b883084b3afa663b11d1cf2c4','RevokedSession@uci.edu',4, CURRENT_TIME(), CURRENT_TIME(), DATE_ADD(CURRENT_TIME(), INTERVAL 1 HOUR)),
('fe6fbf756c921e93bb11ec2ec4b55e5a81425addaf060554fd94dd4675fd7a8df01e27cd9479042142eaac6129aad8fe98083100de3fddfd7c052f32b0c7295a','NotFoundSession@uci.edu',4, CURRENT_TIME(), CURRENT_TIME(), DATE_ADD(CURRENT_TIME(), INTERVAL 1 HOUR));