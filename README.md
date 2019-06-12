# Calculator
RPM命令行计算器java实现

1.其中Pojo包中Calculator为计算器封装类，封装了计算器加减乘除以及开方(sqrt)、清除(clear)、退回（undo）操作方法。

2.Controller包中Resultopt为实现类，通过运用Calulator来实现命令行输入并完成相应计算或存储等操作。 

3.util包中是工具方法，我写了两个，一个是列表栈的存储方法，因为在Calculator和Resultopt类中都有运用到，就写在工具类了。还有一个字符串获取转Double对象的方法。用于获取传入的数字并转为字符串。如果传入的是操作符则返回空。

4.题目的难度适中，最主要烦的点就是那个undo操作，退回上一步，想了不少时间去考虑，后来一想就写一个历史日志列表吧，然后进而想想要保持一致还是做一个栈型的历史日志列表来存储数据的变化。还有一个点就是精度不变只取10位显示，我翻阅了不少资料但是还是不能像example里面所写的那种“2 sqrt”结果最后一位为3，我用的方法都是四舍五入了，网上说可以用算法来实现，但我没有去实际操作一番.

5.包里直接打开Project包运行Main方法就可以看到效果了.

6.配置:java 1.9 一般克隆下来打开就可以用了。

7.项目结构

├── RPM_Calculator.iml

├── out

│   └── ...

└── src

    └── com
    
        └── Lxx
        
            └── Project
            
                ├── Controller
                
                │   └── Resultopt.java
                
                ├── Main.java
                
                ├── Pojo
                
                │   └── Calculator.java
                
                └── util
                
                    └── Tools.java

