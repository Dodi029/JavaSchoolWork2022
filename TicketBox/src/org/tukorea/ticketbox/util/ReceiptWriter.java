package org.tukorea.ticketbox.util;

import java.util.*;
import org.tukorea.ticketbox.payment.Receipt;

public class ReceiptWriter {
	public void printConsole(HashMap<Integer, Receipt> map) {
		Set<Integer> keys = map.keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()) {
			 int id = it.next();
			 Receipt temp = map.get(id);
			 System.out.println(temp.toBackupString());
		}
	}
}
