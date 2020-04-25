import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITicTacToe extends JFrame {
    private Container pane;
    private String currentPlayer;
    private JButton [][] board;
    private boolean checkWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;

    //This will be the tictactoe constructor
    public GUITicTacToe(){
        super(); //calls parent class, calling JFrame default constructor
        pane = getContentPane();
        pane.setLayout(new GridLayout(3,3));
        setTitle("Tic-Tac-Toe");
        setSize(400, 400);
        setLocationRelativeTo(null); //centers to middle of screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        currentPlayer= "X";
        board = new JButton[3][3];
        checkWinner = false;
        initializeBoard();
        initializeMenuBar();

    }
    private void initializeMenuBar(){
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menu.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));

        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resetBoard();
            }
        });

        quit = new JMenuItem("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0); //this will terminate the program
            }
        });
        //add the components together
        menu.add(newGame);
        menu.add(quit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
    private void resetBoard(){
        currentPlayer = "X";
        checkWinner = false;

        //now we are going to reset the buttons
        for(int i= 0; i< 3; i++){
            for(int j = 0; j <3; j++){
                board[i][j].setText("");
            }
        }
    }
    private void initializeBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                JButton XOButton = new JButton();
                XOButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
                board[i][j] = XOButton;
                XOButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        if(((JButton)actionEvent.getSource()).getText().equals("") && checkWinner == false){
                            XOButton.setText(currentPlayer);
                            checkWinner();
                            togglePlayer();
                        }
                    }
                });
                pane.add(XOButton);
            }
        }
        checkDraw();

    }
    private void togglePlayer(){
        if(currentPlayer.equals("X"))
            currentPlayer = "O";
        else
            currentPlayer = "X";
    }
    private void checkWinner() {
        String TopL = board[0][0].getText();
        String TopM = board[0][1].getText();
        String TopR = board[0][2].getText();
        String MiddleL = board[1][0].getText();
        String MiddleM = board[1][1].getText();
        String MiddleR = board[1][2].getText();
        String BottomL = board[2][0].getText();
        String BottomM = board[2][1].getText();
        String BottomR = board[2][2].getText();

        if (TopL.equals(currentPlayer) && TopM.equals(currentPlayer) && TopR.equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
            checkWinner = true;
        } else if (MiddleL.equals(currentPlayer) && MiddleM.equals(currentPlayer) && MiddleR.equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
            checkWinner = true;
        } else if (BottomL.equals(currentPlayer) && BottomM.equals(currentPlayer) && BottomR.equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
            checkWinner = true;
        } else if (TopL.equals(currentPlayer) && MiddleL.equals(currentPlayer) && BottomL.equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
            checkWinner = true;
        } else if (TopM.equals(currentPlayer) && MiddleM.equals(currentPlayer) && BottomM.equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
            checkWinner = true;
        } else if(TopR.equals(currentPlayer) && MiddleR.equals(currentPlayer) && BottomR.equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
            checkWinner = true;
        }else if(TopL.equals(currentPlayer) && MiddleM.equals(currentPlayer) && BottomR.equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
            checkWinner = true;
        }else if(TopR.equals(currentPlayer) && MiddleM.equals(currentPlayer) && BottomL.equals(currentPlayer)) {
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won!");
            checkWinner = true;
        }

    }
    public void checkDraw(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j< 3; j++){
                if(!(board[i][j].getText().equals(""))){
                    JOptionPane.showMessageDialog(null, "Draw");
                    checkWinner = true;
                }
            }
        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUITicTacToe();
            }
        });

    }
}