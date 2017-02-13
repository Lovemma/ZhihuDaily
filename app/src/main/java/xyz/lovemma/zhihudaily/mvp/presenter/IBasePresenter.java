package xyz.lovemma.zhihudaily.mvp.presenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by OO on 2017/2/13.
 */

public class IBasePresenter {
    private CompositeSubscription mCompositeSubscription;

    protected void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }

    public void unsubcrible() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }
}
