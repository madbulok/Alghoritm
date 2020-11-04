package homework.ui;

import homework.logic.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private int fieldSize;
    private boolean isInit;
    private int cellWidth;
    private int cellHeight;
    private Logic logic;

    public BattleField(GameWindow gv) {
        gameWindow = gv;
        logic = gv.getLogic();

        setBackground(Color.GREEN);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX()/cellWidth;
                int cellY = e.getY()/cellHeight;
                if (!logic.isFinishedGame()){
                    gameWindow.changeStatusGame();
                    logic.humanTurn(cellY, cellX);
                    gameWindow.changeStatusGame();
                    repaint();
                }
            }
        });
    }

    public void startToGame(int gameMode, int fieldSize, int winLength){
        this.fieldSize = fieldSize;
        logic.setDOTS_TO_WIN(winLength);
        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit){
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        drawLinesField(g, panelWidth, panelHeight);

        drawStatusMap(g);
    }

    private void drawStatusMap(Graphics g) {
        for (int i = 0; i < logic.getSIZE(); i++) {
            for (int j = 0; j < logic.getSIZE(); j++) {
                if (logic.getMap()[i][j] == logic.getDOT_X()){
                    drawX(g, j, i);
                } else if (logic.getMap()[i][j] == logic.getDOT_O()){
                    drawO(g, j, i);
                }
            }
        }
    }

    private void drawLinesField(Graphics g, int panelWidth, int panelHeight) {
        for (int i = 1; i < fieldSize; i++){
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 1; i < fieldSize; i++){
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
    }

    void drawX(Graphics g, int x, int y){
        g.setColor(Color.BLACK);
        ((Graphics2D)g).setStroke(new BasicStroke(5));
        g.drawLine(x*cellWidth, y*cellHeight, (x+1)*cellWidth, (y+1)*cellHeight);
        g.drawLine(cellWidth*(1+x), y*cellHeight, x*cellWidth, (y+1)*cellHeight);
    }

    void drawO(Graphics g, int x, int y){
        g.setColor(Color.RED);
        ((Graphics2D)g).setStroke(new BasicStroke(5));
        g.drawOval(x*cellWidth, y*cellHeight, cellWidth, cellHeight);
    }
}
