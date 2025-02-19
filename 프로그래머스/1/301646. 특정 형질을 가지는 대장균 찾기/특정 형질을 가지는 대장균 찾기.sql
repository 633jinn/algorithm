-- 비트 연산자를 이용해 2진수 비교

select count(*) as 'COUNT'
    from ECOLI_DATA A
    where genotype & 2 != 2
        and (genotype & 1 = 1 
        or genotype & 4 = 4);
        
