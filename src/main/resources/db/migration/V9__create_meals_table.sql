CREATE TABLE meals (
    meal_id UUID PRIMARY KEY,
    diet_id UUID,
    meal_name VARCHAR NOT NULL,
    meal_carbohydrates NUMERIC(6,1) NOT NULL,
    meal_protein NUMERIC(6,1) NOT NULL,
    meal_lipids NUMERIC(6,1) NOT NULL,
    meal_kcal NUMERIC(7,1) NOT NULL,
    meal_time TIME NOT NULL,
    CONSTRAINT fk_diet
        FOREIGN KEY(diet_id)
        REFERENCES diets(diet_id)
        ON DELETE CASCADE
);


ALTER TABLE diet_foods
    RENAME TO meal_foods;

ALTER TABLE meal_foods
    DROP CONSTRAINT fk_diet;

ALTER TABLE meal_foods
    RENAME COLUMN diet_id TO meal_id;

ALTER TABLE meal_foods
    ADD CONSTRAINT fk_meal
        FOREIGN KEY(meal_id)
        REFERENCES meals(meal_id)
        ON DELETE CASCADE;


ALTER TABLE diet_dishes
    RENAME TO meal_dishes;

ALTER TABLE meal_dishes
    DROP CONSTRAINT fk_diet;

ALTER TABLE meal_dishes
    RENAME COLUMN diet_id TO meal_id;

ALTER TABLE meal_dishes
    ADD CONSTRAINT fk_meal
        FOREIGN KEY(meal_id)
        REFERENCES meals(meal_id)
        ON DELETE CASCADE;
