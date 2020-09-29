from collections import deque

def dfs(i, j, canDig, num):
    global longest
    moved = False
    for k in range(4):
        ni, nj = i+di[k], j+dj[k]
        if 0<=ni<N and 0<=nj<N and not visited[ni][nj]:
            if m[ni][nj] < m[i][j]:
                visited[ni][nj] = True
                dfs(ni, nj, canDig, num+1)
                moved = True
                visited[ni][nj] = False
            else:
                if canDig and K > m[ni][nj] - m[i][j]:
                    temp = m[ni][nj]
                    m[ni][nj] -= temp - m[i][j] + 1
                    visited[ni][nj] = True
                    dfs(ni, nj, False, num+1)
                    moved = True
                    visited[ni][nj] = False
                    m[ni][nj] = temp
    if not moved and num > longest:
        longest = num



di = [0, 0, -1, 1]
dj = [-1, 1, 0, 0]

T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    m = []
    high, highs = 0, []
    for i in range(N):
        m.append(list(map(int, input().split())))
        for j in range(N):
            if m[i][j] > high:
                high = m[i][j]
                highs = [(i, j)]
            elif m[i][j] == high:
                highs.append((i, j))
    longest = 1
    for hi,hj in highs:
        visited = [[False]*N for _ in range(N)]
        visited[hi][hj] = True
        dfs(hi, hj, True, 1)
    print(f'#{test_case} {longest}')