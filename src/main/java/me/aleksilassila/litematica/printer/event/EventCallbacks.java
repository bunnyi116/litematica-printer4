package me.aleksilassila.litematica.printer.event;

import me.aleksilassila.litematica.printer.event.callbacks.ModIterationCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.event.Event;

public class EventCallbacks {
    public static final Event<ClientTickEvents.StartTick> CLIENT_START_TICK = ClientTickEvents.START_CLIENT_TICK;
    public static final Event<ClientTickEvents.EndTick> CLIENT_END_TICK = ClientTickEvents.END_CLIENT_TICK;

    public static final Event<ClientPlayConnectionEvents.Join> CLIENT_PLAY_JOIN = ClientPlayConnectionEvents.JOIN;
    public static final Event<ClientPlayConnectionEvents.Disconnect> CLIENT_PLAY_DISCONNECT = ClientPlayConnectionEvents.DISCONNECT;

    public static final Event<ModIterationCallback> MOD_ITERATION = ModIterationCallback.EVENT;
}
