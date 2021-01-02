
package kata_7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import kata_7.control.BlockPresenter;
import kata_7.control.Command;
import kata_7.control.DownCommand;
import kata_7.control.LeftCommand;
import kata_7.control.RightCommand;
import kata_7.control.UpCommand;
import kata_7.control.timeCommand;
import kata_7.model.Block;
import kata_7.view.BlockDisplay;

public class Kata_7 extends JFrame {
    private Block block;
    private BlockDisplay blockDisplay;
    private BlockPresenter blockpresenter;
    Map<String, Command> commands;
    public static void main(String[] args) {
        new Kata_7().execute();
    }
    public Kata_7(){
        this.setTitle("Block shifter v2");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(740,790);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().add(blockPanel());
        this.add(toolbar(),BorderLayout.SOUTH);
    }

    private void execute() {
        this.block=new Block(4,4);
        this.blockpresenter=new BlockPresenter(block,blockDisplay);
        this.commands=createCommands();
        this.setVisible(true);
    }

    private JPanel blockPanel() {
        BlockPanel panel = new BlockPanel(Block.MAX,blockpresenter.SIZE);
        this.blockDisplay = panel;
        return panel;
    }
    
    private Map<String,Command> createCommands(){
        Map<String, Command> commands = new HashMap<>();
        commands.put("U", new UpCommand(block));
        commands.put("D", new DownCommand(block));
        commands.put("L", new LeftCommand(block));
        commands.put("R", new RightCommand(block));
        commands.put("T", new timeCommand(block));
        return commands;
    }

    private JMenuBar toolbar() {
        JMenuBar result = new JMenuBar();
        result.setLayout(new FlowLayout(FlowLayout.CENTER));
        result.add(button("L"));
        result.add(button("U"));
        result.add(button("D"));
        result.add(button("R"));
        result.add(button("T"));
        return result;
    }

    private JButton button(String command) {
        JButton button = new JButton(command);
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                commands.get(command).execute();
            }
        });
        return button;
    }
    
}
