package com.deitel.gui.webbrowser;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jose on 2/13/2017.
 */
public class WebToolBar extends JToolBar
        implements HyperlinkListener {

    private WebBrowserPane webBrowserPane;
    private JButton backButton;
    private JButton forwardButton;
    private JTextField urlTextField;

    public WebToolBar(WebBrowserPane browser) {
        super("Web Navigation");

        webBrowserPane = browser;
        webBrowserPane.addHyperlinkListener(this);

        urlTextField = new JTextField(25);
        urlTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    URL url = new URL(urlTextField.getText());
                    webBrowserPane.goToURL(url);
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
            }
        });

//        backButton = new JButton(new ImageIcon(getClass()
//                .getResource("src/main/resources/back.jpg")));
        backButton = new JButton("BACK");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                URL url = webBrowserPane.back();
                urlTextField.setText(url.toString());
            }
        });

//        forwardButton = new JButton(new ImageIcon(getClass()
//                .getResource("src/main/resources/forward.jpg")));
        forwardButton = new JButton("FORWARD");
        forwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                URL url = webBrowserPane.forward();
                urlTextField.setText(url.toString());
            }
        });

        add(backButton);
        add(forwardButton);
        add(urlTextField);
    }

    public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() ==
                HyperlinkEvent.EventType.ACTIVATED) {
            URL url = e.getURL();

            webBrowserPane.goToURL(url);
            urlTextField.setText(url.toString());
        }
    }
}
