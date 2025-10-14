package org.harini;


import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class App extends JFrame
{
    public App() throws HeadlessException {
    }

    public static void main(String[] args )
    {
       Login log = new Login();
       log.getDefaultCloseOperation();
       log.setVisible(true);
    }
}
