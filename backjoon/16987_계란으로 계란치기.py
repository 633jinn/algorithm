import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
que = deque()  # 달걀들의 무게와 내구도를 담을 데크
egg_s = list()
egg_w = list()
for i in range(N):
    s, w = map(int, input().split())  # s = 내구도, w : 무게
    que.append(i)  # que에 순서 append
    egg_s.append(s)  # 리스트에 append
    egg_w.append(w)

count = 0  # 깰 수 있는 달걀의 수


def dfs():
    egg = que.popleft()  # 손에 들고 있는 달걀
    s_lst = egg_s
    for i in que:
        count_egg(s_lst)
def count_egg(s_lst):


print(count)
