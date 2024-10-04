import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
wine = [0] * 10000
check_list = list()
que = deque()
answer = 0
dp = [0] * 10000
for i in range(N):
    wine[i]=int(input())
    # check_list.append(False)


# que.append((0, 0, 0))  # index와 연속으로 마신 wine 수의 튜플값


def recursion_drink_wine(num, liter):  # 런타임 에러로 실패
    global wine, N, answer, check_list
    if num == N:
        answer = max(answer, liter)
        return
    if not (num > 1 and check_list[num - 2] and check_list[num - 1]):  # 이전의 두 와인을 모두 마시지 않았다면
        check_list[num] = True
        recursion_drink_wine(num + 1, liter + wine[num])  # 와인을 마신다.
    check_list[num] = False
    recursion_drink_wine(num + 1, liter)  # 마시지 않고 넘긴다.


def dfs():  # 시간 초과로 실패
    global wine, N, answer
    while que:
        n, w, l = que.popleft()
        if n == N:
            answer = max(answer, l)
        else:
            if w != 2:  # 현재 와인을 마실 때
                if (n + 1, w + 1, l + wine[n]) not in que:
                    que.append((n + 1, w + 1, l + wine[n]))
            if (n + 1, 0, l) not in que:
                que.append((n + 1, 0, l))  # 현재 와인을 안 마실 때


def dynamic_programming():
    global wine, N, dp
    # dp는 각 순서에서 가장 많이 마신 양의 값이다
    dp[0] = wine[0]
    dp[1] = wine[0] + wine[1]
    # 2번 와인을 마시고 1번을 안마실 때, 2번 와인을 마시고 0번을 안마실 때, 2번째를 마시지 않을 때의 최댓값
    dp[2] = max(wine[2] + wine[0], wine[2] + wine[1], dp[1])
    for i in range(3, N):
        # i번 와인을 마시고, i-1를 안마실 때, i번와 인을 마시고 i-2를 안마실 때, i번 와인을 안마실 때
        dp[i] = max(wine[i] + dp[i - 2], wine[i] + wine[i - 1] + dp[i - 3], dp[i - 1])


# recursion_drink_wine(0, 0)
# dfs()
# print(answer)
dynamic_programming()
print(max(dp))
