dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]


def solution():
    N, M = map(int, input().split())
    r, c, d = map(int, input().split())
    m = []
    for i in range(N):
        m.append(list(map(int, input().split())))
    time = 0
    blocked = False
    while not blocked:
        if m[r][c] == 0:
            m[r][c] = 2
            time += 1
        for i in range(3, -1, -1):
            nr = r + dr[(i+d)%4]
            nc = c + dc[(i+d)%4]
            if m[nr][nc] == 0:
                r = nr
                c = nc
                d = (i+d)%4
                break
        else:
            if m[r+dr[(d+2)%4]][c+dc[(d+2)%4]] == 1:
                blocked = True
            else:
                r += dr[(d + 2) % 4]
                c += dc[(d + 2) % 4]
    print(time)


if __name__ == '__main__':
    solution()