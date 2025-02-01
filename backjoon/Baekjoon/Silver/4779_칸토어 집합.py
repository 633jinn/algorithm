import sys
input = sys.stdin.readline


memo = ['' for _ in range(13)]
memo[0] = '-'
def recursion(exp):
    if memo[exp] != '':
        return memo[exp]
    num = pow(3, exp)
    size = num // 3
    return recursion(exp-1) + ' ' * size + recursion(exp-1)


while True:
    try:
        n = int(input())
        answer = recursion(n)
        memo[n] = answer
        print(answer)
    except:
        break


