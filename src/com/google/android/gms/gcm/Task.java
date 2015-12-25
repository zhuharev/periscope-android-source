// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.gcm:
//            zzc, GcmNetworkManager

public abstract class Task
    implements Parcelable
{
    public static abstract class Builder
    {

        protected Bundle extras;
        protected String gcmTaskService;
        protected boolean isPersisted;
        protected int requiredNetworkState;
        protected boolean requiresCharging;
        protected String tag;
        protected boolean updateCurrent;
        protected zzc zzaCT;

        public abstract Task build();

        protected void checkConditions()
        {
            boolean flag;
            if (gcmTaskService != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                throw new IllegalArgumentException(String.valueOf("Must provide an endpoint for this task by calling setService(ComponentName)."));
            }
            GcmNetworkManager.zzdh(tag);
            Task.zza(zzaCT);
            if (isPersisted)
            {
                Task.zzA(extras);
            }
        }

        public abstract Builder setExtras(Bundle bundle);

        public abstract Builder setPersisted(boolean flag);

        public abstract Builder setRequiredNetwork(int i);

        public abstract Builder setRequiresCharging(boolean flag);

        public abstract Builder setService(Class class1);

        public abstract Builder setTag(String s);

        public abstract Builder setUpdateCurrent(boolean flag);

        public Builder()
        {
            zzaCT = zzc.zzaCI;
        }
    }


    public static final int EXTRAS_LIMIT_BYTES = 10240;
    public static final int NETWORK_STATE_ANY = 2;
    public static final int NETWORK_STATE_CONNECTED = 0;
    public static final int NETWORK_STATE_UNMETERED = 1;
    protected static final long UNINITIALIZED = -1L;
    private final Bundle mExtras;
    private final String mTag;
    private final String zzaCN;
    private final boolean zzaCO;
    private final boolean zzaCP;
    private final int zzaCQ;
    private final boolean zzaCR;
    private final zzc zzaCS;

    Task(Parcel parcel)
    {
        Log.e("Task", "Constructing a Task object using a parcel.");
        zzaCN = parcel.readString();
        mTag = parcel.readString();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzaCO = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzaCP = flag;
        zzaCQ = 2;
        zzaCR = false;
        zzaCS = zzc.zzaCI;
        mExtras = null;
    }

    Task(Builder builder)
    {
        zzaCN = builder.gcmTaskService;
        mTag = builder.tag;
        zzaCO = builder.updateCurrent;
        zzaCP = builder.isPersisted;
        zzaCQ = builder.requiredNetworkState;
        zzaCR = builder.requiresCharging;
        zzaCS = builder.zzaCT;
        mExtras = builder.extras;
    }

    public static void zzA(Bundle bundle)
    {
label0:
        {
            if (bundle == null)
            {
                break label0;
            }
            Object obj = Parcel.obtain();
            bundle.writeToParcel(((Parcel) (obj)), 0);
            int i = ((Parcel) (obj)).dataSize();
            if (i > 10240)
            {
                ((Parcel) (obj)).recycle();
                throw new IllegalArgumentException((new StringBuilder("Extras exceeding maximum size(10240 bytes): ")).append(i).toString());
            }
            ((Parcel) (obj)).recycle();
            obj = bundle.keySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (zzz(bundle.get((String)((Iterator) (obj)).next())));
            throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
        }
    }

    public static void zza(zzc zzc1)
    {
        if (zzc1 != null)
        {
            int i = zzc1.zzvZ();
            if (i != 1 && i != 0)
            {
                throw new IllegalArgumentException((new StringBuilder("Must provide a valid RetryPolicy: ")).append(i).toString());
            }
            int j = zzc1.zzwa();
            int k = zzc1.zzwb();
            if (i == 0 && j < 0)
            {
                throw new IllegalArgumentException((new StringBuilder("InitialBackoffSeconds can't be negative: ")).append(j).toString());
            }
            if (i == 1 && j < 10)
            {
                throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
            }
            if (k < j)
            {
                throw new IllegalArgumentException((new StringBuilder("MaximumBackoffSeconds must be greater than InitialBackoffSeconds: ")).append(zzc1.zzwb()).toString());
            }
        }
    }

    private static boolean zzz(Object obj)
    {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean);
    }

    public int describeContents()
    {
        return 0;
    }

    public Bundle getExtras()
    {
        return mExtras;
    }

    public int getRequiredNetwork()
    {
        return zzaCQ;
    }

    public boolean getRequiresCharging()
    {
        return zzaCR;
    }

    public String getServiceName()
    {
        return zzaCN;
    }

    public String getTag()
    {
        return mTag;
    }

    public boolean isPersisted()
    {
        return zzaCP;
    }

    public boolean isUpdateCurrent()
    {
        return zzaCO;
    }

    public void toBundle(Bundle bundle)
    {
        bundle.putString("tag", mTag);
        bundle.putBoolean("update_current", zzaCO);
        bundle.putBoolean("persisted", zzaCP);
        bundle.putString("service", zzaCN);
        bundle.putInt("requiredNetwork", zzaCQ);
        bundle.putBoolean("requiresCharging", zzaCR);
        bundle.putBundle("retryStrategy", zzaCS.zzz(new Bundle()));
        bundle.putBundle("extras", mExtras);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(zzaCN);
        parcel.writeString(mTag);
        if (zzaCO)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (zzaCP)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }
}
