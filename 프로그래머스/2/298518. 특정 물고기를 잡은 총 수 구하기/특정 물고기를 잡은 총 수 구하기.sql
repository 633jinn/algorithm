select count(*) as FISH_COUNT
    from FISH_INFO f join FISH_NAME_INFO fn 
        on f.FISH_TYPE = fn.FISH_TYPE
    where fn.FISH_NAME = 'SNAPPER' OR fn.FISH_NAME = 'BASS'
;