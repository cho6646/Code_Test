from collections import deque
from itertools import product
from copy import deepcopy
import math


def bomb(power, i, j):
    for o in range(4):
        ni = i + dx[o]
        nj = j + dy[o]
        if 0 <= ni < W and 0 <= nj < H:
            stack.append((power - 1, ni, nj, o))


def flame(fire, i, j, o):
    ni = i + dx[o]
    nj = j + dy[o]
    if 0 <= ni < W and 0 <= nj < H:
        stack.append((fire - 1, ni, nj, o))


dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

T = int(input())

for test_case in range(1, T + 1):
    N, W, H = map(int, input().split())
    m = [deque() for _ in range(W)]
    bCnt = [0 for _ in range(W)]
    for i in range(H):
        a = list(map(int, input().split()))
        for j in range(W):
            m[j].appendleft(a[j])
            if a[j]:
                bCnt[j] += 1

    result = math.inf
    stack = deque()
    for balls in product(range(W), repeat=N):
        subM = deepcopy(m)
        blocksCnt = bCnt[:]
        for p in balls:
            removeCnt = [0 for _ in range(W)]
            j = 0
            # print(p)
            if blocksCnt[p]:
                j = blocksCnt[p]-1
            else:
                break
            removeCnt[p]+=1
            power = subM[p][j]
            subM[p][j] = 0
            if power > 1:
                bomb(power, p, j)

            while stack:
                fire,i,j,o = stack.pop()
                if subM[i][j]:
                    removeCnt[i]+=1
                    power = subM[i][j]
                    subM[i][j]=0
                    if power>1:
                        bomb(power,i,j)
                if fire > 1:
                    flame(fire,i,j,o)

            for r in range(W):
                blocksCnt[r] -= removeCnt[r]
                for _ in range(removeCnt[r]):
                    subM[r].remove(0)
                    subM[r].append(0)

        cnt = sum(blocksCnt)
        if result > cnt:
            result = cnt
        if cnt == 0:
            break
    print(f"#{test_case} {result}")