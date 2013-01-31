package cn.edu.sjtu.jllvm.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.GroupLayout;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;

import cn.edu.sjtu.jllvm.ESP.ESPProperty.ESPTransitionSystem;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ESP_GUI extends javax.swing.JFrame {
	private JMenuBar jMenuBar1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JCheckBoxMenuItem jCheckBoxMenuItem2;
	private JLabel statusLabel;
	private JTextArea resultTextArea;
	private JTabbedPane jTabbedPane1;
	private JTextArea sourceFileArea;
	private JCheckBoxMenuItem jCheckBoxMenuItem1;
	private JMenu jMenu3;
	private JMenuItem jMenuItem3;
	private JMenu jMenu2;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ESP_GUI inst = new ESP_GUI();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ESP_GUI() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout(
					getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jTabbedPane1 = new JTabbedPane();
				{
					jScrollPane1 = new JScrollPane();
					jTabbedPane1.addTab("sourceFile", null, jScrollPane1, null);
					jScrollPane1.setPreferredSize(new java.awt.Dimension(715,
							299));
					jScrollPane1.getHorizontalScrollBar().setEnabled(false);
					{
						sourceFileArea = new JTextArea();
						jScrollPane1.setViewportView(sourceFileArea);
					}
				}
				{
					jScrollPane2 = new JScrollPane();
					jTabbedPane1.addTab("result", null, jScrollPane2, null);
					jScrollPane2.setPreferredSize(new java.awt.Dimension(715,
							299));
					jScrollPane2.getHorizontalScrollBar().setEnabled(false);
					{
						resultTextArea = new JTextArea();
						jScrollPane2.setViewportView(resultTextArea);
					}
				}
			}
			{
				statusLabel = new JLabel();
				statusLabel.setText("");
			}
			thisLayout.setVerticalGroup(thisLayout
					.createSequentialGroup()
					.addComponent(jTabbedPane1, 0, 311, Short.MAX_VALUE)
					.addComponent(statusLabel, GroupLayout.PREFERRED_SIZE, 21,
							GroupLayout.PREFERRED_SIZE));
			thisLayout.setHorizontalGroup(thisLayout
					.createParallelGroup()
					.addComponent(jTabbedPane1, GroupLayout.Alignment.LEADING,
							0, 718, Short.MAX_VALUE)
					.addComponent(statusLabel, GroupLayout.Alignment.LEADING,
							0, 718, Short.MAX_VALUE));
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("File");
					jMenu1.setMnemonic('F');
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("Open");
						jMenuItem1.setMnemonic('O');
						jMenuItem1.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								openFile(evt);
							}
						});
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("Save");
						jMenuItem2.setMnemonic('S');
						jMenuItem2.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								saveResult(evt);
							}
						});
					}
				}
				{
					jMenu2 = new JMenu();
					jMenuBar1.add(jMenu2);
					jMenu2.setText("Run");
					jMenu2.setMnemonic('R');
					{
						jMenuItem3 = new JMenuItem();
						jMenu2.add(jMenuItem3);
						jMenuItem3.setText("ESP");
						jMenuItem3.setMnemonic('E');
						jMenuItem3.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								runESP(evt);
							}
						});
					}
					{
						jMenu3 = new JMenu();
						jMenu2.add(jMenu3);
						jMenu3.setText("Configure");
						{
							jCheckBoxMenuItem1 = new JCheckBoxMenuItem();
							jMenu3.add(jCheckBoxMenuItem1);
							jCheckBoxMenuItem1.setText("No Details");
							jCheckBoxMenuItem1.addChangeListener(new ChangeListener() {
								@Override
								public void stateChanged(ChangeEvent evt) {
									jCheckBoxMenuItem1StateChanged(evt);
								}
							});
						}
//						{
//							jCheckBoxMenuItem2 = new JCheckBoxMenuItem();
//							jMenu3.add(jCheckBoxMenuItem2);
//							jCheckBoxMenuItem2.setText("Use STP Solver");
//							jCheckBoxMenuItem2.addChangeListener(new ChangeListener() {
//								public void stateChanged(ChangeEvent evt) {
//									jCheckBoxMenuItem2StateChanged(evt);
//								}
//							});
//						}
					}
				}
			}
			pack();
			this.setSize(856, 529);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void openFile(ActionEvent evt) {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(UIUtil.fileFolder));
		FileFilter filter = new ExtensionFileFilter("llvm file",
				new String[] { "ll" });
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			if (file != null && file.exists()) {
				jTabbedPane1.setSelectedIndex(0);
				UIUtil.filePath = file.getAbsolutePath();
				UIUtil.fileFolder = file.getPath(); 
				statusLabel.setText(file.getAbsolutePath());

				try {
					byte[] buffer = new byte[(int) file.length()];
					BufferedInputStream f = new BufferedInputStream(
							new FileInputStream(file));
					f.read(buffer);
					sourceFileArea.setText(new String(buffer));
					f.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void saveResult(ActionEvent evt) {
		jTabbedPane1.setSelectedIndex(1);
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(UIUtil.fileFolder));
		FileFilter filter = new ExtensionFileFilter("text file",
				new String[] { "txt" });
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			if (file != null) {
				if (!file.exists()) {
					try {
						file.createNewFile();
					} catch (Exception e) {
						e.printStackTrace();
						return;
					}
				}

				if (file.isDirectory())
					return;

				try {
					PrintWriter writer = new PrintWriter(new FileWriter(file));
					writer.print(resultTextArea.getText());
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void runESP(ActionEvent evt) {
		//
		jTabbedPane1.setSelectedIndex(1);
		UIUtil rmc = new UIUtil();
		try {
			String result = rmc.run();
			String lockInfos[] = result.split("#");

			resultTextArea.setText("");
			for (String info : lockInfos) {
				if (info.length() > 40) {
					resultTextArea.append("# " + info);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jCheckBoxMenuItem1StateChanged(ChangeEvent evt) {
		//System.out.println("jCheckBoxMenuItem1.stateChanged, event="+evt);
		if(ESPTransitionSystem.DEBUG_INFO==ESPTransitionSystem.ALL_INFO){
			ESPTransitionSystem.DEBUG_INFO = ESPTransitionSystem.NOT_EXECUTIONSTATE;
		}else{
			ESPTransitionSystem.DEBUG_INFO = ESPTransitionSystem.ALL_INFO;
		}
	}
	
	private void jCheckBoxMenuItem2StateChanged(ChangeEvent evt) {
		//System.out.println("jCheckBoxMenuItem2.stateChanged, event="+evt);
		if(ESPTransitionSystem.USE_SOLVER){
			ESPTransitionSystem.USE_SOLVER = false;
		}else {
			ESPTransitionSystem.USE_SOLVER = true;
		}
	}
}

class ExtensionFileFilter extends FileFilter {
	String description;

	String extensions[];

	public ExtensionFileFilter(String description, String extension) {
		this(description, new String[] { extension });
	}

	public ExtensionFileFilter(String description, String extensions[]) {
		if (description == null) {
			this.description = extensions[0];
		} else {
			this.description = description;
		}
		this.extensions = extensions.clone();
		toLower(this.extensions);
	}

	private void toLower(String array[]) {
		for (int i = 0, n = array.length; i < n; i++) {
			array[i] = array[i].toLowerCase();
		}
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		} else {
			String path = file.getAbsolutePath().toLowerCase();
			for (int i = 0, n = extensions.length; i < n; i++) {
				String extension = extensions[i];
				if ((path.endsWith(extension) && (path.charAt(path.length()
						- extension.length() - 1)) == '.')) {
					return true;
				}
			}
		}
		return false;
	}
}
