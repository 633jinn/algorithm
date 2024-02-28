import sys
input = sys.stdin.readline
"""
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
"""
house = int(input()) # N(2 ≤ N ≤ 1,000)
rgb = []*house
for j in range(house):
    rgb.append(list(map(int, input().split())))

arr = [[0,0,0] for i in range(house)]

arr[0][0] = rgb[0][0]
arr[0][1] = rgb[0][1]
arr[0][2] = rgb[0][2]
for i in range(1,house):
    arr[i][0] = min(arr[i-1][1],arr[i-1][2])+rgb[i][0]
    arr[i][1] = min(arr[i-1][0],arr[i-1][2])+rgb[i][1]
    arr[i][2] = min(arr[i-1][0],arr[i-1][1])+rgb[i][2]


print(min(arr[house-1][0],arr[house-1][1],arr[house-1][2]))