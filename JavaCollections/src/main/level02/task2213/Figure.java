package level02.task2213;

public class Figure {
	
	private int x;
	private int y;
	private int[][] matrix;
	
	public Figure(int x, int y, int[][] matrix) {
		this.x = x;
		this.y = y;
		this.matrix = matrix;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int[][] getMatrix() {
		return matrix;
	}
	
	public void left() {
		x--;
		if (!isCurrentPositionAvailable()) {
			x++;
		}
	}
	
	public void right() {
		x++;
		if (!isCurrentPositionAvailable()) {
			x--;
		}
	}
	
	public void down() {
		y++;
		if (!isCurrentPositionAvailable()) {
			y--;
		}
	}
	
	public void up() {
		y--;
		if (!isCurrentPositionAvailable()) {
			y++;
		}
	}
	
	public void rotate() {
		int[][] matrix2 = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix2[i][j] = matrix[j][i];
			}
		}
		
		matrix = matrix2;
	}
	
	public void downMaximum() {
		while (isCurrentPositionAvailable()) {
			y++;
		}
		
		y--;
	}
	
	public boolean isCurrentPositionAvailable() {
		Field field = Tetris.game.getField();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrix[i][j] == 1) {
					if (y + i >= field.getHeight())
						return false;
					
					Integer value = field.getValue(x + j, y + i);
					if (value == null || value == 1)
						return false;
				}
			}
		}
		
		return true;
	}
	
	public void landed() {
		Field field = Tetris.game.getField();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrix[i][j] == 1)
					field.setValue(x + j, y + i, 1);
			}
		}
	}
	
}
