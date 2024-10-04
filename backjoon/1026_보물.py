N=int(input())
A=list(map(int, input().split()))
B=list(map(int, input().split()))
S=0
for i in range(len(B)):
    S+=max(B) * min(A)
    B.remove(max(B))
    A.remove(min(A))
print(S)