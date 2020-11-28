package tlr.vladimir;

import javax.swing.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main extends JFrame {

    private static ArrayList<String> data = null;
    private static String otvet = "";
    private static int tecNumber = 0;
    private static Base b = null;

    public static void main(String[] args) {
        b = new Base(true);
        data = b.getQuestions();
        EventQueue.invokeLater(() -> {
            try {
                Main frame = new Main();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    private static JButton btnNewButton;
    private static JButton btnNewButton_1;
    private static JButton btnNewButton_2;
    private static JButton btnNewButton_3;
    private static JButton btnNewButton_4;
    private static JLabel lblNewLabel;
    private static JButton b1;
    private static JButton b2;
    private static JTextPane textPane;

    public Main() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 480, 283);
        setTitle("Поиск программы");
        setResizable(false);
        JLabel contentPane = new JLabel();
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        Image img = ImageIO.read(new File("./fon.jpeg"));
        contentPane.setIcon(new ImageIcon(img));

        btnNewButton = new JButton("Android");
        btnNewButton.setFont(new Font("Noto Serif", Font.PLAIN, 17));
        btnNewButton.setBounds(10, 168, 100, 65);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("IOS");
        btnNewButton_1.setFont(new Font("Noto Serif", Font.PLAIN, 17));
        btnNewButton_1.setBounds(120, 168, 111, 65);
        contentPane.add(btnNewButton_1);

        btnNewButton_2 = new JButton("macOS");
        btnNewButton_2.setFont(new Font("Noto Serif", Font.PLAIN, 17));
        btnNewButton_2.setBounds(10, 92, 100, 65);
        contentPane.add(btnNewButton_2);

        btnNewButton_3 = new JButton("Windows");
        btnNewButton_3.setFont(new Font("Noto Serif", Font.PLAIN, 20));
        btnNewButton_3.setBounds(10, 11, 221, 70);
        contentPane.add(btnNewButton_3);

        btnNewButton_4 = new JButton("Linux");
        btnNewButton_4.setFont(new Font("Noto Serif", Font.PLAIN, 17));
        btnNewButton_4.setBounds(120, 92, 111, 65);
        contentPane.add(btnNewButton_4);

        lblNewLabel = new JLabel("<html><div style='text-align: center;'>" + data.get(tecNumber) + "</div></html>");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblNewLabel.setBounds(10, 11, 444, 108);
        lblNewLabel.setVisible(false);
        lblNewLabel.setForeground(Color.WHITE);
        contentPane.add(lblNewLabel);


        b2 = new JButton("\u0414\u0430");
        b2.setFont(new Font("Noto Serif", Font.PLAIN, 33));
        b2.setBounds(10, 159, 189, 74);
        b2.setVisible(false);
        contentPane.add(b2);

        b1 = new JButton("\u041D\u0435\u0442");
        b1.setFont(new Font("Noto Serif", Font.PLAIN, 33));
        b1.setBounds(265, 159, 189, 74);
        b1.setVisible(false);
        contentPane.add(b1);

        textPane = new JTextPane();
        textPane.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
        textPane.setText("\u041F\u043E\u0434\u0431\u043E\u0440 \u0442\u0435\u043A\u0441\u0442\u043E\u0432\u043E\u0433\u043E \u0440\u0435\u0434\u0430\u043A\u0442\u043E\u0440\u0430\r\n\r\n\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435 \u0432\u0430\u0448\u0443 \u043E\u043F\u0435\u0440\u0430\u0446\u0438\u043E\u043D\u043D\u0443\u044E \u0441\u0438\u0441\u0442\u0435\u043C\u0443 \u0447\u0442\u043E\u0431\u044B \u043D\u0430\u0447\u0430\u0442\u044C...\r\n");
        textPane.setBounds(241, 11, 213, 222);
        textPane.setForeground(Color.WHITE);
        textPane.setOpaque(false);
        textPane.setEditable(false);
        contentPane.add(textPane);

        b1.addActionListener(arg0 -> work(1, lblNewLabel));

        b2.addActionListener(arg0 -> work(2, lblNewLabel));

        btnNewButton.addActionListener(arg0 -> {
            work(6, lblNewLabel);
            vis(true);
        });

        btnNewButton_1.addActionListener(arg0 -> {
            work(7, lblNewLabel);
            vis(true);
        });

        btnNewButton_2.addActionListener(arg0 -> {
            work(4, lblNewLabel);
            vis(true);
        });

        btnNewButton_3.addActionListener(arg0 -> {
            work(3, lblNewLabel);
            vis(true);
        });

        btnNewButton_4.addActionListener(arg0 -> {
            work(5, lblNewLabel);
            vis(true);
        });
    }

    private static void vis(boolean a){
        b2.setVisible(a);
        b1.setVisible(a);
        lblNewLabel.setVisible(a);
        btnNewButton.setVisible(!a);
        btnNewButton_1.setVisible(!a);
        btnNewButton_2.setVisible(!a);
        btnNewButton_3.setVisible(!a);
        btnNewButton_4.setVisible(!a);
        textPane.setVisible(!a);
    }

    protected void work(int i, JLabel l) {
        if(i == 1 || i == 2){
            otvet += (i == 1) ? "N" : "Y";
        }else{
            otvet += i + "";
        }
        tecNumber++;

        if(tecNumber >= data.size()){
            setVisible(false);
            tecNumber = 0;

            ArrayList<String> apps = b.getProg(otvet);
            Set<String> set = new HashSet<>(apps);
            apps.clear();
            apps.addAll(set);

            System.out.println(apps);
            String out = "Вот программы которые подходят вам:";
            for(String d : apps){
                out += "<br><br>" + d + "<br><a href=\"" + b.getLink(d) + "\">" + b.getLink(d) + "</a>";
            }

            JEditorPane ep = new JEditorPane("text/html", "<html><body>"
                    + out
                    + "</body></html>");

            ep.addHyperlinkListener(e -> {
                if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
                    openWebpage(e.getURL());
            });
            ep.setEditable(false);
            ep.setBackground(l.getBackground());

            JOptionPane.showMessageDialog(null, ep);

            otvet = "";
            vis(false);
            setVisible(true);
        }
        l.setText("<html><div style='text-align: center;'>" + data.get(tecNumber) + "</div></html>");
    }

    public static boolean openWebpage(URL url) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(url.toURI());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}