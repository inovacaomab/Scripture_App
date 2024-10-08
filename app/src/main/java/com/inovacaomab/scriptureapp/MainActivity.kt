package com.inovacaomab.scripturaapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        val webSettings: WebSettings = webView.settings

        webSettings.apply {
            javaScriptEnabled = true
            builtInZoomControls = true
            displayZoomControls = false
            loadWithOverviewMode = true
            useWideViewPort = true
            domStorageEnabled = true
            allowContentAccess = true
            allowFileAccess = true
            setGeolocationEnabled(true)
            databaseEnabled = true
            cacheMode = WebSettings.LOAD_DEFAULT
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
                // Aqui você pode tratar erros de carregamento
                // Por exemplo, mostrar uma mensagem de erro ou um layout alternativo
            }
        }

        webView.webChromeClient = WebChromeClient()
        webView.loadUrl("https://sites.google.com/view/family35")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}