package net.devstudy.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Model implements Serializable {
	private List<String> list = Arrays.asList(new String[] { "first", "second", "third" });

	public List<String> getList() {
		return list;
	}

	public String getData() {
		StringBuilder sb = new StringBuilder();
		for (String item : list) {
			sb.append(item).append(" || ");
		}
		return sb.toString();
	}
}
