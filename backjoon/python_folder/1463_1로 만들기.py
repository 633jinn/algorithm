import sys
from collections import deque

input = sys.stdin.readline
# 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
#
# X가 3으로 나누어 떨어지면, 3으로 나눈다.
# X가 2로 나누어 떨어지면, 2로 나눈다.
# 1을 뺀다.
# 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

x = int(input())
count = [0] * (x + 1)
que = deque()
que.appendleft(x)


# dfs
# def recursize(n):
#     global count
#     if count[n] == 0:
#         if n % 6 == 0:
#             count[n] = min(recursize(n // 3), recursize(n // 2), recursize(n - 1)) + 1
#         elif n % 3 == 0:
#             count[n] = min(recursize(n // 3), recursize(n - 1)) + 1
#         elif n % 2 == 0:
#             count[n] = min(recursize(n // 2), recursize(n - 1)) + 1
#         else:
#             count[n] = recursize(n - 1) + 1
#     return count[n]

# bps
def bfs():
    global que
    global count
    while True:
        n = que.popleft()
        if n == 1:
            break
        if n % 2 == 0 and count[n // 2] == 0:
            count[n // 2] = count[n] + 1
            que.append(n // 2)
        if n % 3 == 0 and count[n // 3] == 0:
            count[n // 3] = count[n] + 1
            que.append(n // 3)
        if count[n - 1] == 0:
            count[n - 1] = count[n] + 1
            que.append( n - 1 )
    return count[n]


print(bfs())
