from itertools import combinations
from collections import deque

di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]

def solution():
    N, M = map(int, input().split())
    m = []
    pos = []
    virus = []
    for i in range(N):
        m.append(list(map(int, input().split())))
        for j in range(M):
            if m[i][j] == 0:
                pos.append((i,j))
            elif m[i][j] == 2:
                virus.append((i,j))
    mx = 0
    for c in combinations(pos, 3):
        nm = []
        for i in range(N):
            nm.append(m[i][:])
        for i, j in c:
            nm[i][j] = 1
        q = deque(virus)
        while q:
            i, j = q.popleft()
            for k in range(4):
                ni, nj = i+di[k], j+dj[k]
                if 0 <= ni < N and 0 <= nj < M and nm[ni][nj] == 0:
                    nm[ni][nj] = 2
                    q.append((ni,nj))
        numOfZero = 0
        for i in range(N):
            numOfZero += nm[i].count(0)
        if mx < numOfZero:
            mx = numOfZero
    print(mx)


if __name__ == '__main__':
    solution()