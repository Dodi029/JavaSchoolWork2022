// File 클래스 활용한 파일 관리 
// File 클래스를 이용하여 파일의 타입을 알아내고, 디렉토리에 있는 파일들을 나열하며, 디렉토리 이름을 변경하는 프로그램을 작성하라 

import java.io.File;

public class FileEx {
	public static void listDirectory(File dir) {
		System.out.println("-----" + dir.getPath() + "의 서브 리스트입니다.-----");
		File[] subFiles = dir.listFiles();
		for(int i = 0; i < subFiles.length; i++) {
			File f = subFiles[i];
			long t = f.lastModified();
			System.out.println(f.getName());
			System.out.print("\t파일 크기 : " + f.length());
			System.out.printf("\t수정한 시간 : %tb %td %ta %tT\n", t, t, t, t );
		}
	}
	
	public static void main(String[] args) {
		File f1 = new File("/Users/doyoung/Downloads/system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
		
		String res = "";
		if (f1.isFile()) res = "파일 ";
		else if(f1.isDirectory()) res = "디렉토리 ";
		System.out.println(f1.getPath() + "은 " + res + " 입니다. ");
		
		File f2 = new File("/Users/doyoung/Downloads/Test_Sample");
		if (f2.exists()) {
			f2.mkdir(); 			// 존재하지 않으면 데릭토리 생성 
		}
		listDirectory(new File("/Users/doyoung/Downloads"));
		f2.renameTo(new File("/Users/doyoung/Downloads/TestSample"));
		listDirectory(new File("/Users/doyoung/Downloads"));
	}
}
