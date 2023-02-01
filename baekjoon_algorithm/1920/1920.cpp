#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <algorithm>
using namespace std;
int cmp(int x, int y, int val, int* &arr)
{
    int count = 0;
    while (x <= y)
    {
        int middle = (x + y) / 2;
        if (val == arr[middle]) {
            count = 1;
            break;
        }
        else if (val > arr[middle]) {
            x = middle + 1;
        }
        else {
            y = middle-1;
        }
    }
    return count;
}
void merge(const int start, const int middle, int end, int size, int arr[]) {
    int i = start;
    int j = middle + 1;
    int k = start;
    int* sorted = new int[size];
    while (i <= middle && j <= end) {
        if (arr[i] <= arr[j]) {
            sorted[k] = arr[i];
            i++;
        }
        else {
            sorted[k] = arr[j];
            j++;
        }
        k++;
    }
    if (i > middle) {
        for (int t = j; t <= end; t++) {
            sorted[k] = arr[t];
            k++;
        }
    }
    else {
        for (int t = i; t <= middle; t++) {
            sorted[k] = arr[t];
            k++;
        }
    }
    for (int x = start; x <= end; x++) {
        arr[x] = sorted[x];
    }
    delete[] sorted;
}
void mergesort(int start, int end, int size, int arr[]) {
    if (start < end)
    {
        mergesort(start, (start + end) / 2, size, arr);
        mergesort((start + end) / 2 + 1, end, size, arr);
        merge(start, (start + end) / 2, end, size, arr);
    }
}
int main() {
    int sizeA = 0;
    scanf("%d", &sizeA);
    int val;
    int* arrA = new int[sizeA];
    int* sorted = new int[sizeA];
    for (int i = 0; i < sizeA; i++) {
        scanf("%d", &arrA[i]);
    }
    mergesort(0, sizeA-1, sizeA, arrA);
    int sizeB = 0;
    scanf("%d", &sizeB);
    for (int i = 0; i < sizeB; i++) {
        scanf("%d", &val);
        printf("%d\n", cmp(0, sizeA - 1, val, arrA));
    }
    delete[] arrA;

    return 0;
}