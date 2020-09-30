def dfs(num, p):
    global profit
    if num > N:
        return
    if num == N:
        if profit < p:
            profit = p
        return
    dfs(num + 1, p)
    dfs(num + schedule[num][0], p + schedule[num][1])


if __name__ == '__main__':
    N = int(input())
    schedule = []
    for i in range(N):
        schedule.append(list(map(int, input().split())))
    profit = 0
    dfs(0, 0)
    print(profit)