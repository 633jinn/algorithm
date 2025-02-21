-- mysql은 0<x<1의 형식은 쓸 수 없다, and를 이용해야한다
-- PERCENT_RANK()를 이용해 백분위를 구할 수 있다.
-- 이때 over()은 PERCENT_RANK()값을 행마다 출력하도록 한다. 
-- 참고로 rank는 변수명으로 쓸 수 없다(지정된 값이라서..?)
select e.id, 
        case
            when e.percentage <= 0.25
            then 'CRITICAL'
            when e.percentage <= 0.5
            then 'HIGH'
            when e.percentage <= 0.75
            then 'MEDIUM'
            else 'LOW'
        end as COLONY_NAME
    from (
            select ID, PERCENT_RANK() OVER (order by SIZE_OF_COLONY DESC) as percentage
            from ECOLI_DATA
        ) e
    order by e.id;