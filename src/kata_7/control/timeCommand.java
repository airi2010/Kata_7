package kata_7.control;

import kata_7.model.Block;

/**
 *
 * @author Airam
 */
public class timeCommand implements Command{
    private final Block block;

    public timeCommand(Block block) {
        this.block = block;
    }
    public void close(){
        block.stop();
    }
    @Override
    public void execute() {
       block.time();
    }
    
}
