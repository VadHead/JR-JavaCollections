package level02.task2213;

import java.util.ArrayList;
import java.util.Arrays;


public class Field {
	
	private int width;
	private int height;
	private int[][] matrix;
	
	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		matrix = new int[height][width];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int[][] getMatrix() {
		return matrix;
	}
	
	public void print() {
		//Создаем массив, куда будем "рисовать" текущее состояние игры
		int[][] canvas = new int[height][width];
		
		//Копируем "матрицу поля" в массив
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				canvas[i][j] = matrix[i][j];
			}
		}
		
		//Копируем фигурку в массив, только непустые клетки
		int left = Tetris.game.getFigure().getX();
		int top = Tetris.game.getFigure().getY();
		int[][] brickMatrix = Tetris.game.getFigure().getMatrix();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (top + i >= height || left + j >= width) continue;
				if (brickMatrix[i][j] == 1)
					canvas[top + i][left + j] = 2;
			}
		}
		
		
		//Выводим "нарисованное" на экран, но начинаем с "границы кадра".
		System.out.println("---------------------------------------------------------------------------\n");
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int index = canvas[i][j];
				if (index == 0)
					System.out.print(" . ");
				else if (index == 1)
					System.out.print(" X ");
				else if (index == 2)
					System.out.print(" X ");
				else
					System.out.print("???");
			}
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println();
	}
	
	public void removeFullLines() {
		ArrayList<int[]> lines = new ArrayList<>();
		int sum;
		for (int i = 0; i < height; i++) {
			sum = (int) Arrays.stream(matrix[i]).filter(s -> s != 0).count();
			System.out.println(sum);
			if (sum < width) {
				lines.add(matrix[i]);
			}
		}
		for (int i = lines.size(); i < height; i++) {
			lines.add(0, new int[width]);
		}
		for (int i = 0; i < height; i++) {
			matrix[i] = lines.get(i);
		}
	}
	
	public void removeFullLinesMyVariant() {
		int rowElementsCount = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (matrix[i][j] != 0) {
					rowElementsCount++;
				}
			}
			if (rowElementsCount == width) {
				for (int r = i; r > 0; r--) {
					matrix[r] = matrix[r - 1];
				}
				matrix[0] = new int[width];
			}
			rowElementsCount = 0;
		}
	}
	
	public Integer getValue(int x, int y) {
		if (x >= 0 && x < width && y >= 0 && y < height)
			return matrix[y][x];
		
		return null;
	}
	
	public void setValue(int x, int y, int value) {
		if (x >= 0 && x < width && y >= 0 && y < height)
			matrix[y][x] = value;
	}
	
}
