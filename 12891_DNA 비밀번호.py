import sys

input = sys.stdin.readline

S, P = map(int, input().split())
DNA = input().rstrip()
a,c,g,t =map(int, input().split())
window = DNA[0:P]
count = {'A': window.count('A'), 'C': window.count('C'), 'G': window.count('G'), 'T': window.count('T')}
res = 0
if a <= count['A'] and c <= count['C'] and g <= count['G'] and t <= \
        count['T']:
    res += 1
for i in range(0, S - P):
    count[DNA[i]] -= 1
    count[DNA[i + P]] += 1
    if a <= count['A'] and c <= count['C'] and g <= count['G'] and t <= \
            count['T']:
        res += 1

print(res)
