// FileOutputStream 으로 바이너리 파일 쓰기 
// FileOutputStream을 이용하여 byte [] 배열 속에 들어 있는 바이너라 값을 텍스트 파일에 저장. 이 파일은 바이너리 파일이 되므로 메모장으로 볼 수 없음 

import java.io.*;

public class FileOutputStreamEx {
	public static void main(String [] args) {
		byte b[] = {7, 51, 3, 4, -1, 24};
		
		try {
			FileOutputStream fout = new FileOutputStream("/Users/doyoung/Downloads/Test2.out");
			
			for (int i = 0; i < b.length; i++)
				fout.write(b[i]);
			fout.close();
		} catch(IOException e) {
			System.out.println("/Users/doyoung/Downloads/Test.out에 저장할 수 없습니다. 경로명을 확인해 주세요.");
			return;
		}
		System.out.println(" /Users/doyoung/Downloads/Test.out을 저장하였습니다.");
	}
}
