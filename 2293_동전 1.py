import sys

input = sys.stdin.readline
from collections import deque

"""
n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오.
각각의 동전은 몇 개라도 사용할 수 있다.
사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
"""

n, k = map(int, input().split())  # n: 동전의 종류, k: 가치의 합
coin = deque()

for i in range(n):
    coin.append(int(input()))

result = [0 for i in range(k + 1)]
result[0] = 1
for c in coin:
    for i in range(1, k + 1):
        if c <= i:
            result[i] = result[i] + result[i - c]

print(result[k])
