package com.gs.cebreja.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.gs.cebreja.R;
import com.gs.cebreja.util.SetupUI;

public class MainActivity extends AppCompatActivity  {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    protected void changeActivity(Activity olderActivity, Class newActivity) {
        startActivity(new Intent(olderActivity, newActivity));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}


