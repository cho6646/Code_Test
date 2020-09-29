def solution():
    N = int(input())
    A = list(map(int, input().split()))
    B, C = map(int, input().split())
    num = N
    for i in range(len(A)-1, -1, -1):
        A[i] -= B
        if A[i] <= 0:
            A.pop(i)
    for a in A:
        num += a // C + (1 if a % C > 0 else 0)

    return num


if __name__ == '__main__':
    print(solution())