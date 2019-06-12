package com.Lxx.Project.Pojo;

import com.Lxx.Project.util.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: lingjunhao
 * create at:  2019-06-11  19:44
 * @description: 计算器封装类
 */

/**
*首先这个计算器由两个栈构成，在这两个栈中，一个是用来存储数字的数字栈number，一个是用来记录存储历史记录的list栈。number_list
*而操作符有+-*undo sqrt clear等构成。因此在此类中可以进行不同操作符方法的封装。还要拥有能够获取数字栈存储历史记录的方法用来存储number_list.
* 普通的number只需要push\pop就可以了，而number_list就稍微复杂一点，需要把存储的历史记录放在一个list对象里面再存入栈中。
*
*/
public class Calculator {
//    /**
//     *首先我们先写number_list栈的存储方法，其实只需要循环遍历number栈进行list.add就能实现。
//     */
//    public List<Double> number_list_get(Stack<Double> number){
//        List<Double> number_list=new ArrayList<>();
//        for (Double x :
//                number) {
//            number_list.add(x);
//        }
//        return number_list;
//    }

    private Tools tools=new Tools();

    public Tools getTools() {
        return tools;
    }

    public void setTools(Tools tools) {
        this.tools = tools;
    }

    /**
     * 接下来我们写加减乘除的封装方法，命名为binary_asmd,在方法中，通过number栈的pop方法来调取操作数，而具体操作符是由外部传入一个opt字符串来确定。
     */
    public void binary_asmd(Stack<Double> number,Stack<List<Double>> number_list,String opt) throws Exception {
        double number_post=number.pop();//1+2中的2
        double number_pre=number.pop();//1+2中的1
        double result=0;
        switch (opt){
            case "+":
                result=number_post+number_pre;
                number.push(result);
                number_list.push(tools.number_list_get(number));
                break;
            case "-":
                result=number_pre-number_post;
                number.push(result);
                number_list.push(tools.number_list_get(number));
                break;
            case "*":
                result=number_pre*number_post;
                number.push(result);
                number_list.push(tools.number_list_get(number));
                break;
            case "/":
                if (number_post==0){
                    throw new Exception("除数不为零");}
                else {
                    result=number_pre/number_post;
                    number.push(result);
                    number_list.push(tools.number_list_get(number));
                }
                break;
                default:
                    throw new Exception("Error!!!!!!");
        }
    }

    /**
     * 开平方的封装方法
     */
    public void binary_sqrt(Stack<Double> number,Stack<List<Double>> number_list)throws Exception{
        double x=number.pop();
        number.push(sqrt(x));
        number_list.push(tools.number_list_get(number));
    }

    /**
     * 开平方的sqrt可以直接使用Math.sqrt
     */
    private double sqrt(double x) throws Exception {
        if (x<0){
            throw new Exception("Error!负数不能开平方！！！");}
        else{
            return Math.sqrt(x);}
    }

    /**
     * 清除操作clear的封装方法，将number栈中的元素全部清除，并在number_list历史记录中加入null。
     * 开始没考虑这个null值，就是两个栈全部清空，后来想到如果clear后面接上一个undo操作的话还需要去历史记录中翻，坑点！！！
     */
    public void binary_clear(Stack<Double> number,Stack<List<Double>> number_list){
        while (!number.isEmpty()){
            number.pop();
        }
//        while (!number_list.isEmpty()){
//            number_list.pop();
//        }
        List<Double> list=new ArrayList<>();
        list.add(null);
        number_list.push(list);
    }

    /**
     * 最难的undo来了！！！最开始想解题思路的时候一直被这个undo操作卡，
     * 之后引入了number_list历史记录栈之后发现其实就是把number栈清空，再将历史记录栈去掉栈顶值。
     * 再将number_list记录栈现在的栈顶值传入number栈中即可。
     */
    public void binary_undo(Stack<Double> number,Stack<List<Double>> number_list){
        while (!number.isEmpty()){
            number.pop();
        }
        if (!number_list.isEmpty()){
            number_list.pop();
            if (!number_list.isEmpty()){
                List<Double> list=number_list.peek();
                for (double x :
                        list) {
                    number.push(x);
                }
            }
        }
    }

}
