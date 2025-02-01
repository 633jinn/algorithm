import sys
import math
input = sys.stdin.readline

n = int(input())

memo = [[] for _ in range(n)]
memo[0] = ['*','*','*']
def rec(n, idx):
    k = 0
    if n != 1:
        k = round(math.log(n, 3))
    if memo[k]!=[] and memo[k][idx] != '':
        return memo[k][idx]
    for i in range(3):
        for j in range(n):
            if len(memo[k]) < j+1:
                memo[k].append('')
            if i == 1 and int(j//(n/3)) == 1:
                memo[k][j] += ' '*len(memo[k-1][j%(n//3)])
            else:
                line = rec(n//3, j%(n//3))
                memo[k][j] += line
    return memo[k][idx]



answer = rec(n, 0)

num = round(math.log(n, 3))
for i in range(len(memo[num])):
    print(memo[num][i])