package me.aleksilassila.litematica.printer.guide.guides;

import me.aleksilassila.litematica.printer.config.Configs;
import me.aleksilassila.litematica.printer.guide.BlockMatchResult;
import me.aleksilassila.litematica.printer.guide.Guide;
import me.aleksilassila.litematica.printer.guide.Result;
import me.aleksilassila.litematica.printer.printer.SchematicBlockContext;
import me.aleksilassila.litematica.printer.action.Action;
import me.aleksilassila.litematica.printer.action.ClickAction;
import me.aleksilassila.litematica.printer.Reference;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Map;

/**
 * 去皮原木
 */
public class StripLogGuide extends Guide {

    public StripLogGuide(SchematicBlockContext context) {
        super(context);
    }

    @Override
    protected Result onBuildActionMissingBlock(BlockMatchResult state) {
        Direction.Axis axis = getProperty(requiredState, BlockStateProperties.AXIS).orElse(null);
        if (axis == null) return Result.skipOtherGuide();

        Action action = new Action().setSides(axis);

        // 配置启用去皮时，可接受原版或去皮版本
        if (Configs.Print.STRIP_LOGS.getBooleanValue()) {
            for (Map.Entry<Block, Block> entry : Reference.STRIPPABLES.entrySet()) {
                if (requiredBlock == entry.getValue()) {
                    action.setItems(entry.getValue().asItem(), entry.getKey().asItem());
                    return Result.success(action);
                }
            }
        }

        return Result.success(action);
    }

    @Override
    protected Result onBuildActionErrorBlock(BlockMatchResult state) {
        if (Configs.Print.BREAK_WRONG_BLOCK.getBooleanValue()) {
            return Result.skipOtherGuide();
        }
        Block stripped = Reference.STRIPPABLES.get(currentBlock);
        if (stripped != null && stripped == requiredBlock) {
            return Result.success(new ClickAction().setItems(Reference.AXE_ITEMS));
        }
        return Result.skipOtherGuide();
    }
}
