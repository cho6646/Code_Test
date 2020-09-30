def solution():
    N, L = map(int, input().split())
    m = []
    for i in range(N):
        m.append(list(map(int, input().split())))
    res = 0
    for i in range(N):
        downOrUp = 0
        continued = 1
        now = m[i][0]
        for j in range(1, N):
            if m[i][j] == now:
                continued += 1
            elif m[i][j] > now:
                if m[i][j] - now > 1:
                    break
                if continued < L:
                    break
                if downOrUp == -1 and continued < 2 * L:
                    break
                continued = 1
                downOrUp = 1
            else:
                if now - m[i][j] > 1:
                    break
                if downOrUp == -1 and continued < L:
                    break
                continued = 1
                downOrUp = -1
            now = m[i][j]
        else:
            if downOrUp == -1:
                if continued >= L:
                    res += 1
            else:
                res += 1
    for i in range(N):
        downOrUp = 0
        continued = 1
        now = m[0][i]
        for j in range(1, N):
            if m[j][i] == now:
                continued += 1
            elif m[j][i] > now:
                if m[j][i] - now > 1:
                    break
                if continued < L:
                    break
                if downOrUp == -1 and continued < 2 * L:
                    break
                continued = 1
                downOrUp = 1
            else:
                if now - m[j][i] > 1:
                    break
                if downOrUp == -1 and continued < L:
                    break
                continued = 1
                downOrUp = -1
            now = m[j][i]
        else:
            if downOrUp == -1:
                if continued >= L:
                    res += 1
            else:
                res += 1
    print(res)


if __name__ == '__main__':
    solution()
