-- Create table for users
CREATE TABLE tb_users (
    id BINARY(16) NOT NULL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Insert sample data into users table
INSERT INTO tb_users (id, username, email) VALUES
(UNHEX(REPLACE('11111111-1111-1111-1111-111111111111', '-', '')), 'john_doe', 'john.doe@example.com'),
(UNHEX(REPLACE('22222222-2222-2222-2222-222222222222', '-', '')), 'jane_smith', 'jane.smith@example.com'),
(UNHEX(REPLACE('33333333-3333-3333-3333-333333333333', '-', '')), 'alice_jones', 'alice.jones@example.com');