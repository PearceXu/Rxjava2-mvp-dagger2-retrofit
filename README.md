#Rxjava2-mvp-dagger2-retrofit
实现真正解耦的mvp 架构，可用于初始项目框架

觉得好用的同学请右上角随手star 一下，谢谢！

同时将retorfit 与 rx2 进行封装 提供自带progress 的Resumer
如果需要实现这种数据处理只需要重写消费者使用泛型写，这个项目里暂时不加上这个
{
  "Data": [
    {
      "ParkId": 1,
      "ParkName": "sample string 2",
      "ParkCode": "sample string 3"
    },
    null
  ],
  "Code": 0,
  "Message": "sample string 1",
  "Success": true
}

代码示例：
自带进度加载圈
  ApiClient.getApiService(ApiService.MainService.class)
                .getInfo("北京")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ProgressSubscriber<>(mView.getContext(), new SubscriberOnNextListener<String>() {
                    @Override
                    public void onNext(String s) {

                    }
                }));
不带进度加载圈
 ApiClient.getApiService(ApiService.MainService.class)
                .getInfo("北京")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ComSubscriber<>(mView.getContext(), new SubscriberOnNextListener<String>() {
                    @Override
                    public void onNext(String s) {

                    }
                },null));
  统一异常处理
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
