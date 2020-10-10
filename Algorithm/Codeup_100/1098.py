if __name__ == '__main__':
    # 세로(h), 가로(w)
    h, w = map(int, input().split())
    board = [[0 for i in range(w+1)] for i in range(h+1)]
    # 막대의 개수(n)
    n = int(input())
    # 각 막대의 길이(l), 방향(d => 0 또는 1), 좌표(x, y)
    for i in range(n):
        l, d, x, y = map(int, input().split())
        cnt = 0
        # 가로로 누운 경우
        if d == 0:
            for ll in range(l):
                board[x][y+cnt] += 1
                cnt += 1
        # 세로로 누운 경우
        else :
            for ll in range(l):
                board[x+cnt][y] += 1
                cnt += 1

    # 결과
    for i in range(1, h+1):
        for j in range(1, w+1):
            print(board[i][j], end=' ')
        print()