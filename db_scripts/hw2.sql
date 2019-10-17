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
	('hehehe@uci.edu', 1, 5, 'f2a6f4e7', '4a7a582e436fa93a38f77fdf6e2c0b404bcc720ee5adfda8b4624dd33dbfae97c2e9e58ade9786cb612bb9363a89094ba92325e8357638ce35466adff14fb40a');