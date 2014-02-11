package com.rlamb1id.MuteAll;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MuteAllActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MuteAllActivity.this.finish();
            }
        });
    }
}
