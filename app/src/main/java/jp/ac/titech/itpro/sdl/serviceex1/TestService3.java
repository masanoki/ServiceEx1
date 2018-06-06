package jp.ac.titech.itpro.sdl.serviceex1;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class TestService3 extends IntentService {
    private final static String TAG = "TestService3";
    public final static String EXTRA_MYARG = "MYARG";
    private final static String ACTION_ANSWER = "ACTION";
    private final static String EXTRA_ANSWER = "EXTRA";

    TestService3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        try {
            Thread.sleep(5000);
            Intent answerIntent = new Intent();
            answerIntent.setAction(ACTION_ANSWER);
            answerIntent.putExtra(EXTRA_ANSWER, "Hello, Serviece3");
            sendBroadcast(answerIntent);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate in " + Thread.currentThread());
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}

