// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.gcm:
//            Task

public class OneoffTask extends Task
{
    public static class Builder extends Task.Builder
    {

        private long zzaCE;
        private long zzaCF;

        static long zza(Builder builder)
        {
            return builder.zzaCE;
        }

        static long zzb(Builder builder)
        {
            return builder.zzaCF;
        }

        public OneoffTask build()
        {
            checkConditions();
            return new OneoffTask(this, null);
        }

        public volatile Task build()
        {
            return build();
        }

        protected void checkConditions()
        {
            super.checkConditions();
            if (zzaCE == -1L || zzaCF == -1L)
            {
                throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
            }
            if (zzaCE >= zzaCF)
            {
                throw new IllegalArgumentException("Window start must be shorter than window end.");
            } else
            {
                return;
            }
        }

        public Builder setExecutionWindow(long l, long l1)
        {
            zzaCE = l;
            zzaCF = l1;
            return this;
        }

        public Builder setExtras(Bundle bundle)
        {
            extras = bundle;
            return this;
        }

        public volatile Task.Builder setExtras(Bundle bundle)
        {
            return setExtras(bundle);
        }

        public Builder setPersisted(boolean flag)
        {
            isPersisted = flag;
            return this;
        }

        public volatile Task.Builder setPersisted(boolean flag)
        {
            return setPersisted(flag);
        }

        public Builder setRequiredNetwork(int i)
        {
            requiredNetworkState = i;
            return this;
        }

        public volatile Task.Builder setRequiredNetwork(int i)
        {
            return setRequiredNetwork(i);
        }

        public Builder setRequiresCharging(boolean flag)
        {
            requiresCharging = flag;
            return this;
        }

        public volatile Task.Builder setRequiresCharging(boolean flag)
        {
            return setRequiresCharging(flag);
        }

        public Builder setService(Class class1)
        {
            gcmTaskService = class1.getName();
            return this;
        }

        public volatile Task.Builder setService(Class class1)
        {
            return setService(class1);
        }

        public Builder setTag(String s)
        {
            tag = s;
            return this;
        }

        public volatile Task.Builder setTag(String s)
        {
            return setTag(s);
        }

        public Builder setUpdateCurrent(boolean flag)
        {
            updateCurrent = flag;
            return this;
        }

        public volatile Task.Builder setUpdateCurrent(boolean flag)
        {
            return setUpdateCurrent(flag);
        }

        public Builder()
        {
            zzaCE = -1L;
            zzaCF = -1L;
            isPersisted = false;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private final long zzaCC;
    private final long zzaCD;

    private OneoffTask(Parcel parcel)
    {
        super(parcel);
        zzaCC = parcel.readLong();
        zzaCD = parcel.readLong();
    }

    OneoffTask(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    private OneoffTask(Builder builder)
    {
        super(builder);
        zzaCC = Builder.zza(builder);
        zzaCD = Builder.zzb(builder);
    }

    OneoffTask(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public long getWindowEnd()
    {
        return zzaCD;
    }

    public long getWindowStart()
    {
        return zzaCC;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putLong("window_start", zzaCC);
        bundle.putLong("window_end", zzaCD);
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(" windowStart=").append(getWindowStart()).append(" windowEnd=").append(getWindowEnd()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeLong(zzaCC);
        parcel.writeLong(zzaCD);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Object createFromParcel(Parcel parcel)
        {
            return zzes(parcel);
        }

        public final Object[] newArray(int i)
        {
            return zzgC(i);
        }

        public final OneoffTask zzes(Parcel parcel)
        {
            return new OneoffTask(parcel, null);
        }

        public final OneoffTask[] zzgC(int i)
        {
            return new OneoffTask[i];
        }

        _cls1()
        {
        }
    }

}
