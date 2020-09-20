def perm(idx, result):
    global mx
    global mn
    if idx == N:
        if result > mx:
            mx = result
        if result < mn:
            mn = result
        return
    for i in range(4):
        if ops[i] > 0:
            ops[i] -= 1
            if i == 0:
                newResult = result + nums[idx]
            elif i == 1:
                newResult = result - nums[idx]
            elif i == 2:
                newResult = result * nums[idx]
            else:
                newResult = int(result / nums[idx])
            perm(idx + 1, newResult)
            ops[i] += 1


T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    ops = list(map(int, input().split()))
    nums = list(map(int, input().split()))
    mx = -9999999999
    mn = 9999999999
    doneOps = {}
    perm(1, nums[0])
    print(f'#{test_case} {mx - mn}')