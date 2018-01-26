// Copyright 2017, the Flutter project authors.  Please see the AUTHORS file
// for details. All rights reserved. Use of this source code is governed by a
// BSD-style license that can be found in the LICENSE file.

package com.example.xlbaidumapflutter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CountActivity extends AppCompatActivity {
  public static final String EXTRA_COUNTER = "counter";
  private int counter = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.android_full_screen_layout);
    counter = getIntent().getIntExtra(EXTRA_COUNTER, 0);
    /*Button switchViewButton = findViewById(R.id.button);
    switchViewButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        returnToFlutterView();
      }
    });*/
  }


  private void returnToFlutterView() {
    Intent returnIntent = new Intent();
    returnIntent.putExtra(EXTRA_COUNTER, counter);
    setResult(Activity.RESULT_OK, returnIntent);
    finish();
  }

  public void onBackPressed() {
    returnToFlutterView();
  }
}
