package com.zhenai.exercise.generics;

/**
 * 
 * @author Matthew Yuan
 * 
 */
public class Exercise34 extends selfBoundedType<Exercise34> {

	private String flag;

	public Exercise34(String tag) {
		this.setTag(tag);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exercise34 e = new Exercise34("created from new");
		System.out.println(e.invoke(e));
		e.invoke(e);
	}

	@Override
	Exercise34 get(Exercise34 s) {
		return s;
	}

	public String toString() {
		return this.flag;
	}

	public String getTag() {
		return flag;
	}

	public void setTag(String tag) {
		this.flag = tag;
	}

}

abstract class selfBoundedType<T extends selfBoundedType<T>> {
	abstract T get(T s);

	T invoke(T s) {
		return get(s);
	}
}
