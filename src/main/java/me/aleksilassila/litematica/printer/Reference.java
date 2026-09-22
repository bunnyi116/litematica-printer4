package me.aleksilassila.litematica.printer;

import com.google.common.collect.ImmutableMap;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 模组核心常量引用类
 * 集中管理模组的全局固定值，避免硬编码和拼写错误
 */
public class Reference {
    public static final Minecraft MINECRAFT = Minecraft.getInstance();
    public static final String MOD_ID = "litematica-printer";
    public static final String MOD_NAME = "Litematica Printer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Item[] HOE_ITEMS = {Items.DIAMOND_HOE, Items.IRON_HOE, Items.GOLDEN_HOE, Items.NETHERITE_HOE, Items.STONE_HOE, Items.WOODEN_HOE};
    public static final Item[] SHOVEL_ITEMS = {Items.DIAMOND_SHOVEL, Items.IRON_SHOVEL, Items.GOLDEN_SHOVEL, Items.NETHERITE_SHOVEL, Items.STONE_SHOVEL, Items.WOODEN_SHOVEL};
    public static final Item[] AXE_ITEMS = {Items.DIAMOND_AXE, Items.IRON_AXE, Items.GOLDEN_AXE, Items.NETHERITE_AXE, Items.STONE_AXE, Items.WOODEN_AXE};

    public static final Map<Block, Block> STRIPPABLES = new ImmutableMap.Builder<Block, Block>()
            .put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD)
            .put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
            .put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
            .put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG)
            .put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
            .put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG)
            .put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
            .put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG)
            .put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
            .put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG)
            .put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
            .put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG)
            .put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM)
            .put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)
            .put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM)
            .put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE)
            //#if MC >= 11900
            .put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD)
            .put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG)
            //#endif
            //#if MC >= 11903
            .put(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK)
            //#endif
            //#if MC >= 11904
            .put(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD)
            .put(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG)
            //#endif
            //#if MC >= 12102
            .put(Blocks.PALE_OAK_WOOD, Blocks.STRIPPED_PALE_OAK_WOOD)
            .put(Blocks.PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_LOG)
            //#endif
            .build();

    public static Class<?>[] ignoreWrongStateBlocks = {
            //#if MC >= 12000
            ChiseledBookShelfBlock.class,       // 雕文书架
            //#endif
            BrewingStandBlock.class,            // 酿造台
            StainedGlassPaneBlock.class,        // 玻璃板
            VegetationBlock.class,              // 植被
            LeavesBlock.class,                  // 树叶
            SugarCaneBlock.class,               // 甘蔗
//            TurtleEggBlock.class,               // 海龟蛋
//            SeaPickleBlock.class,               // 海泡菜

    };


    /**
     * 是否忽略错误状态方块
     */
    public static boolean isIgnoreWrongStateBlocks(Block block) {
        for (Class<?> clazz : ignoreWrongStateBlocks) {
            if (clazz.isInstance(block)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 可交互的方块类
     */
    public static Class<?>[] interactiveBlocks = {
            AbstractFurnaceBlock.class,     // 熔炉/烟熏炉/高炉
            CraftingTableBlock.class,       // 工作台
            ChestBlock.class,               // 箱子
            BarrelBlock.class,              // 木桶
            HopperBlock.class,              // 漏斗
            ShulkerBoxBlock.class,          // 潜影盒
            ComparatorBlock.class,          // 红石比较器
            RepeaterBlock.class,            // 红石中继器
            LeverBlock.class,               // 拉杆
            DoorBlock.class,                // 门
            TrapDoorBlock.class,            // 活板门
            BedBlock.class,                 // 床
            //#if MC >= 260300
            //$$ RedstoneWireBlock.class,        // 红石线
            //#else
            RedStoneWireBlock.class,        // 红石线
            //#endif
            ScaffoldingBlock.class,         // 脚手架
            EnchantingTableBlock.class,     // 附魔台
            NoteBlock.class,                // 音符盒
            JukeboxBlock.class,             // 唱片机
            CakeBlock.class,                // 蛋糕
            FenceGateBlock.class,           // 栅栏门
            BrewingStandBlock.class,        // 酿造台
            DragonEggBlock.class,           // 龙蛋
            CommandBlock.class,             // 命令方块
            BeaconBlock.class,              // 信标
            AnvilBlock.class,               // 铁砧
            DropperBlock.class,             // 投掷器
            DispenserBlock.class,           // 发射器
            LecternBlock.class,             // 讲台
            FlowerPotBlock.class,           // 花盆
            BellBlock.class,                // 钟
            SmithingTableBlock.class,       // 锻造台
            LoomBlock.class,                // 织布机
            CartographyTableBlock.class,    // 制图台
            GrindstoneBlock.class,          // 砂轮
            StonecutterBlock.class,         // 切石机
            SignBlock.class,                // 告示牌（右键打开编辑界面）
            //#if MC < 12109
            //$$ FletchingTableBlock.class, // 制箭台
            //#endif
            //#if MC >= 12003
            CrafterBlock.class,             // 合成器（自动合成台）
            //#endif
    };

    /**
     * 检查方块是否可以交互
     */
    public static boolean isInteractive(Block block) {
        for (Class<?> clazz : interactiveBlocks) {
            if (clazz.isInstance(block)) {
                return true;
            }
        }
        return false;
    }
}
