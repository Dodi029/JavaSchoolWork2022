package org.tukorea.ticketbox.util;

import java.util.*;

import org.tukorea.ticketbox.payment.Receipt;

public class Statistics {			// 스크린 별 결제 금액 총액 계산 
	public static double sum(HashMap<Integer, Receipt> map) {
		Set<Integer> keys = map.keySet();
		Iterator<Integer> it = keys.iterator();
		
		double total = 0;
		
		while(it.hasNext()) {
			int reservedId = it.next();
			Receipt temp = map.get(reservedId);
			total += temp.getTotalAmount();
		}
		
		return total;
	}
}
