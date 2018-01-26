package com.example.xlbaidumapflutter;

import android.content.Intent;
import android.os.Bundle;

import function.activity.MapActivity;
import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
  private static final String CHANNEL = "samples.flutter.io/platform_view";
  private static final String METHOD_SWITCH_VIEW = "switchView";
  private static final int COUNT_REQUEST = 1;

  private MethodChannel.Result result;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(this);

    new MethodChannel(getFlutterView(), CHANNEL).setMethodCallHandler(
            new MethodChannel.MethodCallHandler() {
              @Override
              public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                MainActivity.this.result = result;
                int count = methodCall.arguments();
                if (methodCall.method.equals(METHOD_SWITCH_VIEW)) {
                  onLaunchFullScreen(count);
                } else {
                  result.notImplemented();
                }
              }
            }
    );
  }

  private void onLaunchFullScreen(int count) {
    Intent fullScreenIntent = new Intent(this, MapActivity.class);
    fullScreenIntent.putExtra(MapActivity.EXTRA_COUNTER, count);
    startActivityForResult(fullScreenIntent, COUNT_REQUEST);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == COUNT_REQUEST) {
      if (resultCode == RESULT_OK) {
        result.success(data.getIntExtra(CountActivity.EXTRA_COUNTER, 0));
      } else {
        result.error("ACTIVITY_FAILURE", "Failed while launching activity", null);
      }
    }
  }
}
