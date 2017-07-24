package com.deitel.gui.webbrowser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MDIWebBrowser extends JFrame {
    JDesktopPane desktopPane = new JDesktopPane();

    public MDIWebBrowser() {
        super("MDI Web Browser");

        createNewWindow();

        Container container = getContentPane();
        container.add(desktopPane);

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new NewWindowAction());
        fileMenu.addSeparator();
        fileMenu.add(new ExitAction());
        fileMenu.setMnemonic('F');

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    private void createNewWindow() {
        JInternalFrame frame = new JInternalFrame(
                "Browser",
                true,
                true,
                true,
                true
        );

        WebBrowserPane browserPane = new WebBrowserPane();
        WebToolBar toolBar = new WebToolBar(browserPane);

        Container container = frame.getContentPane();
        container.add(toolBar, BorderLayout.NORTH);
        container.add(new JScrollPane(browserPane),
                BorderLayout.CENTER);

        frame.setSize(320, 240);

        int offset = 30 * desktopPane.getAllFrames().length;
        frame.setLocation(offset, offset);

        desktopPane.add(frame);

        frame.setVisible(true);
    }

    private class NewWindowAction extends AbstractAction {
        public NewWindowAction() {
            putValue(Action.NAME, "New Window");
            putValue(Action.SHORT_DESCRIPTION,
                    "Create New Web Browser Window");
            putValue(Action.MNEMONIC_KEY, new Integer('N'));
        }

        public void actionPerformed(ActionEvent event) {
            createNewWindow();
        }
    }

    private class ExitAction extends AbstractAction {

        public ExitAction() {
            putValue(Action.NAME, "Exit");
            putValue(Action.SHORT_DESCRIPTION,
                    "Exit Application");
            putValue(Action.MNEMONIC_KEY, new Integer('x'));
        }
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        MDIWebBrowser webBrowser = new MDIWebBrowser();
        webBrowser.setDefaultCloseOperation(EXIT_ON_CLOSE);
        webBrowser.setSize(640, 480);
        webBrowser.setVisible(true);
    }
}
