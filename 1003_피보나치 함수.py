import sys
input = sys.stdin.readline

T = int(input())
count = list()
count.append((1,0))
count.append((0,1))
count.append((1,1))
count.append((1,2))

for _ in range(T):
    n = int(input())
    length = len(count)-1
    if n > length:
        check = length
        while check != n:
            count.append((count[check-1][0]+count[check][0],count[check-1][1]+count[check][1]))
            check = check+1
    print(count[n][0],count[n][1])