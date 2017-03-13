package me.modmuss50.timer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(name = "LaunchTimer", modid = "launchtimer", clientSideOnly = true, acceptedMinecraftVersions = "*")
public class TimerMod {

	private static long stoptime = 0;
	private static boolean hasStopped = false;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void renderGui(GuiScreenEvent.DrawScreenEvent event) {
		if (event.getGui() != null && event.getGui() instanceof GuiMainMenu) {
			if (!hasStopped) {
				stoptime = System.currentTimeMillis() - TimerCore.startTime;
				System.out.println("Startup time: " + formatTime(stoptime));
				hasStopped = true;
			}

			event.getGui().drawString(Minecraft.getMinecraft().fontRendererObj, "Startup time: " + formatTime(stoptime), 10, 10, -1);
		}
	}

	public static String formatTime(long time) {
		final int min = (int) (time / 60000L);
		time -= min * 60000;
		final int sec = (int) (time / 1000L);
		time -= sec * 1000;
		return String.format("%02d:%02d.%03d", min, sec, time);
	}
}
