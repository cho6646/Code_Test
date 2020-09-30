def solution():
    N, M, X, Y, K = map(int, input().split())
    dice = [0, 0, 0, 0, 0, 0] # top, bottom, up, down, left, right
    m = []
    for i in range(N):
        m.append(list(map(int, input().split())))
    order = list(map(int, input().split()))
    pos = [X, Y]
    dice[1] = m[X][Y]
    m[X][Y] = 0
    for o in order:
        if o == 1:
            if pos[1] < M-1:
                pos[1] += 1
                dice = [dice[4], dice[5], dice[2], dice[3], dice[1], dice[0]]
                print(dice[0])
                if m[pos[0]][pos[1]] != 0:
                    dice[1] = m[pos[0]][pos[1]]
                    m[pos[0]][pos[1]] = 0
                else:
                    m[pos[0]][pos[1]] = dice[1]
        elif o == 2:
            if pos[1] > 0:
                pos[1] -= 1
                dice = [dice[5], dice[4], dice[2], dice[3], dice[0], dice[1]]
                print(dice[0])
                if m[pos[0]][pos[1]] != 0:
                    dice[1] = m[pos[0]][pos[1]]
                    m[pos[0]][pos[1]] = 0
                else:
                    m[pos[0]][pos[1]] = dice[1]
        elif o == 3:
            if pos[0] > 0:
                pos[0] -= 1
                dice = [dice[3], dice[2], dice[0], dice[1], dice[4], dice[5]]
                print(dice[0])
                if m[pos[0]][pos[1]] != 0:
                    dice[1] = m[pos[0]][pos[1]]
                    m[pos[0]][pos[1]] = 0
                else:
                    m[pos[0]][pos[1]] = dice[1]
        else:
            if pos[0] < N-1:
                pos[0] += 1
                dice = [dice[2], dice[3], dice[1], dice[0], dice[4], dice[5]]
                print(dice[0])
                if m[pos[0]][pos[1]] != 0:
                    dice[1] = m[pos[0]][pos[1]]
                    m[pos[0]][pos[1]] = 0
                else:
                    m[pos[0]][pos[1]] = dice[1]
                    

if __name__ == '__main__':
    solution()