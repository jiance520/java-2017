package ������XML.��ϰ.��1�θ�ϰ;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @version ʱ�䣺2017-12-11 ����2:17:58
 *
 */
public class DOM4JReader {
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
         write.close();//���رձ��治��ʾ,�������ǹر���
    }
    public void showInfo(){
         Element rootEle = doc.getRootElement();
         Iterator brandIt = rootEle.elementIterator();
         while(brandIt.hasNext()){
             Element brandEle = (Element)(brandIt.next());//����Ҫ�ж��Ƿ����ӽڵ㣬����Ҫת��
             String brandStr = brandEle.attributeValue("name");
             System.out.println(brandStr);
             Iterator typeIt = brandEle.elementIterator();
             while(typeIt.hasNext()){
                  Element typeEle = (Element)(typeIt.next());
                  String typeStr = typeEle.attributeValue("name");
                  System.out.println("�ֻ�Ʒ���ǣ�"+brandStr+",�ֻ��ͺ��ǣ�"+typeStr);
             }
         }
    }
    public void addInfo(){
         Element rootEle = doc.getRootElement();
         Element brandEle = rootEle.addElement("Brand");
         brandEle.addAttribute("name","����");//����setAttribute("name","����");
         Element typeEle = brandEle.addElement("Type");
         typeEle.addAttribute("name", "Note4");
    }
    public void modifyInfo() throws IOException{
         int cnt = 1;
         Element rootEle = doc.getRootElement();
         Iterator brandIt = rootEle.elementIterator();
         while(brandIt.hasNext()){
             Element brandEle = (Element)(brandIt.next());
             brandEle.addAttribute("Id", cnt+++"");//��������������
         }
         saveInfo("DOM4J�ղ���Ϣ.xml");
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
    //----------------------�Լ����ӵ�----------------------
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
    public static void main(String[] args) throws DocumentException, IOException {
         DOM4JReader parse = new DOM4JReader();
         parse.loadDoc("�ղ���Ϣ.xml");
         parse.addInfo();
         parse.change("����");
         parse.delInfo("SUNSANG");
         parse.modifyInfo();
         parse.showInfo();
         parse.saveInfo("������ղ�.xml");
    }
}

