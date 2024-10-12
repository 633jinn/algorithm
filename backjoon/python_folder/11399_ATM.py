N = int(input())
P = list(map(int, input().split()))
sum = 0
plus = 0
for i in range(N):
    plus += min(P)
    P.remove(min(P))
    sum += plus
print(sum)
