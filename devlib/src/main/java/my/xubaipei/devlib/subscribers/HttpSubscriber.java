package my.xubaipei.devlib.subscribers;

import android.content.Context;

import java.util.Locale;

import my.xubaipei.devlib.SubscriberOnNextListener;
import my.xubaipei.devlib.entities.BaseEntity;
import my.xubaipei.devlib.LoadingView;

/**
 * author ： xubaipei
 * create date： 2018-12-25
 */
public class HttpSubscriber<T extends BaseEntity> extends ComSubscriber<T> {
    public HttpSubscriber(Context context, SubscriberOnNextListener<T> listener, LoadingView loadingView) {
        super(context, listener, loadingView);
    }

    @Override
    public void onNext(T t) {
        if (t.code != 200){
            onError(new Exception(String.format(Locale.US,"error:%s\ndesc:%s",t.code,t.desc)));
            return;
        }
        super.onNext(t);
    }
}
