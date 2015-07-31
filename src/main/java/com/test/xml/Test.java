package com.test.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.junit.internal.runners.statements.Fail;

/**
 * xml读写测试
 * 
 * @author admin_Hzw
 * 
 */
public class Test {

	public static void main(String[] args) throws Exception {
		File f = new File("C:\\temp\\temp14343391488396077.xml");
		// List<TestBean> list = new ArrayList<TestBean>();
		// for (int i = 0; i < 100; i++) {
		// TestBean t = new TestBean();
		// t.setId(i);
		// t.setName("胡汉三");
		// t.setTel("110");
		// list.add(t);
		// }
		//
		// writeXml(list);
		// readXMLContent(f);
		removeXMLContent(f, "B");
	}

	/**
	 * 写入xml
	 * 
	 * @param list
	 * @throws Exception
	 */
	public static void writeXml(List<TestBean> list) throws Exception {
		long wB = System.currentTimeMillis();
		/*
		 * 所有的XML元素都是 Element 的实例。根元素也不例外：
		 */
		Element rootElement = new Element("TestBean");
		Document myDocument = new Document(rootElement);// 以根元素作为参数创建Document对象。一个Document只有一个根，即root元素。
		for (int i = 0; i < list.size(); i++) {
			TestBean t = list.get(i);
			Element iElement = new Element("B");// 创建 name 元素
			iElement.setAttribute("id", t.getId() + "");
			rootElement.addContent(iElement);// 将name元素作为content添加到根元素
			Element nameElement = new Element("name");// 创建 name 元素
			nameElement.addContent(t.getName());// 将kingwong作为content添加到name元素
			iElement.addContent(nameElement);// 将name元素作为content添加到根元素
			Element telElement = new Element("tel");// 创建 name 元素
			telElement.addContent(t.getTel());// 将kingwong作为content添加到name元素
			iElement.addContent(telElement);// 将name元素作为content添加到根元素
		}
		String path = "C://temp//temp" + System.currentTimeMillis() + new Random().nextInt(100000);
		// 如果使用格式化，那么文件大小将会增大
		// XMLOutputter xmlOut = new XMLOutputter(Format.getPrettyFormat());
		XMLOutputter xmlOut = new XMLOutputter();
		File f = null;
		try {
			File ffFile = new File("C://temp");
			if (!ffFile.exists()) {
				ffFile.mkdir();
			}
			f = new File(path + ".xml");
			if (f.exists()) {
				f.delete();
			}
			f.createNewFile();
			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
			BufferedWriter writer = new BufferedWriter(write);
			writer.write(xmlOut.outputString(myDocument));
			writer.close();
			long wN = System.currentTimeMillis();
			System.out.println("写入用时：" + (wN - wB) + "毫秒");
			readXMLContent(f); // 解析
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析XML
	 * 
	 * @param f
	 */
	@SuppressWarnings("unchecked")
	public static void readXMLContent(File f) {
		long xB = System.currentTimeMillis();
		SAXBuilder builder = new SAXBuilder();
		List<TestBean> listBean = new ArrayList<TestBean>();
		try {
			Document doc = builder.build(f);
			Element rootEl = doc.getRootElement();
			// 获得所有子元素
			List<Element> list = rootEl.getChildren();
			for (Element el : list) {
				TestBean t = new TestBean();
				// 获取id属性值
				String id = el.getAttributeValue("id");
				t.setId(Integer.valueOf(id));
				// 获取子元素文本值
				String name = el.getChildText("name");
				t.setName(name);
				String tel = el.getChildText("tel");
				el.removeChild("tel");
				t.setTel(tel);
				listBean.add(t);
				System.out.println("id=" + id + "-------name=" + name + "---------tel=" + tel);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long xN = System.currentTimeMillis();
		System.out.println("解析用时：" + (xN - xB) + "毫秒");
		System.out.println("------" + listBean.size());
	}

	@SuppressWarnings("unchecked")
	public static void removeXMLContent(File f, String node) {
		long xB = System.currentTimeMillis();
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(f);
			Element rootEl = doc.getRootElement();
			rootEl.removeChildren("B");
			System.out.println(rootEl);
			// 获得所有子元素
			List<Element> list = rootEl.getChildren();
			for (Element el : list) {
				TestBean t = new TestBean();
				// 获取id属性值
				String id = el.getAttributeValue("id");
				t.setId(Integer.valueOf(id));
				// 获取子元素文本值
				String name = el.getChildText("name");
				t.setName(name);
				String tel = el.getChildText("tel");
				el.removeChild("tel");
				t.setTel(tel);
				System.out.println("id=" + id + "-------name=" + name + "---------tel=" + tel);
			}
			// 第七步，存盘
			XMLOutputter outputter = new XMLOutputter();// 用于输出jdom 文档
			FileWriter writer;
			try {
				writer = new FileWriter(f);
				outputter.output(rootEl, writer);
				writer.close();
			} catch (IOException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long xN = System.currentTimeMillis();
		System.out.println("解析用时：" + (xN - xB) + "毫秒");
	}
}
