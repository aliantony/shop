package com.thunisoft.spider;

import com.thunisoft.domain.Phone;
import com.thunisoft.utils.ShopUUID;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhan219 on 2017/1/7.
 */
public class JdPhoneSpider {

    private static String url="https://list.jd.com/list.html?cat=9987,653,655";

    /**
     * 获取第page页的数据
     * @param page
     * @return
     * @throws IOException
     */
    public static List<Phone> getPhoneFromJdByPage(int page) throws IOException {
        String jdUrl = url+"&page="+page+"&trans=1&JL=6_0_0&ms=4#J_main";
        List<Phone> phones = new ArrayList<>();
        Document document = Jsoup.connect(jdUrl).get();
        Element plist = document.getElementById("plist");
        Elements divs = plist.getElementsByClass("gl-i-wrap j-sku-item");
        for(Element div :divs){
            String num = div.attr("data-sku").toString();
            String phonename = div.getElementsByClass("p-name").get(0).text();
            Phone phone = new Phone();
            phone.setId(ShopUUID.getUUID());
            phone.setCnum(num);
            phone.setPhonename(phonename);
            phones.add(phone);
        }
        return phones;
    }
    public static List<Phone> getAllPhone() throws IOException {
        int pageNum = 92;
        List<Phone> all = new ArrayList<>();
        for(int i=0;i<pageNum;i++){
            List<Phone> list = getPhoneFromJdByPage(i);
            all.addAll(list);
        }
        return  all;
    }

    public static void main(String args[]){
        List<Phone> phones = null;
        try {
            phones = getAllPhone();
            System.out.println(phones.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Phone p: phones ) {
            System.out.print(p.getId()+" ");
        }
    }
}
