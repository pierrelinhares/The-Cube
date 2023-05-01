import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SpinCube extends JPanel {

    private double vertex[][][][]
            = {
            {
                    {
                            {-1, -1, -1},
                            {1, -1, -1}
                    },
                    {
                            {-1, 1, -1},
                            {1, 1, -1}
                    }
            },
            {
                    {
                            {-1, -1, 1},
                            {1, -1, 1}
                    },
                    {
                            {-1, 1, 1},
                            {1, 1, 1}
                    }
            }
    };

    private double xyR = 0.005, xzR = 0.005, yzR = 0.005;

    private final static int Image_Size = 500,
    Scale = 100,
    OffSet = 200,
    Diameter = 8;

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, Image_Size, Image_Size);

        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                for (int z = 0; z < 2; z++) {
                    xyRotate(vertex[x][y][z], Math.sin(xyR), Math.cos(xyR));
                    xzRotate(vertex[x][y][z], Math.sin(xzR), Math.cos(xzR));
                    yzRotate(vertex[x][y][z], Math.sin(yzR), Math.cos(yzR));
                }
            }
        }

        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                graphics.setColor(Color.ORANGE);
                drawEdge(vertex[x][y][0][0], vertex[x][y][0][1], vertex[x][y][1][0], vertex[x][y][1][1], graphics);
                graphics.setColor(Color.blue);
                drawEdge(vertex[x][0][y][0], vertex[x][0][y][1], vertex[x][1][y][0], vertex[x][1][y][1], graphics);
                graphics.setColor(Color.MAGENTA);
                drawEdge(vertex[0][x][y][0], vertex[0][x][y][1], vertex[1][x][y][0], vertex[1][x][y][1], graphics);
            }
        }

        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                for (int z = 0; z < 2; z++) {
                    drawVertex(vertex[x][y][z][0], vertex[x][y][z][1], graphics);
                }
            }
        }
    }

    final void xyRotate(double p[], double sin, double cos){
        double temp;
        temp = cos * p[0] + sin * p[1];
        p[1] = -sin * p[0] + cos * p[1];
        p[0] = temp;
    }

    final void xzRotate(double p[], double sin, double cos) {
        double temp;
        temp = cos * p[0] + sin * p[2];
        p[2] = -sin * p[0] + cos * p[2];
        p[0] = temp;
    }

    final void yzRotate(double p[], double sin, double cos) {
        double temp;
        temp = cos * p[1] + sin * p[2];
        p[2] = -sin * p[1] + cos * p[2];
        p[1] = temp;
    }

    final void drawEdge(double x1, double y1, double x2, double y2, Graphics g) {
        g.drawLine((int) (x1 * Scale) + OffSet, (int) (-y1 * Scale) + OffSet, (int) (x2 * Scale) + OffSet, (int) (-y2 * Scale) + OffSet);
    }

    final void drawVertex(double x, double y, Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval((int) (Scale * x) + OffSet - Diameter / 2, (int) (Scale * (-y)) + OffSet - Diameter / 2, Diameter, Diameter);

        g.setColor(Color.black);
        g.drawOval((int) (Scale * x) + OffSet - Diameter / 2, (int) (Scale * (-y)) + OffSet - Diameter / 2, Diameter, Diameter);
    }
}