from collections import deque

di = [-1, 1, 0, 0]
dj = [0, 0, -1, 1]

def solution():
    N = int(input())
    K = int(input())
    apples = []
    for i in range(K):
        apples.append(tuple(map(int, input().split())))

    m = [[-1]*(N+2)] + [([-1]+[0]*N+[-1]) for _ in range(N)] + [[-1]*(N+2)]
    for ai,aj in apples:
        m[ai][aj] = 1
    L = int(input())
    dirChange = deque()
    for i in range(L):
        dirChange.append(input().split())
        dirChange[i][0] = int(dirChange[i][0])
    time = 0
    d = 3 # up, down, left, right
    snake = deque()
    snake.append((1,1))
    m[1][1] = 2
    while True:
        time += 1
        i, j = snake[-1]
        ni, nj = i+di[d], j+dj[d]
        if m[ni][nj] == -1 or m[ni][nj] == 2:
            return time
        snake.append((ni,nj))
        if m[ni][nj] == 0:
            pi, pj = snake.popleft()
            m[pi][pj] = 0
        m[ni][nj] = 2
        if dirChange and dirChange[0][0] == time:
            change = dirChange.popleft()[1]
            if d == 0:
                if change == 'L':
                    d = 2
                else:
                    d = 3
            elif d == 1:
                if change == 'L':
                    d = 3
                else:
                    d = 2
            elif d == 2:
                if change == 'L':
                    d = 1
                else:
                    d = 0
            else:
                if change == 'L':
                    d = 0
                else:
                    d = 1


if __name__ == '__main__':
    print(solution())