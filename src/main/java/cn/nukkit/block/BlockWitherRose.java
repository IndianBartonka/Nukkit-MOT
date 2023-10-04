package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.block.blockproperty.BlockProperties;
import cn.nukkit.block.blockproperty.CommonBlockProperties;
import cn.nukkit.block.blockproperty.value.SmallFlowerType;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityLiving;
import cn.nukkit.item.Item;
import cn.nukkit.math.AxisAlignedBB;
import cn.nukkit.potion.Effect;
import org.jetbrains.annotations.NotNull;

public class BlockWitherRose extends BlockFlower {
    public BlockWitherRose() {
        this(0);
    }

    public BlockWitherRose(int meta) {
        super(0);
    }

    @Override
    public int getId() {
        return WITHER_ROSE;
    }

    @NotNull
    @Override
    public BlockProperties getProperties() {
        return CommonBlockProperties.EMPTY_PROPERTIES;
    }

    @Override
    public boolean canPlantOn(Block block) {
        return super.canPlantOn(block) || block.getId() == BlockID.NETHERRACK || block.getId() == BlockID.SOUL_SAND;
    }

    @Override
    public boolean onActivate(@NotNull Item item, Player player) {
        return false;
    }

    @Override
    public void onEntityCollide(Entity entity) {
        if (level.getServer().getDifficulty() != 0 && entity instanceof EntityLiving living) {
            if (!living.invulnerable && !living.hasEffect(Effect.WITHER)
                    && (!(living instanceof Player) || !((Player) living).isCreative() && !((Player) living).isSpectator())) {
                Effect effect = Effect.getEffect(Effect.WITHER);
                effect.setDuration(40);
                effect.setAmplifier(1);
                living.addEffect(effect);
            }
        }
    }

    @Override
    protected AxisAlignedBB recalculateCollisionBoundingBox() {
        return this;
    }

    @Override
    public boolean hasEntityCollision() {
        return true;
    }

    
    @Override
    public void setFlowerType(SmallFlowerType flowerType) {
        setOnSingleFlowerType(SmallFlowerType.WITHER_ROSE, flowerType);
    }
    
    @Override
    public SmallFlowerType getFlowerType() {
        return SmallFlowerType.WITHER_ROSE;
    }
}
