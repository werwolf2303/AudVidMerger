package com.merger.init;

import com.merger.config.Config;
import com.merger.internet.Download;
import com.merger.internet.HandleUnpacked;
import com.merger.setup.Setup;
import com.merger.tools.DetectArchitecture;
import com.merger.tools.DetectOS;
import com.merger.windows.MainWindow;
import java.io.File;

public class Init {
    public static void main(String[] args) {
        File f = new File(System.getProperty("user.dir") + "/config.conf");
        if(!f.exists()) {
            new Setup().showSetup();
        }else{
            new MainWindow().open();
        }
    }
}
