import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
result = 0
t = list()
p = list()
for i in range(N):
    ti, pi = map(int, input().split())
    t.append(ti)
    p.append(pi)


def dfs(day, money):
    global result
    if day >= N:
        result = max(result, money)
        return
    if t[day] + day <= N:  # 상담 소요 시간이 퇴사일 이전일 경우
        dfs(t[day] + day, p[day] + money)  # day날 상담을 한다.
    dfs(day + 1, money)  # 오늘 상담을 안할 때


dfs(0, 0)

print(result)
