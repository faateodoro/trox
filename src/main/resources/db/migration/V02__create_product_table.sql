CREATE TABLE product(
    id VARCHAR(36) NOT NULL,
    title VARCHAR (150) NOT NULL,
    description TEXT NOT NULL,
    category VARCHAR(150) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    user_id VARCHAR(36) NOT NULL,
    created_at DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES user(id)
        ON DELETE CASCADE
);
