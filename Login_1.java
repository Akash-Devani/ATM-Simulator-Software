import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

class Login_1 {
    public static void main(String[] args)
    {
        login123 obj = new login123();
    }
}

class Error {  
    JFrame f; 
    public void valid()
    {
        f=new JFrame();  
        JOptionPane.showMessageDialog(f,"Please Fill Up all detail");
    }
    public void crea()
    {
        f=new JFrame();  
        JOptionPane.showMessageDialog(f,"First Creat Account","Alert",JOptionPane.WARNING_MESSAGE);
    }
    public void depo()
    {
        f=new JFrame();  
        JOptionPane.showMessageDialog(f,"Not have sufficient balance","Alert",JOptionPane.WARNING_MESSAGE);
    }
}

class login123 extends JFrame implements ActionListener
{
    JButton b1;
    JButton b2;
    JButton b3;
    JTextField login_id;
    JTextField password;
    JLabel background;
    JLabel msg;
    public login123()
    {
        background=new JLabel(new ImageIcon("E://Swing//login.jpg"));
        background.setBounds(0, 0, 555, 400);
        add(background);

       b1=new JButton("CREATE");
       b1.setBounds(245, 450, 120,50);
       b2 = new JButton("LOGIN");
       b2.setBounds(100, 450,120,50);
       b3 = new JButton("RESET");
       b3.setBounds(390,450,120,50);
       login_id = new JTextField(20);
       login_id.setBounds(323,250,250,50);
       password = new JTextField(20);
       password.setBounds(323,350,250,50);



       background.add(b1);
       background.add(b2);
       background.add(b3);
       background.add(login_id);
       background.add(password);
       


       b1.addActionListener(this);
       b2.addActionListener(this);
       b3.addActionListener(this);
        
        setLayout(new FlowLayout());
        setBounds(10,5,1347,764);
        setVisible(true);
        setDefaultCloseOperation(3);
    }
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == b1)
        {
            dispose();
            signup sign = new signup();
            
            
        }

        if(ae.getSource() == b2)
        {
            String id=login_id.getText();
            String pass=password.getText();
            Error obj1=new Error();            
            if(id.length()==0 || pass.length()==0)
            {
                
               obj1.valid();
               dispose();
               login123 go = new login123();
            }
            else
            {
                try 
            {
                File obj=new File(id+".txt");
                if(obj.exists())
                {
                    Scanner reader=new Scanner(obj);
                    String data = reader.nextLine();
                    String[] arr=data.split(" ");
                    reader.close();
                    if(arr[1].equals(id) && arr[2].equals(pass))
                    {
                        dispose();
                        mainScreen main_screen = new mainScreen(id);
                    }
                    else
                    {
                        // display error msg
                        
                        obj1.valid();
                        dispose();
                        login123 go = new login123();
                    
                    }
                }
                else
                {
                    obj1.crea();
                    signup sign = new signup();
                }

            } 
            catch (Exception e)
            {
                
            }
            }

        }

        if(ae.getSource() == b3) {
            login_id.setText("");
            password.setText("");
        }
    }
}

