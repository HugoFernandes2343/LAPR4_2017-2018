package eapli.framework.dto;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by nuno on 28/02/17.
 */
public class SyntheticFieldCounter {

	/*public int countNonSyntheticFields(Object object) {
		int nonSyntheticFieldCount = 0;

		Class<?> c = null;
		try {
			c = Class.forName(object.getClass().getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Field[] flds = c.getDeclaredFields();
		for (Field f : flds) {
			System.out.println("Field Name:" + f.getName());
			if (!"$jacocoData".equals(f.getName())) {
				nonSyntheticFieldCount++;
			}
		}

		System.out.println("nonSyntheticFieldCount:" + nonSyntheticFieldCount);
		return nonSyntheticFieldCount;
	}*/

	public int countNonSyntheticElements(Map<String, Object> map) {
		int nonSyntheticFieldCount = 0;

		for (final Map.Entry<String, Object> e : map.entrySet()) {
			if (!"$jacocoData".equals(e.getKey())) {
				System.out.println("[" + e.getKey() + "] => [" + e.getValue() + "]");
				nonSyntheticFieldCount++;
			}
		}
		return nonSyntheticFieldCount;
	}
}
