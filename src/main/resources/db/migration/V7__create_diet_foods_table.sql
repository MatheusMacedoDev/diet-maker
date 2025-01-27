CREATE TABLE diet_foods (
    diet_food_id UUID PRIMARY KEY,
    diet_id UUID,
    food_id SMALLINT,
    grams_quantity NUMERIC(4,0) NOT NULL,
    CONSTRAINT fk_diet
        FOREIGN KEY(diet_id)
            REFERENCES diets(diet_id)
                ON DELETE CASCADE,
    CONSTRAINT fk_food
        FOREIGN KEY(food_id)
            REFERENCES foods(food_id)
                ON DELETE CASCADE
);