class signup extends JFrame implements ActionListener
{
    JButton b1;
    JButton b2;
    JTextField name;
    JTextField id;
    JTextField password;
    JTextField dob;
    JLabel back;
    public signup()
    {
        back = new JLabel(new ImageIcon ("E://Swing//signup.jpg"));
        back.setBounds(0,0,555,400);
        add(back);
        b1 = new JButton("CREATE");
        b2 = new JButton("RESET");
        name = new JTextField(20);
        id = new JTextField(20);
        password = new JTextField(20);
        dob = new JTextField("DDMMYYYY");

        back.add(b1);
        back.add(b2);
        back.add(name);
        back.add(id);
        back.add(password);
        back.add(dob);

        b1.setBounds(100, 500, 120,50);
        b2.setBounds(245, 500,120,50);
        name.setBounds(320, 160, 250, 50);
        id.setBounds(320,240,250,50);
        password.setBounds(320,320,250,50);
        dob.setBounds(320,400,250,50);
        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new FlowLayout());
        setBounds(10,5,1347,764);
        setVisible(true);
        setDefaultCloseOperation(3);
        
    }
    public void actionPerformed (ActionEvent ae) {

        String nam=name.getText();
        String i=id.getText();
        String pass=password.getText();
        String date=dob.getText();
    
        if(ae.getSource() == b1) {

        if(nam.length()==0 || i.length()==0 || pass.length()==0 || date.length()==0)
        {
            Error obj=new Error();
            
            obj.valid();
            dispose();
            signup obj1=new signup();
        }

        else{

            try
        {
            File file = new File(i+".txt");
            file.createNewFile();
            FileWriter wri=new FileWriter(i+".txt");
            wri.write(nam);
            wri.write(" "+i);
            wri.write(" "+pass);
            wri.write(" "+0);
            wri.write(" "+date);
            wri.close();

            File statement_file = new File(i+"_statement.txt");
            statement_file.createNewFile();
            FileWriter wri2 = new FileWriter(i+"_statement.txt");
            wri2.write("signup was succeed.");
            wri2.close();
        }
        catch (IOException e)
        {

        }

        dispose();
        login123 screen2 = new login123();

        }
    }

    if(ae.getSource() == b2) {

        name.setText("");
        id.setText("");
        password.setText("");
        dob.setText("");
    }
        
    }
}

class mainScreen extends JFrame implements ActionListener {

    JLabel back;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    String id;
    public mainScreen(String i)
    {
        back = new JLabel(new ImageIcon("E://Swing//main screen.jpg"));
        back.setBounds(0,0,555,400);
        add(back);

        b1=new JButton("DEPOSIT");
        b2=new JButton("WITHDRAWAL");
        b3=new JButton("MINI-STATEMENT");
        b4=new JButton("SET-PIN");

        
        b1.setBounds(300,200, 200,80);
        b2.setBounds(300,400,200,80);
        b3.setBounds(600,200,200,80);
        b4.setBounds(600,400,200,80);

        back.add(b1);
        back.add(b2);
        back.add(b3);
        back.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        id=i;

        setLayout(new FlowLayout());
        setBounds(10,5,1347,764);
        setVisible(true);
        setDefaultCloseOperation(3);
    }
    public void actionPerformed (ActionEvent ae) {
        dispose();
        if(ae.getSource()==b1)
        {
            Deposit d=new Deposit(id);   
        }
        else if(ae.getSource()==b2)
        {
            Withdrawl with=new Withdrawl(id);
        }  
        else if(ae.getSource()==b3)
        {
            mini_statement pin = new mini_statement(id);
        }
        else if(ae.getSource()==b4)
        {
            set_pin pin = new set_pin(id);
        }
    }
} 
class Deposit extends JFrame implements ActionListener
{
    JTextField t1;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JLabel back;
    String id;
    public Deposit(String i)
    {
        back=new JLabel(new ImageIcon("E://Swing//deposit.jpg"));
        back.setBounds(0,0,555,400);
        add(back);

        t1=new JTextField(20);
        b1=new JButton("500 Rs.");
        b2=new JButton("1000 Rs.");
        b3=new JButton("2000 Rs.");
        b4=new JButton("5000 Rs.");
        b5=new JButton("DONE");
        b6 = new JButton("PREVIOUS");

        t1.setBounds(400, 100, 375, 58);
        b1.setBounds(400, 230, 180, 65);
        b2.setBounds(605, 230, 180, 65);
        b3.setBounds(400, 320, 180, 65);
        b4.setBounds(605, 320, 180, 65);
        b5.setBounds(605, 405, 100, 50);
        b6.setBounds(480,405,100,50);

        back.add(t1);
        back.add(b1);
        back.add(b2);
        back.add(b3);
        back.add(b4);
        back.add(b5);
        back.add(b6);

        id=i;
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        setLayout(new FlowLayout());
        setBounds(10,5,1347,764);
        setVisible(true);
        setDefaultCloseOperation(3);
    }

