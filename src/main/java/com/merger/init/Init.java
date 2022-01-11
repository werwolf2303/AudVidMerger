package com.merger.init;

import com.merger.config.Config;
import com.merger.fallback.Resources;
import com.merger.internet.Download;
import com.merger.internet.HandleUnpacked;
import com.merger.setup.Setup;
import com.merger.tools.DetectArchitecture;
import com.merger.tools.DetectOS;
import com.merger.windows.MainWindow;
import java.io.File;

public class Init {
    public static void main(String[] args) {
        try {
            if(args[0].contains("-test-resources")) {
                new Resources().unpackWGET();
                System.exit(0);
            }
        }catch (ArrayIndexOutOfBoundsException aioobe) {
            File f = new File(System.getProperty("user.dir") + "/config.conf");
            if (!f.exists()) {
                new Setup().showSetup();
            } else {
                new MainWindow().open();
            }
        }
    }
}
