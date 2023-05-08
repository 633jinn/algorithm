import math
lst = list(input().rstrip())
dic = {'U': 0, 'D': 0, 'P': 0}
for i in lst:
    if i == 'C' or i == 'U':
        dic['U'] += 1
    elif i == 'D' or i == 'P':
        dic['D'] += 1
        dic['P'] += 1
if dic['U'] > math.ceil(dic['D'] / 2):
    print('U', end='')
if dic['D'] != 0:
    print('DP')