    public void actionPerformed (ActionEvent ae)
    {
        int x=0;                    
        String s=""; 
        if(ae.getSource()==b1)
        {
            if((t1.getText().equals(s))==false)
                x=Integer.parseInt(t1.getText());
            x=x+500;
            t1.setText(x+"");             
        }
        if(ae.getSource()==b2)
        {
            if((t1.getText().equals(s))==false)
                x=Integer.parseInt(t1.getText());
            x=x+1000;
            t1.setText(x+"");  
        }
        if(ae.getSource()==b3)
        {
            if((t1.getText().equals(s))==false)
                x=Integer.parseInt(t1.getText());
            x=x+2000;
            t1.setText(x+"");  
        }
        if(ae.getSource()==b4)
        {
            if((t1.getText().equals(s))==false)
                x=Integer.parseInt(t1.getText());
            x=x+5000;
            t1.setText(x+"");  
        }
        if(ae.getSource()==b5)
        {
            try 
            {
            File obj=new File(id+".txt");
            Scanner reader=new Scanner(obj);
            String data = reader.nextLine();
            String[] arr=data.split(" ");
            reader.close();
            x=Integer.parseInt(t1.getText());
            int z=Integer.parseInt(arr[3])+x;
            String y=z+"";
            arr[3]=y;
            String balance = arr[3];
            String neu=arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4];
            FileWriter wri=new FileWriter(id+".txt");
            wri.write(neu);
            wri.close();

            DateTimeFormatter current_time = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String current = current_time.format(now);

            
            byte[] add_5000 = ( "\n" + current + "  " + x +" rupees added" + "  "  + " balance = " +balance).getBytes();
            FileOutputStream wri2 = new FileOutputStream(id+"_statement.txt", true);
            wri2.write(add_5000);

            dispose();

            success final2 = new success(id); 
            } 
            catch (Exception e)
            {
            
            }
        }

        if(ae.getSource() == b6){

            dispose();
            mainScreen old = new mainScreen(id);
        }
        

    }
}
class Withdrawl extends JFrame implements ActionListener
{
    JTextField t1;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JLabel back;
    String id;
    public Withdrawl(String i)
    {
        
        
        back=new JLabel(new ImageIcon("E://Swing//withdraw.jpg"));
        back.setBounds(0,0,555,400);
        add(back);

        t1=new JTextField(20);
        b1=new JButton("500 Rs.");
        b2=new JButton("1000 Rs.");
        b3=new JButton("2000 Rs.");
        b4=new JButton("5000 Rs.");
        b5=new JButton("DONE");
        b6=new JButton("PREVIOUS");
    
        t1.setBounds(400, 100, 375, 58);
        b1.setBounds(400, 230, 180, 65);
        b2.setBounds(605, 230, 180, 65);
        b3.setBounds(400, 320, 180, 65);
        b4.setBounds(605, 320, 180, 65);
        b5.setBounds(605, 405, 100, 50);
        b6.setBounds(480,405,100,50);

        id=i;
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
    
        back.add(t1);
        back.add(b1);
        back.add(b2);
        back.add(b3);
        back.add(b4);
        back.add(b5);
        back.add(b6);
    
        setLayout(new FlowLayout());
        setBounds(10,5,1347,764);
        setVisible(true);
        setDefaultCloseOperation(3);
        
    }
    public void actionPerformed (ActionEvent ae)
    {
        int x=0;
        String s="";
        Error obj2 = new Error();
        if(ae.getSource()==b1)
        {
            if((t1.getText().equals(s))==false)
                x=Integer.parseInt(t1.getText());
            x=x+500;
            t1.setText(x+"");            
        }
        if(ae.getSource()==b2)
        {
            if((t1.getText().equals(s))==false)
                x=Integer.parseInt(t1.getText());
            x=x+1000;
            t1.setText(x+"");  
        }
        if(ae.getSource()==b3)
        {
            if((t1.getText().equals(s))==false)
                x=Integer.parseInt(t1.getText());
            x=x+2000;
            t1.setText(x+"");  
        }
        if(ae.getSource()==b4)
        {
            if((t1.getText().equals(s))==false)
                x=Integer.parseInt(t1.getText());
            x=x+5000;
            t1.setText(x+"");  
        }
        
        if(ae.getSource()==b5)
        {
            try 
            {
            File obj=new File(id+".txt");
            Scanner reader=new Scanner(obj);
            String data = reader.nextLine();
            String[] arr=data.split(" ");
            reader.close();
            x=Integer.parseInt(t1.getText());
            int z=Integer.parseInt(arr[3])-x;
            if(z<0)
            {
                obj2.depo();
            }
            else
            {
                String y=z+"";
                arr[3]=y;
                String balance = arr[3];
                String neu=arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4];
                FileWriter wri=new FileWriter(id+".txt");
                wri.write(neu);
                wri.close();

                DateTimeFormatter current_time = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String current = current_time.format(now);
                
                byte[] minus_x = ( "\n" + current + "  " + x +" rupees withdrawal" + "  "  + " balance = " +balance).getBytes();
                FileOutputStream wri2 = new FileOutputStream(id+"_statement.txt", true);
                wri2.write(minus_x);

                dispose();

                success final2 = new success(id); 
            } 
        }
            catch (Exception e)
            {
            
            }
        }

