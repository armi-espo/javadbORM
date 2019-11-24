package it.jac.javadb.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import it.jac.javadb.entity.Item;

public class Utils {

	public static void stampaLista(List<Item> list) {

		StringBuilder sb = new StringBuilder();
		
		sb.append("-----------------------------------------------------------\n");
		for(Item bean : list) {

			sb
			.append("|")
			.append(StringUtils.rightPad(bean.getCode(), 20))
			.append("|")
			.append(StringUtils.rightPad(bean.getName(), 30))
			.append("|")
			.append(StringUtils.rightPad(bean.getDescription(), 50));
			sb.append("\n");
		}
		sb.append("-----------------------------------------------------------");	
		System.out.println(sb.toString());
		
	}

}
