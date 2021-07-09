package 深拷贝2;

public class Test {
    public static void main(String[] args) throws Exception {

        WeeklyLog log_1;

        log_1 = new WeeklyLog();	//创建原型对象
        Attachment attachment = new Attachment(); //创建附件对象
        attachment.setName("附件1");
        log_1.setAttachment(attachment);	//将附件添加到周报种去

        WeeklyLog log_2= log_1.deepclone();	//克隆周报

        System.out.println("周报是否相同"+(log_1==log_2)); // false
        System.out.println("附件是否相同"+(log_1.getAttachment()==log_2.getAttachment())); // false

        System.out.println(log_2.getAttachment().getName());
        System.out.println(log_1.getAttachment().getName());

    }
}
