package co.edu.uptc.fligths.view.output;

import java.util.Iterator;
import java.util.List;

public class OutputData {
	public static <E> void  showList(List<E> list) {
		System.out.println("====== List =====");
		for (Iterator<E> iterator = list.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next().toString());
		}
		System.out.println("===== End list ====");
	}
}
