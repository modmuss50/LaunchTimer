package me.modmuss50.timer;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import java.util.Map;

/**
 * To run this in dev you need to add the following to the *VM* Options in the run config
 *
 * -Dfml.coreMods.load=me.modmuss50.timer.TimerCore
 */
@IFMLLoadingPlugin.SortingIndex(Integer.MAX_VALUE)
public class TimerCore implements IFMLLoadingPlugin {

	public static long startTime;

	public TimerCore() {
		//If any one knows any place that can do this sooner let me know
		startTime = System.currentTimeMillis();
	}

	@Override
	public String[] getASMTransformerClass() {
		return new String[0];
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {

	}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}
}
