package com.site.util;

/**
 * Created by zdsoft on 14-7-24.
 */
public class SqlUtil {

    //采用正则表达式，将输入的所有特殊符号转换为空格或其他字符 防止SQL注入
    public static String TransactSQLInjection(String str){
        return str.replaceAll(".*([';]+|(--)+).*", " ");
    }
}
