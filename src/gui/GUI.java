package gui;

import handler.*;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import etc.LogCenter;

/**
 *
 * @author Iorgreths
 * @version 1.0
 */
public class GUI extends javax.swing.JFrame implements InformationHandler{

    /*
     * NOTE: window sizes
     * single-motor: [417,396]
     * double-motor: [824,396]
     */
	
	/**
	 * 01   - day;
	 * 01   - month;
	 * 2015 - year;
	 * 6    - car-number
	 * 10   - version
	 */
	private static final long serialVersionUID = 01012015610L;
	
	private HashMap<String,List<String>> fncts; // mapping of all functions
												// <fnct-name, params>
	
	/**
     * Creates new form GUI
     * The form GUI is the default JFrame for the Program TUWR-Connect
     */
    public GUI(HashMap<String,List<String>> functions) { 
    	
    	this.fncts = functions; // map all the wanted functions
    	
    	/* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	
        /* Set information about this frame */
    	this.setTitle("TUWR-Connect");
    	String path = new File("").getAbsolutePath();
    	//System.out.println(System.getProperties());
		if(System.getProperty("os.name").contains("Windows") ||
				System.getProperty("os.name").contains("Microsoft")){
			this.setIconImage(new ImageIcon(path+"\\"+"resources"+"\\"+"icon.png").getImage());
		}else{
			this.setIconImage(new ImageIcon(path+"/resources/icon.png").getImage());
		}
    	
    	
		/* set component information */
        initComponents();
        rightmotor.setVisible(false);
        this.setSize(417, 422);
        this.setLocationRelativeTo(null);
        //NOTE: experimental-code
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new GuiWindowHandler(this));
        
        /* create function-tab */
        String[] comm = new String[fncts.size()];
        Iterator<String> keys = fncts.keySet().iterator();
        for( int i=0; i<fncts.size(); i++ ){
        	comm[i] = keys.next();
        }
        fnct_list = new javax.swing.JList<String>(comm);
        fnct_list.setVisible(true);
        functiontab.setViewportView(fnct_list);
        fnct_list_r = new javax.swing.JList<String>(comm);
        fnct_list_r.setVisible(true);
        functiontab1.setViewportView(fnct_list_r);
        
        /* set component listener */
        ct_torque_radio.addActionListener(new ControlRadioButtonHandler(this));
        ct_torque_radio_r.addActionListener(new Control_R_RadioButtonHandler(this));
        ct_rotation_radio.addActionListener(new ControlRadioButtonHandler(this));
        ct_rotation_radio_r.addActionListener(new Control_R_RadioButtonHandler(this));
        expand.addActionListener(new ExpandHandler(this));
        runbutton.addActionListener(new StartHandler(this));
        runbutton_r.addActionListener(new Start_R_Handler(this));
        //fnct_list.addListSelectionListener(new FunctionHandler(this));
        //fnct_list_r.addListSelectionListener(new Function_R_Handler(this));
        baudchosser.addActionListener(new PropertyChangeHandler(this));
        baudchosser.setVisible(false);
        
        /*
         * Set the menu-bar
         */
        initMenuBar();
        
        /* set enter function for frame */
        //NOTE: experimental code
        control_accept = new javax.swing.JButton();
        this.add(control_accept);
        control_accept.addActionListener(new ControlHandler(this));
        this.getRootPane().setDefaultButton(control_accept);
        //controltab.getRootPane().setDefaultButton(control_accept);
       
