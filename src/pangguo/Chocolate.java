package pangguo;

public class Chocolate {
	public static long pre(int x) {
		if (x == 0) {
			return 1L;
		} else if (x == 1) {
			return 1L;
		} else {
			return pre(x - 1) + pre(x - 2);
		}
	}

	// start 提示：自动阅卷起始唯一标识，请勿删除或增加。
	public static void main(String args[]) {
		System.out.println(pre(30));
	}
	// end //提示：自动阅卷结束唯一标识，请勿删除或增加。
}
