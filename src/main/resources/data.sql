create database portfolio_manager;

use portfolio_manager;

-- Asset Table
CREATE TABLE assets (
    symbol VARCHAR(12) PRIMARY KEY,
    asset_type CHAR(3) NOT NULL CHECK (asset_type IN ('EQ', 'ETF', 'MF')),
    asset_name VARCHAR(100) NOT NULL,
    closing_price DECIMAL(12,4) NOT NULL
);

-- Fund Manager Table
CREATE TABLE fund_manager (
    fund_manager_id INT PRIMARY KEY AUTO_INCREMENT,
    fm_name VARCHAR(100) NOT NULL,
    current_balance DECIMAL(12,4) NOT NULL,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

-- Fund Balance History Table
CREATE TABLE fund_balance_history (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fund_manager_id INT NOT NULL,
    balance_date DATE NOT NULL,
    balance DECIMAL(12,4) NOT NULL
);

-- Trade Book Table
CREATE TABLE trade_book (
    trade_id INT PRIMARY KEY AUTO_INCREMENT,
    asset_id VARCHAR(12) NOT NULL,
    asset_price DECIMAL(12,4) NOT NULL,
    quantity INT NOT NULL,
    trade_amount DECIMAL(12,4) NOT NULL,
    buy_sell CHAR(1) NOT NULL CHECK (buy_sell IN ('B', 'S')),
    tran_time DATETIME,
    fund_manager_id INT NOT NULL,
    tran_status CHAR(1) NOT NULL CHECK (tran_status IN ('I', 'A', 'C'))
);

-- Funds (Fund Transaction) Table
CREATE TABLE fund_tran (
    rec_id INT PRIMARY KEY AUTO_INCREMENT,
    tran_type CHAR(1) NOT NULL CHECK (tran_type IN ('d', 'c')),
    amount DECIMAL(12,4),
    tran_time DATETIME NOT NULL,
    fund_manager_id INT NOT NULL,
    fund_acc_balance DECIMAL(12,4) NOT NULL,
    bank_acc_no VARCHAR(50)
);

-- Insert Dummy Data

-- Dummy Data for `assets`
INSERT INTO assets (symbol, asset_type, asset_name, closing_price) VALUES
('AAPL', 'EQ', 'Apple Inc.', 174.53),
('GOOGL', 'EQ', 'Alphabet Inc.', 2834.00),
('TSLA', 'EQ', 'Tesla Inc.', 669.09),
('SPY', 'ETF', 'SPDR S&P 500 ETF Trust', 444.67),
('VFIAX', 'MF', 'Vanguard 500 Index Fund', 407.50);

-- Dummy Data for `fund_manager`
INSERT INTO fund_manager (fm_name, current_balance, last_updated) VALUES
('John Doe', 100000.00, '2024-08-09 12:00:00'),
('Jane Smith', 150000.00, '2024-08-09 12:00:00'),
('Alice Johnson', 200000.00, '2024-08-09 12:00:00'),
('Bob Brown', 250000.00, '2024-08-09 12:00:00');

-- Dummy Data for `fund_balance_history`
INSERT INTO fund_balance_history (fund_manager_id, balance_date, balance) VALUES
(1, '2024-08-01', 100000.00),
(1, '2024-08-02', 95000.00),
(2, '2024-08-01', 150000.00),
(2, '2024-08-02', 155000.00),
(3, '2024-08-01', 200000.00),
(3, '2024-08-02', 198000.00),
(4, '2024-08-01', 250000.00),
(4, '2024-08-02', 240000.00);

-- Dummy Data for `trade_book`
INSERT INTO trade_book (asset_id, asset_price, quantity, trade_amount, buy_sell, tran_time, fund_manager_id, tran_status) VALUES
('AAPL', 174.53, 50, 8726.50, 'B', '2024-08-09 10:00:00', 1, 'A'),
('GOOGL', 2834.00, 10, 28340.00, 'S', '2024-08-09 11:00:00', 2, 'I'),
('TSLA', 669.09, 15, 10036.35, 'B', '2024-08-09 12:00:00', 3, 'C'),
('SPY', 444.67, 25, 11116.75, 'B', '2024-08-09 13:00:00', 4, 'A'),
('VFIAX', 407.50, 20, 8150.00, 'S', '2024-08-09 14:00:00', 1, 'I');

-- Dummy Data for `fund_tran`
INSERT INTO fund_tran (tran_type, amount, tran_time, fund_manager_id, fund_acc_balance, bank_acc_no) VALUES
('d', 5000.00, '2024-08-09 09:00:00', 1, 95000.00, '1234567890'),
('c', 10000.00, '2024-08-09 10:00:00', 2, 155000.00, '0987654321'),
('d', 2000.00, '2024-08-09 11:00:00', 3, 198000.00, '1122334455'),
('c', 5000.00, '2024-08-09 12:00:00', 4, 240000.00, '6677889900');