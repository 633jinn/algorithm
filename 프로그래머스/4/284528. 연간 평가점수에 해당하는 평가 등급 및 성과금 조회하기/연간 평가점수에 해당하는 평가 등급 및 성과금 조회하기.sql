select g.EMP_NO, e.EMP_NAME, g.GRADE, 
    case
        when g.GRADE ='S'
        then e.SAL * 0.2
        when g.GRADE='A'
        then e.SAL * 0.15
        when g.GRADE='B'
        then e.SAL * 0.1
        else e.SAL * 0
    end as BONUS
        
from HR_DEPARTMENT d join HR_EMPLOYEES e join (
        select EMP_NO, 
            case
                when AVG(SCORE)>=96
                then 'S'
                when AVG(SCORE)>=90
                then 'A'
                when AVG(SCORE)>=80
                then 'B'
                else 'C'
            end as GRADE
        from HR_GRADE 
        group by EMP_NO
        )g
    on d.DEPT_ID = e.DEPT_ID and e.EMP_NO = g.EMP_NO
    order by g.EMP_NO

