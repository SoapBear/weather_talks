CREATE TABLE sw_countries (
    country_id INTEGER PRIMARY KEY,
    country_name VARCHAR(16) NOT NULL
)

CREATE TABLE sw_cities (
    city_id INTEGER PRIMARY KEY,
    city_name VARCHAR(64) NOT NULL,
    city_country INTEGER REFERENCES sw_countries
)

CREATE TABLE sw_users (
    user_id SERIAL PRIMARY KEY,
    register_date TIMESTAMP NOT NULL,
    city_id INTEGER REFERENCES sw_cities
)

CREATE TABLE sw_weather (
    weather_id SMALLSERIAL PRIMARY KEY,
    weather_name VARCHAR(15) NOT NULL
)

CREATE TABLE sw_weather_stamps (
    weeather_stamp_id SERIAL PRIMARY KEY,
    city_id INTEGER REFERENCES sw_cities,
    time_stamp TIMESTAMP NOT NULL,
    weather_id SMALLINT REFERENCES sw_weather,
    atmosphere_pressure INTEGER,
    air_temperature REAL,
    air_humidity REAL,
    wind_direction SMALLINT,
    wind_speed REAL,
    cloud_cover SMALLINT,
    precipitation SMALLINT,
    visibility SMALLINT
)

CREATE TABLE sw_users_ratings (
    user_id INTEGER REFERENCES sw_users,
    weather_id INTEGER REFERENCES sw_weather,
    rating SMALLINT NOT NULL,
    PRIMARY KEY(user_id, weather_id)
)

CREATE TABLE sw_comments (
    comment_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES sw_users,
    weeather_stamp_id INTEGER REFERENCES sw_weather_stamps,
    comment_time TIMESTAMP NOT NULL,
    likes_count SMALLINT DEFAULT 0,
    weather_rating SMALLINT DEFAULT NULL,
    user_name VARCHAR(10) DEFAULT NULL,
    comment_text VARCHAR(64) NOT NULL
)

CREATE TABLE sw_comments_likes (
    comment_id INTEGER REFERENCES sw_comments,
    user_id INTEGER REFERENCES sw_users,
    PRIMARY KEY(comment_id, user_id)
)

CREATE TABLE sw_messages (
    message_id SERIAL PRIMARY KEY,
    weeather_stamp_id INTEGER REFERENCES sw_weather_stamps,
    user_id INTEGER REFERENCES sw_users,
    message_label VARCHAR(32),
    message VARCHAR(128),
    CHECK((message_label IS NOT NULL) OR (message IS NOT NULL))
)