if __name__ == '__main__':
    n = int(input())

    board = [[0 for i in range(20)] for i in range(20)]
    
    for i in range(n):
        x, y = map(int, input().split())
        board[x][y] = 1

    for i in range(1,len(board)):
        for j in range(1, len(board[1])):
            print(board[i][j], end=' ')
        print()
