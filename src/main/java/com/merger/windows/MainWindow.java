package com.merger.windows;

import com.merger.tools.Files;
import com.merger.tools.ffmpeg;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class MainWindow extends JPanel {
    private JButton jcomp1;
    private JTextArea jcomp2;
    private JTextArea jcomp3;
    private JLabel jcomp4;
    private JLabel jcomp5;
    private JTextField jcomp6;
    private JButton jcomp7;
    private JFrame frames;
    private JCheckBox check;
    private JLabel info;
    private JLabel endopt;

    public MainWindow() {
        //construct components
        jcomp1 = new JButton ("Merge");
        jcomp2 = new JTextArea (5, 5);
        jcomp3 = new JTextArea (5, 5);
        jcomp4 = new JLabel ("Video");
        jcomp5 = new JLabel ("Audio");
        jcomp6 = new JTextField (5);
        jcomp7 = new JButton ("ExtractAudio");
        check = new JCheckBox("Save Only Video");
        info = new JLabel("Extract Audio Options");
        endopt = new JLabel("---------------------");
        jcomp7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!check.isSelected()) {
                    new ffmpeg().cutAudio(jcomp6.getText(), System.getProperty("user.dir") + "/OUT/");
                }else{
                    new ffmpeg().cutAudioSaveOnlyVideo(jcomp6.getText(), System.getProperty("user.dir") + "/OUT/");
                }
            }
        });
        jcomp1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(jcomp2.getText().equals("Click to select file")) {
                    new ErrorDialog().open("Error", "You didnt select a video file", frames);
                }else {
                    if (jcomp2.getText().equals("")) {
                        new ErrorDialog().open("Error", "You didnt select a video file", frames);
                    }else {
                        if (jcomp3.getText().equals("Click to select file")) {
                            new ErrorDialog().open("Error", "You didnt select a audio file", frames);
                        }else {
                            if (jcomp3.getText().equals("")) {
                                new ErrorDialog().open("Error", "You didnt select a audio file", frames);
                            }else{
                                new ffmpeg().mergeAudioAndVideo(jcomp2.getText(),jcomp3.getText(),System.getProperty("user.dir") + "/OUT/");
                            }
                        }
                    }
                }
            }
        });
        //adjust size and set layout
        setPreferredSize (new Dimension(542, 465));
        setLayout (null);
        jcomp2.setEditable(false);
        jcomp2.setText("Click to select file");
        jcomp2.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                jcomp2.setText(new Files().fileChooser("Choose Video File",frames,"C:\\"));
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });
        jcomp3.setEditable(false);
        jcomp3.setText("Click to select file");
        jcomp3.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                jcomp3.setText(new Files().fileChooser("Choose Audio File",frames,"C:\\"));
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });
        jcomp6.setText("Click to select");
        jcomp6.setEditable(false);
        jcomp6.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                String folder = new Files().fileChooser("Choose File",frames,"C:\\");
                if(!folder.equals("")) {
                    jcomp6.setText(folder);
                }
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }
        });
        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);
        add (jcomp7);
        add (check);
        add (info);
        add (endopt);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (370, 10, 100, 25);
        jcomp2.setBounds (0, 115, 540, 140);
        jcomp3.setBounds (0, 295, 540, 165);
        jcomp4.setBounds (15, 85, 100, 25);
        jcomp5.setBounds (20, 265, 100, 25);
        jcomp6.setBounds (5, 10, 185, 25);
        jcomp7.setBounds (200, 10, 110, 25);
        check.setBounds (5, 60,185,25);
        info.setBounds (5, 40, 185, 15);
        endopt.setBounds(5,80,185,7);
    }


    public void open() {
        final JFrame frame = new JFrame ("AudVidMerger");
        frames = frame;
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MainWindow());
        frame.pack();
        frame.setResizable(false);
        frame.setVisible (true);
    }
}
