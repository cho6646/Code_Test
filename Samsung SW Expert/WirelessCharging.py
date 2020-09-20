from collections import defaultdict
T = int(input())
di = [0, -1, 0, 1, 0]
dj = [0, 0, 1, 0, -1]
for test_case in range(1, T + 1):
    M, A = map(int, input().split())
    userA = list(map(int, input().split()))
    userB = list(map(int, input().split()))
    board = defaultdict(lambda : defaultdict(list))
    userAPoint = [1,1]
    userBPoint = [10,10]
    APs = []
    for i in range(A):
        APs.append(tuple(map(int,input().split())))
    for i in range(1, 11):
        for j in range(1, 11):
            a = board[i][j]
            for k, ap in enumerate(APs):
                x, y, c, p = ap
                if abs(j-x)+abs(i-y) <= c:
                    a.append((p, k))
            a.append((0, -1))
            if len(a) >= 2:
                a.sort(key=lambda x : x[0], reverse=True)
    result = board[1][1][0][0] + board[10][10][0][0]
    for m in range(M):
        userAPoint[0] += di[userA[m]]
        userAPoint[1] += dj[userA[m]]
        userBPoint[0] += di[userB[m]]
        userBPoint[1] += dj[userB[m]]
        a = board[userAPoint[0]][userAPoint[1]]
        b = board[userBPoint[0]][userBPoint[1]]
        if a[0][1] != -1 and a[0][1] == b[0][1]:
            result += max(a[0][0]+b[1][0], b[0][0]+a[1][0])
        else:
            result += a[0][0] + b[0][0]
    print(f'#{test_case} {result}')