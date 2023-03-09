// 텍스트 파일 복사 
// 문자 스트림 FileReader와 FileWriter를 이용하여 c:\windows\system.ini를 c:\temp\system.txt 파일로 복사하는 프로그램을 작성 

import java.io.*;

public class TextCopyEx {
	public static void main(String [] args) {
		File src = new File("/Users/doyoung/Downloads/ToyotaCorolla.txt");		// 원본 파일 경로명 
		File dest = new File("/Users/doyoung/Downloads/ToyotaCorolla.txt");		// 복사 파일 경로명 
		// File src = new File("/Users/doyoung/Downloads/Unknown.jpg");			// 바이너리 파일은 오류 발생 
		// File dest = new File("/Users/doyoung/Downloads/Unknown_Copy.jpg");	// 바이너리 파일은 오류 발생 
		int c;
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(dest);
			while((c = fr.read()) != -1) {					// 문자 하나 읽고 
				fw.write((char)c);							// 문자 하나 쓰고 
			}
			fr.close();
			fw.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다. " );
		} catch(IOException e) {
			System.out.println("파일 복사 오류 ");
		}
	}
}
