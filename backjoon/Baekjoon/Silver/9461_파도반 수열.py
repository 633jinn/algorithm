import sys
readline = sys.stdin.readline

T = int(input())
triangle = [1, 1, 1]


def calculate_width(start, end):
    global triangle
    for i in range(start, end):
        triangle.append(triangle[i-3]+triangle[i-2])



for _ in range(T):
    N = int(input())
    if len(triangle)<N:
        calculate_width(len(triangle), N)
    print(triangle[N-1])

