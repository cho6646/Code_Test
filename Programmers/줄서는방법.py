def solution(n, k):
    def factorial(num):
        if num in fac:
            return fac[num]
        fac[num] = num * factorial(num-1)
        return fac[num]
    fac = {0:1, 1:1, 2:2}
    ls = list(range(1,n+1))
    res = []
    k-=1
    while ls:
        print(len(ls))
        a = k // factorial(len(ls)-1)
        res.append(ls[a])
        k %= factorial(len(ls)-1)
        ls = ls[:a]+ls[a+1:]
    return res

print(solution(20,100))