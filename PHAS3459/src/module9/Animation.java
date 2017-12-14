package module9;

import javax.swing.*;

/**
 * Rotating square animation applet with
 * start, stop and exit buttons.
 */
public class Animation {
  /** Create and display JFrame containing animation GUI panel */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new JFrame("Solar System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1900,1000);
        AnimationPanel panel = new AnimationPanel(1900,1000);
        frame.add(panel);
        frame.setVisible(true);
      }
    });
  }
}