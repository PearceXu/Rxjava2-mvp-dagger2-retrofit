package my.xubaipei.devlib.dialogs;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

public class ProgressHandler extends Handler {
    private Dialog mPDialog;

    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private Context context;

    public ProgressHandler(Context context) {
        this.context = context;
    }


    private void initProgressDialog(){
        if (mPDialog == null) {
            if (context == null) {
                throw new NullPointerException("context is null,check param input");
            }
            mPDialog = new CustomProgress(context);
            if (!mPDialog.isShowing()) {
                mPDialog.show();
            }
        }
    }



    private void dismissProgressDialog(){
        if (mPDialog != null && mPDialog.isShowing()) {
            mPDialog.dismiss();
            mPDialog = null;
        }
    }
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
