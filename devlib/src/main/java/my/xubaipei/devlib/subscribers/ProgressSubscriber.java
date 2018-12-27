package my.xubaipei.devlib.subscribers;


import android.content.Context;

import io.reactivex.disposables.Disposable;
import my.xubaipei.devlib.dialogs.ProgressHandler;
import my.xubaipei.devlib.SubscriberOnNextListener;

import static my.xubaipei.devlib.dialogs.ProgressHandler.DISMISS_PROGRESS_DIALOG;
import static my.xubaipei.devlib.dialogs.ProgressHandler.SHOW_PROGRESS_DIALOG;

/**
 * author ： xubaipei
 * create date： 2018-12-25
 */
public class ProgressSubscriber<T> extends ComSubscriber<T>{
    ProgressHandler mProgressHanlder;

    public ProgressSubscriber(Context context, SubscriberOnNextListener<T> listener) {
        super(context, listener, null);
        mProgressHanlder = new ProgressHandler(context);
    }

    @Override
    public void onNext(T t) {
        super.onNext(t);
    }

    @Override
    public void onSubscribe(Disposable d) {
        super.onSubscribe(d);
        mProgressHanlder.sendEmptyMessage(SHOW_PROGRESS_DIALOG);
    }

    @Override
    public void onComplete() {
        super.onComplete();
        mProgressHanlder.sendEmptyMessage(DISMISS_PROGRESS_DIALOG);
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
    }
}
