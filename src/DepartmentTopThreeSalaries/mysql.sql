# Write your MySQL query statement below
select D.Name as Department, E.Name as Employee, E.Salary as Salary
from Department as D, Employee as E, Employee as E2
where D.Id = E.DepartmentId and E.DepartmentId = E2.DepartmentId and E.Salary <= E2.Salary
group by D.Name, E.Name having count(distinct E2.Salary) <=3
order by D.Name, E.Salary