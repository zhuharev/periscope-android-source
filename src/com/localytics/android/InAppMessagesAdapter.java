// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.localytics.android:
//            MarketingMessage, InAppManager

final class InAppMessagesAdapter extends BaseAdapter
{

    private final Context mContext;
    private InAppManager mInAppManager;
    private final List mInAppMessages = new ArrayList();

    InAppMessagesAdapter(Context context, InAppManager inappmanager)
    {
        mContext = context;
        mInAppManager = inappmanager;
    }

    public final int getCount()
    {
        return mInAppMessages.size();
    }

    public final volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public final Map getItem(int i)
    {
        return (Map)mInAppMessages.get(i);
    }

    public final long getItemId(int i)
    {
        return (long)((Integer)((MarketingMessage)mInAppMessages.get(i)).get("campaign_id")).intValue();
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = new LinearLayout(mContext);
            viewgroup.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
            viewgroup.setOrientation(0);
            view = new LinearLayout(mContext);
            view.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
            view.setGravity(16);
            view.setOrientation(1);
            int j = (int)(mContext.getResources().getDisplayMetrics().density * 8F + 0.5F);
            view.setPadding(j << 1, j, j << 1, j);
            viewgroup.addView(view);
            TextView textview = new TextView(mContext);
            textview.setId(1);
            textview.setTextSize(16F);
            textview.setTextColor(0xff000000);
            TextView textview2 = new TextView(mContext);
            textview2.setId(2);
            textview2.setTextSize(24F);
            textview2.setTextColor(0xff000000);
            view.addView(textview2);
            view.addView(textview);
        }
        view = (TextView)viewgroup.findViewById(1);
        TextView textview1 = (TextView)viewgroup.findViewById(2);
        view.setText(String.format("Campaign ID: %d", new Object[] {
            Long.valueOf(getItemId(i))
        }));
        textview1.setText((String)getItem(i).get("rule_name_non_unique"));
        return viewgroup;
    }

    final boolean updateDataSet()
    {
        Exception exception;
        mInAppMessages.clear();
        final FutureTask fTask = new FutureTask(new _cls1());
        (new _cls2()).start();
        boolean flag;
        try
        {
            flag = ((Boolean)fTask.get()).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            return false;
        }
        return flag;
    }



    private class _cls1
        implements Callable
    {

        final InAppMessagesAdapter this$0;

        public Boolean call()
        {
            boolean flag = false;
            MarketingMessage marketingmessage;
            for (Iterator iterator = mInAppManager.getInAppMessages().iterator(); iterator.hasNext(); mInAppMessages.add(marketingmessage))
            {
                marketingmessage = (MarketingMessage)iterator.next();
                flag = true;
            }

            return Boolean.valueOf(flag);
        }

        public volatile Object call()
        {
            return call();
        }

        _cls1()
        {
            this$0 = InAppMessagesAdapter.this;
            super();
        }
    }


    private class _cls2 extends Thread
    {

        final InAppMessagesAdapter this$0;
        final FutureTask val$fTask;

        public void run()
        {
            try
            {
                fTask.run();
                return;
            }
            catch (Exception exception)
            {
                Localytics.Log.w("Caught an exception", exception);
            }
        }

        _cls2()
        {
            this$0 = InAppMessagesAdapter.this;
            fTask = futuretask;
            super();
        }
    }

}
