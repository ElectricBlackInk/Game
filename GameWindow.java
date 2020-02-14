/**
 *  * @author Alexander Finch
 * Colin Woods
 * Mariah Moore
 * Peter Harris
 * Stefan Emmons
 *
 * Date: Feb 12, 2020
 *
 * This is the actual "game". Will have to make some major changes.
 * This is just a "hollow" shell.
 *
 * When you get done, I should see the buttons at the top in the "play" area
 * (NOT a pull-down menu). The only one that should do anything is Quit.
 *
 * Should also see something that shows where the 4x4 board and the "spare"
 * tiles will be when we get them stuffed in.
 *
 * This COULD be part of a package but I choose to make the starting point NOT a
 * package. However all other added elements should certainly sub-packages.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener
{
  /**
   * because it is a serializable object, need this or javac
   * complains <b>a lot</b>, the ID can be any integer.
   */

  public static final long serialVersionUID = 1;

  /*
   * This is so I can try changing the starting point easily. Can certainly be
   * left out altogether. 
   */
  //private int startAt=1;
  
  /**
   * Constructor sets the window name using super(), changes the layout,
   * which you really need to read up on, and maybe you can see why I chose
   * this one.
   *
   * @param s
   */

  public GameWindow(String s)
  {
    super(s);
    GridBagLayout gbl = new GridBagLayout();
    setLayout(gbl);
  }

  /**
   * For the buttons
   * @param e is the ActionEvent
   * 
   * BTW can ask the event for the name of the object generating event.
   * The odd syntax for non-java people is that "exit" for instance is
   * converted to a String object, then that object's equals() method is
   * called.
   */

  public void actionPerformed(ActionEvent e) {
    if("exit".equals(e.getActionCommand())) {
      System.exit(0);
    }
    if("reset".equals(e.getActionCommand())) {
      System.out.println("reset pressed\n");
    }
    if("new".equals(e.getActionCommand())) {
      System.out.println("new pressed\n");
    }
    }

  /**
   *  Establishes the inital board
   */

  //BEGIN STEFAN AND ALEX SECTION
  public void setUp() {

    // actually create the array for elements, make sure it is big enough
    // Has been moved to addTiles()

    // Need to play around with the dimensions and the gridx/y values
    // These constraints are going to be added to the pieces/parts I
    // stuff into the "GridBag".
    // YOU CAN USE any type of constraints you like. Just make it work.

    //Establish a new panel, with GridBagLayout manager to insert into the
    //base game container.
    //Not a huge fan of Cyan, I have changed the background to dark grey.

    JPanel board = new JPanel();
    board.setLayout(new GridBagLayout());

    GridBagConstraints basic = new GridBagConstraints();

    //We want the board centered, most of these dimensions are here
    //so the other programmers cansee exactly how this is aligned.
    //Take note, ipad species how much space each grid object takes up.
    basic.anchor = GridBagConstraints.CENTER;
    basic.fill = GridBagConstraints.BOTH;
    basic.weightx = 0;
    basic.weighty = 0;
    basic.gridx = 0;
    basic.ipadx = 70; //Magic number yes, but only serves to enlarge cells.
    basic.ipady = 70;
    basic.gridy = 0;
    basic.gridwidth = 1;
    basic.gridheight = 1;

    //Use For loop to create slots for 16 tiles.
    //Essentially create a 4x4 matrix.
    for (basic.gridy = 0; basic.gridy < 4; basic.gridy++) {

      for(basic.gridx = 0; basic.gridx < 4; basic.gridx++)
      {
        //Cell is a custom class that essentially acts as a placeholder. 
        //Has no button functionality, but looks quite nice. This will likely need to be converted
        //into button functionality in the future.

        board.add(new Cell(), basic);
         
      }
    }
  
    //END ALEX AND STEFAN SECTION
    //BEGIN COLIN AND MARIAH SECTION
    // This is really a constant in the GrdiBagConstraints. This way we 
    // don't need to know what type/value it is
    
    // Render the contents of the new Grid panel.


    //Here I should create 16 -Elements- to put into my gameBoard
    //THE ELEMENTS CANNOT BE BUTTONS!!!!!!!!
    //I can also just arrange things as I like then have methods, or an
    //argument to the constructor that adds elements. 

    
    // Now I add each one, modifying the default gridx/y and add
    // it along with the modified constraint

    //END COLIN AND MARIAH SECTION
    
    //We are working with a Frame, hence JFrame being extended in this class. Add the board panel, along
    //with it's constraints to the frame.
    add(board, basic);


    // And of course I have to add the buttons.
    this.addButtons();
    this.addTiles();
    //What this really means, is render our individual panels previously added to our frame,
    //and display them in the main game container. 
    getContentPane();
  
    return;  
  }
  /**
   * Used by setUp() to configure the buttons on a button bar and
   * add it to the gameBoard
   */
    //BEGIN PETER SECTION
  public void addButtons() {
    
    //Establish layout with desired manager, we are using GBL. 
    //Specify constraints, this is VERY much needed
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    
    //New Panel for button, Gridlayout(1,0) essentially means format all buttons together neatly,
    //in a single row. 
    JPanel buttonLayout = new JPanel(new GridLayout(1, 0));
    
    //Add buttons to this currently empty panel.
    buttonLayout.add(new JButton("New Game"));
    buttonLayout.add(new JButton("Reset"));
    buttonLayout.add(new JButton("Quit"));
    
    //Set up GridBagConstraints. For the menu buttons, "weighty" is very important. This "pushes"
    //the button assembly/panel away from the gameboard grid, and aligns it with the top of the game
    //container.
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 0;
    gbc.weighty = 0.2;
    gbc.gridx = 0;
    gbc.gridy = 0;

    //We are working with a Frame, hence JFrame being extended in this class. Add the button panel, along
    //with their constraints to the frame.
    add(buttonLayout, gbc);

    return;
  }
  //END PETER SECTION

  public void addTiles() {

    final JPanel[] elements = new JPanel[16];

    JPanel element0 = new JPanel();
    
    element0.setOpaque(true);

    element0.setBackground(Color.BLUE);

    JPanel element1 = new JPanel();

    element1.setOpaque(true);

    element1.setBackground(Color.RED);

    JPanel element2 = new JPanel();

    element2.setOpaque(true);

    element2.setBackground(Color.DARK_GRAY);

    JPanel element3 = new JPanel();

    element3.setOpaque(true);

    element3.setBackground(Color.BLUE);

    JPanel element4 = new JPanel();

    element4.setOpaque(true);

    element4.setBackground(Color.RED);

    JPanel element5 = new JPanel();

    element5.setOpaque(true);

    element5.setBackground(Color.DARK_GRAY);

    JPanel element6 = new JPanel();

    element6.setOpaque(true);

    element6.setBackground(Color.BLUE);

    JPanel element7 = new JPanel();

    element7.setOpaque(true);

    element7.setBackground(Color.RED);

    JPanel element8 = new JPanel();

    element8.setOpaque(true);

    element8.setBackground(Color.DARK_GRAY);

    JPanel element9 = new JPanel();

    element9.setOpaque(true);

    element9.setBackground(Color.BLUE);

    JPanel element10 = new JPanel();

    element10.setOpaque(true);

    element10.setBackground(Color.RED);

    JPanel element11 = new JPanel();

    element11.setOpaque(true);

    element11.setBackground(Color.DARK_GRAY);

    JPanel element12 = new JPanel();

    element12.setOpaque(true);

    element12.setBackground(Color.RED);

    JPanel element13 = new JPanel();

    element13.setOpaque(true);

    element13.setBackground(Color.DARK_GRAY);

    JPanel element14 = new JPanel();

    element14.setOpaque(true);

    element14.setBackground(Color.BLUE);

    JPanel element15 = new JPanel();

    element15.setOpaque(true);

    element15.setBackground(Color.RED);

    elements[0] = element0;

    elements[1] = element1;

    elements[2] = element2;

    elements[3] = element3;

    elements[4] = element4;

    elements[5] = element5;

    elements[6] = element6;

    elements[7] = element7;

    elements[8] = element8;

    elements[9] = element9;

    elements[10] = element10;

    elements[11] = element11;

    elements[12] = element12;

    elements[13] = element13;

    elements[14] = element14;

    elements[15] = element15;
  
    return;
  }

  // Non-interactive cell class, for now, acts as a static gameboard
  class Cell extends JPanel{

    Cell() {
      setBackground(Color.WHITE);
    }
  }

};
