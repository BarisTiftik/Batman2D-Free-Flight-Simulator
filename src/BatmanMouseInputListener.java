import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class BatmanMouseInputListener implements MouseInputListener {

    private Object object;

    public BatmanMouseInputListener(Object object) {
        this.object = object;
    }

    @Override
    public void mouseMoved( MouseEvent e ) {
        if (object instanceof WallpaperPanel)
            ((WallpaperPanel) object).getBatman().setBatmanLocation( e.getX() - ( ((WallpaperPanel) object).getBatman().getBatmanImage().getWidth(null) / 2 ),
                    e.getY() - ( ((WallpaperPanel) object).getBatman().getBatmanImage().getHeight(null) / 2 ) );
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (object instanceof WallpaperPanel)
            ((WallpaperPanel) object).getBatman().setBatmanLocation( e.getX() - ( ((WallpaperPanel) object).getBatman().getBatmanImage().getWidth(null) / 2 ),
                    e.getY() - ( ((WallpaperPanel) object).getBatman().getBatmanImage().getHeight(null) / 2 ) );
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (object instanceof MainFrame) {
            if ( e.getSource() == ((MainFrame) object).getInfoLabel() ) {
                JOptionPane.showMessageDialog(new JFrame(), "Batman 2D Free Flight Simulator!\n" +
                                                                    "Left Click to go ahead!\n" +
                                                                    "Right Click to back down!\n" +
                                                                    "Find out what arrow keys do!\n" +
                                                                    "Press 'W' to speed up! , Press 'S' to slow down!\n" +
                                                                    "To go back to the main menu: Just Simply press the back_space key!");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (object instanceof WallpaperPanel) {
                if (((WallpaperPanel) object).getImageIndex() == ((WallpaperPanel) object).getBackgroundImages().length - 1)
                    ((WallpaperPanel) object).resetImageIndex();
                else
                    ((WallpaperPanel) object).incrementImageIndex();
            }
        }
        else if (e.getButton() == MouseEvent.BUTTON3) {
            if (object instanceof WallpaperPanel) {
                if (((WallpaperPanel) object).getImageIndex() == 0)
                    ((WallpaperPanel) object).resetImageIndex();
                else
                    ((WallpaperPanel) object).decrementImageIndex();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
