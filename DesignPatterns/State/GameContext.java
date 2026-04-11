import javax.swing.*;

public class GameContext {
    private GameState currentState;
    public JFrame frame;
    public JButton startButton;
    public JButton snakeButton;
    public JButton foodButton;
    public JLabel scoreLabel;
    public int scoreValue = 0;

    public GameContext() {
        frame = new JFrame("Mini Snake Game");
        frame.setLayout(null);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startButton = new JButton("Start");
        snakeButton = new JButton("S");
        foodButton = new JButton("F");
        scoreLabel = new JLabel("Score: 0");

        // Initial positions
        startButton.setBounds(425, 450, 150, 60);
        snakeButton.setBounds(500, 500, 20, 20);
        foodButton.setBounds(100, 100, 30, 30);
        scoreLabel.setBounds(450, 15, 200, 35);

        // Styling
        snakeButton.setBackground(java.awt.Color.GREEN);
        foodButton.setBackground(java.awt.Color.RED);
        foodButton.setForeground(java.awt.Color.WHITE);
        startButton.setBackground(java.awt.Color.BLACK);
        startButton.setForeground(java.awt.Color.WHITE);
        scoreLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));

        // Initially hidden
        snakeButton.setVisible(false);
        foodButton.setVisible(false);
        scoreLabel.setVisible(false);

        frame.add(startButton);
        frame.add(snakeButton);
        frame.add(foodButton);
        frame.add(scoreLabel);

        frame.setVisible(true);
    }

    public void setState(GameState state) {
        this.currentState = state;
        state.enter(this);
    }
}
