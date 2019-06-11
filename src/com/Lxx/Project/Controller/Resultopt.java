package com.Lxx.Project.Controller;

import com.Lxx.Project.Pojo.Calculator;
import com.Lxx.Project.util.Tools;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Stack;

/**
 * @author: lingjunhao
 * create at:  2019-06-11  20:57
 * @description:实现命令行输入字符串并处理
 */
public class Resultopt {
    /**
     * 数字栈number和历史记录栈number_list
     */
    private Stack<Double> number=new Stack<>();
    private Stack<List<Double>> number_list=new Stack<>();

    private Tools tools=new Tools();

    /**
     * 对输入的RPM进行处理。以空格为分割。再进行遍历字符串数组，如果是数字就对number和number_list栈进行写入。
     * 遇到操作符就去调Calculator的对应操作方法，并传入number和number_list。
     */
    public void result_RPM(String str) throws Exception {
        String []rpm=str.split(" ");
        int rpm_l=rpm.length;//数组长度
        int i=0;
        while (rpm_l-->0){
            Calculator calculator=new Calculator();
            int n=number.size();
            //对传入的命令行进行判断，如果是数字直接入栈，如果是操作符则进行操作。
            if (tools.StrToDouble(rpm[i])!=null){
                number.push(tools.StrToDouble(rpm[i]));
                number_list.push(tools.number_list_get(number));
            }else{
                String opt =rpm[i];
                switch (opt){
                    case "undo":
                        calculator.binary_undo(number,number_list);
                        break;
                    case "sqrt":
                        //栈中有数字才可以操作，没有则报错
                        if (n>0){
                            calculator.binary_sqrt(number,number_list);
                            break;
                        }else {
                            //出现错误，报哪一位出现参数不足。
                            System.out.println("operator "+opt+" (position:"+(i+1)+"):insufficient parameters ");
                            rpm_l=-1;//跳出while循环
                            break;
                        }
                    case "clear":
                        calculator.binary_clear(number,number_list);
                        break;
                    case "+":
                        if (n>1){
                            calculator.binary_asmd(number,number_list,opt);
                            break;
                        }else {
                            System.out.println("operator "+opt+" (position:"+(i+1)+"):insufficient parameters ");
                            rpm_l=-1;//跳出while循环
                            break;
                        }
                    case "-":
                        if (n>1){
                            calculator.binary_asmd(number,number_list,opt);
                            break;
                        }else {
                            System.out.println("operator "+opt+" (position:"+(i+1)+"):insufficient parameters ");
                            rpm_l=-1;//跳出while循环
                            break;
                        }
                    case "*":
                        if (n>1){
                            calculator.binary_asmd(number,number_list,opt);
                            break;
                        }else {
                            System.out.println("operator "+opt+" (position:"+(i+1)+"):insufficient parameters ");
                            rpm_l=-1;//跳出while循环
                            break;
                        }
                    case "/":
                        if (n>1){
                            calculator.binary_asmd(number,number_list,opt);
                            break;
                        }else {
                            System.out.println("operator "+opt+" (position:"+(i+1)+"):insufficient parameters ");
                            rpm_l=-1;//跳出while循环
                            break;
                        }
                        default:
                            throw new Exception("输入的字符串不符合标准");
                }
            }
            i++;
        }
        print(number);
    }
    public void print(Stack<Double> number){//打印number
        int length=number.size();
        if (length!=0){
            System.out.print("stack: ");
            for (Double x :
                  number  ) {
                /**
                 * 被这个精度不能变还要保留10位搞死了！！！！！查了好多资料，样例里的2 sqrt的结果最后一位还是改不成3还是4。
                 */
//                String pp=String.valueOf(x);
//                BigDecimal bigDecimal=new BigDecimal(pp);
//                double m=bigDecimal.setScale(10,BigDecimal.ROUND_).doubleValue();
//                String s= BigDecimal.valueOf(m).stripTrailingZeros().toPlainString();
//                System.out.print(s+" ");
                DecimalFormat decimalFormat=new DecimalFormat();
                decimalFormat.applyPattern("##########.##########");
                String s = decimalFormat.format(x);
                System.out.print(s+" ");
            }
            System.out.println();
        }else {
            System.out.println("stack: ");
        }
    }

}
