package 第六章XML.DOM4J;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


/**
 * @version 时间：2017-12-10 下午8:46:38
 *
 */
public class DOM4JParse {
	Document doc = null;
	public void loadDoc(String path) throws DocumentException{
		SAXReader reader = new SAXReader();
		doc = reader.read(path);
	}
	public void saveInfo(String path) throws IOException{
		OutputFormat format = OutputFormat.createPrettyPrint();//new OutputFormat();
		format.setEncoding("GB2312");
		XMLWriter write = new XMLWriter(new FileWriter(path),format);
		write.write(doc);
		write.close();//不关闭保存不显示//老是忘记关闭流
//-------------------方式二:写入保存------------------------
//		File file = new File(path);
//		FileOutputStream fout = new FileOutputStream(file);
//		OutputStreamWriter ow = new OutputStreamWriter(fout,"UTF-8");
//		OutputFormat format = OutputFormat.createPrettyPrint();
//		format.setEncoding("UTF-8");
//		XMLWriter xw = new XMLWriter(ow,format);
//		xw.write(doc);
//		xw.flush();
//		xw.close();
	}
	public void showInfo(){
		Element rootEle = doc.getRootElement();
		Iterator brandIt = rootEle.elementIterator();
		while(brandIt.hasNext()){
			Element brandEle = (Element)(brandIt.next());//不需要判断是否有子节点，但是要转换
			String brandStr = brandEle.attributeValue("name");
			System.out.println(brandStr);
//			---------------------方法一普通for循环-----------------------------
//			Iterator typeIt = brandEle.elementIterator();
//			while(typeIt.hasNext()){
//				Element typeEle = (Element)(typeIt.next());
//			-----------方法二可使用两个foreach嵌套循环，证明foreach也是循环输出-------------
			List<Element> typeList = brandEle.elements();
			for(Element typeEle:typeList){
				String typeStr = typeEle.attributeValue("name");
				System.out.println("手机品牌是："+brandStr+",手机型号是："+typeStr);
				List<Element> colorList = typeEle.elements();
				for(Element colorEle:colorList){
					System.out.println("文本节点名："+colorEle.getName());
					System.out.println("文本节点值："+colorEle.getTextTrim());
//					getTextTrim()和getText()用于文本节点输出文本值，输出结果一样，暂未发现区别
				}
			}
		}
	}
//	通过XPath路径获取指定元素或属性
	public void jaxenShow() throws DocumentException{
//		获取小米手机的颜色，通过指定路径节点名，获取指定节点的值。
		loadDoc("保存的收藏.xml");
//		List<Node> colorList = doc.selectNodes("Color");//获取指定节点的集合
		Element colorEle = (Element)doc.selectSingleNode("//Color[2]");
		System.out.println("获小米手机的信息：");
		System.out.println("文本节点名："+colorEle.getName());
		System.out.println("文本节点值："+colorEle.getTextTrim());
	}
	public void addInfo(){
		Element rootEle = doc.getRootElement();
		Element brandEle = rootEle.addElement("Brand");
		brandEle.addAttribute("name","三星");//DOM4J增加节点不是setAttribute("name","三星");DOM中修改节点setAttribute("name","三星")
		Element typeEle = brandEle.addElement("Type");
		typeEle.addAttribute("name", "Note4");
	}
	public void jaxenAddInfo(){
		Element rootEle = doc.getRootElement();
		Element brandEle = rootEle.addElement("Brand");
		brandEle.addAttribute("name", "小米");
		Element typeEle = brandEle.addElement("Type");
		typeEle.addAttribute("name", "Note6");
//		Element textEle = typeEle.addElement("Color");
//		textEle.setText("白色");
	}
	public void modifyInfo() throws IOException{
		int cnt = 1;
		Element rootEle = doc.getRootElement();
		Iterator brandIt = rootEle.elementIterator();
		while(brandIt.hasNext()){
			Element brandEle = (Element)(brandIt.next());
			brandEle.addAttribute("Id", cnt+++"");//多练，容易忘记
		}
		saveInfo("DOM4J收藏信息.xml");
	}
	public void delInfo(String str){
		Element rootEle = doc.getRootElement();
		Iterator brandIt = rootEle.elementIterator();
		while (brandIt.hasNext()) {
			Element brandEle = (Element) brandIt.next();
			if(brandEle.attributeValue("name").equals(str)){
				brandEle.getParent().remove(brandEle);
			}
		}
	}
	//----------------------自己增加的----------------------
	public void change(String str){
		Element root = doc.getRootElement();
		Iterator brandIt = root.elementIterator();
		while(brandIt.hasNext()){
			Element brandEle = (Element)brandIt.next();
			if (brandEle.attributeValue("name").equals(str)) {
				brandEle.addAttribute("name", "SUNSANG");
				break;
			}
		}
	}
//	public void test(){//测试方法用，跟程序无关。
//		Element root  = doc.getRootElement();
//		Element ele = root.addAttribute("name", "root");
//		Element brandele = root.element("Brand");
//		List brandlist = brandele.elements();
//		System.out.println(brandele.attribute("name").getValue());
//	}
	public static void main(String[] args) throws DocumentException, IOException {
		DOM4JParse parse = new DOM4JParse();
		parse.loadDoc("收藏信息.xml");
		parse.addInfo();
		parse.jaxenAddInfo();
//		parse.change("三星");
//		parse.delInfo("SUNSANG");
//		parse.modifyInfo();
		parse.showInfo();
		parse.jaxenShow();
		parse.saveInfo("保存的收藏.xml");
	}
}
