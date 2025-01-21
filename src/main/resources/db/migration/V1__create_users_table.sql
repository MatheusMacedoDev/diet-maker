CREATE TABLE users (
    user_id UUID PRIMARY KEY,
    user_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    password_hash BYTEA NOT NULL,
    password_salt BYTEA NOT NULL,
    birth_date DATE NOT NULL,
    gender NUMERIC(1, 0) NOT NULL,
    height_cm NUMERIC(4,1) NOT NULL,
    weight_kg NUMERIC(4,1) NOT NULL,
    basal_metabolic_rate SMALLINT NOT NULL,
    activity_level_coefficient NUMERIC(2, 1) NOT NULL
);
