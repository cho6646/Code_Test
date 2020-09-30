m = []
for i in range(4):
    m.append(list(map(int, list(input()))))

K = int(input())

p = [0, 0, 0, 0]
for i in range(K):
    o, d = map(int, input().split())
    if o == 1:
        if m[0][p[0]+2] != m[1][p[1]-2]:
            if m[1][p[1]+2] != m[2][p[2]-2]:
                if m[2][p[2]+2] != m[3][p[3]-2]:
                    p[3] += d
                p[2] -= d
            p[1] += d
        p[0] -= d
    elif o == 2:
        if m[1][p[1] + 2] != m[2][p[2] - 2]:
            if m[2][p[2] + 2] != m[3][p[3] - 2]:
                p[3] -= d
            p[2] += d
        if m[0][p[0]+2] != m[1][p[1]-2]:
            p[0] += d
        p[1] -= d
    elif o == 3:
        if m[2][p[2] + 2] != m[3][p[3] - 2]:
            p[3] += d
        if m[1][p[1] + 2] != m[2][p[2] - 2]:
            if m[0][p[0]+2] != m[1][p[1]-2]:
                p[0] -= d
            p[1] += d
        p[2] -= d
    else:
        if m[2][p[2] + 2] != m[3][p[3] - 2]:
            if m[1][p[1] + 2] != m[2][p[2] - 2]:
                if m[0][p[0] + 2] != m[1][p[1] - 2]:
                    p[0] += d
                p[1] -= d
            p[2] += d
        p[3] -= d
    for j in range(4):
        if p[j] < -6:
            p[j] += 8
        if p[j] >= 6:
            p[j] -= 8
result = m[0][p[0]] + 2 * m[1][p[1]] + 4 * m[2][p[2]] + 8 * m[3][p[3]]
print(result)