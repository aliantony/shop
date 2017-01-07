package com.thunisoft.utils;

import java.util.UUID;

/**
 * Created by yhan219 on 2017/1/7.
 */
public class ShopUUID {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
