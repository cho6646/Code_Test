def dfs(num, c):
    global cost
    if c > cost:
        return
    if num >= 12:
        if c < cost:
            cost = c
        return
    if not plan[num]:
        dfs(num+1, c)
        return
    dfs(num + 1, c + plan[num] * one)
    dfs(num + 1, c + month)
    dfs(num + 3, c + three_month)


T = int(input())
for test_case in range(1, T + 1):
    one, month, three_month, year = map(int, input().split())
    plan = list(map(int, input().split()))
    cost = year
    dfs(0, 0)
    print(f'#{test_case} {cost}')