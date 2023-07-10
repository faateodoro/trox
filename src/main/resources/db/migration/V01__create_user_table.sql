CREATE TABLE user(
    id VARCHAR(36) NOT NULL,
    username VARCHAR (50) NOT NULL,
    password VARCHAR(150) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(150) NOT NULL,
    active TINYINT(1) DEFAULT 1,
    created_at DATETIME NOT NULL,
    PRIMARY KEY (id)
);
