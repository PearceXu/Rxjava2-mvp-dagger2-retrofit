package my.xubaipei.devlib.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.widget.TextView;

import myxubaipei.devlib.R;

/**
 * Created by xubaipei on 2016/10/31.
 */
public class CustomProgress extends Dialog {
    TextView mLoadMessage = null;
    public CustomProgress(Context context) {
        super(context,R.style.Progress_Dialog);
    }

    public CustomProgress(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    public void init(){
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.progress_dialog);
        mLoadMessage = (TextView)findViewById(R.id.txt_gen);
        getWindow().getAttributes().gravity = Gravity.CENTER;
        setCancelable(false);
    }
    void setText(String content){
        if (mLoadMessage != null) {
            mLoadMessage.setText(content);
        }
    }
}