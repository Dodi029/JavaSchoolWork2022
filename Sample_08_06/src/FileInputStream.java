// FileInputStream으로 바이너리 파일 읽기 
// FileInputStream을 이용하여 텍스트 파일을 읽어 byte[] 배열 속에 저장하고 화면에 출력 

import java.io.*;

public class FileInputStream {
	public static void main(String[] args) {
		byte b[] = new byte[6];
		try {
			FileInputStream fin = new FileInputStream("/Users/doyoung/Downloads/Test2.out");
			int n = 0, c;
			while((c = fin.read()) != -1) {
				b[n] = (byte)c;
				n++;
			}
			System.out.println("/Users/doyoung/Downloads/Test.out에서 읽은 배열을 출력합니다. ");
			for (int i = 0; i < b.length; i++)
				System.out.println(b[i] + " ");
			System.out.println(" ");
			fin.close();
		} catch(IOException e) {
			System.out.println("/Users/doyoung/Downloads/Test2.out에서 읽지 못했습니다. 경로명을 확인해주세요. ");
		}
	}
}
