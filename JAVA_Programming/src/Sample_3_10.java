// 2차원 배열로 년 평점 구하기 - 2차원 배열에 학년별로 1, 2학기 성적을 저장하고, 4년간 전체 평점 평균을 출력 

public class Sample_3_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double score [][] = {{3.3, 3.4}, {3.5, 3.6}, {3.7, 4.0}, {4.1, 4.2}};
							// 1, 2, 3, 4학년 1,2 학기 평점 
		
		double sum = 0;
		for(int year = 0; year < score.length; year++)				// 각 학년별로 반
			for(int term = 0; term < score[year].length; term++)	// 각 학년의 학기별로 반
				sum += score[year][term];
		
		int n = score.length;										// 배열의 행 개수, 4
		int m = score[0].length;									// 배열의 열 개수, 2
		System.out.println("4년 전체 평점 평균은 " + sum/(n*m));

	}

}
