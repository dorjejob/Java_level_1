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
        private int winHeight = 500;
        private int winPosX = 300;
        private int winPosY = 150;

        private int minMapSize = 3;
        private int maxMapSize = 10;
        private int minWinLength = 3;


        private String mapSizeSettingsPrefix = "Размер карты сейчас ";
        private String mapWinLengthPrefix = "Выигрышная комбинация равна  ";


        private JButton jbStart;
        private JButton jbExit;
        private JButton jbClear;

        private JPanel panelSettings;
        private JPanel panelControls;

        private JTextArea gameLogs;
        private JScrollPane scrollPanel;

        private JSlider sliderMapSizeSetup;
        private JLabel labelMapSize;

        private JSlider sliderWinLengthSetup;
        private JLabel labelWinLength;

        private GameMap gameMap;


    MainWindow()  {


        prepareAppWondow();
        prepareGameSettings();
        prepareButtons();
        prepareSettingsControls();
        prepareGameLog();

        gameMap = new GameMap(this);

        panelSettings.add(panelControls, BorderLayout.NORTH);
        panelSettings.add(scrollPanel, BorderLayout.SOUTH);

        add(panelSettings, BorderLayout.EAST);
        add(gameMap);


        setVisible(true);
    }

    private void prepareGameSettings() {
        panelSettings = new JPanel();
        panelSettings.setLayout(new GridLayout(2, 1));

    }

    private void prepareButtons() {
        jbStart = new JButton("Start");
        jbStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectGameSetup();
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
        labelMapSize = new JLabel(mapSizeSettingsPrefix + minMapSize);
        sliderMapSizeSetup = new JSlider(minMapSize,maxMapSize, minMapSize);
        sliderMapSizeSetup.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentMapSizeValue = sliderMapSizeSetup.getValue();
                labelMapSize.setText(mapSizeSettingsPrefix + currentMapSizeValue);
                sliderWinLengthSetup.setMaximum(currentMapSizeValue);
            }
        });

        labelWinLength = new JLabel(mapWinLengthPrefix + minWinLength);
        sliderWinLengthSetup = new JSlider(minWinLength, minMapSize, minMapSize);
        sliderWinLengthSetup.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(mapWinLengthPrefix + sliderWinLengthSetup.getValue());
            }
        });

        panelControls.setLayout(new GridLayout(10,1));
        panelControls.add(labelMapSize);
        panelControls.add(sliderMapSizeSetup);
        panelControls.add(labelWinLength);
        panelControls.add(sliderWinLengthSetup);
        panelControls.add(jbStart);
        panelControls.add(jbExit);
        panelControls.add(jbClear);
    }

    private void prepareAppWondow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Кресты и Ноли");
        setSize(wniwidht, winHeight);
        setLocation(winPosX, winPosY);
        setResizable(false);
    }
    private void prepareGameLog() {

        gameLogs = new JTextArea();
        scrollPanel = new JScrollPane(gameLogs);
        gameLogs.setEditable(false);
        gameLogs.setLineWrap(true);
    }

     void putLogs(String msg) {
        gameLogs.append(msg + "\n");
    }

    private void collectGameSetup() {
        int mapSize = sliderMapSizeSetup.getValue();
        int winLen = sliderWinLengthSetup.getValue();

        putLogs("Размер карты " + mapSize + "x" + mapSize + "\nВыигрышная комбинация равна " + winLen);
        gameMap.startGame(mapSize, mapSize,winLen);
    }


}
