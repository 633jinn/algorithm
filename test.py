from collections import deque


def solution(queue1, queue2):
    answer = 0
    deq1 = deque(queue1)
    deq2 = deque(queue2)
    goal = (sum(deq1) + sum(deq2))
    if goal % 2 == 1:
        return -1
    else:
        goal //= 2
    sum1 = sum(deq1)

    for _ in range(len(deq1) * 4):
        if sum1 == goal:
            return answer
        if not deq1 or not deq2:
            break
        if sum1 < goal:
            deq2_pop = deq2.popleft()
            sum1 += deq2_pop
            deq1.append(deq2_pop)
        else:
            deq1_pop = deq1.popleft()
            sum1 -= deq1_pop
            deq2.append(deq1_pop)
        answer += 1

    return -1


s = solution([1, 2, 1, 2], [1, 10, 1, 2])
print(s)