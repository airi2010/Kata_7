
package kata_7.control;

import kata_7.model.Block;
import kata_7.view.BlockDisplay;
import kata_7.view.BlockDisplay.Moved;

public class BlockPresenter implements Block.Observer{
    public static final int SIZE=100;
    private final Block block;
    private final BlockDisplay blockdisplay;

    public BlockPresenter(Block block, BlockDisplay blockdisplay) {
        this.block = block;
        this.blockdisplay = blockdisplay;
        this.blockdisplay.on(new Moved() {
            @Override
            public void to(int x, int y) {
               block.moveTo(x/100 +1, Block.MAX- y /100);
            }
        });
        this.block.register(this);
        this.refresh();
    }

    private void refresh() {
      blockdisplay.paintBlock((block.x()-1)*SIZE,(block.MAX-block.y())*SIZE);
      
    }

    @Override
    public void changed() {
        this.refresh();
    }
    
}
