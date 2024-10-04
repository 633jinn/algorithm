import sys

input = sys.stdin.readline

a,b,c = map(int, input().split())
N=[0 for x in range(a+b+c-2) ]
for i in range(1, a+1):
    for j in range(1, b+1):
        for k in range(1, c+1):
            N[i+j+k-3]+=1
print(N.index(max(N))+3)
