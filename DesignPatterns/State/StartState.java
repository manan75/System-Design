public class StartState implements GameState {
    @Override
    public void enter(GameContext context) {
        context.startButton.setVisible(true);

        // Remove old listeners to avoid multiple triggers
        for (ActionListener al : context.startButton.getActionListeners()) {
            context.startButton.removeActionListener(al);
        }

        context.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                context.setState(new PlayingState());

                // Ensure focus for key events
                context.frame.requestFocusInWindow();
            }
        });
    }
}
