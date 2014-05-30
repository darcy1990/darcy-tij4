//: net/mindview/util/EnumSets.java
package net.mindview.util;

import static generics.watercolors.Watercolors.BRILLIANT_RED;
import static generics.watercolors.Watercolors.BURNT_UMBER;
import static generics.watercolors.Watercolors.CERULEAN_BLUE_HUE;
import static generics.watercolors.Watercolors.VIRIDIAN_HUE;
import static net.mindview.util.Print.print;
import generics.watercolors.Watercolors;

import java.util.*;

/**
 * Exercise17
 * @author zhongming.yuan
 * @date 2014-1-18
 */
public class EnumSets {
	public static <T extends Enum<T>> EnumSet<T> union(EnumSet<T> a, EnumSet<T> b) {
//		EnumSet<T> result = new HashEnumSet<T>(a);
		EnumSet<T> result = a.clone();
		result.addAll(b);
		return result;
	}

	public static <T extends Enum<T>> EnumSet<T> intersection(EnumSet<T> a, EnumSet<T> b) {
		EnumSet<T> result = a.clone();
		result.retainAll(b);
		return result;
	}

	// Subtract subEnumSet from superEnumSet:
	public static <T extends Enum<T>> EnumSet<T> difference(EnumSet<T> superEnumSet, EnumSet<T> subEnumSet) {
		EnumSet<T> result = superEnumSet.clone();
		result.removeAll(subEnumSet);
		return result;
	}

	// Reflexive--everything not in the intersection:
	public static <T extends Enum<T>> EnumSet<T> complement(EnumSet<T> a, EnumSet<T> b) {
		return difference(union(a, b), intersection(a, b));
	}
	
	public static void main(String[] args) {
		EnumSet<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
		EnumSet<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
		print("set1: " + set1);
		print("set2: " + set2);
		print("union(set1, set2): " + union(set1, set2));
		EnumSet<Watercolors> subset = intersection(set1, set2);
		print("intersection(set1, set2): " + subset);
		print("difference(set1, subset): " + difference(set1, subset));
		print("difference(set2, subset): " + difference(set2, subset));
		print("complement(set1, set2): " + complement(set1, set2));
	}
} // /:~
