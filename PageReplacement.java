package osgla2;
/*
 * NAME - MAYURI GUPTA
 * ROLL - 1710110209
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PageReplacement implements ActionListener {
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	JFrame f = new JFrame();
	JPanel p1=new JPanel();  // main panel which is added to frame
	JPanel p2=new JPanel(); // panel of grid 1
	JPanel p3=new JPanel(); // panel of grid 2
	JPanel p4=new JPanel(); // panel of grid 3
	JPanel p5=new JPanel(); // panel of grid 4
	JPanel p6=new JPanel(); // panel of grid 5
	JPanel p7=new JPanel(); // panel of grid 6
	JPanel p8=new JPanel(); // panel of grid 7
	JPanel p9=new JPanel(); // panel of grid 8
	JPanel p10=new JPanel(); // panel of grid 9
	JLabel l1=new JLabel("Number Of Frames");
	JLabel l2=new JLabel("Reference String");
	JLabel l3=new JLabel("FIRST IN FIRST OUT PAGE REPLACEMENT ALGORITHM");
	JLabel l4=new JLabel("OPTIMAL PAGE REPLACEMENT ALGORITHM");
	JLabel l5=new JLabel("LEAST RECENTLY USED REPLACEMENT ALGORITHM");
	JButton b1=new JButton("COMPUTE");
	JTextField t1=new JTextField("");
	String [] frm={"3","4","5","6","7"};
	JComboBox box=new JComboBox(frm);
	PageReplacement(){
	        f.setLayout(new BorderLayout());
	        f.setResizable(false);
	        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        Font font=new Font("Arial",Font.BOLD,15);
	        p1.setBorder(BorderFactory.createLineBorder(Color.red,3));
	        p1.setLayout(new GridLayout(9,1));
	        p2.setLayout(null);
	        p3.setLayout(null);
	        p4.setLayout(null);
	        p5.setLayout(null);
	        p7.setLayout(null);
	        p9.setLayout(null);
	        l1.setBounds(500, 0, 300, 100);
	        l2.setBounds(50, 0,300,100);
	        l3.setBounds(50,0,500,100);
	        l4.setBounds(50,0,500,100);
	        l5.setBounds(50,0,500,100);
	        l1.setFont(font);
	        l2.setFont(font);
	        l3.setFont(font);
	        l4.setFont(font);
	        l5.setFont(font);
	        l3.setForeground(Color.BLUE);
	        l4.setForeground(Color.BLUE);
	        l5.setForeground(Color.BLUE);
	        box.setBounds(650,33,100,30);
	        t1.setBounds(200,34,1100,30);
	        b1.setBounds(580,30,150,50);
	        b1.addActionListener(this);
	        p2.add(l1);
	        p2.add(box);
	        p3.add(l2);
	        p3.add(t1);
	        p4.add(b1);
	        p1.add(p2);
	        p1.add(p3);
	        p1.add(p4);
	        JScrollPane scrollPane = new JScrollPane(p1);
	        f.getContentPane().add(scrollPane);
	        f.pack();
	        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	        f.setVisible(true);
	}
	
	public static void main(String args[]){
		new PageReplacement();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		p5.removeAll();
		p6.removeAll();
		p7.removeAll();
		p8.removeAll();
		p9.removeAll();
		p10.removeAll();
		int counter=0;
		String text=t1.getText();
		String [] af=text.split("[,.]"); // array from textfield
		int [] array=new int[af.length]; // integer array of reference string
		for(int i=0;i<af.length;i++)
			array[i]=Integer.parseInt(af[i]);
		p5.add(l3);
        p7.add(l4);
        p9.add(l5);
		int loc=Integer.parseInt(box.getSelectedIndex()+"");
		int frames=Integer.parseInt(frm[loc]);
		int n=frames+2;
		int m=array.length+1;
		p6.setLayout(new GridLayout(n,m));
		p8.setLayout(new GridLayout(n,m));
		p10.setLayout(new GridLayout(n,m));
		String [][] ans=new String[n][m];
		// FIFO:
		for(int j=1;j<m;j++)
			ans[0][j]=af[j-1];
		for(int i=1;i<n-1;i++)
			ans[i][0]="f"+i+"";
		for(int i=1;i<n;i++)
			for(int j=1;j<m;j++)
				ans[i][j]="NULL";
		Queue<String> queue=new LinkedList<String>(); 
		for(int j=1;j<m;j++){
			String check="";
			int siz=queue.size();
			if(queue.contains(af[j-1])){
				ans[n-1][j]="HIT";
				continue;
			}
			if(siz>=frames)
				check=queue.remove();
			for(int i=1;i<n;i++){
				if(check.equals("2"));
				if(siz<frames)
					{
						if(ans[i][j].equalsIgnoreCase("NULL"))
						{queue.add(af[j-1]);
						ans[n-1][j]="FAULT";
						counter+=1;
						int k=j; 
						while(k<m)
						ans[i][k++]=af[j-1];
						break;}
					}
					else{
						if(check.equalsIgnoreCase(ans[i][j])){
							queue.add(af[j-1]);
							ans[n-1][j]="FAULT";
							counter+=1;
							int k=j;
							while(k<m)
								ans[i][k++]=af[j-1];
							break;
						}
					}
				}
			}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
			JLabel b=new JLabel(ans[i][j]);
        	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        	b.setOpaque(true);
        	b.setBackground(Color.WHITE);
        	b.setBorder(border);
        	b.setHorizontalAlignment(SwingConstants.CENTER);
        	p6.add(b);
		}
		}
		JLabel pg1=new JLabel("NUMBER OF PAGE FAULTS: "+counter);
    	JLabel pg2=new JLabel("NUMBER OF PAGE HITS: "+(af.length-counter));
    	pg1.setBounds(800,0,500,100);
    	pg2.setBounds(1050,0,500,100);
    	Font font=new Font("Arial",Font.BOLD,15);
    	pg1.setFont(font);
    	pg2.setFont(font);
    	p5.add(pg1);
    	p5.add(pg2);
    	counter=0;
		// OPTIMAL:
		for(int j=1;j<m;j++)
			ans[0][j]=af[j-1];
		for(int i=1;i<n-1;i++)
			ans[i][0]="f"+i+"";
		for(int i=1;i<n;i++)
			for(int j=1;j<m;j++)
				ans[i][j]="NULL";
		ArrayList<String> a=new ArrayList<String>();
		for(int j=1;j<m;j++){
			int time=0,test=0;
			TreeMap<Integer,String> at=new TreeMap();
			String check="";
			if(a.contains(af[j-1])){
				ans[n-1][j]="HIT";
				continue;
			}
			if(a.size()>=frames){
				for(int k=0;k<a.size();k++){
					int flag=0;
					for(int l=j+1;l<m;l++){
						if(a.get(k).equalsIgnoreCase(af[l-1])){
							flag=1;
							at.put(l+1,a.get(k));
							time+=1;
							break;
						}
					}
					if(flag==0)
						at.put((time+1)*100,a.get(k));
				}
				test=at.lastKey();
				check=at.get(test);
			}
				for(int i=1;i<n;i++){
					if((a.size())<frames)
						{
							if(ans[i][j].equalsIgnoreCase("NULL"))
							{
								a.add(af[j-1]);
							    ans[n-1][j]="FAULT";
							    counter+=1;
							    int k=j; 
							    while(k<m)
							    ans[i][k++]=af[j-1];
							    break;
							    }
						}
						else{
							if(check.equalsIgnoreCase(ans[i][j])){
								a.add(af[j-1]);
								for(int k=0;k<a.size();k++)
								{
									if(a.get(k).equalsIgnoreCase(check))
										a.remove(k);
								}
								ans[n-1][j]="FAULT";
								counter+=1;
								int k=j;
								while(k<m)
									ans[i][k++]=af[j-1];
								break;
							}
						}
					}
			}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
			JLabel b=new JLabel(ans[i][j]);
        	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        	b.setOpaque(true);
        	b.setBackground(Color.WHITE);
        	b.setBorder(border);
        	b.setHorizontalAlignment(SwingConstants.CENTER);
        	p8.add(b);
		}
		}
		JLabel pg3=new JLabel("NUMBER OF PAGE FAULTS: "+counter);
    	JLabel pg4=new JLabel("NUMBER OF PAGE HITS: "+(af.length-counter));
    	pg3.setBounds(800,0,500,100);
    	pg4.setBounds(1050,0,500,100);
    	pg3.setFont(font);
    	pg4.setFont(font);
    	p7.add(pg3);
    	p7.add(pg4);
    	counter=0;
		// LRU :
		for(int j=1;j<m;j++)
			ans[0][j]=af[j-1];
		for(int i=1;i<n-1;i++)
			ans[i][0]="f"+i+"";
		for(int i=1;i<n;i++)
			for(int j=1;j<m;j++)
				ans[i][j]="NULL";
		TreeMap<Integer,String> tree=new TreeMap();
		int time=0;
		for(int j=1;j<m;j++){
			String check="";
			Integer check_key=0;
			for(Map.Entry<Integer,String>entry : tree.entrySet()){
				check=entry.getValue();
				check_key=entry.getKey();
				break;
			}
		
			for(int i=1;i<n;i++){
				if(tree.containsValue(af[j-1]))
					{
					ans[n-1][j]="HIT";
					for(Map.Entry<Integer,String>entry : tree.entrySet()){
						if(entry.getValue().equalsIgnoreCase(af[j-1]))
						{
							tree.remove(entry.getKey());
							break;
						}
					}
					tree.put(time,af[j-1]);
					time+=1;
					continue;
					}
				
				if(tree.size()<frames){
					if(ans[i][j].equalsIgnoreCase("NULL"))
					{
					ans[n-1][j]="FAULT";
					counter+=1;
					tree.put(time,af[j-1]);
					time+=1;
					int k=j; 
					while(k<m)
					ans[i][k++]=af[j-1];
					break;}
				}
				else{;
					if(check.equalsIgnoreCase(ans[i][j])){
						tree.put(time,af[j-1]);
						time+=1;
						tree.remove(check_key);
						ans[n-1][j]="FAULT";
						counter+=1;
						int k=j;
						while(k<m)
							ans[i][k++]=af[j-1];
						break;
				}
			}
		}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
			JLabel b=new JLabel(ans[i][j]);
        	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        	b.setOpaque(true);
        	b.setBackground(Color.WHITE);
        	b.setBorder(border);
        	b.setHorizontalAlignment(SwingConstants.CENTER);
        	p10.add(b);
		}
		}
		JLabel pg5=new JLabel("NUMBER OF PAGE FAULTS: "+counter);
    	JLabel pg6=new JLabel("NUMBER OF PAGE HITS: "+(af.length-counter));
    	pg5.setBounds(800,0,500,100);
    	pg6.setBounds(1050,0,500,100);
    	pg5.setFont(font);
    	pg6.setFont(font);
    	p9.add(pg5);
    	p9.add(pg6);
    	counter=0;
		p1.add(p5);
		p1.add(p6);
		p1.add(p7);
		p1.add(p8);
		p1.add(p9);
		p1.add(p10);
		f.revalidate();
		f.repaint();
	}
}
