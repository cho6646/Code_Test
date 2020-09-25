def work():
    for l in range(N, 2, -1):
        for i in range(N - l + 1):
            for j in range(N - l + 1):
                for k in range(j + 1, j + l - 1):
                    s = set()
                    dup = False
                    c, r = k, i
                    while c < j + l - 1 and not dup:
                        # print('1',r,c)
                        if m[r][c] in s:
                            dup = True
                            break
                        s.add(m[r][c])
                        c += 1
                        r += 1
                    while r < i + l - 1 and not dup:
                        # print('2', r, c)
                        if m[r][c] in s:
                            dup = True
                            break
                        s.add(m[r][c])
                        c -= 1
                        r += 1
                    while c > j and not dup:
                        # print('3', r, c)
                        if m[r][c] in s:
                            dup = True
                            break
                        s.add(m[r][c])
                        c -= 1
                        r -= 1
                    while r > i and not dup:
                        # print('4', r, c)
                        if m[r][c] in s:
                            dup = True
                            break
                        s.add(m[r][c])
                        c += 1
                        r -= 1
                    if not dup:
                        return len(s)


T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    m = []
    for i in range(N):
        m.append(list(map(int, input().split())))
    ans = work()
    if not ans:
        ans = -1
    print(f'#{test_case} {ans}')
