package net.pourquoipas.tests01;

import net.pourquoipas.tests01.util.SystemUiHider;
import android.os.Bundle;
import android.view.View;

public class FirstTestActivity extends BaseTestActivity {
	/**
	 * Whether or not the system UI should be auto-hidden after
	 * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
	 */
	private static final boolean AUTO_HIDE = true;
	public boolean getAutoHide() {
		return AUTO_HIDE;
	}

	/**
	 * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
	 * user interaction before hiding the system UI.
	 */
	private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
	public int getAutoHideDelayMillis() {
		return AUTO_HIDE_DELAY_MILLIS;
	}

	/**
	 * If set, will toggle the system UI visibility upon interaction. Otherwise,
	 * will show the system UI visibility upon interaction.
	 */
	private static final boolean TOGGLE_ON_CLICK = true;
	public boolean getToggleOnClick() {
		return TOGGLE_ON_CLICK;
	}

	/**
	 * The flags to pass to {@link SystemUiHider#getInstance}.
	 */
	private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;
	public int getHiderFlags() {
		return HIDER_FLAGS;
	}
	

	@Override
	public int getLayoutResId() {
		return R.layout.activity_base_test;
	}

	@Override
	public void onCreateBeforeLayout(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreateEnd(Bundle savedInstanceState) {
		// Upon interacting with UI controls, delay any scheduled hide()
		// operations to prevent the jarring behavior of controls going away
		// while interacting with the UI.
		findViewById(R.id.dummy_button).setOnTouchListener(
				mDelayHideTouchListener);
		
	}


	@Override
	public void onCreateAfterLayout(Bundle savedInstanceState) {
		controlsView = findViewById(R.id.fullscreen_content_controls);
		contentView = findViewById(R.id.fullscreen_content);
		
	}

	private View controlsView;
	private View contentView;


	@Override
	public View getContentView() {
		return contentView;
	}


	@Override
	public View getControlsView() {
		return controlsView;
	}

}
