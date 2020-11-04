package homework.ui;


import homework.logic.Logic;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOX_X = 500;
    static final int WINDOX_Y = 300;
    static final int WINDOX_WIDTH = 505;
    static final int WINDOX_HEIGHT = 555;
    private final JLabel statusGame;

    private SettingWindow settingWindow;
    private BattleField battleField;
    private Logic logic;

    public GameWindow() {
        setBounds(WINDOX_X, WINDOX_Y, WINDOX_WIDTH, WINDOX_HEIGHT);
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        logic = new Logic();
        settingWindow = new SettingWindow(this);
        battleField = new BattleField(this);

        add(battleField, BorderLayout.CENTER);

        JPanel jPanel = new JPanel(new GridLayout(1,2));
        JButton btnStartGame = new JButton("Начать новую игру");
        JButton exitButton = new JButton("Выход");
        statusGame = new JLabel("");
        add(statusGame, BorderLayout.NORTH);
        jPanel.add(btnStartGame);
        jPanel.add(exitButton);
        add(jPanel, BorderLayout.SOUTH);

        exitButton.addActionListener(e->{
            System.exit(0);
        });
        btnStartGame.addActionListener(e->{
            settingWindow.setVisible(true);
        });

        setVisible(true);
    }

    public void startToGame(int gameMode, int fieldSize, int winLength){
        battleField.startToGame(gameMode, fieldSize, winLength);
        statusGame.setText("Игра началась! Ваш ход!");
    }

    public void changeStatusGame(){
        statusGame.setText(Logic.statusGame);
    }

    public Logic getLogic() {
        return logic;
    }
}
