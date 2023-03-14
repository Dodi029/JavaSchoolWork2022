package org.tukorea.ticketbox.util;

import java.util.*;

import org.tukorea.ticketbox.payment.Receipt;

public class Statistics {
	public static double sum(HashMap<Integer, Receipt> map) {
		Set<Integer> keys = map.keySet();
		Iterator<Integer> it = keys.iterator();
		double total = 0;
		while(it.hasNext()) {
			 int id = it.next();
			 Receipt temp = map.get(id);
			 total += temp.getTotalAmount();
		}
		return total;
	}
}
