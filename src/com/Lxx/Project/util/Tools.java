package com.Lxx.Project.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: lingjunhao
 * create at:  2019-06-11  21:00
 * @description: 工具类
 */
public class Tools {
    /**
     *首先我们先写number_list栈的存储方法，其实只需要循环遍历number栈进行list.add就能实现。
     */
    public List<Double> number_list_get(Stack<Double> number){
        List<Double> number_list=new ArrayList<>();
        for (Double x :
                number) {
            number_list.add(x);
        }
        return number_list;
    }

//    字符串获取并转换为Double，如果是操作符则返回null。
    public Double StrToDouble(String str){
        try {
            double num=Double.valueOf(str);
            return num;
        }catch (Exception e){
            return null;
        }
    }

}
