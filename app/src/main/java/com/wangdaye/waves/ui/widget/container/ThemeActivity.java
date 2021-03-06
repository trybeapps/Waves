package com.wangdaye.waves.ui.widget.container;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.wangdaye.waves.R;
import com.wangdaye.waves.utils.ImageUtils;

/**
 * Theme activity, extends AppCompatActivity class.
 * */

public abstract class ThemeActivity extends AppCompatActivity {

    public void initColorTheme(String name, int color) {
        this.setWindowTop(name, color);
    }

    public void setWindowTop(String name, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Bitmap icon = ImageUtils.readBitmapFormSrc(this,
                    R.drawable.ic_launcher, 144, 144, getResources().getDisplayMetrics().widthPixels);
            ActivityManager.TaskDescription taskDescription
                    = new ActivityManager.TaskDescription(name, icon, ContextCompat.getColor(this, color));
            setTaskDescription(taskDescription);
            icon.recycle();
        }
    }

    public void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
