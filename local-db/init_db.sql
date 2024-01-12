-- user

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE,
    address TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT (UTC_TIMESTAMP)
);

-- category

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT (UTC_TIMESTAMP)
);

INSERT INTO
    `category`
VALUES
    (NULL, 'Electronics', TRUE, UTC_TIMESTAMP()),
    (NULL, 'Furniture', TRUE, UTC_TIMESTAMP()),
    (NULL, 'Clothing', TRUE, UTC_TIMESTAMP()),
    (NULL, 'Books', TRUE, UTC_TIMESTAMP());


-- item

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
     id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(30) NOT NULL UNIQUE,
     active BOOLEAN NOT NULL DEFAULT TRUE,
     price DECIMAL(10,2) NOT NULL,
     description TEXT NOT NULL,
     category_id INT UNSIGNED NOT NULL,
     FOREIGN KEY (category_id) REFERENCES category(id),
     created_at TIMESTAMP NOT NULL DEFAULT (UTC_TIMESTAMP)
);


INSERT INTO
    `item`
VALUES
    (NULL, 'iPhone', TRUE, 1000.00, 'A great phone', 1, UTC_TIMESTAMP()),
    (NULL, 'Sofa', TRUE, 500.00, 'A great sofa', 2, UTC_TIMESTAMP()),
    (NULL, 'Shirt', TRUE, 20.00, 'A great shirt', 3, UTC_TIMESTAMP()),
    (NULL, 'Book', TRUE, 10.00, 'A great book', 4, UTC_TIMESTAMP()),
    (NULL, 'TV', TRUE, 200.00, 'A great TV', 1, UTC_TIMESTAMP()),
    (NULL, 'Chair', TRUE, 50.00, 'A great chair', 2, UTC_TIMESTAMP()),
    (NULL, 'Pants', TRUE, 30.00, 'A great pants', 3, UTC_TIMESTAMP()),
    (NULL, 'Shoes', TRUE, 40.00, 'A great shoes', 3, UTC_TIMESTAMP()),
    (NULL, 'Watch', TRUE, 60.00, 'A great watch', 1, UTC_TIMESTAMP()),
    (NULL, 'Laptop', TRUE, 150.00, 'A great laptop', 1, UTC_TIMESTAMP()),
    (NULL, 'Table', TRUE, 80.00, 'A great table', 2, UTC_TIMESTAMP());



-- order

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNSIGNED NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT (UTC_TIMESTAMP),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

-- order_item

DROP TABLE IF EXISTS `order_item`;

CREATE TABLE `order_item` (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_id INT UNSIGNED NOT NULL,
    item_id INT UNSIGNED NOT NULL,
    quantity INT UNSIGNED NOT NULL,
    FOREIGN KEY (item_id) REFERENCES item(id),
    FOREIGN KEY (order_id) REFERENCES `order`(id)
);
