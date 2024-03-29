package com.example.studentrecord.AboutUs;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.studentrecord.R;

import static com.example.studentrecord.R.id.staboutUs;

//import Fragment;

public class AboutUsFragment extends Fragment {

    public WebView webView;
    public ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View aboutview = inflater.inflate(R.layout.fragment_about_us,container,false);

        webView = aboutview.findViewById(staboutUs);
        progressBar = aboutview.findViewById(R.id.stprogress);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(view.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(view.GONE);
            }
        });
        webView.loadUrl("https://softwarica.edu.np/");


        return aboutview;


    }




}
