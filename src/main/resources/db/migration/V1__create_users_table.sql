CREATE TABLE users (
    user_id UUID PRIMARY KEY,
    user_name VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    password_hash BYTEA NOT NULL,
    password_salt BYTEA NOT NULL,
    weight NUMERIC(6,3) NOT NULL,
    basal_metabolic_rate SMALLINT NOT NULL,
    activity_level_coefficient NUMERIC(3, 2) NOT NULL
);
