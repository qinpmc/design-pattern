package demo1;

public class Test {
    public static void main(String[] args)
    {
        SimpleRemoteControl remoteControl =
                new SimpleRemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();

        // we can change command dynamically
        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.buttonWasPressed();

        System.out.println("*************");
        remoteControl.setCommand(new StereoOnWithCDCommand(stereo));
        remoteControl.buttonWasPressed();

        System.out.println("*************");
        remoteControl.setCommand(new StereoOffCommand(stereo));
        remoteControl.buttonWasPressed();
    }
}
