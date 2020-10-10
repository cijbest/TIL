if __name__ == '__main__':
    # 미로의 크기(10 * 10)
    board = []
    for i in range(1,11):
        board.append(list(map(int, input().split())))

    # 출발 위치 (2, 2)
    x = 1
    y = 1
    
    # 개미가 이동한 경로를 9로 표시
    # 오른쪽으로 갈 수 있으면 가고 없으면 아래로
    while board[x][y] != 2:
        board[x][y] = 9
        if (board[x][y+1] == 1 and board[x+1][y] == 1) or (x == 8 and y == 8):
            break
        if board[x][y+1] == 0 or board[x][y+1] == 2:
            y += 1
        elif board[x+1][y] == 0 or board[x+1][y] == 2:
            x += 1
    board[x][y] = 9
        
    for i in range(0, len(board)):
        for j in range(0, len(board[0])):
            print(board[i][j], end=' ')
        print()