        if(ae.getSource() == b6){

            dispose();
            mainScreen old = new mainScreen(id);
        }
    }
}

class mini_statement extends JFrame implements ActionListener {

    JLabel back;
    JButton b1;
    JButton b2;
    JButton b3;
    String id;
    public mini_statement(String i)
    {
        back = new JLabel(new ImageIcon("E://Swing//statement.jpg"));
        back.setBounds(0,0,575,440);
        add(back);

        b1 = new JButton("View Statement Online");
        b2 = new JButton("DONE");
        b3 = new JButton("PREVIOUS");

        back.add(b1);
        back.add(b2);
        back.add(b3);

        id = i;

        b1.setBounds(450,180,215,80);
        b2.setBounds(570,290,100,55);
        b3.setBounds(450,290,100,55);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setLayout(new FlowLayout());
        setBounds(10,5,1347,764);
        setVisible(true);
        setDefaultCloseOperation(3);
    }
    public void actionPerformed(ActionEvent ae) {
        dispose();
        if(ae.getSource() == b1 ) {
            mini_statement newmini = new mini_statement(id);
            OpenTextFileIntoJTextArea view_statement = new OpenTextFileIntoJTextArea(id);
        }

        
        if(ae.getSource() == b2 ) {
            
            success f2 = new success(id);             
        }

        if(ae.getSource() == b3){

            dispose();
            mainScreen old = new mainScreen(id);
        }

    }
}

class OpenTextFileIntoJTextArea extends JFrame
{
    String id;
public OpenTextFileIntoJTextArea(String i)
{
 try
 {
  id = i;
  FileReader readTextFile=new FileReader(id+"_statement.txt");

  Scanner fileReaderScan=new Scanner(readTextFile);

  String storeAllString="";

  while(fileReaderScan.hasNextLine())
  {
   String temp=fileReaderScan.nextLine()+"\n";
  
   storeAllString=storeAllString+temp;
  }

  fileReaderScan.close();
  JTextArea textArea=new JTextArea(storeAllString);
 
  textArea.setLineWrap(true);
 
  textArea.setWrapStyleWord(true);
 
  JScrollPane scrollBarForTextArea=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
 
  JFrame frame=new JFrame("Statement");
 
  frame.add(scrollBarForTextArea);
 
  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
  frame.setSize(500,500);
 
  frame.setLocationRelativeTo(null);
 
  frame.setVisible(true);
 }
 catch(Exception exception)
 {
  System.out.println("Error in file processing");
 }
}
}

class set_pin extends JFrame implements ActionListener{

