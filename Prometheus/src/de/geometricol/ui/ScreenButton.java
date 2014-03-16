package de.geometricol.ui;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ScreenButton {

	public static final float SCALE_FACTOR = Gdx.graphics.getWidth() / 300;

	public static HashMap<String, ScreenButton> buttons = new HashMap<String, ScreenButton>();

	public String title;

	public int x;
	public int y;

	public int width;
	public int height;

	public TextureRegion textureRegion;

	public boolean isClicked = false;
	public boolean visible = false;

	public int tempPointer = -1;

	public ScreenButton(String title, int x, int y) {
		int i = 1;
		if (buttons.containsKey(title)) {
			while (buttons.containsKey(title + i)) {
				i++;
			}
			buttons.put(title + i, this);
			this.title = title + i;
		} else {
			this.title = title;
			buttons.put(title, this);
		}

		this.x = x;
		this.y = y;
	}

	public ScreenButton(String title, int x, int y, int width, int height) {
		int i = 1;
		if (buttons.containsKey(title)) {
			while (buttons.containsKey(title + i)) {
				i++;
			}
			buttons.put(title + i, this);
			this.title = title + i;
		} else {
			this.title = title;
			buttons.put(title, this);
		}

		this.x = x;
		this.y = y;

		this.width = width;
		this.height = height;
	}

	public ScreenButton(String title, int x, int y, TextureRegion texture) {
		int i = 1;
		if (buttons.containsKey(title)) {
			while (buttons.containsKey(title + i)) {
				i++;
			}
			buttons.put(title + i, this);
			this.title = title + i;
		} else {
			this.title = title;
			buttons.put(title, this);
		}

		this.x = x;
		this.y = y;

		this.textureRegion = texture;
	}

	public ScreenButton(String title, int x, int y, int width, int height, TextureRegion texture) {
		int i = 1;

		if (buttons.containsKey(title)) {
			while (buttons.containsKey(title + i)) {
				i++;
			}
			buttons.put(title + i, this);
			this.title = title + i;
		} else {
			this.title = title;
			buttons.put(title, this);
		}

		this.x = x;
		this.y = y;

		this.width = width;
		this.height = height;

		this.textureRegion = texture;
	}

	public static void update(float delta) {
		for (Map.Entry<String, ScreenButton> entry : buttons.entrySet()) {
			entry.getValue().updateButton(delta);
		}

	}

	public static void render(SpriteBatch sB) {

		sB.begin();
		sB.enableBlending();
		for (Map.Entry<String, ScreenButton> entry : buttons.entrySet()) {
			entry.getValue().renderButton(sB);
		}
		sB.end();

	}

	public void updateButton(float delta) {
		if (isClicked) x--;
	}

	public void renderButton(SpriteBatch sB) {
		if (visible) {
			sB.draw(textureRegion, x, y, width, height);
		}
	}

	public static void onTouchDown(int screenX, int screenY, int pointer) {
		for (Map.Entry<String, ScreenButton> entry : buttons.entrySet()) {
			ScreenButton screenButton = entry.getValue();

			int buttonX = (int) (screenButton.x * SCALE_FACTOR);
			int buttonY = (int) (screenButton.y * SCALE_FACTOR);

			int buttonXC = buttonX + ((int) (screenButton.width * SCALE_FACTOR));
			int buttonYC = buttonY + ((int) (screenButton.height * SCALE_FACTOR));

			if (screenX >= buttonX && screenY >= buttonY && screenX <= buttonXC && screenY <= buttonYC) {
				screenButton.tempPointer = pointer;
				screenButton.isClicked = true;
			}

		}
	}

	public static void onTouchUp(int pointer) {
		for (Map.Entry<String, ScreenButton> entry : buttons.entrySet()) {
			ScreenButton screenButton = entry.getValue();

			if (screenButton.tempPointer == pointer) {
				screenButton.tempPointer = -1;
				screenButton.isClicked = false;
			}
		}
	}

	public static void onTouchDragged(int screenX, int screenY, int pointer) {
		for (Map.Entry<String, ScreenButton> entry : buttons.entrySet()) {
			ScreenButton screenButton = entry.getValue();

			int buttonX = (int) (screenButton.x * SCALE_FACTOR);
			int buttonY = (int) (screenButton.y * SCALE_FACTOR);

			int buttonXC = buttonX + ((int) (screenButton.width * SCALE_FACTOR));
			int buttonYC = buttonY + ((int) (screenButton.height * SCALE_FACTOR));

			if (screenButton.tempPointer == pointer) {
				if (!(screenX >= buttonX && screenY >= buttonY && screenX <= buttonXC && screenY <= buttonYC)) {
					screenButton.tempPointer = -1;
					screenButton.isClicked = false;
				}
			} else if (screenX >= buttonX && screenY >= buttonY && screenX <= buttonXC && screenY <= buttonYC) {
				screenButton.tempPointer = pointer;
				screenButton.isClicked = true;
			}
		}
	}
}
