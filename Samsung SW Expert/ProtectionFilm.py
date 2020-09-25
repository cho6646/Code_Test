def check():
    for i in range(W):
        s = sum([tmp[j][i] for j in range(K)])
        for j in range(D-K):
            if s == 0 or s == K:
                break
            s = s - tmp[j][i] + tmp[j + K][i]
        if s != 0 and s != K:
            return False
    return True

def dfs(row, paintCnt):
    global ans, tmp
    if paintCnt > ans:
        return
    if row == D:
        for i in range(D):
            for j in range(W):
                tmp[i][j] = film[i][j]
        for i in range(D):
            if paintRow[i] != -1:
                tmp[i] = [paintRow[i]] * W
        if check():
            ans = paintCnt
        return
    paintRow[row] = -1
    dfs(row + 1, paintCnt)
    paintRow[row] = 1
    dfs(row + 1, paintCnt + 1)
    paintRow[row] = 0
    dfs(row + 1, paintCnt + 1)



T = int(input())
for test_case in range(1, T + 1):
    D, W, K = map(int, input().split())
    film = []
    tmp = [[0]*W for _ in range(D)]
    paintRow = [0] * D
    ans = 9999999999
    for i in range(D):
        film.append(list(map(int, input().split())))
    dfs(0, 0)
    print(f'#{test_case} {ans}')
