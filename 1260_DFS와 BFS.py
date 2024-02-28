import sys
from collections import deque

input = sys.stdin.readline

n, m, v = map(int, input().split())  # 정점, 간선, 시작 정점 번호
line = list()  # 간선 정보
num1 = [[] for _ in range(n + 1)]
num2 = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    num1[a].append(b)
    num1[b].append(a)
    num2[a].append(b)
    num2[b].append(a)





def dfs():
    global n
    que = deque()
    que.append(v)
    check = False
    result = list()
    while True:
        q = que.popleft()
        if q not in result:
            result.append(q)
        for i in num1:
            if len(i) !=0:
                check = True
                break
        if check:
            lst = list()
            for j in sorted(num1[q],reverse=True):
                que.appendleft(j)
                lst.append(j)
            for j in lst:
                num1[q].remove(j)
                num1[j].remove(q)
        if len(que) == 0:
            return result


def bfs():
    global n
    que = deque()
    que.append(v)
    result = list()
    check = False
    while True:
        q = que.popleft()
        if q not in result:
            result.append(q)
        for i in num2:
            if len(i) !=0:
                check = True
        if check :
            lst = list()
            for j in sorted(num2[q]):
                que.append(j)
                lst.append(j)
            for j in lst:
                num2[q].remove(j)
                num2[j].remove(q)
        if len(que) == 0:
            return result

print(*dfs(), sep = " ")
print(*bfs(), sep = " ")