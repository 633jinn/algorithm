select round(sum(f.length)/count(f.id), 2) as AVERAGE_LENGTH
    from 
        (
            select id, IFNULL(length, 10) as length
                from fish_info
        ) f
        
;