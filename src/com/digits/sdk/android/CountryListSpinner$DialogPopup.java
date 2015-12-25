// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ListView;

// Referenced classes of package com.digits.sdk.android:
//            CountryListSpinner, CountryListAdapter, CountryInfo

public class listAdapter
    implements android.content.
{

    private static final long DELAY_MILLIS = 10L;
    private AlertDialog dialog;
    private final CountryListAdapter listAdapter;
    final CountryListSpinner this$0;

    public void dismiss()
    {
        if (dialog != null)
        {
            dialog.dismiss();
            dialog = null;
        }
    }

    public boolean isShowing()
    {
        return dialog != null && dialog.isShowing();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = (CountryInfo)listAdapter.getItem(i);
        CountryListSpinner.access$002(CountryListSpinner.this, ((CountryInfo) (dialoginterface)).country);
        CountryListSpinner.access$100(CountryListSpinner.this, ((CountryInfo) (dialoginterface)).countryCode, ((CountryInfo) (dialoginterface)).country);
        dismiss();
    }

    public void show(final int selected)
    {
        if (listAdapter == null)
        {
            return;
        } else
        {
            dialog = (new android.app.ialogPopup.dialog(getContext())).oiceItems(listAdapter, 0, this).ener();
            dialog.setCanceledOnTouchOutside(true);
            final ListView listView = dialog.getListView();
            listView.setFastScrollEnabled(true);
            class _cls1
                implements Runnable
            {

                final CountryListSpinner.DialogPopup this$1;
                final ListView val$listView;
                final int val$selected;

                public void run()
                {
                    listView.setSelection(selected);
                }

            _cls1()
            {
                this$1 = CountryListSpinner.DialogPopup.this;
                listView = listview;
                selected = i;
                super();
            }
            }

            listView.postDelayed(new _cls1(), 10L);
            dialog.show();
            return;
        }
    }

    _cls1(CountryListAdapter countrylistadapter)
    {
        this$0 = CountryListSpinner.this;
        super();
        listAdapter = countrylistadapter;
    }
}
