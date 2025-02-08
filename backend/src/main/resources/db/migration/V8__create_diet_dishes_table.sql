CREATE TABLE diet_dishes (
    diet_dish_id UUID PRIMARY KEY,
    diet_id UUID,
    dish_id SMALLINT,
    multiplier NUMERIC(3,1) NOT NULL,
    CONSTRAINT fk_diet
        FOREIGN KEY(diet_id)
            REFERENCES diets(diet_id)
                ON DELETE CASCADE,
    CONSTRAINT fk_dish
        FOREIGN KEY(dish_id)
            REFERENCES dishes(dish_id)
                ON DELETE CASCADE
);
