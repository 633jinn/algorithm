import  sys
input = sys.stdin.readline

N = int(input())

meet = ["ChongChong"]

for i in range(N):
    a, b = input().split()
    if a in meet and b not in meet:
        meet.append(b)
    elif a not in meet and b in meet:
        meet.append(a)

print(len(meet))