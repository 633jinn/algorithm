import sys

input = sys.stdin.readline

string = list(input().rstrip())
boom = list(input().rstrip())

stack = []

for i in string:
    stack.append(i)
    length = len(stack)-len(boom)
    if stack[length:] == boom:
        for _ in range(len(boom)):
            stack.pop()

if len(stack) == 0:
    print("FRULA")
else:
    print(*stack, sep="")
