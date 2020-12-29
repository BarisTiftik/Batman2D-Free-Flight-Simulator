import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {
    public static final int SCREEN_WIDTH = 1800;
    public static final int SCREEN_HEIGHT = 900;

    private JPanel mainPanel;
    private JPanel wallpaperPanel;
    private JButton freeFlightButton;
    private JButton exitButton;
    private JLabel infoLabel;
    private KeyListener keyListener;
    private MouseInputListener mouseInputListener;

    public MainFrame() {

        setLayout(new BorderLayout());

        initializeListeners();
        wallpaperPanel = new WallpaperPanel();
        add(mainPanel, BorderLayout.CENTER);

        addListeners();

        adjustMainFrameSettings();
    }

    private void addListeners() {
        freeFlightButton.addActionListener(this);
        exitButton.addActionListener(this);
        wallpaperPanel.addKeyListener(keyListener);
        infoLabel.addMouseListener(mouseInputListener);
    }

    private void initializeListeners() {
        keyListener = new BatmanKeyListener(this);
        mouseInputListener = new BatmanMouseInputListener(this);
    }

    public void adjustMainFrameSettings()
    {
        setTitle( "Batman2D" );
        setBounds( 55, 70, SCREEN_WIDTH, SCREEN_HEIGHT );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == freeFlightButton) {
            setVisible(false);
            remove(mainPanel);
            add(wallpaperPanel);
            repaint();
            setVisible(true);
        }
        else if (e.getSource() == exitButton)
            System.exit(0);
    }

    public JPanel getWallpaperPanel() {
        return wallpaperPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    /*private void createUIComponents() {
        // TODO: place custom component creation code here
        infoLabel = new JLabel();

    }*/

    public JLabel getInfoLabel() {
        return infoLabel;
    }
}