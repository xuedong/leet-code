# Write your MySQL query statement below
SELECT Employees.employee_id
FROM Employees
WHERE
    Employees.employee_id NOT IN
    (
        SELECT Salaries.employee_id FROM Salaries
    )

UNION

SELECT Salaries.employee_id
FROM Salaries
WHERE
    Salaries.employee_id NOT IN
    (
        SELECT Employees.employee_id FROM Employees
    )

ORDER BY employee_id ASC;

