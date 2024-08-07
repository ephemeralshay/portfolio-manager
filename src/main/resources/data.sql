create database portfolio_manager;

use portfolio_manager;

-- Create fund_manager table
CREATE TABLE fund_manager (
    fund_manager_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fm_name VARCHAR(100) NOT NULL,
    current_balance DECIMAL(12,4),
    datetime DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Create assets table
CREATE TABLE assets (
    symbol VARCHAR(255) PRIMARY KEY, -- Adjusted length to accommodate larger values if needed
    asset_type CHAR(3) NOT NULL CHECK (asset_type IN ('EQ', 'ETF', 'MF')),
    asset_name VARCHAR(100) NOT NULL,
    closing_price DECIMAL(12,4) NOT NULL
);

-- Create fund_balance_history table
CREATE TABLE fund_balance_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fund_manager_id BIGINT,
    balance_date DATE,
    balance DECIMAL(12,4),
    FOREIGN KEY (fund_manager_id) REFERENCES fund_manager(fund_manager_id)
);

-- Create funds table
CREATE TABLE funds (
    rec_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tran_type CHAR(1) NOT NULL CHECK (tran_type IN ('d', 'c')),
    amount DECIMAL(12,4) NOT NULL,
    tran_time DATETIME NOT NULL,
    fund_manager_id BIGINT,
    fund_acc_balance DECIMAL(12,4),
    bank_acc_no VARCHAR(50),
    FOREIGN KEY (fund_manager_id) REFERENCES fund_manager(fund_manager_id)
);

-- Create trade_book table
CREATE TABLE trade_book (
    trade_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    asset_id VARCHAR(255) NOT NULL, -- Updated to VARCHAR(255)
    asset_price DECIMAL(12,4) NOT NULL,
    quantity INT NOT NULL,
    trade_amount DECIMAL(12,4) GENERATED ALWAYS AS (asset_price * quantity) STORED,
    buy_sell CHAR(1) NOT NULL CHECK (buy_sell IN ('B', 'S')),
    tran_time DATETIME NOT NULL,
    fund_manager_id BIGINT,
    tran_status CHAR(1) NOT NULL CHECK (tran_status IN ('I', 'A', 'C')),
    FOREIGN KEY (asset_id) REFERENCES assets(symbol),
    FOREIGN KEY (fund_manager_id) REFERENCES fund_manager(fund_manager_id)
);

-- Insert dummy data for assets
INSERT INTO assets (symbol, asset_type, asset_name, closing_price) VALUES
('AAPL', 'EQ', 'Apple Inc.', 150.00),
('GOOGL', 'EQ', 'Alphabet Inc.', 2800.00),
('MSFT', 'EQ', 'Microsoft Corp.', 300.00),
('SPY', 'ETF', 'SPDR S&P 500 ETF', 400.00),
('VFIAX', 'MF', 'Vanguard 500 Index Fund', 200.00);

-- Insert dummy data for fund_manager
INSERT INTO fund_manager (fm_name, current_balance) VALUES
('John Doe', 100000.00),
('Jane Smith', 150000.00);

-- Insert dummy data for fund_balance_history
INSERT INTO fund_balance_history (fund_manager_id, balance_date, balance) VALUES
(1, '2024-01-01', 100000.00),
(2, '2024-01-01', 150000.00);

-- Insert dummy data for trade_book
INSERT INTO trade_book (asset_id, asset_price, quantity, buy_sell, tran_time, fund_manager_id, tran_status) VALUES
('AAPL', 150.00, 10, 'B', '2024-07-01 10:00:00', 1, 'A'),
('GOOGL', 2800.00, 5, 'S', '2024-07-02 11:00:00', 2, 'A');

-- Insert dummy data for funds
INSERT INTO funds (tran_type, amount, tran_time, fund_manager_id, fund_acc_balance, bank_acc_no) VALUES
('c', 50000.00, '2024-07-01 10:00:00', 1, 50000.00, '1234567890'),
('d', 10000.00, '2024-07-02 11:00:00', 2, 10000.00, '0987654321');
