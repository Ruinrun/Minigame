import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Open World extends JFrame {

    private JLabel characterLabel = new ImageIcon(getClass().getResource("character.png"));;
    private int characterX, characterY;
    private static final int MINI_GAME_TRIGGER_X = 300;

    public GameWithMiniGame() {
        setTitle("Java Game with Mini-Game [PH]");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize character
        characterX = 50;
        characterY = 200;

        // Create a JLabel for the character
        characterLabel = new JLabel(new ImageIcon("character.png")); // Replace with your character image
        characterLabel.setBounds(characterX, characterY, 50, 50);

        // Add character to the frame
        add(characterLabel);

        // Set up key listener for character movement
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                moveCharacter(e.getKeyCode());
                checkMiniGameTrigger();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        // Set focusable to true to enable key events
        setFocusable(true);
    }

    private void moveCharacter(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                characterX -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                characterX += 10;
                break;
            case KeyEvent.VK_UP:
                characterY -= 10;
                break;
            case KeyEvent.VK_DOWN:
                characterY += 10;
                break;
        }

        // Update character position
        characterLabel.setLocation(characterX, characterY);
    }

    private void checkMiniGameTrigger() {
        if (characterX >= MINI_GAME_TRIGGER_X) {
            // Trigger mini-game
            startMiniGame();
        }
    }

    private void startMiniGame() {
        // Implement your mini-game logic here
        JOptionPane.showMessageDialog(this, "Mini-Game Triggered!");

        // Reset character position
        characterX = 50;
        characterY = 200;
        characterLabel.setLocation(characterX, characterY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameWithMiniGame frame = new GameWithMiniGame();
            frame.setVisible(true);
        });
    }
}
