select SUM(B.SCORE) AS SCORE, A.EMP_NO, A.EMP_NAME, A.POSITION, A.EMAIL
from HR_EMPLOYEES A
join HR_GRADE B
on A.EMP_NO = B.EMP_NO
where B.YEAR = 2022
group by A.EMP_NO, A.EMP_NAME, A.POSITION, A.EMAIL
having SUM(B.SCORE) >= ALL(
    select SUM(SCORE)
    from HR_GRADE
    where YEAR = 2022
    group by EMP_NO
);