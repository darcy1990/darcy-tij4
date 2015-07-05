package com.zhenai.exercise.containers;

import java.util.ArrayList;
import java.util.Collections;

import net.mindview.util.Countries;
import net.mindview.util.Print;

/**
 * 
 * @author Matthew Yuan
 * 
 */
public class Exiercise1 {
	ArrayList<String> a = new ArrayList<String>(Countries.names(6));

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>(Countries.names(6));
		Collections.sort(a);
		Print.print(a);
		Collections.shuffle(a);
		Print.print(a);
		Collections.shuffle(a);
		Print.print(a);
		Collections.shuffle(a);
		Print.print(a);
	}
}
