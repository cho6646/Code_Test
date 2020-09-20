from collections import defaultdict

T = int(input())
di = [1,-1,0,0]
dj = [0,0,1,-1]
change = (
    'dummy',
    (2,0,3,1),
    (1,2,3,0),
    (1,3,0,2),
    (3,0,1,2),
    (1,0,3,2)
)
for test_case in range(1, T + 1):
    N = int(input())
    wormHole = defaultdict(list)
    board = [[5] * (N + 2)]
    for i in range(N):
        a = list(map(int, input().split()))
        board.append([5] + a + [5])
        for j in range(N):
            if a[j] > 5:
                wormHole[a[j]].append((i+1,j+1))

    board.append([5] * (N + 2))
    scores = {}
    maxScore = 0
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if board[i][j] != 0:
                continue
            for d in range(4): # 0 = down, 1 = up, 2 = right, 3 = left
                a,b = i+di[d],j+dj[d]
                # print(a,b,i,j)
                score = 0
                while True:
                    if (a,b) == (i,j) or board[a][b] == -1:
                        break
                    elif 0 < board[a][b] <= 5:
                        d = change[board[a][b]][d]
                        score += 1
                        # print(a,b,i,j,score)
                    elif board[a][b] > 5:
                        # print(a,b,i,j)
                        hole = wormHole[board[a][b]]
                        if (a,b) == hole[0]:
                            a,b = hole[1]
                        else:
                            a,b = hole[0]
                        # print(a, b, i, j)
                    a, b = a+di[d], b+dj[d]
                if maxScore < score:
                    maxScore = score

    print(f'#{test_case} {maxScore}')