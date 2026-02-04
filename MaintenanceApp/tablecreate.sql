CREATE TABLE site (
    site_number INT PRIMARY KEY,
    length INT NOT NULL,
    breadth INT NOT NULL,
    site_type VARCHAR(30) NOT NULL,
    occupancy_status VARCHAR(30) NOT NULL
);


drop table site;


CREATE TABLE site_owner (
    owner_id VARCHAR(50) PRIMARY KEY,

    owner_name VARCHAR(100) NOT NULL,

    phone_number BIGINT NOT NULL UNIQUE,

    email VARCHAR(100) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL,

    site_number INT UNIQUE,

    CONSTRAINT fk_site_owner_site
        FOREIGN KEY (site_number)
        REFERENCES site(site_number)
        ON DELETE SET NULL
);

drop table if exists admin_table;
create table admin_table(
	admin_id VARCHAR(50) PRIMARY KEY,

    admin_name VARCHAR(100) NOT NULL,

    

    email VARCHAR(100) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL
);

