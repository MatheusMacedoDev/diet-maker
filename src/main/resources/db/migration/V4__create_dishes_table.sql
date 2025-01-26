CREATE TABLE dishes (
    dish_id SMALLSERIAL PRIMARY KEY,
    dish_name VARCHAR NOT NULL,
    dish_carbohydrates NUMERIC(4,3) NOT NULL,
    dish_protein NUMERIC(4,3) NOT NULL,
    dish_lipids NUMERIC(4,3) NOT NULL,
    dish_kcal NUMERIC(4,3) NOT NULL
);
