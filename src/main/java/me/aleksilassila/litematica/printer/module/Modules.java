package me.aleksilassila.litematica.printer.module;

import com.google.common.collect.ImmutableList;
import me.aleksilassila.litematica.printer.module.modules.*;

public class Modules {
    public static final GuiModule GUI = new GuiModule();
    public static final PrintModule PRINT = new PrintModule();
    public static final FillModule FILL = new FillModule();
    public static final MineModule MINE = new MineModule();
    public static final FluidModule FLUID = new FluidModule();
    public static final BedrockModule BEDROCK = new BedrockModule();
    public static final ImmutableList<Module> VALUES = ImmutableList.of(GUI, MINE, FLUID, PRINT, FILL, BEDROCK);
}