        // request focus
        this.requestFocus();
        JDialog connect = new ConnectDialog(this);
        connect.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        ct_radiogroup = new javax.swing.ButtonGroup();
        ct_radiogroup_r = new javax.swing.ButtonGroup();
        leftmotor = new javax.swing.JPanel();
        toppanel = new javax.swing.JPanel();
        runbutton = new javax.swing.JToggleButton();
        torque_label = new javax.swing.JLabel();
        rotation_label = new javax.swing.JLabel();
        torque_output = new javax.swing.JTextField();
        rotation_output = new javax.swing.JTextField();
        torque_nm = new javax.swing.JLabel();
        rotation_rpm = new javax.swing.JLabel();
        expand = new javax.swing.JButton();
        tabs = new javax.swing.JTabbedPane();
        controltab = new javax.swing.JPanel();
        ct_torque_radio = new javax.swing.JRadioButton();
        ct_rotation_radio = new javax.swing.JRadioButton();
        ct_tr_input_label = new javax.swing.JLabel();
        ct_tr_input = new javax.swing.JTextField();
        ct_iq = new javax.swing.JLabel();
        ct_iq_output = new javax.swing.JTextField();
        ct_iq_output_label = new javax.swing.JLabel();
        ct_id = new javax.swing.JLabel();
        ct_id_input = new javax.swing.JTextField();
        ct_id_input_label = new javax.swing.JLabel();
        ct_id_output = new javax.swing.JTextField();
        ct_id_output_label = new javax.swing.JLabel();
        functiontab = new javax.swing.JScrollPane();
        errors_scroll = new javax.swing.JScrollPane();
        errors = new javax.swing.JTextArea();
        console_scroll = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        rightmotor = new javax.swing.JPanel();
        toppanel_r = new javax.swing.JPanel();
        runbutton_r = new javax.swing.JToggleButton();
        torque_label_r = new javax.swing.JLabel();
        rotation_label_r = new javax.swing.JLabel();
        torque_output_r = new javax.swing.JTextField();
        rotation_output_r = new javax.swing.JTextField();
        torque_nm_r = new javax.swing.JLabel();
        rotation_rpm_r = new javax.swing.JLabel();
        tabs_r = new javax.swing.JTabbedPane();
        controltab_r = new javax.swing.JPanel();
        ct_torque_radio_r = new javax.swing.JRadioButton();
        ct_rotation_radio_r = new javax.swing.JRadioButton();
        ct_tr_input_label_r = new javax.swing.JLabel();
        ct_tr_input_r = new javax.swing.JTextField();
        ct_iq1 = new javax.swing.JLabel();
        ct_iq_output1 = new javax.swing.JTextField();
        ct_iq_output_label1 = new javax.swing.JLabel();
        ct_id1 = new javax.swing.JLabel();
        ct_id_input1 = new javax.swing.JTextField();
        ct_id_input_label1 = new javax.swing.JLabel();
        ct_id_output1 = new javax.swing.JTextField();
        ct_id_output_label1 = new javax.swing.JLabel();
        functiontab1 = new javax.swing.JScrollPane();
        console_scroll_r = new javax.swing.JScrollPane();
        console_r = new javax.swing.JTextArea();
        errors_scroll_r = new javax.swing.JScrollPane();
        errors_r = new javax.swing.JTextArea();
        baudchosser = new javax.swing.JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("tuwr_gui"); // NOI18N
        setResizable(false);

        leftmotor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        leftmotor.setPreferredSize(new java.awt.Dimension(400, 356));

        toppanel.setPreferredSize(new java.awt.Dimension(346, 76));

        runbutton.setText("Start");

        torque_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        torque_label.setText("Drehmoment:");

        rotation_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotation_label.setText("Drehzahl:");

        torque_output.setEditable(false);
        torque_output.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        torque_output.setText("0");

        rotation_output.setEditable(false);
        rotation_output.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rotation_output.setText("0");

        torque_nm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        torque_nm.setText("Nm");

        rotation_rpm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotation_rpm.setText("rpm");

        expand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/arrow.png"))); // NOI18N

