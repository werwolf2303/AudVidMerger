package com.merger.fallback;

import com.merger.init.Init;

import java.io.*;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.merger.internet.Download.newFile;

public class Resources {
    public void unpackWGET() {
        try {
            Runtime.getRuntime().exec("jar xf AudVidMerger.jar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
