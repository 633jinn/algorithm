import sys

input = sys.stdin.readline
"""
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
"""
case = int(input())
num = 0
lst = [0] * 11
lst[1] = 1
lst[2] = 2
lst[3] = 4


def bfs(num):
    if num > 3:
        for i in range(4, num + 1):
            lst[i] = lst[i - 3] + lst[i - 2] + lst[i - 1]
    return lst[num]


for i in range(case):
    num = int(input())
    print(bfs(num))
