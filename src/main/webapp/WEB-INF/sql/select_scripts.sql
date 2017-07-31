-- get all users in a certain city
select u.user_id, c.city_name as city
    from sw_users u
        inner join sw_cities c
            on u.city_id = c.city_id
    where c.city_name = :city_name;

-- get weather ratings by user
select u.user_id, w.weather_name as weather, uw.rating
    from sw_users_ratings uw
        inner join sw_users u on u.user_id = :user_id and u.user_id = uw.user_id
        inner join sw_weather w on w.weather_id = uw.weather_id;

-- get last N comments for the specified city
select *
    from sw_comments cm
        inner join sw_cities ct on ct.city_name = :city_name and cm.city_id = ct.city_id
    limit :count;