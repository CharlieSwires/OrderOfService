
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrderOfService extends JPanel {
	private static String hymn1 ="";
	private static String hymn2 ="";
	private static String hymn3 ="";
	private static String hymn4 ="";
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		// Set the custom font to Calibri, plain style, 14 points
		Font customFont = new Font("Calibri", Font.PLAIN, 180);
		g2d.setFont(customFont);
		// Draw the text with the custom font
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, 1920, 1080);
		g2d.setColor(Color.WHITE);

		g2d.drawString(hymn1.length() > 0 ? "1:"+hymn1:hymn1, 100, 50+180);
		g2d.drawString(hymn2.length() > 0 ? "2:"+hymn2:hymn2, 100, 1080/2-50);
		g2d.drawString(hymn3.length() > 0 ? "3:"+hymn3:hymn3, 1920/2 - 100, 50+180);
		g2d.drawString(hymn4.length() > 0 ? "4:"+hymn4:hymn4, 1920/2 - 100,1080/2-50);
	}
	public static void main(String[] args) {
		if (args.length >= 1) {
			switch (args.length) {
			case 1:
				hymn1 = args[1];
				break;
			case 2:
				hymn1 = args[0];
				hymn2 = args[1];
				break;
			case 3:
				hymn1 = args[0];
				hymn2 = args[1];
				hymn3 = args[2];
				break;
			case 4:
				hymn1 = args[0];
				hymn2 = args[1];
				hymn3 = args[2];
				hymn4 = args[3];
				break;
			default:
				hymn1 = "Too Many Args";
				break;
			}
		} else {
			System.out.println("Usage: java OrderOfService P100 P200 P300 P400");
			System.exit(ABORT);
		}
		JFrame frame = new JFrame("Order of Service");

		OrderOfService panel = new OrderOfService();
		frame.add(panel);
		frame.setSize(1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

