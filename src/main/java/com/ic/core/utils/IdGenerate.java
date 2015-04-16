package com.ic.core.utils;

import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc:Id生成器 规则： md5(UUID+随机数)
 * Author: Charles
 * Date  : 2014/12/18
 */
public class IdGenerate {

    public static String nextId(){
        return MD5Util.getMD5String(UUID.randomUUID().toString()+getRandomStr(5));
    }

    private static String getRandomStr(int n){
        //输入位数必须大于0
        if(n>0){
            StringBuffer sb = new StringBuffer(n);
            for(int i=0; i<n;i++){
                sb.append((int)(Math.random()*10));
            }
            return sb.toString();
        }else{
            return "";
        }
    }

    public static void main(String[] args){
        //测试
        for(int i=0;i<10;i++)
        {
            System.out.println(nextId());
        }
    }
}
