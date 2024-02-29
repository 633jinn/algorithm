import math

N = int(input())
i, j = 1, 2
Sum = 1
res = 0
if N != 1:
    while j <= math.ceil(N / 2) + 1:
        if Sum < N:
            Sum += j
            j += 1
        elif Sum > N:
            Sum -= i
            i += 1
        else:
            res += 1
            Sum += j
            j += 1
print(res + 1)