package de.geometricol.Prometheus;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Prometheus";
		cfg.useGL20 = false;
		cfg.width = 600;
		cfg.height = cfg.width / 16 * 9;
		cfg.resizable = false;
		new LwjglApplication(new PrometheusGame(), cfg);
	}
}