/**
 * Caro Game application
 * @author tuquyen87
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CaroGame implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	private int turn = 1;
	private int count = 0;
	private JButton[][] buttons = new JButton[3][3];
	
	public CaroGame() {
		//System.out.println("Constructor");
		frame = new JFrame();
		frame.setBounds(500, 200, 600, 600);
		frame.setTitle("Caro Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		frame.add(panel, BorderLayout.CENTER);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton("");
				panel.add(buttons[i][j]);
				buttons[i][j].addActionListener(this);
			}
		}
	}
	
	public void start() {
		System.out.println("Start");
		frame.setVisible(true);
	}
	
	public String checkWinner() {
		String winner = "";
		for (int i = 0; i < 3; i++) {
			for(int j = 1; j < 2; j++) {
				if ((buttons[i][j].getText() == buttons[i][j-1].getText()) && (buttons[i][j].getText() == buttons[i][j+1].getText())) {
					 winner = buttons[i][j].getText();
				}				
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for(int j = 1; j < 2; j++) {
				if ((buttons[j][i].getText() == buttons[j-1][i].getText()) && (buttons[j][i].getText() == buttons[j+1][i].getText())) {
						winner = buttons[j][i].getText();
				}				
			}
		}
		return winner;
	}
	
	public static void main (String[] args) {
		CaroGame app = new CaroGame();
		app.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(null, "Button click" + ((JButton)e.getSource()).getText());
		JButton source = ((JButton)e.getSource());
		String display = turn == 1 ? "O" : "X";
		source.setText(display);
		turn = 3 - turn;
		source.removeActionListener(this);
		String winner = checkWinner();
		if (winner != "") {
			JOptionPane.showMessageDialog(null, "Winner is " + winner);
		}
		count ++;
		if (count == 9) {
			JOptionPane.showMessageDialog(null, "No winner");
		}
	}
}
