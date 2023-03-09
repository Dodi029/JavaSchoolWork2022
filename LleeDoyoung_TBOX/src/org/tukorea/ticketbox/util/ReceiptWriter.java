package org.tukorea.ticketbox.util;

import java.util.*;

import org.tukorea.ticketbox.payment.Receipt;

public class ReceiptWriter {				// 콘솔에 스크린 별 영수증 출력하기 
											// 압둘알리, 시네마 천국, BankTransfer, 048-13-23456, 8000, 0, 8800.0 
	public void printConsole(HashMap<Integer, Receipt> map) {
		Set<Integer> keys = map.keySet();
		Iterator<Integer> it = keys.iterator();
		
		while(it.hasNext()) {
			int reservedId = it.next();
			
			System.out.println(map.get(reservedId).toBackupString());
		}
	}
}
