select d.DEPT_ID, d.DEPT_NAME_EN, e.AVG_SAL
    from HR_DEPARTMENT d 
        join (
            select DEPT_ID, ROUND(AVG(SAL),0) as AVG_SAL 
                from HR_EMPLOYEES
            group by DEPT_ID
            ) as e
            on d.DEPT_ID = e.DEPT_ID
            
    order by e.AVG_SAL desc    
;
    