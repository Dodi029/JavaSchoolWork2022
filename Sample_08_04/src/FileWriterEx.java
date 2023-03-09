// 키보드 입력을 파일로 저장하기 
// Scanner를 이용하여 키보드에서 입력받은 데이터를 텍스트 파일에 저장하는 프로그램을 작성하라 

import java.io.*;
import java.util.*;

public class FileWriterEx {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("/Users/doyoung/Downloads/Test.txt");
			while(true) {
				String line = scanner.nextLine();
				if(line.length() == 0)
					break;
				
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();
		} catch(IOException e) {
			System.out.println(" 입출력 오류 ");
		}
		scanner.close();
	}
}
