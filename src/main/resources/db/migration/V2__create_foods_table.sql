CREATE TABLE foods (
    food_id SMALLSERIAL PRIMARY KEY,
    food_name VARCHAR NOT NULL,
    food_carbohydrates NUMERIC(4,3) NOT NULL,
    food_protein NUMERIC(4,3) NOT NULL,
    food_lipids NUMERIC(4,3) NOT NULL,
    food_kcal NUMERIC(4,3) NOT NULL
);
