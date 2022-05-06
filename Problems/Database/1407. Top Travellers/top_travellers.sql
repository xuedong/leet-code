# Write your MySQL query statement below
SELECT
    name,
    CASE
        WHEN SUM(distance) IS NULL THEN 0
        ELSE SUM(distance)
    END AS travelled_distance
FROM Users u LEFT JOIN Rides r ON u.id = r.user_id
GROUP BY u.id
ORDER BY travelled_distance DESC, name ASC
;

