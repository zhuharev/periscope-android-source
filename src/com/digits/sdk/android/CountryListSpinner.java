// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;
import o.rz;

// Referenced classes of package com.digits.sdk.android:
//            CountryListAdapter, CountryListLoadTask, Digits, CountryInfo

public class CountryListSpinner extends TextView
    implements android.view.View.OnClickListener, CountryListLoadTask.Listener
{
    public class DialogPopup
        implements android.content.DialogInterface.OnClickListener
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
            selectedCountryName = ((CountryInfo) (dialoginterface)).country;
            setSpinnerText(((CountryInfo) (dialoginterface)).countryCode, ((CountryInfo) (dialoginterface)).country);
            dismiss();
        }

        public void show(final int selected)
        {
            if (listAdapter == null)
            {
                return;
            } else
            {
                dialog = (new android.app.AlertDialog.Builder(getContext())).setSingleChoiceItems(listAdapter, 0, this).create();
                dialog.setCanceledOnTouchOutside(true);
                final ListView listView = dialog.getListView();
                listView.setFastScrollEnabled(true);
                class _cls1
                    implements Runnable
                {

                    final DialogPopup this$1;
                    final ListView val$listView;
                    final int val$selected;

                    public void run()
                    {
                        listView.setSelection(selected);
                    }

                _cls1()
                {
                    this$1 = DialogPopup.this;
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

        DialogPopup(CountryListAdapter countrylistadapter)
        {
            this$0 = CountryListSpinner.this;
            super();
            listAdapter = countrylistadapter;
        }
    }


    private CountryListAdapter countryListAdapter;
    private DialogPopup dialogPopup;
    private android.view.View.OnClickListener listener;
    private String selectedCountryName;
    private String textFormat;

    public CountryListSpinner(Context context)
    {
        this(context, null, 0x1010081);
    }

    public CountryListSpinner(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010081);
    }

    public CountryListSpinner(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void executeUserClickListener(View view)
    {
        if (listener != null)
        {
            listener.onClick(view);
        }
    }

    private void init()
    {
        super.setOnClickListener(this);
        countryListAdapter = new CountryListAdapter(getContext());
        dialogPopup = new DialogPopup(countryListAdapter);
        textFormat = getResources().getString(R.string.dgts__country_spinner_format);
        selectedCountryName = "";
        setSpinnerText(1, Locale.US.getDisplayCountry());
    }

    private void loadCountryList()
    {
        (new CountryListLoadTask(this)).executeOnExecutor(Digits.getInstance().getExecutorService(), new Void[0]);
    }

    private void setSpinnerText(int i, String s)
    {
        setText(String.format(textFormat, new Object[] {
            s, Integer.valueOf(i)
        }));
        setTag(Integer.valueOf(i));
    }

    public void onClick(View view)
    {
        if (countryListAdapter.getCount() == 0)
        {
            loadCountryList();
        } else
        {
            dialogPopup.show(countryListAdapter.getPositionForCountry(selectedCountryName));
        }
        rz._mth02CA(getContext(), this);
        executeUserClickListener(view);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (dialogPopup.isShowing())
        {
            dialogPopup.dismiss();
        }
    }

    public void onLoadComplete(List list)
    {
        countryListAdapter.setData(list);
        dialogPopup.show(countryListAdapter.getPositionForCountry(selectedCountryName));
    }

    void setDialogPopup(DialogPopup dialogpopup)
    {
        dialogPopup = dialogpopup;
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        listener = onclicklistener;
    }

    public void setSelectedForCountry(String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            selectedCountryName = s;
            setSpinnerText(Integer.valueOf(s1).intValue(), s);
        }
    }


/*
    static String access$002(CountryListSpinner countrylistspinner, String s)
    {
        countrylistspinner.selectedCountryName = s;
        return s;
    }

*/

}
