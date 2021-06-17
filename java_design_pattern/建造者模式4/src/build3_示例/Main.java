
package build3_示例;


public class Main {
    public static void main(String[] args) {


        TextBuilder textbuilder = new TextBuilder();
        Director director = new Director(textbuilder);
        director.construct();
        String result = textbuilder.getResult();
        System.out.println(result);

        HTMLBuilder htmlbuilder = new HTMLBuilder();
        Director director2 = new Director(htmlbuilder);
        director2.construct();
        String filename = htmlbuilder.getResult();
        System.out.println(filename + "文件编写完成。");

    }
    public static void usage() {
        System.out.println("Usage: java Main plain      编写纯文本文档");
        System.out.println("Usage: java Main html       编写HTML文档");
    }
}
