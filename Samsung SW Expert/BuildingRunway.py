T = int(input())

for test_case in range(1, T + 1):
    N, X = map(int, input().split())
    m = []
    for i in range(N):
        m.append(list(map(int, input().split())))
    result = 0
    for i in range(N):
        flat = 0
        a = 0
        upOrDown = 'a'
        no = False
        for j in range(N):
            if a != 0 and m[i][j] != a:
                if abs(m[i][j] - a) > 1:
                    no = True
                    break
                if upOrDown == 'd' and flat < X:
                    no = True
                    break
                if m[i][j] > a:
                    if upOrDown != 'd' and flat < X or upOrDown == 'd' and flat < 2 * X:
                        no = True
                        break
                    upOrDown = 'u'
                if m[i][j] < a:
                    upOrDown = 'd'
                flat = 0
            flat += 1
            a = m[i][j]
        if not no:
            if upOrDown == 'd' and flat < X:
                continue
            result += 1
    for i in range(N):
        flat = 0
        a = 0
        upOrDown = 'a'
        no = False
        for j in range(N):
            if a != 0 and m[j][i] != a:
                if abs(m[j][i] - a) > 1:
                    no = True
                    break
                if upOrDown == 'd' and flat < X:
                    no = True
                    break
                if m[j][i] > a:
                    if upOrDown != 'd' and flat < X or upOrDown == 'd' and flat < 2 * X:
                        no = True
                        break
                    upOrDown = 'u'
                if m[j][i] < a:
                    upOrDown = 'd'
                flat = 0
            flat += 1
            a = m[j][i]
        if not no:
            if upOrDown == 'd' and flat < X:
                continue
            result += 1

    print(f'#{test_case} {result}')
