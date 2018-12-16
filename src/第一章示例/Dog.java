package 第一章示例;
/**
 * @author 邓集军 E-mail: 332992686@qq.com
 * @version 时间：2017-10-23 下午10:23:25
 * alt+shift+S+R快速
 */
public class Dog {
	private String name;
	private String strain;	
	public Dog(){
	}
	public Dog(String name,String strain){
		this.name = name;
		this.strain = strain;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStrain() {
		return strain;
	}
	public void setStrain(String strain) {
		this.strain = strain;
	}
}
