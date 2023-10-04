package cn.nukkit.event.blockstate;

import cn.nukkit.block.Block;
import cn.nukkit.block.blockstate.BlockStateRepair;
import cn.nukkit.event.HandlerList;
import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author joserobjr
 */
public class BlockStateRepairFinishEvent extends BlockStateRepairEvent {
    @NotNull
    private final List<BlockStateRepair> allRepairs;

    @NotNull
    private Block result;

    public BlockStateRepairFinishEvent(@NotNull List<BlockStateRepair> allRepairs, @NotNull Block result) {
        super(allRepairs.get(allRepairs.size() - 1));
        this.allRepairs = List.copyOf(allRepairs);
        this.result = result;
    }

    @NotNull
    public List<BlockStateRepair> getAllRepairs() {
        return allRepairs;
    }

    @NotNull
    public Block getResult() {
        return result;
    }

    public void setResult(@NotNull Block result) {
        this.result = Preconditions.checkNotNull(result);
    }

    @NotNull
    private static final HandlerList handlers = new HandlerList();

    @NotNull
    public static HandlerList getHandlers() {
        return handlers;
    }
}
