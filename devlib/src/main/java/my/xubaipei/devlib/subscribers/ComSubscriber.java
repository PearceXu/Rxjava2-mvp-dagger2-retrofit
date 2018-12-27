package my.xubaipei.devlib.subscribers;

import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import my.xubaipei.devlib.exceptionHandler.ExceptionHandler;
import my.xubaipei.devlib.LoadingView;
import my.xubaipei.devlib.SubscriberOnNextListener;


public class ComSubscriber<T> implements Observer<T> {
    LoadingView mLoadingView;
    SubscriberOnNextListener<T> mListener;
    ExceptionHandler mExceptionHandler;

    public ComSubscriber(Context context,SubscriberOnNextListener<T> listener, LoadingView loadingView) {
        this.mLoadingView = loadingView;
        mListener = listener;
        mExceptionHandler = new ExceptionHandler(context);
    }

    @Override
    public void onNext(T t) {
        if (mListener != null){
            mListener.onNext(t);
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (mLoadingView != null){
            mLoadingView.startLoadding();
        }
    }

    @Override
    public void onComplete() {
        if (mLoadingView != null){
            mLoadingView.stopLoadding();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (mExceptionHandler != null){
            mExceptionHandler.catchException(e);
        }
        onComplete();
    }

}
