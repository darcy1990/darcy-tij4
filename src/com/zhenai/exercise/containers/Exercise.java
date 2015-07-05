package com.zhenai.exercise.containers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import net.mindview.util.Countries;

public class Exercise {

	public static void main(String[] args) {
		Set<String> hs = new HashSet<String>(Countries.names(25));
		Set<String> ls = new LinkedHashSet<String>(Countries.names(25));
		Set<String> ts = new TreeSet<String>(Countries.names(25));
	}

	private boolean isRepeat(Set s) {
		boolean isRepeat = false;
		Iterator i = s.iterator();
		if (i.hasNext()) {
			// TODO
		}
		return isRepeat;
	}
}
