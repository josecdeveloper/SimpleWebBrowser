package com.deitel.gui.webbrowser;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
* A simple Web-browsing component that
* extends JEditorPane and maintains a history of visited URLS
* */
public class WebBrowserPane extends JEditorPane{

    private List history = new ArrayList();
    private int historyIndex;

    //Disable editing to enable hyperlinks
    public WebBrowserPane() {
        setEditable(false);
    }

    //Navigate to given URL
    public void goToURL(URL url) {
        displayPage(url);
        history.add(url);
        historyIndex = history.size() - 1;
    }

    //Navigates to the next page in the URL history
    public URL forward() {
        historyIndex++;

        //Do not go past the end of the history
        if(historyIndex >= history.size()) {
            historyIndex = history.size() - 1;
        }

        URL url = (URL) history.get(historyIndex);
        displayPage(url);

        return url;

    }

    //Navigates to the previous page in the URL history
    public URL back() {
        historyIndex--;

        if (historyIndex < 0) {
            historyIndex = 0;
        }

        URL url = (URL) history.get(historyIndex);
        displayPage(url);

        return url;
    }

    public void displayPage(URL pageUrl) {
        try {
            setPage(pageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}





















