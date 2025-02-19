-- 코드를 작성해주세요
select YEAR(a.DIFFERENTIATION_DATE) as YEAR, 
        (b.max_size_of_colony - a.size_of_colony) as YEAR_DEV, 
        a.id as ID
    from ECOLI_DATA a
    
    join (
        select max(size_of_colony) as max_size_of_colony, 
            date_format(DIFFERENTIATION_DATE, '%Y') as year
        from ECOLI_DATA
        group by year
    ) b on date_format(a.DIFFERENTIATION_DATE, '%Y') = b.year
    
    order by YEAR, YEAR_DEV;
    