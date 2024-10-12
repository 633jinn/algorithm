import sys

input = sys.stdin.readline

N, M = map(int, input().split())

dic = dict()

for _ in range(N):
    name = input().strip()
    if name not in dic:
        dic[name] = 1
for _ in range(M):
    name = input().strip()
    if name in dic:
        dic[name] += 1

result = []

for k, v in dic.items():
    if v == 2:
        result.append(k)

print(len(result))
for i in sorted(result):
    print(i)
