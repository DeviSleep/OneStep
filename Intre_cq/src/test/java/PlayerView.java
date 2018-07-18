import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PlayerView extends JFrame implements ActionListener, MouseListener {

	List<String> musiclist = new ArrayList<String>();
	Map<String, String> matchlist = new HashMap<String, String>();
	JPanel mainpan;
	JScrollPane jsp;
	int location = 0;
	public boolean isfirst = true;

	public static void main(String[] args) {

		new PlayerView();
	}

	public PlayerView() {

		JPanel jp = new JPanel();
		mainpan = new JPanel();
		JPanel tool = new JPanel();
		JMenuBar jmenu = new JMenuBar();
		JMenu jm = new JMenu("File");
		JMenuItem jmi = new JMenuItem("open");
		jmi.addActionListener(this);
		jmi.setActionCommand("open");
		JButton play = new JButton("open");
		play.addActionListener(this);
		play.setActionCommand("play");
		JButton stop = new JButton("play");
		stop.addActionListener(this);
		stop.setActionCommand("stop");
		JButton next = new JButton("stop");
		next.addActionListener(this);
		next.setActionCommand("next");
		JButton last = new JButton("next");
		last.addActionListener(this);
		last.setActionCommand("last");
		JButton up = new JButton("last");
		up.addActionListener(this);
		up.setActionCommand("up");
		JButton down = new JButton("up");
		down.addActionListener(this);
		down.setActionCommand("down");

		tool.setLayout(new FlowLayout(FlowLayout.LEFT, 28, 1));
		tool.add(play);
		tool.add(stop);
		tool.add(next);
		tool.add(last);
		//tool.add(up);
		//tool.add(down);

		jm.add(jmi);
		jmenu.add(jm);
		this.add(tool, "South");
		this.setJMenuBar(jmenu);
		this.setSize(460, 580);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		circulatePlay();

	}

	public void actionPerformed(ActionEvent e) {
		if ("open".equals(e.getActionCommand())) {
			openList();
			if (mainpan != null) {
				mainpan.removeAll();
			}
			jsp = new JScrollPane(addName());
			jsp.setPreferredSize(new Dimension(this.getWidth() - 15, this.getHeight() - 120));
			jsp.add(addName());
			mainpan.add(jsp);
			this.add(mainpan, "Center");
			this.setVisible(true);

		}
		if ("stop".equals(e.getActionCommand())) {
			Player.isStop = true;
			
		}
		if ("play".equals(e.getActionCommand())&&!isfirst) {
			Player.isStop = true;
			String str=musiclist.get(location).substring(musiclist.get(location).lastIndexOf("\\") + 1);
			conn(str);
		}
		if ("next".equals(e.getActionCommand())&&!isfirst) {						
			if (location < musiclist.size() - 1) {
				location++;
				Player.isStop = true;
				String str=musiclist.get(location).substring(musiclist.get(location).lastIndexOf("\\") + 1);
				conn(str);
			}
			if(location==musiclist.size()-1){
				location=0;
				Player.isStop = true;
				String str=musiclist.get(location).substring(musiclist.get(location).lastIndexOf("\\") + 1);
				conn(str);
			}

		}
		if ("last".equals(e.getActionCommand())&&!isfirst) {
			if (location >= 1) {
				location--;
				Player.isStop = true;
				System.out.println(location);
				System.out.println(musiclist.get(location));
				String str=musiclist.get(location).substring(musiclist.get(location).lastIndexOf("\\") + 1);
				conn(str);
			}
			if (location == 0) {
				location = musiclist.size()-1;
				Player.isStop = true;				
				String str=musiclist.get(location).substring(musiclist.get(location).lastIndexOf("\\") + 1);
				conn(str);
				
			}
		}
	}
	//
	public void circulatePlay(){
		Thread tt=new Thread(){
			public void run(){
				while(true){
					if(!isfirst&&!Player.t.isAlive()&&!Player.isStop){
						int time=0;
						for(String str:musiclist){						
							if(Player.name.equals(str)){
								location=time;
							}
							time++;
						}
						
						if (location < musiclist.size() - 1) {
							location++;
							String str=musiclist.get(location).substring(musiclist.get(location).lastIndexOf("\\") + 1);
							conn(str);
						}
						if(location==musiclist.size()-1){
							location=0;
							String str=musiclist.get(location).substring(musiclist.get(location).lastIndexOf("\\") + 1);
							conn(str);
						}
					}
				}
			}
		};
		tt.start();
	}

	public JPanel addName() {
		JPanel jp = new JPanel();
		int length = 23;
		if (musiclist.size() > 23) {
			length = musiclist.size();
		}
		jp.setLayout(new GridLayout(length, 1, 4, 4));
		JLabel[] jl = new JLabel[musiclist.size()];
		for (int i = 0; i < jl.length; i++) {
			String name = musiclist.get(i).substring(musiclist.get(i).lastIndexOf("\\") + 1);
			jl[i] = new JLabel(name, JLabel.LEFT);
			jl[i].setFont(new Font("Font", Font.PLAIN, 14));
			jl[i].addMouseListener(this);
			jp.add(jl[i]);
		}
		return jp;
	}

	public void openList() {
		FileDialog list = new FileDialog(this, "open", FileDialog.LOAD);
		list.setVisible(true);
		String filepath = list.getDirectory();
		if (filepath != null) {
			File file = new File(filepath);
			File[] filelist = file.listFiles();
			for (File f : filelist) {
				String path = f.getAbsolutePath();
				musiclist.add(path);
				String name = path.substring(path.lastIndexOf("\\") + 1);
				matchlist.put(name, path);
			}

		}
	}

	/**
	 *
	 */
	public void mouseClicked(MouseEvent e) {

		if (e.getClickCount() == 2) {
			String name = ((JLabel) e.getSource()).getText().trim();
			System.out.println(name);
			conn(name);		
			
		}

	}

	//
	public void conn(String name){
		if (!isfirst) {
			//
			while(Player.t.isAlive()){
				Player.isStop = true;
			}
				new Player(matchlist.get(name));
		} else {
			new Player(matchlist.get(name));
			isfirst = false;
		}
	}
	
	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
}
