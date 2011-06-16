package com.t_arn.JavaIDEdroid;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;

public class HelpActivity extends Activity 
{

//===================================================================
  @Override
  protected void onCreate(Bundle savedInstanceState) 
//===================================================================
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.help);

    final WebView view = (WebView) findViewById(R.id.vwHelp);
    view.getSettings().setJavaScriptEnabled(true);
    initWebKit(view, this);
    view.bringToFront();
  } // onCreate
//===================================================================
  private void initWebKit(final WebView view, final Context context) 
//===================================================================
  {
    final String mimetype = "text/html";
    final String encoding = "UTF-8";
    String htmldata;
    
    final int contextMenueId = R.raw.help;    
    final InputStream is = context.getResources().openRawResource(contextMenueId);

    try 
    {
      if (is != null && is.available() > 0) 
      {
        final byte[] bytes = new byte[is.available()];
        is.read(bytes);
        htmldata = new String(bytes);
        view.loadDataWithBaseURL(null, htmldata, mimetype, encoding, null);
      }
    } catch (IOException e) { }
  } // initWebKit
//===================================================================
}
