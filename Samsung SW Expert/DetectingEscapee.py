from collections import deque


dx = [0,0,-1,1]
dy = [-1,1,0,0]

T = int(input())
for test_case in range(1, T + 1):
    N, M, R, C, L = map(int, input().split())
    m = []
    for i in range(N):
        m.append(list(map(int, input().split())))
    ans = 0
    visited = [[False]*M for _ in range(N)]
    visited[R][C] = True
    q = deque()
    q.append(((R,C,1)))
    while q:
        a = q.popleft()
        if a[2] > L:
            break
        n = m[a[0]][a[1]]
        ans += 1
        b = []
        if n == 1:
            b = [0,1,2,3]
        elif n == 2:
            b = [0,1]
        elif n == 3:
            b = [2,3]
        elif n == 4:
            b = [0,3]
        elif n == 5:
            b = [1,3]
        elif n == 6:
            b = [1,2]
        else:
            b = [0,2]
        for i in b:
            ny = a[0]+dy[i]
            nx = a[1]+dx[i]
            if i == 0:
                c = [1, 2, 5, 6]
            elif i == 1:
                c = [1, 2, 4, 7]
            elif i == 2:
                c = [1, 3, 4, 5]
            else:
                c = [1, 3, 6, 7]
            if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx] and m[ny][nx] in c:
                q.append((ny,nx,a[2]+1))
                visited[ny][nx] = True

    print(f'#{test_case} {ans}')