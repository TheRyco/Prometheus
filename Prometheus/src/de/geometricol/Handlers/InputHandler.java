package de.geometricol.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import de.geometricol.Prometheus.PrometheusGame;
import de.geometricol.ui.ScreenButton;

public class InputHandler implements InputProcessor {
	

	public boolean[] keys;

	public InputHandler() {
		keys = new boolean[200];
	}

	@Override
	public boolean keyDown(int keycode) {
		keys[keycode] = true;
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		keys[keycode] = false;
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		ScreenButton.onTouchDown(screenX, screenY, pointer);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		ScreenButton.onTouchUp(pointer);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		ScreenButton.onTouchDragged(screenX, screenY, pointer);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
