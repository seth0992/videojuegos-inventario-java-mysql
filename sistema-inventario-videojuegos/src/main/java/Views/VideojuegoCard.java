import Models.Videojuegos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;

public class VideojuegoCard extends JPanel {
    private Videojuegos videojuego;
    private JLabel tituloLabel;
    private JLabel plataformaLabel;
    private JLabel generoLabel;
    private JLabel precioLabel;
    private JLabel stockLabel;
    private JLabel imagenLabel;
    private JButton modificarButton;

    public VideojuegoCard(Videojuegos videojuego) {
        this.videojuego = videojuego;
        setLayout(new GridLayout(7, 1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        tituloLabel = new JLabel("Título: " + videojuego.getTitulo());
        plataformaLabel = new JLabel("Plataforma: " + videojuego.getPlataforma());
        generoLabel = new JLabel("Género: " + videojuego.getGenero());
        precioLabel = new JLabel("Precio: " + videojuego.getPrecio());
        stockLabel = new JLabel("Stock: " + videojuego.getStock());

        // Mostrar la imagen
        imagenLabel = new JLabel();
        if (videojuego.getImagen() != null) {
            try {
                ByteArrayInputStream bais = new ByteArrayInputStream(videojuego.getImagen());
                BufferedImage img = ImageIO.read(bais);
                ImageIcon icon = new ImageIcon(img.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
                imagenLabel.setIcon(icon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            imagenLabel.setText("No Image");
        }

        modificarButton = new JButton("Modificar");

        add(tituloLabel);
        add(plataformaLabel);
        add(generoLabel);
        add(precioLabel);
        add(stockLabel);
        add(imagenLabel);
        add(modificarButton);
    }

    public void addModificarListener(ActionListener listener) {
        modificarButton.addActionListener(listener);
    }

    public Videojuegos getVideojuego() {
        return videojuego;
    }
}
