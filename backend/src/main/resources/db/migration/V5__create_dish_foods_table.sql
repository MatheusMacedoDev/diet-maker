CREATE TABLE dish_foods (
    dish_food_id SERIAL PRIMARY KEY,
    dish_id SMALLINT,
    food_id SMALLINT,
    grams_quantity NUMERIC(4,0) NOT NULL,
    CONSTRAINT fk_dish
        FOREIGN KEY(dish_id)
            REFERENCES dishes(dish_id)
                ON DELETE CASCADE,
    CONSTRAINT fk_food
        FOREIGN KEY(food_id)
            REFERENCES foods(food_id)
                ON DELETE CASCADE
);
