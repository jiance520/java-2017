package 第二章实用类.内部类;
/**
 * @version 时间：2017-12-29 下午9:22:37
 *
 */
class InClass {
	public Object doit(){
		Object o = new Object(){
			private int i = 0;
		};
		return o;
	}
}
