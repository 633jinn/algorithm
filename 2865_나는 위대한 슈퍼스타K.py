import sys
input = sys.stdin.readline

N,M,K=map(int, input().split())
score_arr =[0 for x in range(N+1)]
res=0

for i in range(M):
    arr=list(map(float, input().split()))
    for j in range(0, N*2,2):
        num, score = arr[j], arr[j+1]
        num=int(num)
        score_arr[num] = max(score,score_arr[num])
score_arr.sort(reverse=True)
for i in range(K):
    res += score_arr[i]

print(round(res,1))