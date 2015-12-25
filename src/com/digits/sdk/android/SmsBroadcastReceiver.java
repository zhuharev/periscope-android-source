// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.EditText;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsBroadcastReceiver extends BroadcastReceiver
{

    static final String PDU_EXTRA = "pdus";
    final WeakReference editTextWeakReference;
    final Pattern patternConfirmationCode = Pattern.compile(":\\s(\\d{6}).*Digits by Twitter");

    SmsBroadcastReceiver(EditText edittext)
    {
        editTextWeakReference = new WeakReference(edittext);
    }

    String getConfirmationCode(SmsMessage smsmessage)
    {
        smsmessage = smsmessage.getDisplayMessageBody();
        if (smsmessage != null)
        {
            smsmessage = patternConfirmationCode.matcher(smsmessage);
            if (smsmessage.find())
            {
                return smsmessage.group(1);
            }
        }
        return null;
    }

    String getConfirmationCode(SmsMessage asmsmessage[])
    {
        int j = asmsmessage.length;
        for (int i = 0; i < j; i++)
        {
            String s = getConfirmationCode(asmsmessage[i]);
            if (s != null)
            {
                return s;
            }
        }

        return null;
    }

    SmsMessage[] getMessagesFromIntent(Intent intent)
    {
        intent = ((Intent) ((Object[])intent.getSerializableExtra("pdus")));
        int j = intent.length;
        SmsMessage asmsmessage[] = new SmsMessage[j];
        for (int i = 0; i < j; i++)
        {
            asmsmessage[i] = SmsMessage.createFromPdu((byte[])intent[i]);
        }

        return asmsmessage;
    }

    public void onReceive(Context context, Intent intent)
    {
        context = getConfirmationCode(getMessagesFromIntent(intent));
        if (context != null)
        {
            intent = (EditText)editTextWeakReference.get();
            if (intent != null)
            {
                intent.setText(context);
                intent.setSelection(context.length());
            }
        }
    }
}
