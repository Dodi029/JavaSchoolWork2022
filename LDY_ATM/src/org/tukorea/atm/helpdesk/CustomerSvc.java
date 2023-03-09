package org.tukorea.atm.helpdesk;

import java.util.Scanner;

import org.tukorea.atm.bank.Account;

public class CustomerSvc {					
   private Account customer;
   public CustomerSvc(Account[] acctArray, int currentAccNum) {  // 생성자
      for (int i = 0; i < acctArray.length; i++) {				// 고객의 수 (배열의 수)만큼 반복 
         if (acctArray[i].getAccountId() == currentAccNum) {	
            customer = acctArray[i];
            break;
         }
      }
   }
   public void updatePasswdReq() {     // 비밀번호 변경 메소드 
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("기존 비밀번호 입력: ");
      String oldPasswd = scanner.nextLine();			// 기존 비밀 번호를 입력받고 oldPasswd	에 저장 
      
      System.out.print("신규 비밀번호 입력: ");
      String newPasswd = scanner.nextLine();			// 새로운 비밀 번호를 입력받고 newPasswd 공간에 저장 
      boolean bool =    customer.updatePasswd(oldPasswd, newPasswd);		// 비밀 번호 변경하는 메소드를 통해 비밀 번호를 변경했다면 
      
      if (bool == true) {
         System.out.println("비밀번호를 수정하였습니다.");			// 변경 성공 했음을 알리는 메시지 출력 
      } else {									// 비밀 변호 변경이 실패했다면 
         System.out.println("입력하신 정보가 없습니다.");			// 비밀 번호 변경에 실패했음을 알리는 메시지 출력 
      }

   }
}