package my.xubaipei.devlib.exceptionHandler;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import myxubaipei.devlib.R;

/**
 * author ： xubaipei
 * create date： 2018-12-25
 */
public class ExceptionHandler implements IExceptionHandler {
    private final String TAG = "ExceptionHandler";
    Context mContext;

    public ExceptionHandler(Context context){
        mContext = context;
    }
    public static ExceptionHandler create(Context context){
        return new ExceptionHandler(context);
    }

    @Override
    public void catchException(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            //"网络中断，请检查您的网络状态"
        } else if (e instanceof SocketException || e instanceof UnknownHostException) {
            //"网络中断，请检查您的网络状态"
            Toast.makeText(mContext, mContext.getString(R.string.no_network), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
            final String erroLog  = getErroLog(e);
            Log.e(TAG,erroLog);
        }

    }

    public String getErroLog(Throwable exception){
        PackageInfo packageInfo = getPackagetInfo(mContext);
        StringBuffer exceptionStr = new StringBuffer();
        exceptionStr.append("Version: " + packageInfo.versionName + "(" + packageInfo.versionCode + ")\n");
        exceptionStr.append("Android: " + Build.VERSION.RELEASE + "(" + Build.MODEL + ")\n");
        exceptionStr.append("Exception: " + exception.toString()+ "\n");
        exceptionStr.append("Time: " +getDate()+ "\n");
        StackTraceElement[] elements = exception.getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            exceptionStr.append(elements[i].toString() + "\n");
        }
        return exceptionStr.toString();
    }

    public static String getDate(){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        res = simpleDateFormat.format(date);
        return res;
    }

    public PackageInfo getPackagetInfo(Context context){
        PackageInfo info = null;
        try {
            info = mContext.getPackageManager().getPackageInfo(
                    mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if (info == null)
            info = new PackageInfo();
        return info;
    }
}
