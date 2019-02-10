package mainView;

import java.awt.BorderLayout;
import java.awt.Color;
import mainController.Controller;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView extends JFrame {

    private JLabel lblTitle1, lblTitle2, lblImg, lblReport;
    private JButton btnOut, btnIn, btnReport;

    public MainView(Controller controller) {
        setTitle("Parking Zone");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));
        
        
        
        Font fontMain = new Font("Tw Cen MT", 3, 22);

        JPanel panelUp = new JPanel();
        panelUp.setLayout(new FlowLayout());
        panelUp.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panelUp.setBackground(new Color(94, 161, 229));

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new GridLayout(1, 2, 50, 50));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panelCenter.setBackground(new Color(51, 100, 150));
        
        JPanel panelDown = new JPanel();
        panelDown.setLayout(new BorderLayout());
        panelDown.setBackground(new Color(94, 161, 229));
        
        JPanel reportImg = new JPanel();
        reportImg.setLayout(new FlowLayout());
        reportImg.setBackground(new Color(94, 161, 229));
        
        ImageIcon logo = new ImageIcon("data/img.png");
        ImageIcon report = new ImageIcon("data/report.png");

        lblTitle1 = new JLabel("Parking");
        lblTitle1.setFont(fontMain);
        lblTitle1.setForeground(Color.WHITE);
        lblTitle2 = new JLabel("Braves");
        lblTitle2.setFont(fontMain);
        lblTitle2.setForeground(Color.WHITE);
        lblImg = new JLabel("");
        lblImg.setIcon(logo);        

        btnIn = new JButton("Ingreso");        
        btnIn.setFont(fontMain);
        btnIn.setBorder(BorderFactory.createLineBorder(new Color(234, 53, 53), 10));
        btnIn.setActionCommand("In");
        btnIn.addActionListener(controller);

        btnOut = new JButton("Salida");
        btnOut.setFont(fontMain);
        btnOut.setBorder(BorderFactory.createLineBorder(new Color(234, 53, 53), 10));
        btnOut.setActionCommand("Out");        
        btnOut.addActionListener(controller);
                
        lblReport = new JLabel("Generar Reporte");
        lblReport.setForeground(Color.WHITE);
        lblReport.setFont(fontMain);
        lblReport.setHorizontalAlignment(JLabel.CENTER);
        btnReport = new JButton();
        btnReport.setIcon(report);
        btnReport.setActionCommand("report");
        btnReport.addActionListener(controller);
        btnReport.setBorder(null);
        btnReport.setOpaque(false);
        btnReport.setContentAreaFilled(false);
        btnReport.setBorderPainted(false);
        reportImg.add(btnReport);
        
        panelUp.add(lblTitle1);
        panelUp.add(lblImg);
        panelUp.add(lblTitle2);
        
        panelCenter.add(btnIn);
        panelCenter.add(btnOut);
        
        panelDown.add(lblReport, BorderLayout.NORTH);
        panelDown.add(reportImg, BorderLayout.CENTER);
        

        add(panelUp);
        add(panelCenter);
        add(panelDown);

        setVisible(true);
    }

}
