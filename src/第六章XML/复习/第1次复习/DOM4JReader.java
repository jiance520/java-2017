package 第六章XML.复习.第1次复习;

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
 * @version 时间：2017-12-11 下午2:17:58
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
         write.close();//不关闭保存不显示,老是忘记关闭流
    }
    public void showInfo(){
         Element rootEle = doc.getRootElement();
         Iterator brandIt = rootEle.elementIterator();
         while(brandIt.hasNext()){
             Element brandEle = (Element)(brandIt.next());//不需要判断是否有子节点，但是要转换
             String brandStr = brandEle.attributeValue("name");
             System.out.println(brandStr);
             Iterator typeIt = brandEle.elementIterator();
             while(typeIt.hasNext()){
                  Element typeEle = (Element)(typeIt.next());
                  String typeStr = typeEle.attributeValue("name");
                  System.out.println("手机品牌是："+brandStr+",手机型号是："+typeStr);
             }
         }
    }
    public void addInfo(){
         Element rootEle = doc.getRootElement();
         Element brandEle = rootEle.addElement("Brand");
         brandEle.addAttribute("name","三星");//不是setAttribute("name","三星");
         Element typeEle = brandEle.addElement("Type");
         typeEle.addAttribute("name", "Note4");
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
    public static void main(String[] args) throws DocumentException, IOException {
         DOM4JReader parse = new DOM4JReader();
         parse.loadDoc("收藏信息.xml");
         parse.addInfo();
         parse.change("三星");
         parse.delInfo("SUNSANG");
         parse.modifyInfo();
         parse.showInfo();
         parse.saveInfo("保存的收藏.xml");
    }
}