    JLabel back;
    JTextField pin_field;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton b8;
    JButton b9;
    JButton b10;
    JButton b11;
    JButton b12;
    JButton b13;
    JButton b14;
    String id;
    public set_pin(String i)
    {
        back = new JLabel(new ImageIcon("E://Swing//pin.jpg"));
        back.setBounds(0,0,575,440);
        add(back);

        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b10 = new JButton("0");
        b11 = new JButton("+");
        b12 = new JButton("CLEAR");
        b13 = new JButton("Confirm");
        b14 = new JButton("PREVIOUS");
        pin_field = new JTextField(20);

        back.add(b1);
        back.add(b2);
        back.add(b3);
        back.add(b4);
        back.add(b5);
        back.add(b6);
        back.add(b7);
        back.add(b8);
        back.add(b9);
        back.add(b10);
        back.add(b11);
        back.add(b12);
        back.add(b13);
        back.add(b14);
        back.add(pin_field);
        id = i;

        b1.setBounds(500,205,67,63);
        b2.setBounds(575,205,67,63);
        b3.setBounds(650,205,67,63);
        b4.setBounds(500,276,67,63);
        b5.setBounds(575,276,67,63);
        b6.setBounds(650,276,67,63);
        b7.setBounds(500,347,67,63);
        b8.setBounds(575,347,67,63);
        b9.setBounds(650,347,67,63);
        b10.setBounds(500,418,67,63);
        b11.setBounds(575,418,67,63);
        b12.setBounds(650,418,67,63);
        b13.setBounds(650,600,160,50);
        b14.setBounds(400,600,160,50);
        pin_field.setBounds(480,120,260,63);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);

        setLayout(new FlowLayout());
        setBounds(10,5,1347,764);
        setVisible(true);
        setDefaultCloseOperation(3);
    }

    public void actionPerformed(ActionEvent ae) {
        
        String s = "";
        String x = "";
        String pin_key = "";
        Error error = new Error();
        if((pin_field.getText().equals(s)) ==false)
        {
            x = pin_field.getText();
        }

        if(ae.getSource()==b13) 
        {
            if((pin_field.getText().equals(s)) ==false){
            try
            {
                File obj = new File(id+".txt");
                Scanner reader = new Scanner(obj);
                String data = reader.nextLine();
                String[] arr = data.split(" ");
                reader.close();
                String y = x;
                arr[2] = y;
                String neu = arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4];
                FileWriter wri = new FileWriter(id+".txt");
                wri.write(neu);
                wri.close();

                dispose();
                success newfinal = new success(id);
            }
        

            catch(Exception e) {

            }
        }
        else{

            error.valid();

        }
            
        }

        if (ae.getSource() == b12)
        {
            pin_field.setText("");
        }

        if (ae.getSource() == b1)
        {
            pin_field.setText(pin_field.getText() + "1");
        }

        if (ae.getSource() == b2)
        {
            pin_field.setText(pin_field.getText() + "2");
        }

        if (ae.getSource() == b3)
        {
            pin_field.setText(pin_field.getText() + "3");
        }

        if (ae.getSource() == b4)
        {
            pin_field.setText(pin_field.getText() + "4");
        }

        if (ae.getSource() == b5)
        {
            pin_field.setText(pin_field.getText() + "5");
        }

        if (ae.getSource() == b6)
        {
            pin_field.setText(pin_field.getText() + "6");
        }

        if (ae.getSource() == b7)
        {
            pin_field.setText(pin_field.getText() + "7");
        }

        if (ae.getSource() == b8)
        {
            pin_field.setText(pin_field.getText() + "8");
        }

        if (ae.getSource() == b9)
        {
            pin_field.setText(pin_field.getText() + "9");
        }

        if (ae.getSource() == b10)
        {
            pin_field.setText(pin_field.getText() + "0");
        }

        if(ae.getSource() == b14){

            dispose();
            mainScreen old = new mainScreen(id);
        }
    }
}

class success extends JFrame implements ActionListener
{
    JLabel back;
    JButton ok;
    JButton pri;
    String id;
    public success(String i)
    {
        back = new JLabel(new ImageIcon("E://Swing//success.jpg"));
        back.setBounds(0,0,575,440);
        add(back); 

        ok = new JButton ("DONE");
        pri = new JButton("PREVIOUS");
        back.add(ok);
        back.add(pri);

        id=i;

        ok.setBounds(310, 300, 100,50);
        pri.setBounds(180,300,100,50);
        ok.addActionListener(this);
        pri.addActionListener(this);

        setLayout(new FlowLayout());
        setBounds(400,200,575,440);
        setVisible(true);
        setDefaultCloseOperation(3); 
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == ok){
        dispose();
        login123 finalnew = new login123();
        }

        if(ae.getSource() == pri){

            dispose();
            mainScreen old = new mainScreen(id);
        }
    }
}