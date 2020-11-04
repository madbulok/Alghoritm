package homework.ui;

import homework.logic.Logic;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SettingWindow extends JFrame {
    static final int WINDOX_X = GameWindow.WINDOX_X+50;
    static final int WINDOX_Y = GameWindow.WINDOX_Y+50;
    static final int WINDOX_WIDTH = GameWindow.WINDOX_WIDTH-100;
    static final int WINDOX_HEIGHT = 555;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    private static final int GAME_MODE_H_VS_AI = 0;
    private static final int GAME_MODE_H_VS_H = 1;

    private GameWindow gameWindow;
    private JRadioButton jrdhumanVsAi;
    private JRadioButton jrdhumanVsHuman;
    private ButtonGroup btnGroup;
    private JSlider jSliderFieldSize;
    private JSlider jSliderWinLength;
    private Logic logic;

    public SettingWindow(GameWindow gw){
        this.gameWindow = gw;
        this.logic = gw.getLogic();

        setBounds(WINDOX_X, WINDOX_Y, WINDOX_WIDTH, WINDOX_HEIGHT);
        setTitle("Настройки");
        setLayout(new GridLayout(8, 1));

        jrdhumanVsAi = new JRadioButton("Человек против Компьютера");
        jrdhumanVsHuman = new JRadioButton("Человек против  человека");
        add(new JLabel("Выберите тип игры"));

        add(jrdhumanVsAi);
        add(jrdhumanVsHuman);

        btnGroup = new ButtonGroup();
        btnGroup.add(jrdhumanVsAi);
        btnGroup.add(jrdhumanVsHuman);
        jrdhumanVsHuman.setEnabled(false);

        jSliderFieldSize = new JSlider(SwingConstants.HORIZONTAL, MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        jSliderFieldSize.setMajorTickSpacing(1);
        jSliderFieldSize.setMinorTickSpacing(1);
        jSliderFieldSize.setPaintLabels(true);
        jSliderFieldSize.setPaintTicks(true);

        jSliderWinLength = new JSlider(SwingConstants.HORIZONTAL, MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        jSliderWinLength.setMajorTickSpacing(1);
        jSliderWinLength.setMinorTickSpacing(1);
        jSliderWinLength.setPaintLabels(true);
        jSliderWinLength.setPaintTicks(true);

        jSliderFieldSize.addChangeListener(e -> jSliderWinLength.setMaximum(jSliderFieldSize.getValue()));
        add(new JLabel("Выберите размер поля"));
        add(jSliderFieldSize);
        add(new JLabel("Выберите количество точек для победы"));
        add(jSliderWinLength);

        JButton btnStart = new JButton("Начать игру");
        btnStart.addActionListener(e -> {
            int gameMode;
            int fieldSize = jSliderFieldSize.getValue();
            int winLength = jSliderWinLength.getValue();

            if (jrdhumanVsAi.isSelected()){
                gameMode = GAME_MODE_H_VS_AI;
            } else {
                gameMode = GAME_MODE_H_VS_H;
            }

            logic.setSIZE(fieldSize);

            logic.setDOTS_TO_WIN(winLength);
            logic.setFinishedGame(false);
            logic.initMap();
            gameWindow.startToGame(gameMode, fieldSize, winLength);
            setVisible(false);
        });
        add(btnStart);

    }
}
