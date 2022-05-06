# Write your MySQL query statement below
SELECT
    name,
    SUM(amount) AS balance
FROM Transactions t
LEFT JOIN Users u on u.account = t.account
GROUP BY t.account
HAVING balance >= 10000
;

