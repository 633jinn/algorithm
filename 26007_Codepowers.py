import sys

input = sys.stdin.readline

N,M,K,X=map(int, input().split())
A=list(map(int, input().split()))

score = [0]+[0 for i in range(N)]
count=[0]+[0 for i in range(N)]
for i in range(1,N+1):
    score[i]=score[i-1]+A[i-1]
    count[i] = count[i - 1]
    if(score[i]<(K-X)):
        count[i]+=1

for i in range(M):
    l,r=map(int, input().split())
    res=count[r-1]-count[l-1]
    print(res)