// 블록 단위로 바이너리 파일 고속 복사 
// 예제 8-10을 10Kb 단위로 읽고 쓰도록 수정하여 고속으로 파일을 복사 
import java.io.*;

public class BlockBinaryCopyEx {
	public static void main(String[] args) {
		File src = new File("/Users/doyoung/Downloads/Unknown.jpg");
		File dest = new File("/Users/doyoung/Downloads/Unknown_Copy2.jpg");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			byte[] buf = new byte [1024*10];			// 10Kb 버퍼 
			while (true) {
				int n = fi.read(buf);					// 버퍼 크기만큼 읽기. n은 실제 읽은 바이트 
				fo.write(buf, 0, n);					// buf[0] 부터 n바이트 쓰기 
				if(n < buf.length)
					break;
			}
				fi.close();
				fo.close();
				System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다. ");
			} catch(IOException e) {
				System.out.println("파일 복사 오류 ");
			}
		}
}


