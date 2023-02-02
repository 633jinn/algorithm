import sys

x = int(sys.stdin.readline())
arr=[]
#arr = list(map(int,sys.stdin.readline().split()))
for i in range(x):
    arr.append(int(sys.stdin.readline()))
def merge(start, middle, end, arr):
    i = start
    j = middle+1
    k = start
    sort=list(range(len(arr)))
    while(i<=middle and j<= end):
        
        if arr[i]<=arr[j]:
            sort[k]=arr[i]
            i+=1
        else:
            sort[k]=arr[j]
            j+=1
        k+=1
        
    if i > middle:
        for m in range(j, end+1):
            sort[k]=arr[m]
            k+=1
    else:
        for m in range(i, middle+1):
            sort[k]=arr[m]
            k+=1
    for m in range(start, end+1): 
            arr[m]=sort[m]

def mergesort(start, end, arr):
    middle=(start+end)//2
    if start<end:
        mergesort(start,middle, arr)
        mergesort(middle+1, end, arr)
        merge(start, middle, end, arr)

mergesort(0, x-1, arr)
for i in arr:
    print(i)