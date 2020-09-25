import heapq
from collections import deque
T = int(input())
for test_case in range(1, T + 1):
    N, M, K, A, B = map(int, input().split())
    a, b, t = [], [], []
    if N == 1:
        a.append(int(input()))
    else:
        a = list(map(int, input().split()))
    if M == 1:
        b.append(int(input()))
    else:
        b = list(map(int, input().split()))
    if K == 1:
        t.append(int(input()))
    else:
        t = list(map(int, input().split()))
    aVacant, aBusy = [], []
    bVacant, bBusy = [], []
    for idx, a1 in enumerate(a):
        heapq.heappush(aVacant, (idx+1, a1))
    for idx, b1 in enumerate(b):
        heapq.heappush(bVacant, (idx+1, b1))
    storeUse = {}
    repairQueue = deque()
    i, j, ans = 0, 0, 0
    while j<len(t) or aBusy or bBusy:
        while aBusy and aBusy[0][0] <= i:
            a1 = heapq.heappop(aBusy)
            heapq.heappush(aVacant, (a1[1], a1[2]))
            repairQueue.append((a1[3], a1[1]))
        while bBusy and bBusy[0][0] <= i:
            b1 = heapq.heappop(bBusy)
            heapq.heappush(bVacant, (b1[1], b1[2]))

        while j<len(t) and t[j] <= i and aVacant:
            customer = t[j]
            a1 = heapq.heappop(aVacant)
            heapq.heappush(aBusy, (a1[1]+i, a1[0], a1[1], j+1))
            j+=1
        while repairQueue and bVacant:
            customer = repairQueue.popleft()
            b1 = heapq.heappop(bVacant)
            if customer[1] == A and b1[0] == B:
                ans += customer[0]
            heapq.heappush(bBusy, (b1[1]+i, b1[0], b1[1], customer[0]))
        i += 1
    if ans == 0:
        ans = -1
    print(f'#{test_case} {ans}')