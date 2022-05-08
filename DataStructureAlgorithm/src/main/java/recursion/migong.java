package recursion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.awt.event.ActionEvent;
public class migong extends JFrame {

	JButton bt1=new JButton("清");
	JButton bt2=new JButton("走");
	public static void main(String [] args){

		migong myMigong=new migong();
		myMigong.setSize(500,500);
		myMigong.show();
	}
	migong(){

		Container ct=this.getContentPane();
		JPanel kongzhi=new JPanel(new GridLayout(2,1));
		myPanel mp=new myPanel();
		kongzhi.add(bt1);
		kongzhi.add(bt2);
		bt1.setActionCommand("clear");
		bt1.addActionListener(mp);

		bt2.setActionCommand("run");
		bt2.addActionListener(mp);

		ct.add("West",kongzhi);
		ct.add("Center",mp);

		Thread t=new Thread(mp);
		t.start();

	}



}

class myPanel extends JPanel implements ActionListener,Runnable{

	mouse litterMouse=null;
	int [][]map=new int[8][7];
	public void paint(Graphics g){

		super.paint(g);
		g.setColor(Color.red);
		//画出格子的横线
		for(int i=0;i<9;i++){
			g.drawLine(0,i*50,350,i*50);
		}
		//画出格子的竖线
		for(int i=0;i<8;i++){
			g.drawLine(i*50,0,i*50,400);
		}
		//画格子
		for(int i=0;i<8;i++){
			for(int j=0;j<7;j++){

				if(map[i][j]==1)
					g.fill3DRect(j*50,i*50,50,50,true);
			}
		}
		//画出老鼠
		if(litterMouse!=null){


			g.fillOval(litterMouse.n*50,litterMouse.m*50,50,50);

		}

	}
	myPanel(){
		//将最上和下的格子设为档板
		for(int i=0;i<7;i++){
			map[0][i]=1;
			map[7][i]=1;
		}
		//将最左和最右的格子设为档板
		for(int i=0;i<8;i++){
			map[i][0]=1;
			map[i][6]=1;
		}

		map[3][1]=1;
		map[3][2]=1;
/*		map[1][1]=0;
		map[1][2]=0;
		map[1][3]=0;
		map[1][4]=0;
		map[1][5]=0;
		map[2][1]=0;
		map[2][2]=1;
		map[2][3]=0;
		map[2][4]=0;
		map[2][5]=0;
		map[3][1]=1;
		map[3][2]=0;
		map[3][3]=0;
		map[3][4]=0;
		map[3][5]=0;
		map[4][1]=0;
		map[4][2]=0;
		map[4][3]=0;
		map[4][4]=0;
		map[4][5]=0;
		map[5][1]=0;
		map[5][2]=0;
		map[5][3]=0;
		map[5][4]=0;
		map[5][5]=0;
		map[6][1]=0;
		map[6][2]=0;
		map[6][3]=0;
		map[6][4]=0;
		map[6][5]=0;*/

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("clear")){

			for(int i=1;i<=6;i++){
				for(int j=1;j<=5;j++){
					map[i][j]=0;
				}
			}
		}
		if(e.getActionCommand().equals("run")){

			litterMouse=new mouse();
			litterMouse.setMap(map);
			litterMouse.setWay(1,1);
			litterMouse.start();

			for(int i=0;i<8;i++){
				for(int j=0;j<7;j++){

					System.out.print(map[i][j]+" ");
				}
				System.out.println ();
			}


		}


	}
	public void run(){



		while(true){
			this.repaint();
			try{
				Thread.sleep(60);
			}catch(Exception e){
			}
		}


	}
}
class Node{
	int a;//行
	int b;//列
	Node(int i,int j){
		a=i;
		b=j;
	}
}
class mouse extends Thread{

	int [][]map;
	int m=1;
	int n=1;
	Vector vc=new Vector();
	void setMap(int[][]mm){
		map=mm;
	}
	boolean setWay(int i,int j){
		//如果到达(6,5),则退出第归
		if(map[6][5]==2) return true;
		else{

			//
			if(map[i][j]==0){
				map[i][j]=2;
				Node node=new Node(i,j);
				vc.add(node);

				//向右下找
			/*	if(setWay(i+1,j+1)){
					return true;
				}
				//向右上
				else if(setWay(i-1,j+1)){
					return true;
				}else if(setWay(i,j+1)){
					return true;
				}else if(setWay(i-1,j)){
					return true;
				}else if(setWay(i+1,j)){
					return true;
				}else if (setWay(i+1,j-1)){
					return true;
				}else if (setWay(i,j-1)){
					return true;
				}else if(setWay(i-1,j-1)){
					return true;
				}else{
					//是条死路
					map[i][j]=3;
					Node node2=new Node(i,j);
					vc.add(node2);
					return false;

				}*/
				//向上找



				if(setWay(i+1,j)){
					return true;
				}
				//向右上
			/*	else if(setWay(i-1,j+1)){
					return true;
				}*/
				else if(setWay(i,j+1)){
					return true;
				}
				/*else if(setWay(i+1,j+1)){
					return true;
				}*/
				else if(setWay(i-1,j)){
					return true;
				}
				/*else if (setWay(i+1,j-1)){
					return true;
				}*/
				else if (setWay(i,j-1)){
					return true;
				}
				/*else if(setWay(i-1,j-1)){
					return true;
				}*/
				else{
					//是条死路
					map[i][j]=3;
					//		Node node2=new Node(i,j);
					//		vc.add(node2);
					return false;

				}

			}
			else{
				return false;
			}
		}
	}

	public void run(){

		for(int i=0;i<vc.size();i++){

			if(map[((Node)vc.get(i)).a][((Node)vc.get(i)).b]==2){

				this.m=((Node)vc.get(i)).a;
				this.n=((Node)vc.get(i)).b;
			}


			try{

				Thread.sleep(1000);
			}catch(Exception e){
			}
			System.out.println ("m="+m+" n="+n);
		}
	}


}

class Test{

	void print(int val){

		if(val>1) print(val-1);
		else{

			System.out.println ("the val is"+val);
		}
	}
}