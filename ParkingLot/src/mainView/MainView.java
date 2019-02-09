package mainView;

import mainController.Controller;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame {

    private JLabel lblTitle;
    private JButton btnIn, btnOut, btnImg, btnReport;

    public MainView(Controller controller) {
        setTitle("Parking Zone");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 10, 10));

        JPanel panelUp = new JPanel();
        panelUp.setLayout(new FlowLayout());
        panelUp.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(1, 2, 50, 50));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        JPanel panelDown = new JPanel();
        panelDown.setLayout(new FlowLayout());
        
        ImageIcon img = new ImageIcon("data/image.png");

        lblTitle = new JLabel("Parking zone");
        btnImg = new JButton();
        //btnImg.setIcon(img);
        btnImg.setBorder(null);

        btnIn = new JButton("Ingreso");
        btnIn.setActionCommand("In");
        btnIn.addActionListener(controller);

        btnOut = new JButton("Salida");
        btnOut.setActionCommand("Out");
        btnOut.addActionListener(controller);
                
        btnReport = new JButton("Generar Reporte");
        btnReport.setActionCommand("report");
        btnReport.addActionListener(controller);
        
        panelUp.add(lblTitle);
        panelUp.add(btnImg);
        
        panelCenter.add(btnIn);
        panelCenter.add(btnOut);
        
        panelDown.add(btnReport);
        

        add(panelUp);
        add(panelCenter);
        add(panelDown);

        setVisible(true);
    }

}
