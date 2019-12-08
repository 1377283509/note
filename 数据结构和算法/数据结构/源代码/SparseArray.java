package array;
import java.util.Arrays;
public class SparseArray {
	public static void main(String[] args) {
		//	创建二维数组
		int[][] array = new int[6][7];
		// 写入数据
		array[0][3] = 22;
		array[0][6] = 15;
		array[1][1] = 11;
		array[1][5] = 17;
		array[2][3] = -6;
		array[3][5] = 39;
		array[4][0] = 91;
		array[5][2] = 28;
		
		System.out.println("原二维数组");
		showArray(array);
		System.out.println("二维数组转换后的稀疏数组");
		int[][] sparseArray = toSparseArray(array,6,7);
		showArray(sparseArray);
		System.out.println("稀疏数组转换后的二维数组");
		showArray(toArray(sparseArray));
	}
	
	public static int getNumOfVal(int[][] array, int row,int col) {
		int sum = 0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(array[i][j]!=0) {
					sum++;
				}
			}
		}
		return sum;
	}
	
	// 将二维数组转换为稀疏数组
	public static int[][] toSparseArray(int[][] array, int row,int col){
		int sum = getNumOfVal(array,row,col);
		int[][] sparseArray = new int[sum+1][3];
		// 首行存入二维数组的基本信息
		sparseArray[0][0] = row;
		sparseArray[0][1] = col;
		sparseArray[0][2] = sum;
		int count=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(array[i][j]!=0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = array[i][j];
				}
			}
		}
		return sparseArray;
	}
	
	// 将稀疏数组转换为二维数组
	public static int[][] toArray(int[][] sparseArray){
		int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];
		for(int j=1;j<=sparseArray[0][2];j++) {
			array[sparseArray[j][0]][sparseArray[j][1]] = sparseArray[j][2];
		}
		return array;
	}
	
	// 输出数组
	public static void showArray(int[][] array) {
		for(int[] link:array) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	
}
