package io.rong.imkit.demo;

import java.io.Serializable;

//import com.sea_monster.core.network.AbstractHttpRequest;
import com.umeng.analytics.MobclickAgent;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

/**
 * Created by zhjchen on 14-4-8.
 */
public abstract class BaseActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		setVolumeControlStream(AudioManager.STREAM_MUSIC);// 使得音量键控制媒体声音
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(setContentViewResId());
		initView();
		initData();

	}

	@SuppressWarnings("unchecked")
	protected <T extends View> T getViewById(int id) {
		return (T) findViewById(id);
	}

	protected abstract int setContentViewResId();

	protected abstract void initView();

	protected abstract void initData();


    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}