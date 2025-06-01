package vue;

import javax.swing.*;
import java.awt.*;

public class ChangeFramesExemple {
    public static void main(String[] args) {
        JFrame frame1 = createJFrame(1);
        JFrame frame2 = createJFrame(2);

        frame1.add(createButtonPanel(frame2));
        frame2.add(createButtonPanel(frame1));

        frame1.setVisible(true);
        frame2.setVisible(true);

    }

    private static Component createButtonPanel(JFrame frame) {
        JPanel panel = new JPanel(new GridBagLayout());
        JButton button = new JButton(frame.getTitle());
        button.addActionListener(e-> frame.setVisible(true));
        //button.addActionListener(e-> frame.toFront());
        panel.add(button);
        return panel;
    }

    private static JFrame createJFrame(int i) {
        JFrame frame = new JFrame("Fenêtree "+i);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        return frame;
    }
}
