JLLVM is a Java version of LLVM Core. To get more info about JLLVM you should follow the link: http://tcloud.sjtu.edu.cn/wiki/index.php/User:Liuhaots:JLLVM

To build the code:
(1) import the project to eclipse
(2) Include ANTLR path to lib.(download ANTLR work from:http://www.antlr.org/download.html).Right click on the project->"Build Path"->"Add External Archives"->choose the "antlrworks-1.4.3.jar"

When you run the project to analysis LLVM IR, you may encounter the out of memory: It is because the source code is too large(such as Apache is 19MB). Some arguments should be added to Configurations, for example I add "-Xms512m -Xmx1024m" to "VM arguments" of "run Configurations" in eclipse.

Enjoy it. Thanks!