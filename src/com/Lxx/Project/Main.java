package com.Lxx.Project;


import com.Lxx.Project.Controller.Resultopt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        Resultopt resultopt=new Resultopt();
        while (true){
            System.out.println("只能输入数字及操作符+,-,*,/,sqrt,clear,undo");
            Scanner scanner=new Scanner(System.in);
            String str=scanner.nextLine();
            resultopt.result_RPM(str);
        }
    }
}
