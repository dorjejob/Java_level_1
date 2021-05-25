package Java_level_1.git.Lesson_7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PrimitiveIterator;

public class MainWindow extends JFrame{
        private int wniwidht = 700;
        private int winHeight = 350;
        private int winPosX = 300;
        private int winPosY = 150;
        private JButton jbStart;
        private JButton jbExit;
        private JButton jbClear;
        private JPanel panelSettings;
        private JPanel panelControls;
        private JTextArea gameLogs;
        private JScrollPane scrollPanel;
        private JSlider slider;
        private JLabel label;


    MainWindow()  {


        prepareAppWondow();
        prepareGameSettings();
        prepareButtons();
        prepareSettingsControls();
        prepareGameLog();



//        add(jbExit, BorderLayout.SOUTH);
//        add(jbStart, BorderLayout.NORTH);

//        setLayout(new GridLayout(5, 10));
//        setLayout(new FlowLayout());
//
//        for (int i = 0; i < 5 ; i++) {
//            add(new JButton("Button" + (i + 1)));
//
//        }






        panelSettings.add(panelControls, BorderLayout.NORTH);
        panelSettings.add(scrollPanel, BorderLayout.SOUTH);

        add(panelSettings, BorderLayout.EAST);


        setVisible(true);


    }

    private void prepareGameSettings() {
        panelSettings = new JPanel();
        panelSettings.setLayout(new GridLayout(2, 1));

    }

    private void prepareGameLog() {

        gameLogs = new JTextArea();
        scrollPanel = new JScrollPane(gameLogs);
        gameLogs.setEditable(false);
        gameLogs.setLineWrap(true);
    }

    private void prepareButtons() {
        jbStart = new JButton("Start");
        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                putLogs("Ты выбрал " + slider.getValue());
            }
        });
        jbExit = new JButton("Exit");
        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jbClear = new JButton("Clear Logs");
        jbClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLogs.setText("");
            }
        });
    }

    private void prepareSettingsControls() {
        panelControls = new JPanel();
        label = new JLabel("Ваш выбор: " + 1);
        slider = new JSlider(1,10, 1);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText("Ваш выбор: " + slider.getValue());
            }
        });
        panelControls.setLayout(new GridLayout(10,1));
        panelControls.add(label);
        panelControls.add(slider);
        panelControls.add(jbStart);
        panelControls.add(jbExit);
        panelControls.add(jbClear);
    }

    private void prepareAppWondow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Програмуля");
        setSize(wniwidht, winHeight);
        setLocation(winPosX, winPosY);
        setResizable(false);
    }
    private void putLogs(String msg) {
        gameLogs.append(msg + "\n");
    }


}
