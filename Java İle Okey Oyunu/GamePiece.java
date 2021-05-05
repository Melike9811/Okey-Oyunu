import java.util.concurrent.ThreadLocalRandom;

public class GamePiece {
	/** Game piece color
	 * {@value} 1: sarý, 2: mavi, 3: kýrmýzý, 4: siyah
	 */
	private int color;
	
	/** Game piece value
	 * {@value} 1-13
	 */
	private int value;
	
	public void setColor(int colorId) {
	    this.color = colorId;
    }
	public void setValue(int newColor) {
	    this.value = newColor;
    }
	
	public int getColor() {
		return this.color;
	}
	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		String newColor = "";
	    switch(this.color) {
	    	case 1:
	    		newColor = "sarý";
	    		break;
	    	case 2:
	    		newColor = "mavi";
	    		break;
	    	case 3:
	    		newColor = "kýrmýzý";
	    		break;
	    	case 4:
	    		newColor = "siyah";
	    		break;
	    };
	    return newColor + "-" + value;
	} 
	
	GamePiece() {
		setValue(ThreadLocalRandom.current().nextInt(1, 13 + 1));
		setColor(ThreadLocalRandom.current().nextInt(1, 4 + 1));
	}
	
	GamePiece(int GamePieceValue, int GamePieceColor) {
		if(GamePieceValue >= 1 && GamePieceValue <= 13 && GamePieceColor >= 1 && GamePieceColor <= 4) {
			setValue(GamePieceValue);
			setColor(GamePieceColor);			
		}else {
			setValue(ThreadLocalRandom.current().nextInt(1, 12 + 1));
			setColor(ThreadLocalRandom.current().nextInt(1, 3 + 1));
		}
	}
	/*public static void main(String[] args) {
		System.out.println("Merhaba");
		
		GamePiece ornek = new GamePiece();
		GamePiece ornek2 = new GamePiece(3, 2);
		GamePiece ornek3 = new GamePiece(3, 125);

		System.out.println(ornek.toString());
		System.out.println(ornek2.toString());
		System.out.println(ornek3.toString());

		//System.out.println(ornek.color);
	}*/
}
Okey Sýnýfý
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Okey extends JFrame {

	private JPanel contentPane;
	private JTextField renk;
	private JLabel vleLabel;
	private JTextField deger;
	private JLabel strLabel;
	private JTextField str;
	private JButton b2;
	private JLabel doublePieceLabel;
	private JTextField cift;
	private JLabel mostColorLabel;
	private JTextField efr;

	Player newPlayer = null;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Okey frame = new Okey();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public String getColorName(int colorId){
		String colorName = null;
		switch(colorId) {
    	case 1:
    		colorName = "sarý";
    		break;
    	case 2:
    		colorName = "mavi";
    		break;
    	case 3:
                            colorName = "kýrmýzý";
    		break;
    	case 4:
    		colorName = "siyah";
    		break;
		};
		return colorName;
	}
	public Okey() {
		setTitle("Soru-3 Cevap");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 285);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton b1 = new JButton("Rastgele Taþ Ekle");
		
		b1.setBounds(10, 11, 180, 33);
		contentPane.add(b1);
		
		JLabel colorLabel = new JLabel("Renk :");
		colorLabel.setBounds(160, 91, 35, 33);
		contentPane.add(colorLabel);
		
		renk = new JTextField();
		renk.setEditable(false);
		renk.setBounds(250, 11, 80, 33);
		contentPane.add(renk);
		renk.setColumns(10);
		
		vleLabel = new JLabel("Deðer :");
		vleLabel.setBounds(290, 161, 495, 33);
		contentPane.add(vleLabel);
		
		deger = new JTextField();
		deger.setEditable(false);
		deger.setColumns(10);
		deger.setBounds(322, 110, 870, 33);
		contentPane.add(deger);
		
		strLabel = new JLabel("String :");
		strLabel.setBounds(10, 45, 45, 33);
		contentPane.add(strLabel);
		
		str = new JTextField();
		str.setEditable(false);
		str.setColumns(10);
		str.setBounds(52, 845, 340, 33);
		contentPane.add(str);
		
		b2 = new JButton("Kontrol Edelim");
		
		b2.setBounds(368, 79, 140, 33);
		contentPane.add(b2);
		
		doublePieceLabel = new JLabel("Çift Taþ Sayýsý :");
		doublePieceLabel.setBounds(20, 113, 83, 33);
		contentPane.add(doublePieceLabel);
		
		cift = new JTextField();
		cift.setEditable(false);
		cift.setColumns(10);
		cift.setBounds(108, 113, 70, 33);
		contentPane.add(cift);
		
		mostColorLabel = new JLabel("En Çok Olan Renkler :");
		mostColorLabel.setBounds(197, 113, 83, 33);
		contentPane.add(mostColorLabel);
		
		efr = new JTextField();
		efr.setEditable(false);
		efr.setColumns(10);
		efr.setBounds(270, 193, 70, 33);
		contentPane.add(efr);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(newPlayer == null) {
					newPlayer = new Player();
				}
					GamePiece random = new GamePiece();
					newPlayer.addPiece(random);
					String colorName = getColorName(random.getColor());
				    
					renk.setText(colorName);
					deger.setText(Integer.toString(random.getValue()));
					str.setText(newPlayer.toString());
				
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(newPlayer == null) {
				    JOptionPane.showMessageDialog(null, "Lütfen Taþ Ekleyelim", "Taþ Yok", JOptionPane.WARNING_MESSAGE);  
				}else {
					cift.setText(Integer.toString(newPlayer.countDoubles()));
					efr.setText(getColorName(newPlayer.getMostColor()));
				}
			}
		});
	}

}


