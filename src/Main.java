import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SpinCube jPanel = new SpinCube();
        JFrame application = new JFrame("Spinning Cube");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(jPanel);
        application.setSize(400,400);
        application.setVisible(true);
        while (true){
            Thread.sleep(100);
            jPanel.repaint();
        }
    }
}
