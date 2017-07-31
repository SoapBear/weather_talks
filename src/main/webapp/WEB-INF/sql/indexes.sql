CREATE UNIQUE INDEX city_id_idx ON sw_cities(city_id);

CREATE UNIQUE INDEX city_name_idx ON sw_cities(city_name);

CREATE CONCURRENTLY INDEX city_name_idx ON sw_users(user_id);

CREATE UNIQUE INDEX ON sw_weather(weather_id);

CREATE CONCURRENTLY INDEX ON sw_weather_stamps(weeather_stamp_id);

CREATE CONCURRENTLY INDEX ON sw_weather_stamps(weeather_stamp_id);