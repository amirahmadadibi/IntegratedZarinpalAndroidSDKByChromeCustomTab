# Integrat Zarinpal Android SDK With ChromeCustomTab
simple project to teach how work with custom tab in order to have better payment flow in your application.

tnx to my greate friend and mentor @github/imanx
### 1 -  add chrome custom tab to your gradle depenceies 
```
    implementation 'com.android.support:customtabs:25.1.0'
```
### 2 - and then insted of just starting the activity like this
```
        purchase.startPayment(payment, new OnCallbackRequestPaymentListener() {
            @Override
            public void onCallbackResultPaymentRequest(int status, String authority, Uri paymentGatewayUri, Intent intent) {
                if (status == 100) {
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Your Payment Failure :(", Toast.LENGTH_LONG).show();
                }
            }
        });
```
### 3 - when you getting ok status insted of just starting activity,create and launch your custom tab
```
        purchase.startPayment(payment, new OnCallbackRequestPaymentListener() {
            @Override
            public void onCallbackResultPaymentRequest(int status, String authority, Uri paymentGatewayUri, Intent intent) {
                if (status == 100) {
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.launchUrl(context, uri);
                } else {
                    Toast.makeText(getApplicationContext(), "Your Payment Failure :(", Toast.LENGTH_LONG).show();
                }
            }
        });
```

### 4 - after payment process you can check for result with overriding onNewIntent Method
```
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri data = intent.getData();
        ZarinPal.getPurchase(this).verificationPayment(data, new OnCallbackVerificationPaymentListener() {
            @Override
            public void onCallbackResultVerificationPayment(boolean isPaymentSuccess, String refID, PaymentRequest paymentRequest) {
                if (isPaymentSuccess) {
                    Toast.makeText(getApplicationContext(), "done" + refID, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
```
### 5 - you have to change your launch mode for target activity in your manifest file 
```
        <activity
            android:name=".MainActivity"
            android:launchMode="singleInstance">
```
## 6 - for deep understanding on how to work with launch mode and why in every aspects read the documentation below 
{https://developer.android.com/guide/components/activities/tasks-and-back-stack}
