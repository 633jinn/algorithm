import sys
input=sys.stdin.readline

N = int(input())
oil = list(map(int,input().split()))
path = list(map(int,input().split()))
res=0
i=0
oil_Money=path[0]
while i<N-1:
    if oil_Money > path[i]:
        oil_Money=path[i]
    res += oil_Money*oil[i]
    i+=1
print(res)