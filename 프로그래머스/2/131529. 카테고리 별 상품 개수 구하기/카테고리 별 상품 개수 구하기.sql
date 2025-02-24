select CATEGORY, count(*) as PRODUCTS
    from (select SUBSTRING(PRODUCT_CODE, 1,2) AS CATEGORY, PRODUCT_CODE
    from PRODUCT) p
    group by CATEGORY;