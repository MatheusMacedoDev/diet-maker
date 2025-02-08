CREATE TABLE diets (
    diet_id UUID PRIMARY KEY,
    user_id UUID,
    diet_name VARCHAR NOT NULL,
    diet_carbohydrates NUMERIC(6,1) NOT NULL,
    diet_protein NUMERIC(6,1) NOT NULL,
    diet_lipids NUMERIC(6,1) NOT NULL,
    diet_fibers NUMERIC(6,1) NOT NULL,
    diet_kcal NUMERIC(7,1) NOT NULL,
    diet_water_ml SMALLINT NOT NULL,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
            REFERENCES users(user_id)
                ON DELETE CASCADE
);
