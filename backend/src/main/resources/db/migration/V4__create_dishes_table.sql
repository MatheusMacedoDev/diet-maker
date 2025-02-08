CREATE TABLE dishes (
    dish_id SMALLSERIAL PRIMARY KEY,
    dish_name VARCHAR NOT NULL,
    dish_carbohydrates NUMERIC(6,1) NOT NULL,
    dish_protein NUMERIC(6,1) NOT NULL,
    dish_lipids NUMERIC(6,1) NOT NULL,
    dish_fibers NUMERIC(6,1) NOT NULL,
    dish_kcal NUMERIC(7,1) NOT NULL
);
