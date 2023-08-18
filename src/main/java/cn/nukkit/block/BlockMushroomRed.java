package cn.nukkit.block;

/**
 * Created by Pub4Game on 03.01.2015.
 */
public class BlockMushroomRed extends BlockMushroom {

    public BlockMushroomRed() {
        super();
    }

    public BlockMushroomRed(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Red Mushroom";
    }

    @Override
    public int getId() {
        return RED_MUSHROOM;
    }

    @Override
    protected int getType() {
        return 1;
    }
}