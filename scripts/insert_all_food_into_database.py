import requests
from dataclasses import dataclass


@dataclass
class Nutrient:
    lipids: float
    protein: float
    carbohydrates: float


@dataclass
class Food:
    nutrients: Nutrient
    name: str


def make_post(url, payload):
    try:
        response = requests.post(
            url, json=payload, headers={"Content-Type": "application/json"}
        )

        response.raise_for_status()

        if response.content:
            return response.json()
    except requests.exceptions.HTTPError as http_err:
        print("HTTP Error Details:")
        print(f"Status Code: {http_err.response.status_code}")
        print(f"URL: {http_err.response.url}")
        print(f"Response Text: {http_err.response.text}")
        print(f"Full Error Message: {str(http_err)}")


def make_graphql_request(url, query):
    payload = {"query": query, "variables": {}}

    return make_post(url, payload)


def map_foods_response(foods_json):
    return [
        Food(
            nutrients=Nutrient(
                protein=food["nutrients"]["protein"],
                carbohydrates=food["nutrients"]["carbohydrates"],
                lipids=food["nutrients"]["lipids"],
            ),
            name=food["name"],
        )
        for food in foods_json["data"]["getAllFood"]
    ]


query = """
    query MyQuery {
        getAllFood {
            nutrients {
            lipids
            protein
            carbohydrates
        }
        name
    }
}
"""

data = make_graphql_request(url="http://localhost:4000/graphql", query=query)
print("(1/4) Data getted from Taco API")


foods = map_foods_response(data)
print("(2/4) Data mapped to memory object")


for food in foods:
    if food.nutrients.carbohydrates is None:
        food.nutrients.carbohydrates = 0

    if food.nutrients.lipids is None:
        food.nutrients.lipids = 0

    if food.nutrients.protein is None:
        food.nutrients.protein = 0

    make_post(
        "http://localhost:8080/foods",
        {
            "name": food.name,
            "carbohydrates": round(food.nutrients.carbohydrates / 100, 3),
            "protein": round(food.nutrients.protein / 100, 3),
            "lipids": round(food.nutrients.lipids / 100, 3),
        },
    )

    print(f"(3/4) Insert foods in database: {food.name} inserted")


print("(4/4) Insert exit with success")
