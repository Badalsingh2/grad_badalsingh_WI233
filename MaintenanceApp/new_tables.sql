
drop table admin_table;
drop table site;
drop table site_owner;

-- Owners table
CREATE TABLE owners (
    owner_id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(15),
    email VARCHAR(100)
);

-- Sites table
CREATE TABLE sites (
    site_id SERIAL PRIMARY KEY,
    owner_id INT REFERENCES owners(owner_id),
    site_type VARCHAR(50),
    length INT,
    breadth INT,
    status VARCHAR(20),
    approved BOOLEAN DEFAULT TRUE
);


-- Maintenance
CREATE TABLE payments (
    payment_id SERIAL PRIMARY KEY,
    site_id INT REFERENCES sites(site_id),
    amount DOUBLE PRECISION,
    paid_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    pending BOOLEAN DEFAULT TRUE
);


-- update_req
CREATE TABLE update_requests (
    request_id SERIAL PRIMARY KEY,
    site_id INT REFERENCES sites(site_id),
    new_status VARCHAR(20),
    approved BOOLEAN DEFAULT FALSE
);

