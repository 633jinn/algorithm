select p1.ID, p1.NAME, p1.HOST_ID
    from PLACES p1 join
    (
        select HOST_ID, count(*) as COUNT
        from PLACES
        group by HOST_ID
    ) p2 on p1.HOST_ID=p2.HOST_ID
    where p2.COUNT>=2;
    