        javax.swing.GroupLayout toppanelLayout = new javax.swing.GroupLayout(toppanel);
        toppanel.setLayout(toppanelLayout);
        toppanelLayout.setHorizontalGroup(
            toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toppanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(runbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(torque_label)
                    .addComponent(rotation_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(toppanelLayout.createSequentialGroup()
                        .addComponent(rotation_output, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rotation_rpm)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(toppanelLayout.createSequentialGroup()
                        .addComponent(torque_output, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(torque_nm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(expand, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        toppanelLayout.setVerticalGroup(
            toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toppanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(toppanelLayout.createSequentialGroup()
                        .addGroup(toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(torque_label)
                            .addComponent(torque_output, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(torque_nm)
                            .addComponent(expand, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(toppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rotation_label)
                            .addComponent(rotation_output, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rotation_rpm)))
                    .addComponent(runbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ct_radiogroup.add(ct_torque_radio);
        ct_torque_radio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ct_torque_radio.setSelected(true);
        ct_torque_radio.setText("Drehmoment");

        ct_radiogroup.add(ct_rotation_radio);
        ct_rotation_radio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ct_rotation_radio.setText("Drehzahl");

        ct_tr_input_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ct_tr_input_label.setText("Nm (soll)");
        ct_tr_input_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ct_tr_input.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ct_tr_input.setText("Drehmoment");

        ct_iq.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ct_iq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ct_iq.setText("iq");

        ct_iq_output.setEditable(false);
        ct_iq_output.setText("...");

        ct_iq_output_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ct_iq_output_label.setText("A (ist)");
        ct_iq_output_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ct_id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ct_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ct_id.setText("id");

        ct_id_input.setText("Ampere");

        ct_id_input_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ct_id_input_label.setText("A (soll)");
        ct_id_input_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ct_id_output.setEditable(false);
        ct_id_output.setText("...");

        ct_id_output_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ct_id_output_label.setText("A (ist)");
        ct_id_output_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout controltabLayout = new javax.swing.GroupLayout(controltab);
        controltab.setLayout(controltabLayout);
        controltabLayout.setHorizontalGroup(
            controltabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controltabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controltabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controltabLayout.createSequentialGroup()
                        .addGroup(controltabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(controltabLayout.createSequentialGroup()
                                .addComponent(ct_iq, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ct_iq_output, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ct_torque_radio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(controltabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ct_iq_output_label)
                            .addComponent(ct_rotation_radio)))
                    .addGroup(controltabLayout.createSequentialGroup()
                        .addComponent(ct_id, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ct_id_input, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ct_id_input_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ct_id_output, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ct_id_output_label))
                    .addGroup(controltabLayout.createSequentialGroup()
                        .addComponent(ct_tr_input, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ct_tr_input_label)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controltabLayout.setVerticalGroup(
            controltabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controltabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controltabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ct_torque_radio)
                    .addComponent(ct_rotation_radio))
                .addGap(18, 18, 18)
                .addGroup(controltabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ct_tr_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ct_tr_input_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controltabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ct_iq_output, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ct_iq)
                    .addComponent(ct_iq_output_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controltabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ct_id_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ct_id_input_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ct_id)
                    .addComponent(ct_id_output, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ct_id_output_label, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabs.addTab("Steuern", controltab);

        functiontab.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        tabs.addTab("Funktionen", functiontab);

        errors_scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        errors_scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        errors.setColumns(20);
        errors.setRows(5);
        errors.setText("Errors");
        errors_scroll.setViewportView(errors);

        console_scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        console_scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        console.setColumns(20);
        console.setRows(5);
        console.setText("Console");
        console_scroll.setViewportView(console);

        javax.swing.GroupLayout leftmotorLayout = new javax.swing.GroupLayout(leftmotor);
        leftmotor.setLayout(leftmotorLayout);
        leftmotorLayout.setHorizontalGroup(
            leftmotorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toppanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
            .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
            .addGroup(leftmotorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errors_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(console_scroll)
                .addContainerGap())
        );
        leftmotorLayout.setVerticalGroup(
            leftmotorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftmotorLayout.createSequentialGroup()
                .addComponent(toppanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftmotorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(errors_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(console_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        rightmotor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rightmotor.setPreferredSize(new java.awt.Dimension(400, 356));

        toppanel_r.setPreferredSize(new java.awt.Dimension(346, 76));

        runbutton_r.setText("Start");

        torque_label_r.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        torque_label_r.setText("Drehmoment:");

        rotation_label_r.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotation_label_r.setText("Drehzahl:");

        torque_output_r.setEditable(false);
        torque_output_r.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        torque_output_r.setText("0");

        rotation_output_r.setEditable(false);
        rotation_output_r.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rotation_output_r.setText("0");

        torque_nm_r.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        torque_nm_r.setText("Nm");

        rotation_rpm_r.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rotation_rpm_r.setText("rpm");

        javax.swing.GroupLayout toppanel_rLayout = new javax.swing.GroupLayout(toppanel_r);
        toppanel_r.setLayout(toppanel_rLayout);
        toppanel_rLayout.setHorizontalGroup(
            toppanel_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toppanel_rLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(toppanel_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(torque_label_r)
                    .addComponent(rotation_label_r))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(toppanel_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(toppanel_rLayout.createSequentialGroup()
                        .addComponent(torque_output_r, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(torque_nm_r))
                    .addGroup(toppanel_rLayout.createSequentialGroup()
                        .addComponent(rotation_output_r, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rotation_rpm_r)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(runbutton_r, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        toppanel_rLayout.setVerticalGroup(
            toppanel_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toppanel_rLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toppanel_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(runbutton_r, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(toppanel_rLayout.createSequentialGroup()
                        .addGroup(toppanel_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(torque_label_r)
                            .addComponent(torque_output_r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(torque_nm_r))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(toppanel_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rotation_output_r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rotation_label_r)
                            .addComponent(rotation_rpm_r))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs_r.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ct_radiogroup_r.add(ct_torque_radio_r);
        ct_torque_radio_r.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ct_torque_radio_r.setSelected(true);
        ct_torque_radio_r.setText("Drehmoment");

        ct_radiogroup_r.add(ct_rotation_radio_r);
        ct_rotation_radio_r.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ct_rotation_radio_r.setText("Drehzahl");

        ct_tr_input_label_r.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ct_tr_input_label_r.setText("Nm (soll)");
        ct_tr_input_label_r.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ct_tr_input_r.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ct_tr_input_r.setText("Drehmoment");

        ct_iq1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ct_iq1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ct_iq1.setText("iq");

        ct_iq_output1.setEditable(false);
        ct_iq_output1.setText("...");

        ct_iq_output_label1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ct_iq_output_label1.setText("A (ist)");
        ct_iq_output_label1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ct_id1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ct_id1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ct_id1.setText("id");

        ct_id_input1.setText("Ampere");

        ct_id_input_label1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ct_id_input_label1.setText("A (soll)");
        ct_id_input_label1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ct_id_output1.setEditable(false);
        ct_id_output1.setText("...");

        ct_id_output_label1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ct_id_output_label1.setText("A (ist)");
        ct_id_output_label1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout controltab_rLayout = new javax.swing.GroupLayout(controltab_r);
        controltab_r.setLayout(controltab_rLayout);
        controltab_rLayout.setHorizontalGroup(
            controltab_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controltab_rLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controltab_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controltab_rLayout.createSequentialGroup()
                        .addGroup(controltab_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(controltab_rLayout.createSequentialGroup()
                                .addComponent(ct_iq1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ct_iq_output1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ct_torque_radio_r))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(controltab_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ct_iq_output_label1)
                            .addComponent(ct_rotation_radio_r)))
                    .addGroup(controltab_rLayout.createSequentialGroup()
                        .addComponent(ct_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ct_id_input1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ct_id_input_label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ct_id_output1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ct_id_output_label1))
                    .addGroup(controltab_rLayout.createSequentialGroup()
                        .addComponent(ct_tr_input_r, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ct_tr_input_label_r)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controltab_rLayout.setVerticalGroup(
            controltab_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controltab_rLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controltab_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ct_torque_radio_r)
                    .addComponent(ct_rotation_radio_r))
                .addGap(18, 18, 18)
                .addGroup(controltab_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ct_tr_input_r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ct_tr_input_label_r, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controltab_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ct_iq_output1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ct_iq1)
                    .addComponent(ct_iq_output_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controltab_rLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ct_id_input1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ct_id_input_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ct_id1)
                    .addComponent(ct_id_output1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ct_id_output_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabs_r.addTab("Steuern", controltab_r);
        tabs_r.addTab("Funktionen", functiontab1);

        console_scroll_r.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        console_scroll_r.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        console_r.setColumns(20);
        console_r.setRows(5);
        console_r.setText("Console");
        console_scroll_r.setViewportView(console_r);

        errors_scroll_r.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        errors_scroll_r.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        errors_r.setColumns(20);
        errors_r.setRows(5);
        errors_r.setText("Errors");
        errors_scroll_r.setViewportView(errors_r);

        javax.swing.GroupLayout rightmotorLayout = new javax.swing.GroupLayout(rightmotor);
        rightmotor.setLayout(rightmotorLayout);
        rightmotorLayout.setHorizontalGroup(
            rightmotorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toppanel_r, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
            .addComponent(tabs_r, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
            .addGroup(rightmotorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(console_scroll_r, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errors_scroll_r)
                .addContainerGap())
        );
        rightmotorLayout.setVerticalGroup(
            rightmotorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightmotorLayout.createSequentialGroup()
                .addComponent(toppanel_r, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs_r)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightmotorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(console_scroll_r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errors_scroll_r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        baudchosser.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "1M", "800K", "500K", "250K", "125K", "100K", "95K", "83K", "50K", "47K", "33K", "20K", "10K", "5K" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leftmotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightmotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(baudchosser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rightmotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftmotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(baudchosser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        
        
        
        console.setEditable(false);
        console_r.setEditable(false);
        errors.setEditable(false);
        errors_r.setEditable(false);
        
        control_accept = new javax.swing.JButton();
        control_accept.setVisible(false);

        pack();
    }// </editor-fold>                                                                         

    /**
     * Adapts the input fields and labels for the left control tab.
     * This method is only allowed to be called by a RadioButtonHandler.
     */
    public void adaptControlLeft(){
    	
    	if(ct_rotation_radio.isSelected()){
    		
    		ct_tr_input.setText("");
    		ct_tr_input_label.setText("rpm (soll)");
    		
    	}else{
    		
    		ct_tr_input.setText("");
    		ct_tr_input_label.setText("Nm (soll)");
    		
    	}
    	
    }
    
    /**
     * Adapts the input fields and labels for the right control tab.
     * This method is only allowed to be called by a RadioButtonHandler.
     */
    public void adaptControlRight(){
    	
    	if(ct_rotation_radio_r.isSelected()){
    		
    		ct_tr_input_r.setText("");
    		ct_tr_input_label_r.setText("rpm (soll)");
    		
    	}else{
    		
    		ct_tr_input_r.setText("");
    		ct_tr_input_label_r.setText("Nm (soll)");
    		
    	}
    	
    }
    
    /**
     * Expands the frame for double-motor usage.
     * This method is only allowed to be called by a ButtonHandler.
     * This method only does something if expand is visible.
     */
    public void expand(){
    	
    	if(expand.isVisible()){
    		
    		/*
             * NOTE: window sizes
             * single-motor: [417,396]
             * double-motor: [824,396]
             */
        	this.setSize(824, 422);
        	rightmotor.setVisible(true);
        	expand.setVisible(false);
        	//this.setLocationRelativeTo(null);
    		
    	}
    	
    }
    
    /**
     * Returns whether the right motor expansion is active.
     * @return if the right motor expansion is active
     */
    public boolean isExpanded(){
    	return !expand.isVisible();
    }
    
    public boolean isBaudEnabled(){
    	//System.out.println(baudchosser.isEnabled());
    	return baudchosser.isEnabled();
    }
    
    /**
     * Adapts the text from the runbutton and returns an integer, which
     * indicates the message to be send.
     * <ul>
     * <li>0 - start the motor</li>
     * <li>1 - stop the motor</li>
     * </ul>
     * 
     * 
     * @return indicator for sending message
     */
    public int adaptStart(){
    	int ret = 0;
    	
    	if(runbutton.getText().equals("Start")){
    		ret = 0;
    		runbutton.setText("Stop");
    	}else{
    		ret = 1;
    		runbutton.setText("Start");
    	}
    	
    	return ret;
    }
    
    /**
     * Returns whether all motors have been stopped.
     * 
     * @return all stopped
     */
    public boolean allStopped(){
    	
    	boolean ret = false;
    	
    	if(runbutton.getText().equals("Start")){
    		if(runbutton_r.getText().equals("Start")){
    			ret = true;
    		}
    	}
    	
    	return ret;
    	
    }
    
    /**
     * Adapts the text from the runbutton_r and returns an integer, which
     * indicates the message to be send.
     * <ul>
     * <li>0 - start the motor</li>
     * <li>1 - stop the motor</li>
     * </ul>
     * 
     * 
     * @return indicator for sending message
     */
    public int adaptStartRight(){
    	int ret = 0;
    	
    	if(runbutton_r.getText().equals("Start")){
    		ret = 0;
    		runbutton_r.setText("Stop");
    	}else{
    		ret = 1;
    		runbutton_r.setText("Start");
    	}
    	
    	return ret;
    }
    
    /**
     * Returns the currently selected function of the LEFT function-tab.
     * The parameter count of this function could be zero.
     * The returned HashMap always only contains one item.
     * 
     * @return selected function
     */
    public HashMap<String,List<String>> getSelectedFunction(){
    	HashMap<String,List<String>> ret = new HashMap<String,List<String>>();
    	for(Entry<String, List<String>> entry : fncts.entrySet()){
    		if(entry.getKey().equals(fnct_list.getSelectedValue())){
    			ret.put(entry.getKey(), entry.getValue());
    			break; // only one selection
    		}
    	}
    	return ret;
    }
    
    /**
     * Returns the currently selected function of the RIGHT function-tab.
     * The parameter count of this function could be zero.
     * The returned HashMap always only contains one item.
     * 
     * @return selected function
     */
    public HashMap<String,List<String>> getSelectedFunctionRight(){
    	HashMap<String,List<String>> ret = new HashMap<String,List<String>>();
    	for(Entry<String, List<String>> entry : fncts.entrySet()){
    		if(entry.getKey().equals(fnct_list_r.getSelectedValue())){
    			ret.put(entry.getKey(), entry.getValue());
    			break; // only one selection
    		}
    	}
    	return ret;
    }
    
    @Override
	public void notifyError(List<String> errors, boolean left) {
		
    	Logger l = LogCenter.getInstance().getLogger();
    	
    	if(left){
    		l.log(Level.INFO,"error-message incoming for left motor.");
    		this.errors.setText("");
    		
    		for(String error : errors){
        		
        		this.errors.setText(this.errors.getText() + error + "\n");
    			
        	}
    		
    	}else{
    		l.log(Level.INFO,"error-message incoming for right motor.");
    		this.errors_r.setText("");
    		
    		for(String error : errors){
        		
        		this.errors_r.setText(this.errors_r.getText() + error + "\n");
    			
        	}
    		
    	}
		
	}

	@Override
	public void notifyConsole(List<String> msg, boolean left) {
		Logger l = LogCenter.getInstance().getLogger();
		
		if(left){
    		l.log(Level.INFO,"notifications incoming for left motor.");
    		this.console.setText("");
    		
    		for(String m : msg){
        		
        		this.console.setText(this.console.getText() + m + "\n");
    			
        	}
    		
    	}else{
    		l.log(Level.INFO,"notifications incoming for right motor.");
    		this.console_r.setText("");
    		
    		for(String m : msg){
        		
        		this.console_r.setText(this.console_r.getText() + m + "\n");
    			
        	}
    		
    	}
		
	}

	@Override
	public void notifyActual(double torque, double rotation, boolean left) {
		Logger l = LogCenter.getInstance().getLogger();
		
		if(left){
			l.log(Level.INFO,"new actual-values (rotation,torque) for left motor.");
			torque_output.setText(String.valueOf(torque));
			rotation_output.setText(String.valueOf(rotation));
			
		}else{
			l.log(Level.INFO,"new actual-values (rotation,torque) for right motor.");
			torque_output_r.setText(String.valueOf(torque));
			rotation_output_r.setText(String.valueOf(rotation));
			
		}
		
	}

	@Override
	public void notifyCurrent(double id, double iq, boolean left) {
		Logger l = LogCenter.getInstance().getLogger();
		if(left){
			l.log(Level.INFO, "new actual-values of currents for left motor.");
			ct_id_output.setText(String.valueOf(id));
			ct_iq_output.setText(String.valueOf(iq));
			
		}else{
			l.log(Level.INFO, "new actual-values of currents for right motor.");
			ct_id_output1.setText(String.valueOf(id));
			ct_iq_output1.setText(String.valueOf(iq));
			
		}
		
	}
	
	/**
	 * Returns the current torque of the left motor.
	 * @return torque of left motor
	 */
	public double getTorque(){
		return Double.valueOf(torque_output.getText());
	}
	
	/**
	 * Returns the current torque of the right motor.
	 * @return torque of right motor
	 */
	public double getTorqueR(){
		return Double.valueOf(torque_output_r.getText());
	}
	
	/**
	 * Returns whether the left motor is running.
	 * 
	 * @return status of the left motor
	 */
	public boolean leftStarted(){
		
		if(runbutton.getText().equals("Stop")){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * Returns whether the right motor is running.
	 * 
	 * @return status of right motor
	 */
	public boolean rightStarted(){
		
		if(runbutton_r.getText().equals("Stop")){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * Returns the information about the left control tab.
	 * 
	 * @return left control tab information
	 */
	public ControlInformation leftInformation(){
		int modus = 0;
		if(ct_rotation_radio.isSelected()){
			modus = 1;
		}
		
		double value = 0;
		
		try{
			
			value = Double.valueOf(ct_tr_input.getText());
			
		}catch(NumberFormatException nfe){
			
			switch(modus){
			case 0:
				value = Double.valueOf(torque_output.getText());
				break;
			case 1:
				value = Double.valueOf(rotation_output.getText());
				break;
			default:
				assert(false);
				break;
			}
			
		}
		
		double id = 0;
		
		try{
			
			id = Double.valueOf(ct_id_input.getText());
			
		}catch(NumberFormatException nfe){
			
			try{
				id = Double.valueOf(ct_id_output.getText());
			}catch(NumberFormatException nfe2){
				id = Double.valueOf("0");
			}
			
		}
		
		return new ControlInformation(modus,value,id);
	}
	
	/**
	 * Returns the information about the right control tab.
	 * 
	 * @return right control tab information
	 */
	public ControlInformation rightInformation(){
		int modus = 0;
		if(ct_rotation_radio_r.isSelected()){
			modus = 1;
		}
		
		double value = 0;
		
		try{
			
			value = Double.valueOf(ct_tr_input_r.getText());
			
		}catch(NumberFormatException nfe){
			
			switch(modus){
			case 0:
				value = Double.valueOf(torque_output_r.getText());
				break;
			case 1:
				value = Double.valueOf(rotation_output_r.getText());
				break;
			default:
				assert(false);
				break;
			}
			
		}
		
		double id = 0;
		
		try{
			
			id = Double.valueOf(ct_id_input1.getText());
			
		}catch(NumberFormatException nfe){
			
			try{
				id = Double.valueOf(ct_id_output1.getText());
			}catch(NumberFormatException nfe2){
				id = Double.valueOf("0");
			}
			
		}
		
		return new ControlInformation(modus,value,id);
	}
	
	/**
	 * Returns the currently selected baud-rate.
	 * 
	 * @return current baud-rate
	 */
	public String getBaudRate(){
		return baudchosser.getItemAt(baudchosser.getSelectedIndex());
	}
	
	/**
	 * Sets whether the baud-rate is editable or not.
	 * 
	 * @param choosable editable rate?
	 */
	public void baudChoosable(boolean choosable){
		baudchosser.setEnabled(choosable);
	}
	
	/**
	 * Returns the index of the selected tab For this information 
	 * about the motor is needed, to be more exact which motor tab shall
	 * be asked. <br/>
	 * <br/>
	 * 0 -> control <br/>
	 * 1 -> functions
	 * 
	 * @param left left motor tab?
	 * @return the index of the currently selected tab
	 */
	public int selectedTab(boolean left){
		if(left){
			return tabs.getSelectedIndex();
		}else{
			return tabs_r.getSelectedIndex();
		}
	}
	
	/**
	 * Method for initializing the menu bar.
	 */
	private void initMenuBar(){
		// init menu items
		menu = new JMenuBar();
		options = new JMenu("Options");
		menu_close = new JMenuItem("Close");
		menu_close.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
		menu_close.addActionListener(new MenuCloseHandler(this));
		menu_connect = new JMenuItem("Reconnect");
		menu_connect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
		menu_connect.addActionListener(new MenuReconnectHandler(this));
		JSeparator options_separator = new JSeparator();
		
		// add menu items to bar 
		menu.add(options);
		options.add(menu_connect);
		options.add(options_separator);
		options.add(menu_close);
		
		// set the bar for this window
        this.setJMenuBar(menu);
	}

    // Variables declaration - do not modify                     
    private javax.swing.JTextArea console;
    private javax.swing.JTextArea console_r;
    private javax.swing.JScrollPane console_scroll;
    private javax.swing.JScrollPane console_scroll_r;
    private javax.swing.JPanel controltab;
    private javax.swing.JPanel controltab_r;
    private javax.swing.JLabel ct_id;
    private javax.swing.JLabel ct_id1;
    private javax.swing.JTextField ct_id_input;
    private javax.swing.JTextField ct_id_input1;
    private javax.swing.JLabel ct_id_input_label;
    private javax.swing.JLabel ct_id_input_label1;
    private javax.swing.JTextField ct_id_output;
    private javax.swing.JTextField ct_id_output1;
    private javax.swing.JLabel ct_id_output_label;
    private javax.swing.JLabel ct_id_output_label1;
    private javax.swing.JLabel ct_iq;
    private javax.swing.JLabel ct_iq1;
    private javax.swing.JTextField ct_iq_output;
    private javax.swing.JTextField ct_iq_output1;
    private javax.swing.JLabel ct_iq_output_label;
    private javax.swing.JLabel ct_iq_output_label1;
    private javax.swing.ButtonGroup ct_radiogroup;
    private javax.swing.ButtonGroup ct_radiogroup_r;
    private javax.swing.JRadioButton ct_rotation_radio;
    private javax.swing.JRadioButton ct_rotation_radio_r;
    private javax.swing.JRadioButton ct_torque_radio;
    private javax.swing.JRadioButton ct_torque_radio_r;
    private javax.swing.JTextField ct_tr_input;
    private javax.swing.JLabel ct_tr_input_label;
    private javax.swing.JLabel ct_tr_input_label_r;
    private javax.swing.JTextField ct_tr_input_r;
    private javax.swing.JTextArea errors;
    private javax.swing.JTextArea errors_r;
    private javax.swing.JScrollPane errors_scroll;
    private javax.swing.JScrollPane errors_scroll_r;
    private javax.swing.JButton expand;
    private javax.swing.JScrollPane functiontab;
    private javax.swing.JScrollPane functiontab1;
    private javax.swing.JPanel leftmotor;
    private javax.swing.JPanel rightmotor;
    private javax.swing.JLabel rotation_label;
    private javax.swing.JLabel rotation_label_r;
    private javax.swing.JTextField rotation_output;
    private javax.swing.JTextField rotation_output_r;
    private javax.swing.JLabel rotation_rpm;
    private javax.swing.JLabel rotation_rpm_r;
    private javax.swing.JToggleButton runbutton;
    private javax.swing.JToggleButton runbutton_r;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTabbedPane tabs_r;
    private javax.swing.JPanel toppanel;
    private javax.swing.JPanel toppanel_r;
    private javax.swing.JLabel torque_label;
    private javax.swing.JLabel torque_label_r;
    private javax.swing.JLabel torque_nm;
    private javax.swing.JLabel torque_nm_r;
    private javax.swing.JTextField torque_output;
    private javax.swing.JTextField torque_output_r;
    private javax.swing.JList<String> fnct_list;
    private javax.swing.JList<String> fnct_list_r;
    private javax.swing.JButton control_accept;
    private javax.swing.JComboBox<String> baudchosser;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu options;
    private javax.swing.JMenuItem menu_close;
    private javax.swing.JMenuItem menu_connect;
    // End of variables declaration                   
}
