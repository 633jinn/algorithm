import sys
from itertools import combinations
input = sys.stdin.readline

N, M = map(int, input().split())
lst = list()
chicken = list()
for i in range(N):
    input_list = list(map(int, input().split()))
    lst.append(input_list)
    for j in range(len(input_list)):
        if input_list[j] == 2:
            chicken.append((i, j))
chicken = list(combinations(chicken, M))
result = [0 for _ in range(len(chicken))]

def find_short_distance(x, y, chickens):
    distance=100
    for chicken in chickens:
        distance = min(distance, abs(x - chicken[0]) + abs(y-chicken[1]))
    return distance


for i in range(len(chicken)): #치킨집의 조합만큼 for문
    for j in range(N): #리스트 for문 - 행
        for k in range(N): #-열
            if lst[j][k] == 1:
                result[i]+=find_short_distance(j,k,chicken[i])

print(min(result))


