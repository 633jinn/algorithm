select f.ID, fn.FISH_NAME, f.LENGTH
    from FISH_INFO f join FISH_NAME_INFO fn
                on f.FISH_TYPE = fn.FISH_TYPE
                
    where (fn.FISH_NAME, f.LENGTH) in (select fn.FISH_NAME, MAX(f.LENGTH) as LENGTH
            from FISH_INFO f join FISH_NAME_INFO fn
                on f.FISH_TYPE = fn.FISH_TYPE
            group by fn.FISH_NAME)
    order by f.ID;
            

        