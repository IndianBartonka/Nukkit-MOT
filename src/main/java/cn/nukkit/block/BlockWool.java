package cn.nukkit.block;

import cn.nukkit.block.blockproperty.BlockProperties;
import cn.nukkit.block.blockproperty.CommonBlockProperties;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;
import cn.nukkit.utils.DyeColor;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2015/12/2 by xtypr.
 * Package cn.nukkit.block in project Nukkit .
 */
public class BlockWool extends BlockSolidMeta {

    public static final BlockProperties PROPERTIES = CommonBlockProperties.COLOR_BLOCK_PROPERTIES;

    public BlockWool() {
        this(0);
    }

    public BlockWool(int meta) {
        super(meta);
    }

    public BlockWool(DyeColor dyeColor) {
        this(dyeColor.getWoolData());
    }

    @Override
    public String getName() {
        return getDyeColor().getName() + " Wool";
    }

    @Override
    public int getId() {
        return WOOL;
    }

    @NotNull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_SHEARS;
    }

    @Override
    public double getHardness() {
        return 0.8;
    }

    @Override
    public double getResistance() {
        return 4;
    }

    @Override
    public int getBurnChance() {
        return 30;
    }

    @Override
    public int getBurnAbility() {
        return 60;
    }

    @Override
    public BlockColor getColor() {
        return DyeColor.getByWoolData(getDamage()).getColor();
    }

    public DyeColor getDyeColor() {
        return DyeColor.getByWoolData(getDamage());
    }
}
