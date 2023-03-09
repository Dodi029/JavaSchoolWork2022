// 바이너리 파일 복사 
// 바이트 스트림을 이용하여 바이널 ㅣ파일을 복사하는 프로그램을 작성 

import java.io.*;

public class BinaryCopyEx {
	public static void main(String [] args) {
		File src = new File("/Users/doyoung/Downloads/Unknown.jpg");
		File dest = new File("/Users/doyoung/Downloads/Unknown_Copy.jpg");
		// File src = new File("/Users/doyoung/Downloads/ToyotaCorolla.txt");				// 텍스트 파일도 정상 실행 
		// File dest = new File("/Users/doyoung/Downloads/ToyotaCorolla_Copy.txt");			// 텍스트 파일도 정상 실행 
		int c;
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			while((c = fi.read()) != -1) {
				fo.write((byte)c);
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다. ");
		} catch(IOException e) {
			System.out.println("파일 복사 오류 ");
		}
	}
}
