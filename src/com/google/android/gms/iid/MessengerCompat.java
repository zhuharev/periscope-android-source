// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import o.bl;
import o.bn;
import o.bo;

public class MessengerCompat
    implements Parcelable
{
    final class if extends o.bo.if
    {

        private Handler handler;
        private MessengerCompat zU;

        public final void send(Message message)
        {
            message.arg2 = Binder.getCallingUid();
            handler.dispatchMessage(message);
        }

        if(Handler handler1)
        {
            zU = MessengerCompat.this;
            super();
            handler = handler1;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new bn();
    public Messenger zS;
    public bo zT;

    public MessengerCompat(IBinder ibinder)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            zS = new Messenger(ibinder);
            return;
        } else
        {
            zT = o.bo.if._mth02BB(ibinder);
            return;
        }
    }

    public MessengerCompat(bl bl)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            zS = new Messenger(bl);
            return;
        } else
        {
            zT = new if(bl);
            return;
        }
    }

    public static int _mth02CB(Message message)
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return message.sendingUid;
        } else
        {
            return message.arg2;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        IBinder ibinder;
        boolean flag;
        try
        {
            if (zS != null)
            {
                ibinder = zS.getBinder();
                break MISSING_BLOCK_LABEL_34;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return false;
        }
        ibinder = zT.asBinder();
        obj = (MessengerCompat)obj;
        if (((MessengerCompat) (obj)).zS != null)
        {
            obj = ((MessengerCompat) (obj)).zS.getBinder();
            break MISSING_BLOCK_LABEL_67;
        }
        obj = ((MessengerCompat) (obj)).zT.asBinder();
        flag = ibinder.equals(obj);
        return flag;
    }

    public int hashCode()
    {
        IBinder ibinder;
        if (zS != null)
        {
            ibinder = zS.getBinder();
        } else
        {
            ibinder = zT.asBinder();
        }
        return ibinder.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (zS != null)
        {
            parcel.writeStrongBinder(zS.getBinder());
            return;
        } else
        {
            parcel.writeStrongBinder(zT.asBinder());
            return;
        }
    }

}
