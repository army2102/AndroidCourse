package androidcourse.naetirat.mvcstructure.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import androidcourse.naetirat.mvcstructure.R;
import androidcourse.naetirat.mvcstructure.fragment.MainFragment;
import androidcourse.naetirat.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();

        //Toast screenWidth & screenHeight
        Toast.makeText(MainActivity.this, "Width : " + screenWidth + ", Height :" + screenHeight, Toast.LENGTH_LONG);

        //Separate by Android version
        if (Build.VERSION.SDK_INT >= 21) {
            // Run on Android 21+
        } else {
            // Run on Android 1-20
        }

        if (savedInstanceState == null) {
            // First created
            // Place Fragment here
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance(123),
                            "MainFragment")
                    .commit();


        }

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            MainFragment fragment =
                    (MainFragment) getSupportFragmentManager().findFragmentByTag("MainFragment");
            fragment.setHelloText("Woo Hooooooo");
        }
    }
}
