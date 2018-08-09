package com.comment.bean;

import java.util.HashMap;

/**
 * Created by SN on 2016/2/19.
 */
public class SortDirection {

    private static HashMap<Integer, String> enumInfo = new HashMap<Integer, String>() {
        {
            put(0, "ASC");
            put(1, "DESC");
        }
    };

    /**
     * 升序
     */
    public static final Integer Asc = 0;

    /**
     * 降序
     */
    public static final Integer Desc = 1;

    /**
     * 获得枚举名称
     * */
    public static String getName(int enumKey){
        if(enumInfo.containsKey(enumKey)){
            return enumInfo.get(enumKey);
        }

        return  enumInfo.get(1);
    }

    /**
     * 获取枚举集合
     * @return
     */
    public static HashMap getMap()
    {
        return enumInfo;
    }
}
