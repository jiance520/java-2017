package XML_DOM4J��TCP��ɾ�Ĳ����;
/**
 * @version ʱ�䣺2018-1-6 ����8:57:32
 *
 */
public enum Param {
//	�ɹ�ʧ����ɾ�Ĳ�
    SUCCESS("success"), // �ɹ�
    FAIL("fail"), // ʧ��
    INSERT("insert"), // ����
    SELECT("select"), // ��ѯ
    UPDATE("update"), // �޸�
    DELETE("delete"),  // ɾ��
    EXIT("exit"); // �˳�
	private String name;
	private Param(String name){
		this.name = name;
	}
	public String toString(){
		return this.name;
	}
}
