import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AWT extends Frame implements ActionListener { // Constructor for ActionListner
    AWT() {
        Button b1 = new Button("Read");
        Button b2 = new Button("Save");
        Button b3 = new Button("Delete");
        Button b4 = new Button("Copy");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        add(b1);
        add(b2);
        add(b3);
        add(b4);

        b1.setActionCommand("b1");
        b2.setActionCommand("b2");
        b3.setActionCommand("b3");
        b4.setActionCommand("b4");

        setSize(400, 400);
        setVisible(true);
        setLayout(new GridLayout(4, 1));
        setBackground(Color.BLUE);

    }

    // For reading file
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("b1")) {
            Frame f = new Frame();
            f.setVisible(true);
            f.setSize(700, 700);
            f.setLayout(null);
            f.setBackground(Color.GREEN);

            TextField t1 = new TextField();
            t1.setBounds(50, 50, 100, 30);
            t1.setVisible(true);
            f.add(t1);

            Button b5 = new Button("Load");
            b5.setBounds(50, 100, 60, 30);
            b5.setBackground(Color.white);
            b5.setVisible(true);
            f.add(b5);

            TextArea t2 = new TextArea();
            t2.setBounds(50, 150, 400, 200);
            t2.setVisible(true);
            f.add(t2);

            b5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        InputStream i = new FileInputStream(t1.getText());
                        int c1;
                        String s1 = "";
                        while ((c1 = i.read()) != -1) {
                            s1 = s1 + (char) c1;
                        }
                        t2.setText(s1);
                    } catch (Exception e1) {
                        System.out.println("File not found");
                    }
                }
            });
        }  
          

    // For saving File
    if (e.getActionCommand().equals("b2")) {
        Frame f1 = new Frame();
        f1.setVisible(true);
        f1.setSize(700, 700);
        f1.setLayout(null);
        f1.setBackground(Color.BLUE);

        TextField t3 = new TextField();
        t3.setBounds(50, 50, 100, 30);
        t3.setVisible(true);
        f1.add(t3);

        Button b6 = new Button("Load");
        b6.setBounds(50, 100, 60, 30);
        b6.setBackground(Color.white);
        b6.setVisible(true);
        f1.add(b6);

        TextArea t4 = new TextArea();
        t4.setBounds(50, 150, 400, 200);
        t4.setVisible(true);
        f1.add(t4);

        b6.addActionListener(new ActionListener()
        {  
            @Override
            public void actionPerformed(ActionEvent e)
            {
                char[] str=new char[100];
                String s=t4.getText();
                str=s.toCharArray();
                try
                {
                    try (OutputStream o = new FileOutputStream("xyz.txt")) {
                        for(int i=0;i<s.length();i++)
                        {
                            o.write(str[i]);
                        }
                    }
                }
                catch(Exception E)    // File not found Exception
                {}
            }
        });
    }  


// For Deleting file

if (e.getActionCommand().equals("b3")) {
    Frame f2 = new Frame();
    f2.setSize(500, 500);
    f2.setVisible(true);
    f2.setLayout(null);
    f2.setBackground(Color.ORANGE);

    TextField t5 = new TextField();
    t5.setBounds(50, 50, 150, 30);
    f2.add(t5);

    Button b7 = new Button("Delete");
    b7.setBounds(225, 50, 60, 30);
    b7.setBackground(Color.white);
    f2.add(b7);

    b7.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            File f3 = new File(t5.getText());
            f3.delete();
        }
    });

}

// For Copying file

if (e.getActionCommand().equals("b4")) {
    Frame f3 = new Frame();
    f3.setSize(500, 500);
    f3.setVisible(true);
    f3.setLayout(null);
    f3.setBackground(Color.GRAY);

    TextField t6 = new TextField();
    t6.setBounds(50, 50, 150, 30);
    f3.add(t6);

    TextField t7 = new TextField();
    t7.setBounds(50, 100, 150, 30);
    f3.add(t7);

    Button b8 = new Button("Copy");
    b8.setBounds(200, 200, 60, 30);
    b8.setBackground(Color.white);
    f3.add(b8);

    b8.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int a ;
            try
            {
                InputStream i=new FileInputStream(t6.getText());
                OutputStream o=new FileOutputStream(t7.getText());
                while ((a=i.read())!=-1)
                {
                    o.write(a);
                }
            }
            catch(Exception E)
            {}
        }
    });
}
}

    public static void main(String[] args) {
         new AWT();
    }
        }