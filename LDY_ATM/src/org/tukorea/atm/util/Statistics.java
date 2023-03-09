package org.tukorea.atm.util;

import org.tukorea.atm.bank.Account;

public class Statistics {
	
   public static int sum(Account[] account, int size) {			// 잔액의 총액 계산 메소드 
      int total = 0;											// 값 초기화 
      for(int i = 0; i < size; i++) {							// 계좌 수만큼 반복 
         total += account[i].getBalance();						// 잔액을 계속 더하고 이를 저장 
      }
      return total;												// 모두 더한 값을 리턴 
   }
   
   public static double avg(Account[] account, int size) {		// 잔액 평균을 구하는 메소드 
      double avg = sum(account, size) / size;					// 잔액 총액에 계좌 수만큼 나눠 평균 구하기 
      return avg;												// 평균 리턴 
   }
   
   public static int max(Account[] account, int size) {			// 최고 잔액 구하는 메소드 
      int biggest = account[0].getBalance();					// 제일 큰 값을 저장할 공간 
      for(int i = 0; i < size; i++) {							// 계좌 수만큼 저장 
         if(account[i].getBalance() > biggest)					// 계좌 비교해가며 제일 큰 값 저장 
            biggest = account[i].getBalance();					
      }
      return biggest;											// 가장 큰 잔액을 리턴 
   }
   
   public static Account[] array(Account[] account, int size) {			// 계좌 배열 생성 
      Account temp = new Account(0, 0, "0", "0");						// 일시적으로 저장할 공간 선언 
      for(int i = 0; i < size-1; i++) {									// 계좌 수 만큼 반복 
         for(int j = i+1; j < size; j++) {								
            if(account[i].getBalance() < account[j].getBalance()) {
            	
               temp = account[i];
               account[i] = account[j];
               account[j] = temp;
            }
         }
      }
         return account;
   }
}