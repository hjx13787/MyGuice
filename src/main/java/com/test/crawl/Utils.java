package com.test.crawl;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Utils {
  
  // UrlVo类存放了3个url，列表图片url，详细信息中的图片url，和商品详细信息url
  // 再通过这三个url可以把所有数据读取出来并封装成对象，然后存入数据库。
  // 同时将所用到的图片下载到本地。

    /**
     * 从一个页面获取该页面商品详细信息的url链接和小图片的链接地址
     * @param url
     * @return
     * @throws
     */
    public static void getBookUrlFromPage(String url, List list) throws Exception{
        // timeout 0:不断请求  默认:2000毫秒超时
        Document document = Jsoup.connect(url).get();
        Elements node = document.select("link[href]");
        //Elements elements = node.get(0).child(0).children();
        for (Element item : node) {
        	System.out.println(item.attr("href"));
//            UrlVO urlVO = new UrlVO();
//            urlVO.setProductDetailUrl(item.child(1).child(0).child(0).child(0).attr("href"));
//            urlVO.setSmallImageUrl(item.child(0).child(0).child(0).attr("src"));
//            list.add(urlVO);
        }
    }

    /**
     * 根据url和页数获取商品详细url
     * @param url
     * @param startPage
     * @param endPage
     * @param list
     */
    public static void getBookUrlByUrlAndPageNum(String url, Integer startPage, Integer endPage, List list) {
        try {
            for(int i = startPage; i <= endPage; i++) {
                String urlStr = url ;
                Utils.getBookUrlFromPage(urlStr, list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据商品详细页面获取Product对象
     * @param url
     * @return
     */
//    public static Product getProductFromUrl(String url) {
//      //这里有些数据利用jsoup获取不到
//        //我用的是htmlunit，设置setJavaScriptEnabled，setAjaxController等参数
//        //具体代码就不贴了，大家可以自己试试
//        //如有需要，求留言
//        return null;
//    }

    /**
     * 根据图片url和文件名保存图片
     * @param urlStr
     * @param filename
     */
    public static void saveImageByUrlAndName(String urlStr, String filename) throws Exception{
        // 构造URL
        URL url = new URL(urlStr);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        OutputStream os = new FileOutputStream(filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        os.flush();
        // 关闭连接
        os.close();
        is.close();
    }

    // 测试及调用
    public static void main(String[] args) {
        List<UrlVO> list = new ArrayList<UrlVO>();
        try {
            getBookUrlByUrlAndPageNum("https://www.baidu.com/", 1, 9, list);
//            getBookUrlFromPage("http://category.dangdang.com/all/?category_path=01.03.38.00.00.00&page_index=2", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(list.size());

//        保存图片
//        String urlStr = "http://img32.ddimg.cn/28/35/23207212-1_l.jpg";
//        try {
//            saveImageByUrlAndName(urlStr, "1.jpg");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}