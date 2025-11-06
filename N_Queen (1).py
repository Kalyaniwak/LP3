N = int(input("Enter the number of queens: "))
board = [[0]*N for _ in range(N)]
def is_safe(row, col):
    for i in range(N):
        if board[row][i] == 1 or board[i][col] == 1:
            return False
    for i in range(N):
        for j in range(N):
            if (i + j == row + col or i - j == row - col) and board[i][j] == 1:
                return False
    return True
def solve(n):
    if n == 0:
        return True
    for i in range(N):
        for j in range(N):
            if is_safe(i, j) and board[i][j] == 0:
                board[i][j] = 1
                if solve(n - 1):
                    return True
                board[i][j] = 0  # backtrack
    return False
if solve(N):
    for row in board:
        print(row)
else:
    print("No solution")