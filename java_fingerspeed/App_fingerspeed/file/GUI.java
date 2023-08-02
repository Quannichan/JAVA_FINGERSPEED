package App_fingerspeed.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame GUI;
    HighlightPainter PainterGreen = new DefaultHighlighter.DefaultHighlightPainter(Color.green);
    HighlightPainter PainterRed = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
    HighlightPainter PainterGray = new DefaultHighlighter.DefaultHighlightPainter(Color.lightGray);
    Generatepara genpara = new Generatepara();
    StringTokenizer str;
    JTextArea strout;
    JTextArea strin;
    JTextArea Time;
    JLabel promt, main;
    String fromLang = "en";
    String toLang = "vi";
    String text = "hello";
    String re = "";
    int dung = 0;
    int sai = 0;
    JScrollPane scrool;
    Highlighter get1, get2, get3;
    ImageIcon icon = new ImageIcon(getClass().getResource("/Image/icon.png"));
    Random rand = new Random();
    ArrayList<String> wordList;
    ArrayList<Integer> spaceatpos;
    HashMap<Integer, Integer> spacepos;
    String wordcheck;
    int chudau;
    int chucuoi;
    boolean check = true;

    public GUI() {

        this.strout = new JTextArea();
        this.strout.setWrapStyleWord(true);
        this.strout.setLineWrap(true);
        this.strout.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        this.strout.setPreferredSize(new Dimension(445, 500));
        this.strout.setVisible(true);
        this.strout.setEditable(false);

        this.strin = new JTextArea();
        this.strin.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        this.strin.setPreferredSize(new Dimension(775, 125));
        this.strin.setBackground(Color.LIGHT_GRAY);
        this.strin.setForeground(Color.BLACK);
        this.strin.setVisible(true);

        this.Time = new JTextArea();
        this.Time.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
        this.Time.setPreferredSize(new Dimension(410, 125));
        this.Time.setEditable(false);
        this.Time.setVisible(true);

        this.promt = new JLabel();
        this.promt.setVisible(true);
        this.promt.setLayout(new BorderLayout());
        this.promt.setPreferredSize(new Dimension(300, 110));
        this.promt.add(this.strin, BorderLayout.WEST);
        this.promt.add(this.Time, BorderLayout.EAST);

        this.main = new JLabel();
        this.main.setVisible(true);
        this.main.setLayout(new BorderLayout());
        this.main.add(this.strout, BorderLayout.NORTH);
        this.main.add(this.promt, BorderLayout.SOUTH);

        this.GUI = new JFrame("FINGERSPEED");
        this.GUI.setSize(1200, 650);
        this.GUI.setResizable(false);
        this.GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.GUI.setContentPane(this.main);
        this.GUI.setVisible(true);
        this.GUI.setLocationRelativeTo(null);
        this.GUI.setIconImage(this.icon.getImage());
        new countTime().start();

    }

    class runPro implements Runnable {
        @Override
        public void run() {
            try {
                ArrayList<CorrectWord> cw = new ArrayList<>();
                ArrayList<Wrongword> ww = new ArrayList<>();
                get1 = strout.getHighlighter();
                String wordran = genpara.generate();
                int count = 0;
                countspace c = new countspace(wordran);
                strout.setText(wordran);
                int thutu = 0;
                wordcheck = c.getw(thutu);
                chudau = c.getchudau(thutu);
                chucuoi = c.getchucuoi(chudau);
                while (check != false) {
                    try {
                        int save = count;
                        if (strin.getText().length() > 0) {
                            for (int i = 0; i < strin.getText().length(); i++) {
                                if (strin.getText().charAt(i) == wordcheck.charAt(i)) {
                                    if (count <= chucuoi - chudau) {
                                        get1.removeAllHighlights();
                                        get1.addHighlight(chudau - 1, chudau + count, PainterGreen);
                                        if (strin.getText().length() == wordcheck.length()) {
                                            if (count < chucuoi - chudau) {
                                                get1.removeAllHighlights();
                                                get1.addHighlight(chudau - 1, chudau + count, PainterRed);
                                            } else {
                                                get1.removeAllHighlights();
                                                get1.addHighlight(chudau - 1, chudau + count, PainterGreen);
                                            }
                                        }
                                        count += 1;
                                    } else if (count == wordcheck.length() && strin.getText().contains(" ")) {
                                        String getin = strin.getText().replace(" ", "");
                                        if (getin.equals(wordcheck)) {
                                            thutu += 1;
                                            get1.removeAllHighlights();
                                            Highlighter g = strout.getHighlighter();
                                            g.addHighlight(chudau - 1, chucuoi, PainterGreen);
                                            strin.setText("");
                                            dung += 1;
                                            System.out.println("Dung: " + dung + " Sai: " + sai);
                                            CorrectWord newcor = new CorrectWord();
                                            newcor.setPoscorAndChudau(chudau - 1, chucuoi);
                                            cw.add(newcor);
                                            wordcheck = c.getw(thutu);
                                            chudau = c.getchudau(thutu);
                                            chucuoi = c.getchucuoi(chudau);
                                            // continue;
                                        } else {
                                            thutu += 1;
                                            Highlighter g = strout.getHighlighter();
                                            g.addHighlight(chudau - 1, chucuoi, PainterGreen);
                                            strin.setText("");
                                            sai += 1;
                                            System.out.println("Dung: " + dung + " Sai: " + sai);
                                            Wrongword newwro = new Wrongword();
                                            newwro.setPoswroAndChudau(chudau - 1, chucuoi);
                                            ww.add(newwro);
                                            wordcheck = c.getw(thutu);
                                            chudau = c.getchudau(thutu);
                                            chucuoi = c.getchucuoi(chudau);
                                        }

                                    } else if (count < wordcheck.length()) {
                                        get1.removeAllHighlights();
                                        get1.addHighlight(chudau - 1, chudau + count - 1, PainterRed);
                                    }
                                } else if (strin.getText().charAt(i) != wordcheck.charAt(i)) {
                                    get1.removeAllHighlights();
                                    get1.addHighlight(chudau - 1, chudau + count, PainterRed);
                                    // System.out.println("no");
                                    if (count != chucuoi - chudau + 1 && strin.getText().contains(" ")) {

                                        String getin = strin.getText().replace(" ", "");
                                        if (getin.equals(wordcheck)) {
                                            thutu += 1;
                                            get1.removeAllHighlights();
                                            Highlighter g = strout.getHighlighter();
                                            g.addHighlight(chudau - 1, chucuoi, PainterGreen);
                                            strin.setText("");
                                            dung += 1;
                                            System.out.println("Dung: " + dung + " Sai: " + sai);
                                            CorrectWord newcor = new CorrectWord();
                                            newcor.setPoscorAndChudau(chudau - 1, chucuoi);
                                            cw.add(newcor);
                                            wordcheck = c.getw(thutu);
                                            chudau = c.getchudau(thutu);
                                            chucuoi = c.getchucuoi(chudau);
                                            // continue;
                                        } else {
                                            thutu += 1;
                                            Highlighter g = strout.getHighlighter();
                                            g.addHighlight(chudau - 1, chucuoi, PainterGreen);
                                            strin.setText("");
                                            sai += 1;
                                            System.out.println("Dung: " + dung + " Sai: " + sai);
                                            Wrongword newwro = new Wrongword();
                                            newwro.setPoswroAndChudau(chudau - 1, chucuoi);
                                            ww.add(newwro);
                                            wordcheck = c.getw(thutu);
                                            chudau = c.getchudau(thutu);
                                            chucuoi = c.getchucuoi(chudau);
                                        }
                                    }
                                }

                            }
                            count = 0;
                        } else if (strin.getText().length() == 0) {
                            count = 0;
                            get1.removeAllHighlights();
                            get1.addHighlight(chudau - 1, chucuoi, PainterGray);
                        } else if (strin.getText().length() <= save) {
                            count -= 1;
                            get1.removeAllHighlights();
                            get1.addHighlight(chudau - 1, chudau + count, PainterGreen);
                        } else if (count == chucuoi - chudau + 1 && strin.getText().contains(" ")) {
                            thutu += 1;
                            strin.setText("");
                            wordcheck = c.getw(thutu);
                            chudau = c.getchudau(thutu);
                            chucuoi = c.getchucuoi(chudau);
                        }

                        // }
                    } catch (Exception e) {
                    }
                    for (int i = 0; i < cw.size(); i++) {
                        int chudau = cw.get(i).getChudau();
                        int chucuoi = cw.get(i).getchucuoi();
                        get1.addHighlight(chudau, chucuoi, PainterGreen);
                    }
                    for (int y = 0; y < ww.size(); y++) {
                        int chudau = ww.get(y).getChudau();
                        int chucuoi = ww.get(y).getchucuoi();
                        get1.addHighlight(chudau, chucuoi, PainterRed);
                    }
                    Thread.sleep(10);
                }
                strin.setEditable(false);
                Time.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
                int total = dung + sai;
                get1.removeAllHighlights();
                for (int i = 0; i < cw.size(); i++) {
                    int chudau = cw.get(i).getChudau();
                    int chucuoi = cw.get(i).getchucuoi();
                    get1.addHighlight(chudau, chucuoi, PainterGreen);
                }
                for (int y = 0; y < ww.size(); y++) {
                    int chudau = ww.get(y).getChudau();
                    int chucuoi = ww.get(y).getchucuoi();
                    get1.addHighlight(chudau, chucuoi, PainterRed);
                }
                Time.setText(total + " WPM(word per minute)\n" + dung + " correct\n" + sai + " wrong");
            } catch (Exception e) {
            }
        }

    }

    class countTime extends Thread {
        int Min = 1;
        int Sec = 0;

        public countTime() {

            try {
                strin.setEnabled(false);
                strout.setText("Ready...");
                Thread.sleep(3000);
                strout.setText("5...");
                Thread.sleep(1000);
                strout.setText("4...");
                Thread.sleep(1000);
                strout.setText("3...");
                Thread.sleep(1000);
                strout.setText("2...");
                Thread.sleep(1000);
                strout.setText("1...");
                Thread.sleep(1000);
                strout.setText("GO!");
                strin.setEnabled(true);
                strin.requestFocusInWindow();
                new Thread(new runPro()).start();
                for (int i = 0; i <= 60; i++) {
                    if (Min == 1 && Sec == 0) {
                        // System.out.println("0" + Min + ":" + Sec + "0");
                        Time.setText("");
                        Time.setText("0" + Min + ":" + Sec + "0");
                        Min = 0;
                        Sec = 59;
                    } else {
                        if (Sec >= 10) {
                            Time.setText("0" + Min + ":" + Sec);
                            Sec -= 1;
                        } else {
                            Time.setText("0" + Min + ":" + "0" + Sec);
                            Sec -= 1;
                        }
                    }
                    Thread.sleep(1000);
                }
                check = false;

            } catch (Exception e) {

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
