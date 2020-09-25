def solution(a):
    def nCr(n, r):
        if combi[n][r] != -1:
            return combi[n][r]
        if n < r:
            combi[n][r] = 0
            return 0
        if n == r or r == 0:
            combi[n][r] = 1
            return 1
        combi[n][r] = (nCr(n - 1, r - 1) + nCr(n - 1, r)) % mod
        return combi[n][r]

    combi = [[-1] * 301 for _ in range(301)]
    mod = 10 ** 7 + 19
    row = len(a)
    col = len(a[0])
    dp = [[0] * (row + 1) for _ in range(col)]
    s = [0] * col
    for i in range(row):
        for j in range(col):
            s[j] += a[i][j]
    dp[0][row - s[0]] = nCr(row, s[0])

    for i in range(1, col):
        cnt = s[i]
        for num in range(row + 1):
            for k in range(cnt + 1):
                a = num + cnt - 2 * k
                if cnt < k or a > row or a < 0:
                    continue
                print(row-num, cnt-k, nCr(row-num, cnt-k))
                mul = (nCr(num, k) * nCr(row - num, cnt - k)) % mod
                dp[i][a] += (dp[i - 1][num] * mul) % mod
                dp[i][a] %= mod

    return dp[col - 1][row]

print(solution([[0,1,0],[1,1,1],[1,1,0],[0,1,1]]))
# print(solution([[1,0,0],[1,0,0]]))