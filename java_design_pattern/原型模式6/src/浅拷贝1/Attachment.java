package 浅拷贝1;

public class Attachment {
    private String name;    //附件名

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void download() {
        System.out.println("下载附件" + name);
    }
}
