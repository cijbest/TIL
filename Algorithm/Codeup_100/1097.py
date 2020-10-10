if __name__ == '__main__':
    board = []
    for i in range(1,20):
        board.append(list(map(int,input().split())))

    n = int(input())

    for i in range(n):
        x, y = map(int, input().split())
        for j in range(0, len(board)):
            if board[x-1][j] == 0:
                board[x-1][j] = 1
            else:
                board[x-1][j] = 0
        for j in range(0, len(board)):
            if board[j][y-1] == 0:
                board[j][y-1] = 1
            else:
                board[j][y-1] = 0

    for i in range(len(board)):
        for j in range(len(board)):
            print(board[i][j], end=' ')
        print()   