import sys
from collections import deque
input = sys.stdin.readline
N = int(input())
arr = deque()  # 달걀들의 무게와 내구도를 담을 데크

for i in range(N):
    s, w = map(int, input().split())  # s = 내구도, w : 무게
    arr.append((s, w))  # 튜플의 형태로 append

egg = arr.popleft()  # 손에 들고 있는 달걀
count = 0  # 깰 수 있는 달걀의 수


if len(arr) != 0:
    minsortEggs = sorted(arr)
    while True:
        for i in range(len(minsortEggs)):
            if minsortEggs[i][0] - egg[1] <= 0:  # 손의 달걀로 내리칠 때, 바닥의 달걀이 깨지면
                if i<len(minsortEggs)-1 and minsortEggs[i + 1][0] - egg[1] <= 0 < egg[0] - minsortEggs[i + 1][0]:
                    continue
                else:
                    egg = (egg[0] - minsortEggs[i][1], egg[1])
                    count += 1  # 깨진 달걀 갯수 +1
                    arr.remove(minsortEggs[i])  # 깨졌으므로 리스트에서 삭제
                    minsortEggs.remove(minsortEggs[i])
                    break
            else:
                egg = (egg[0] - minsortEggs[i][1], egg[1])
                arr[0] = (minsortEggs[i][1] - egg[0], minsortEggs[i][1])
                minsortEggs[i] = (minsortEggs[i][1] - egg[0], minsortEggs[i][1])
                break


        if egg[0] <= 0:  # 손에 든 달걀이 깨졌다면,
            count += 1  # 깨진 달걀 갯수 +1
            if len(arr) <= 1:
                break
            else:
                egg = arr.popleft()  # 새로운 달걀을 손에 듦
                minsortEggs.remove(egg)

print(count)
