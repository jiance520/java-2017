package XML_DOM4J及TCP增删改查测试;
/**
 * @version 时间：2018-1-6 上午8:57:32
 *
 */
public enum Param {
//	成功失败增删改查
    SUCCESS("success"), // 成功
    FAIL("fail"), // 失败
    INSERT("insert"), // 新增
    SELECT("select"), // 查询
    UPDATE("update"), // 修改
    DELETE("delete"),  // 删除
    EXIT("exit"); // 退出
	private String name;
	private Param(String name){
		this.name = name;
	}
	public String toString(){
		return this.name;
	}
}
