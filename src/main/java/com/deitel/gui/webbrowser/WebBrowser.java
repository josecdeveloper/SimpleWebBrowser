package com.deitel.gui.webbrowser;

import javax.swing.*;
import java.awt.*;

/*You must provide the full URL of the website
* EX: https://www.google.com
* */
public class WebBrowser extends JFrame {
    private WebBrowserPane webBrowserPane;
    private WebToolBar toolBar;

    public WebBrowser() {
        super("Deitel Web Browser");

        webBrowserPane = new WebBrowserPane();
        toolBar = new WebToolBar(webBrowserPane);

        Container container = getContentPane();
        container.add(toolBar, BorderLayout.NORTH);
        container.add(new JScrollPane(webBrowserPane),
                BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        WebBrowser webBrowser = new WebBrowser();
        webBrowser.setDefaultCloseOperation(EXIT_ON_CLOSE);
        webBrowser.setSize(640, 480);
        webBrowser.setVisible(true);
    }
}
