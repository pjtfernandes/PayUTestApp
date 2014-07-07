package com.payutestapp.app;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.PayU.ApiVersion;
import com.Wsdl2Code.WebServices.EnterpriseAPISoapService.EnterpriseAPISoapService;
import com.Wsdl2Code.WebServices.EnterpriseAPISoapService.GetTransactionResponseMessage;
import com.Wsdl2Code.WebServices.EnterpriseAPISoapService.IWsdl2CodeEvents;
import com.Wsdl2Code.WebServices.EnterpriseAPISoapService.SetTransaction;
import com.Wsdl2Code.WebServices.EnterpriseAPISoapService.SetTransactionResponseMessage;
import com.Wsdl2Code.WebServices.EnterpriseAPISoapService.WS_Enums;
import com.Wsdl2Code.WebServices.EnterpriseAPISoapService.additionalInfo;
import com.Wsdl2Code.WebServices.EnterpriseAPISoapService.basket;
import com.Wsdl2Code.WebServices.EnterpriseAPISoapService.customer;

/**
 * Created by PJTFernandes
 */
public class MainActivity extends ActionBarActivity implements IWsdl2CodeEvents {

    //vars
    private static final String STAGING_API_URL = "https://staging.payu.co.za/service/PayUAPI";
    private static final String LIVE_API_URL = "https://secure.payu.co.za/service/PayUAPI";
    private static final String SUCCESS_URL = "http://www.google.com", FAIL_URL = "http://www.twitter.com/";
    private static final String USERNAME = "Staging Integration Store 3", PASSWORD = "WSAUFbw6";
    private static final String SAFEKEY = "{07F70723-1B96-4B97-B891-7BF708594EEA}";
    static Activity activity;
    private static SetTransactionResponseMessage setTransactionResponseMessage;
    //views
    WebView webview;
    GetTransactionResponseMessage getTransactionResponseMessage;
    private boolean isStaging = true;

    public static SetTransaction buildSetTransaction() {
        SetTransaction setTransaction = new SetTransaction();
        setTransaction.set_Api(ApiVersion.ONE_ZERO.name());

        // AdditionalInfo
        additionalInfo addInfo = new additionalInfo();
        addInfo.merchantReference = "Test";
        addInfo.demoMode = "true";
        addInfo.cancelUrl = FAIL_URL;
        addInfo.returnUrlField = SUCCESS_URL;
        addInfo.notificationUrl = FAIL_URL;
        addInfo.supportedPaymentMethods = "CREDITCARD";
        addInfo.redirectChannel = "mobi";

        setTransaction.set_AdditionalInformation(addInfo);

        basket basket = new basket();
        basket.amountInCents = "10000";
        basket.currencyCode = "ZAR";
        basket.description = "Test Product";

        setTransaction.set_Basket(basket);

        customer customer = new customer();
        customer.firstName = "John";
        customer.lastName = "Doe";
        customer.email = "john@doe.com";
        customer.mobile = "0821234567";

        setTransaction.set_Customer(customer);


        setTransaction.set_Safekey(SAFEKEY);
        setTransaction.set_TransactionType(WS_Enums.transactionType.PAYMENT);

        return setTransaction;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;

        //get views
        webview = (WebView) findViewById(R.id.webView);

        //setup soap
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                callWebService();
                return null;
            }
        }.execute();

        //setup webview
        webview.getSettings().setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }

            public void onLoadResource(WebView view, String url) {

            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Toast.makeText(activity, "Page Started! " + url, Toast.LENGTH_SHORT).show();

                if (url.startsWith(SUCCESS_URL)) {
                    //look for success/failure URL
                    EnterpriseAPISoapService srv1 = new EnterpriseAPISoapService((IWsdl2CodeEvents) activity);
                    srv1.setUrl(STAGING_API_URL);
                    additionalInfo additionalInfo = new additionalInfo();
                    additionalInfo.payUReference = setTransactionResponseMessage.payUReference;
                    additionalInfo.merchantReference = setTransactionResponseMessage.merchantReference;
                    try {
                        srv1.getTransactionAsync("ONE_ZERO", SAFEKEY, additionalInfo, USERNAME, PASSWORD);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
        webview.loadUrl("http://slashdot.org/");
    }

    public void callWebService() {

        try {
            EnterpriseAPISoapService srv1 = new EnterpriseAPISoapService(this);
            srv1.setUrl(STAGING_API_URL);

            SetTransaction setTran = buildSetTransaction();
            setTransactionResponseMessage = srv1.setTransaction(setTran.get_Api(), setTran.get_SafeKey(), setTran.get_TransactionType(), true, false, false,
                    setTran.get_AdditionalInfo(), setTran.get_Customer(), setTran.get_baBasket(), null, null, null, null, null, null, null, null, null, null, null, null, USERNAME, PASSWORD);

            if (setTransactionResponseMessage != null) {
                if (isStaging)
                    webview.loadUrl("https://staging.payu.co.za/rpp.do?PayUReference=" + setTransactionResponseMessage.payUReference);
                else
                    webview.loadUrl("https://secure.payu.co.za/rpp.do?PayUReference=" + setTransactionResponseMessage.payUReference);
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void Wsdl2CodeStartedRequest() {
        Log.e("Wsdl2Code", "Wsdl2CodeStartedRequest");

    }

    @Override
    public void Wsdl2CodeFinished(String methodName, Object Data) {
        Log.e("Wsdl2Code", "Wsdl2CodeFinished");
        Log.e("Wsdl2Code", methodName);
        if (methodName.equals("getTransaction")) {
            getTransactionResponseMessage = ((GetTransactionResponseMessage) Data);

            if (getTransactionResponseMessage != null && getTransactionResponseMessage.successful) {
                //do success stuff here
                Toast.makeText(activity, "Yay, payment success!", Toast.LENGTH_SHORT).show();
            } else {
                //do failure stuff here
                Toast.makeText(activity, "Aah, payment failed!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void Wsdl2CodeFinishedWithException(Exception ex) {
        Log.e("Wsdl2Code", "Wsdl2CodeFinishedWithException");

    }

    @Override
    public void Wsdl2CodeEndedRequest() {
        Log.e("Wsdl2Code", "Wsdl2CodeEndedRequest");
    }
}
