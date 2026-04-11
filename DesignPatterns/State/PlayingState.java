import java.awt.event.*;
import java.util.Random;

public class PlayingState implements GameState {
    @Override
    public void enter(GameContext context) {
        Random r = new Random();

        context.startButton.setVisible(false);
        context.snakeButton.setVisible(true);
        context.foodButton.setVisible(true);
        context.scoreLabel.setVisible(true);

        context.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int x = context.snakeButton.getX();
                int y = context.snakeButton.getY();
                int width = context.snakeButton.getWidth();
                int height = context.snakeButton.getHeight();

                switch (keyCode) {
                    case KeyEvent.VK_W: y -= 10; break;
                    case KeyEvent.VK_A: x -= 10; break;
                    case KeyEvent.VK_S: y += 10; break;
                    case KeyEvent.VK_D: x += 10; break;
                }

                // Check for collision with food
                if (context.snakeButton.getBounds().intersects(context.foodButton.getBounds())) {
                    context.foodButton.setVisible(false);
                    context.scoreValue += 10;
                    width += 10;
                    context.snakeButton.setSize(width, height);
                    context.scoreLabel.setText("Score: " + context.scoreValue);

                    int foodX = r.nextInt(900);
                    int foodY = r.nextInt(900);
                    context.foodButton.setBounds(foodX, foodY, 30, 30);
                    context.foodButton.setVisible(true);
                }

                context.snakeButton.setBounds(x, y, width, height);
                context.frame.revalidate();
                context.frame.repaint();
            }
        });

        context.frame.setFocusable(true);
        context.frame.requestFocusInWindow();
       

    }
}
