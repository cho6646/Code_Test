from itertools import product

di = [-1, 0, 1, 0]
dj = [0, 1, 0, -1]

def solution():
    N, M = map(int, input().split())
    m = []
    cctv = []
    fives = []
    for i in range(N):
        m.append(input().split())
        for j in range(M):
            if m[i][j] == '5':
                fives.append((i, j))
            if m[i][j] in {'1','2','3','4'}:
                cctv.append((i, j, m[i][j]))
    numOfZero = 0
    for i in range(N):
        numOfZero += m[i].count('0')
    mn = numOfZero
    if fives:
        for i, j in fives:
            for k in range(4):
                ni, nj = i+di[k], j+dj[k]
                while 0 <= ni < N and 0 <= nj < M and m[ni][nj] != '6':
                    m[ni][nj] = '#'
                    ni, nj = ni + di[k], nj + dj[k]
        numOfZero = 0
        for i in range(N):
            numOfZero += m[i].count('0')
        mn = numOfZero
    if cctv:
        for order in product(range(4), repeat=len(cctv)):
            nm = []
            for i in range(N):
                nm.append(m[i][:])
            for idx, v in enumerate(cctv):
                i, j, t = v
                o = order[idx]
                if t == '1':
                    d = [(1+o)%4]
                elif t == '2':
                    d = [(3+o)%4, (1+o)%4]
                elif t == '3':
                    d = [o%4, (1+o)%4]
                else:
                    d = [(3+o)%4, o%4, (1+o)%4]
                for k in d:
                    ni, nj = i + di[k], j + dj[k]
                    while 0 <= ni < N and 0 <= nj < M and m[ni][nj] != '6':
                        nm[ni][nj] = '#'
                        ni, nj = ni + di[k], nj + dj[k]
            numOfZeros = 0
            for i in range(N):
                numOfZeros += nm[i].count('0')
            mn = min(mn, numOfZeros)
    print(mn)


if __name__ == '__main__':
    solution()