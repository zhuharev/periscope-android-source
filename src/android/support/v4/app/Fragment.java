// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import o.02B3;
import o.02C8;
import o.02C9;
import o.0406;
import o.0640;
import o.1427;
import o.1428;
import o.1508;
import o.1551;
import o.15EE;
import o.FF70;
import o.con;

public class Fragment
    implements ComponentCallbacks, android.view.View.OnCreateContextMenuListener
{
    public static class SavedState
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new _cls02C8();
        final Bundle _fld1D63;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeBundle(_fld1D63);
        }


        public SavedState(Parcel parcel, ClassLoader classloader)
        {
            _fld1D63 = parcel.readBundle();
        }
    }

    public static class if extends RuntimeException
    {

        public if(RemoteException remoteexception)
        {
            super(remoteexception);
        }

        public if(String s)
        {
            super(s);
        }

        public if(String s, Parcel parcel)
        {
            super((new StringBuilder()).append(s).append(" Parcel: pos=").append(parcel.dataPosition()).append(" size=").append(parcel.dataSize()).toString());
        }

        public if(String s, ReflectiveOperationException reflectiveoperationexception)
        {
            super(s, reflectiveoperationexception);
        }
    }


    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    private static final _cls1551 sClassMap = new _cls1551();
    public boolean mAdded;
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    public View mAnimatingAway;
    Bundle mArguments;
    public int mBackStackNesting;
    public boolean mCalled;
    boolean mCheckedForLoaderManager;
    public _cls1428 mChildFragmentManager;
    public ViewGroup mContainer;
    public int mContainerId;
    public boolean mDeferStart;
    public boolean mDetached;
    Object mEnterTransition;
    public _cls1508 mEnterTransitionCallback;
    Object mExitTransition;
    _cls1508 mExitTransitionCallback;
    public int mFragmentId;
    public _cls1428 mFragmentManager;
    public boolean mFromLayout;
    public boolean mHasMenu;
    public boolean mHidden;
    public _cls0640 mHost;
    public boolean mInLayout;
    public int mIndex;
    public View mInnerView;
    public _cls02B3 mLoaderManager;
    boolean mLoadersStarted;
    public boolean mMenuVisible;
    public int mNextAnim;
    public Fragment mParentFragment;
    Object mReenterTransition;
    public boolean mRemoving;
    public boolean mRestored;
    public boolean mResumed;
    public boolean mRetainInstance;
    public boolean mRetaining;
    Object mReturnTransition;
    public Bundle mSavedFragmentState;
    public SparseArray mSavedViewState;
    Object mSharedElementEnterTransition;
    Object mSharedElementReturnTransition;
    public int mState;
    public int mStateAfterAnimating;
    public String mTag;
    public Fragment mTarget;
    public int mTargetIndex;
    public int mTargetRequestCode;
    public boolean mUserVisibleHint;
    public View mView;
    public String mWho;

    public Fragment()
    {
        mState = 0;
        mIndex = -1;
        mTargetIndex = -1;
        mMenuVisible = true;
        mUserVisibleHint = true;
        mEnterTransition = null;
        mReturnTransition = USE_DEFAULT_TRANSITION;
        mExitTransition = null;
        mReenterTransition = USE_DEFAULT_TRANSITION;
        mSharedElementEnterTransition = null;
        mSharedElementReturnTransition = USE_DEFAULT_TRANSITION;
        mEnterTransitionCallback = null;
        mExitTransitionCallback = null;
    }

    public static Fragment instantiate(Context context, String s)
    {
        return instantiate(context, s, null);
    }

    public static Fragment instantiate(Context context, String s, Bundle bundle)
    {
        Class class1;
        Class class2;
        try
        {
            class2 = (Class)sClassMap.get(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new if((new StringBuilder("Unable to instantiate fragment ")).append(s).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new if((new StringBuilder("Unable to instantiate fragment ")).append(s).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new if((new StringBuilder("Unable to instantiate fragment ")).append(s).append(": make sure class name exists, is public, and has an empty constructor that is public").toString(), context);
        }
        class1 = class2;
        if (class2 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        class1 = context.getClassLoader().loadClass(s);
        sClassMap.put(s, class1);
        context = (Fragment)class1.newInstance();
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        bundle.setClassLoader(context.getClass().getClassLoader());
        context.mArguments = bundle;
        return context;
    }

    public static boolean isSupportFragmentClass(Context context, String s)
    {
        Class class1;
        Class class2;
        boolean flag;
        try
        {
            class2 = (Class)sClassMap.get(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        class1 = class2;
        if (class2 != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        class1 = context.getClassLoader().loadClass(s);
        sClassMap.put(s, class1);
        flag = android/support/v4/app/Fragment.isAssignableFrom(class1);
        return flag;
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s);
        printwriter.print("mFragmentId=#");
        printwriter.print(Integer.toHexString(mFragmentId));
        printwriter.print(" mContainerId=#");
        printwriter.print(Integer.toHexString(mContainerId));
        printwriter.print(" mTag=");
        printwriter.println(mTag);
        printwriter.print(s);
        printwriter.print("mState=");
        printwriter.print(mState);
        printwriter.print(" mIndex=");
        printwriter.print(mIndex);
        printwriter.print(" mWho=");
        printwriter.print(mWho);
        printwriter.print(" mBackStackNesting=");
        printwriter.println(mBackStackNesting);
        printwriter.print(s);
        printwriter.print("mAdded=");
        printwriter.print(mAdded);
        printwriter.print(" mRemoving=");
        printwriter.print(mRemoving);
        printwriter.print(" mResumed=");
        printwriter.print(mResumed);
        printwriter.print(" mFromLayout=");
        printwriter.print(mFromLayout);
        printwriter.print(" mInLayout=");
        printwriter.println(mInLayout);
        printwriter.print(s);
        printwriter.print("mHidden=");
        printwriter.print(mHidden);
        printwriter.print(" mDetached=");
        printwriter.print(mDetached);
        printwriter.print(" mMenuVisible=");
        printwriter.print(mMenuVisible);
        printwriter.print(" mHasMenu=");
        printwriter.println(mHasMenu);
        printwriter.print(s);
        printwriter.print("mRetainInstance=");
        printwriter.print(mRetainInstance);
        printwriter.print(" mRetaining=");
        printwriter.print(mRetaining);
        printwriter.print(" mUserVisibleHint=");
        printwriter.println(mUserVisibleHint);
        if (mFragmentManager != null)
        {
            printwriter.print(s);
            printwriter.print("mFragmentManager=");
            printwriter.println(mFragmentManager);
        }
        if (mHost != null)
        {
            printwriter.print(s);
            printwriter.print("mHost=");
            printwriter.println(mHost);
        }
        if (mParentFragment != null)
        {
            printwriter.print(s);
            printwriter.print("mParentFragment=");
            printwriter.println(mParentFragment);
        }
        if (mArguments != null)
        {
            printwriter.print(s);
            printwriter.print("mArguments=");
            printwriter.println(mArguments);
        }
        if (mSavedFragmentState != null)
        {
            printwriter.print(s);
            printwriter.print("mSavedFragmentState=");
            printwriter.println(mSavedFragmentState);
        }
        if (mSavedViewState != null)
        {
            printwriter.print(s);
            printwriter.print("mSavedViewState=");
            printwriter.println(mSavedViewState);
        }
        if (mTarget != null)
        {
            printwriter.print(s);
            printwriter.print("mTarget=");
            printwriter.print(mTarget);
            printwriter.print(" mTargetRequestCode=");
            printwriter.println(mTargetRequestCode);
        }
        if (mNextAnim != 0)
        {
            printwriter.print(s);
            printwriter.print("mNextAnim=");
            printwriter.println(mNextAnim);
        }
        if (mContainer != null)
        {
            printwriter.print(s);
            printwriter.print("mContainer=");
            printwriter.println(mContainer);
        }
        if (mView != null)
        {
            printwriter.print(s);
            printwriter.print("mView=");
            printwriter.println(mView);
        }
        if (mInnerView != null)
        {
            printwriter.print(s);
            printwriter.print("mInnerView=");
            printwriter.println(mView);
        }
        if (mAnimatingAway != null)
        {
            printwriter.print(s);
            printwriter.print("mAnimatingAway=");
            printwriter.println(mAnimatingAway);
            printwriter.print(s);
            printwriter.print("mStateAfterAnimating=");
            printwriter.println(mStateAfterAnimating);
        }
        if (mLoaderManager != null)
        {
            printwriter.print(s);
            printwriter.println("Loader Manager:");
            mLoaderManager.dump((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
        if (mChildFragmentManager != null)
        {
            printwriter.print(s);
            printwriter.println((new StringBuilder("Child ")).append(mChildFragmentManager).append(":").toString());
            mChildFragmentManager.dump((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
    }

    public final boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    Fragment findFragmentByWho(String s)
    {
        if (s.equals(mWho))
        {
            return this;
        }
        if (mChildFragmentManager != null)
        {
            _cls1428 _lcls1428 = mChildFragmentManager;
            if (_lcls1428._fld1D40 != null && s != null)
            {
                for (int i = _lcls1428._fld1D40.size() - 1; i >= 0; i--)
                {
                    Fragment fragment = (Fragment)_lcls1428._fld1D40.get(i);
                    if (fragment == null)
                    {
                        continue;
                    }
                    fragment = fragment.findFragmentByWho(s);
                    if (fragment != null)
                    {
                        return fragment;
                    }
                }

            }
            return null;
        } else
        {
            return null;
        }
    }

    public final _cls02C9 getActivity()
    {
        if (mHost == null)
        {
            return null;
        } else
        {
            return (_cls02C9)mHost.mActivity;
        }
    }

    public boolean getAllowEnterTransitionOverlap()
    {
        if (mAllowEnterTransitionOverlap == null)
        {
            return true;
        } else
        {
            return mAllowEnterTransitionOverlap.booleanValue();
        }
    }

    public boolean getAllowReturnTransitionOverlap()
    {
        if (mAllowReturnTransitionOverlap == null)
        {
            return true;
        } else
        {
            return mAllowReturnTransitionOverlap.booleanValue();
        }
    }

    public final Bundle getArguments()
    {
        return mArguments;
    }

    public final _cls1427 getChildFragmentManager()
    {
        if (mChildFragmentManager == null)
        {
            instantiateChildFragmentManager();
            if (mState >= 5)
            {
                _cls1428 _lcls1428 = mChildFragmentManager;
                _lcls1428._fld13A5 = false;
                _lcls1428._mth02CA(5, 0, 0, false);
            } else
            if (mState >= 4)
            {
                _cls1428 _lcls1428_1 = mChildFragmentManager;
                _lcls1428_1._fld13A5 = false;
                _lcls1428_1._mth02CA(4, 0, 0, false);
            } else
            if (mState >= 2)
            {
                _cls1428 _lcls1428_2 = mChildFragmentManager;
                _lcls1428_2._fld13A5 = false;
                _lcls1428_2._mth02CA(2, 0, 0, false);
            } else
            if (mState > 0)
            {
                _cls1428 _lcls1428_3 = mChildFragmentManager;
                _lcls1428_3._fld13A5 = false;
                _lcls1428_3._mth02CA(1, 0, 0, false);
            }
        }
        return mChildFragmentManager;
    }

    public Context getContext()
    {
        if (mHost == null)
        {
            return null;
        } else
        {
            return mHost.mContext;
        }
    }

    public Object getEnterTransition()
    {
        return mEnterTransition;
    }

    public Object getExitTransition()
    {
        return mExitTransition;
    }

    public final _cls1427 getFragmentManager()
    {
        return mFragmentManager;
    }

    public final Object getHost()
    {
        if (mHost == null)
        {
            return null;
        } else
        {
            return mHost._mth02CF();
        }
    }

    public final int getId()
    {
        return mFragmentId;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle)
    {
        bundle = mHost.onGetLayoutInflater();
        getChildFragmentManager();
        _cls0406._mth02CA(bundle, mChildFragmentManager);
        return bundle;
    }

    public FF70 getLoaderManager()
    {
        if (mLoaderManager != null)
        {
            return mLoaderManager;
        }
        if (mHost == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            mCheckedForLoaderManager = true;
            mLoaderManager = mHost._mth02CA(mWho, mLoadersStarted, true);
            return mLoaderManager;
        }
    }

    public final Fragment getParentFragment()
    {
        return mParentFragment;
    }

    public Object getReenterTransition()
    {
        if (mReenterTransition == USE_DEFAULT_TRANSITION)
        {
            return getExitTransition();
        } else
        {
            return mReenterTransition;
        }
    }

    public final Resources getResources()
    {
        if (mHost == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            return mHost.mContext.getResources();
        }
    }

    public final boolean getRetainInstance()
    {
        return mRetainInstance;
    }

    public Object getReturnTransition()
    {
        if (mReturnTransition == USE_DEFAULT_TRANSITION)
        {
            return getEnterTransition();
        } else
        {
            return mReturnTransition;
        }
    }

    public Object getSharedElementEnterTransition()
    {
        return mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition()
    {
        if (mSharedElementReturnTransition == USE_DEFAULT_TRANSITION)
        {
            return getSharedElementEnterTransition();
        } else
        {
            return mSharedElementReturnTransition;
        }
    }

    public final String getString(int i)
    {
        return getResources().getString(i);
    }

    public final transient String getString(int i, Object aobj[])
    {
        return getResources().getString(i, aobj);
    }

    public final String getTag()
    {
        return mTag;
    }

    public final Fragment getTargetFragment()
    {
        return mTarget;
    }

    public final int getTargetRequestCode()
    {
        return mTargetRequestCode;
    }

    public final CharSequence getText(int i)
    {
        return getResources().getText(i);
    }

    public boolean getUserVisibleHint()
    {
        return mUserVisibleHint;
    }

    public View getView()
    {
        return mView;
    }

    public final boolean hasOptionsMenu()
    {
        return mHasMenu;
    }

    public final int hashCode()
    {
        return super.hashCode();
    }

    public void initState()
    {
        mIndex = -1;
        mWho = null;
        mAdded = false;
        mRemoving = false;
        mResumed = false;
        mFromLayout = false;
        mInLayout = false;
        mRestored = false;
        mBackStackNesting = 0;
        mFragmentManager = null;
        mChildFragmentManager = null;
        mHost = null;
        mFragmentId = 0;
        mContainerId = 0;
        mTag = null;
        mHidden = false;
        mDetached = false;
        mRetaining = false;
        mLoaderManager = null;
        mLoadersStarted = false;
        mCheckedForLoaderManager = false;
    }

    void instantiateChildFragmentManager()
    {
        mChildFragmentManager = new _cls1428();
        mChildFragmentManager._mth02CA(mHost, new con(this), this);
    }

    public final boolean isAdded()
    {
        return mHost != null && mAdded;
    }

    public final boolean isDetached()
    {
        return mDetached;
    }

    public final boolean isHidden()
    {
        return mHidden;
    }

    public final boolean isInBackStack()
    {
        return mBackStackNesting > 0;
    }

    public final boolean isInLayout()
    {
        return mInLayout;
    }

    public final boolean isMenuVisible()
    {
        return mMenuVisible;
    }

    public final boolean isRemoving()
    {
        return mRemoving;
    }

    public final boolean isResumed()
    {
        return mResumed;
    }

    public final boolean isVisible()
    {
        return isAdded() && !isHidden() && mView != null && mView.getWindowToken() != null && mView.getVisibility() == 0;
    }

    public void onActivityCreated(Bundle bundle)
    {
        mCalled = true;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
    }

    public void onAttach(Activity activity)
    {
        mCalled = true;
    }

    public void onAttach(Context context)
    {
        mCalled = true;
        if (mHost == null)
        {
            context = null;
        } else
        {
            context = mHost.mActivity;
        }
        if (context != null)
        {
            mCalled = false;
            onAttach(((Activity) (context)));
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        mCalled = true;
    }

    public Animation onCreateAnimation(int i, boolean flag, int j)
    {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        getActivity().onCreateContextMenu(contextmenu, view, contextmenuinfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return null;
    }

    public void onDestroy()
    {
        mCalled = true;
        if (!mCheckedForLoaderManager)
        {
            mCheckedForLoaderManager = true;
            mLoaderManager = mHost._mth02CA(mWho, mLoadersStarted, false);
        }
        if (mLoaderManager != null)
        {
            mLoaderManager._mth1D62();
        }
    }

    public void onDestroyOptionsMenu()
    {
    }

    public void onDestroyView()
    {
        mCalled = true;
    }

    public void onDetach()
    {
        mCalled = true;
    }

    public void onHiddenChanged(boolean flag)
    {
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        mCalled = true;
    }

    public void onInflate(Context context, AttributeSet attributeset, Bundle bundle)
    {
        mCalled = true;
        if (mHost == null)
        {
            context = null;
        } else
        {
            context = mHost.mActivity;
        }
        if (context != null)
        {
            mCalled = false;
            onInflate(((Activity) (context)), attributeset, bundle);
        }
    }

    public void onLowMemory()
    {
        mCalled = true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu)
    {
    }

    public void onPause()
    {
        mCalled = true;
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
    }

    public void onRequestPermissionsResult(int i, String as[], int ai[])
    {
    }

    public void onResume()
    {
        mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
    }

    public void onStart()
    {
        mCalled = true;
        if (!mLoadersStarted)
        {
            mLoadersStarted = true;
            if (!mCheckedForLoaderManager)
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mHost._mth02CA(mWho, mLoadersStarted, false);
            }
            if (mLoaderManager != null)
            {
                mLoaderManager._mth05D9();
            }
        }
    }

    public void onStop()
    {
        mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle)
    {
    }

    public void onViewStateRestored(Bundle bundle)
    {
        mCalled = true;
    }

    public void performActivityCreated(Bundle bundle)
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager._fld13A5 = false;
        }
        mCalled = false;
        onActivityCreated(bundle);
        if (!mCalled)
        {
            throw new _cls15EE((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onActivityCreated()").toString());
        }
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.dispatchActivityCreated();
        }
    }

    public void performConfigurationChanged(Configuration configuration)
    {
        onConfigurationChanged(configuration);
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.dispatchConfigurationChanged(configuration);
        }
    }

    public boolean performContextItemSelected(MenuItem menuitem)
    {
        if (!mHidden)
        {
            if (onContextItemSelected(menuitem))
            {
                return true;
            }
            if (mChildFragmentManager != null && mChildFragmentManager.dispatchContextItemSelected(menuitem))
            {
                return true;
            }
        }
        return false;
    }

    public void performCreate(Bundle bundle)
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager._fld13A5 = false;
        }
        mCalled = false;
        onCreate(bundle);
        if (!mCalled)
        {
            throw new _cls15EE((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onCreate()").toString());
        }
        if (bundle != null)
        {
            bundle = bundle.getParcelable("android:support:fragments");
            if (bundle != null)
            {
                if (mChildFragmentManager == null)
                {
                    instantiateChildFragmentManager();
                }
                mChildFragmentManager.restoreAllState(bundle, null);
                mChildFragmentManager.dispatchCreate();
            }
        }
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        if (!mHidden)
        {
            boolean flag = flag2;
            if (mHasMenu)
            {
                flag = flag2;
                if (mMenuVisible)
                {
                    flag = true;
                    onCreateOptionsMenu(menu, menuinflater);
                }
            }
            flag1 = flag;
            if (mChildFragmentManager != null)
            {
                flag1 = flag | mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuinflater);
            }
        }
        return flag1;
    }

    public View performCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager._fld13A5 = false;
        }
        return onCreateView(layoutinflater, viewgroup, bundle);
    }

    public void performDestroy()
    {
        if (mChildFragmentManager != null)
        {
            _cls1428 _lcls1428 = mChildFragmentManager;
            _lcls1428._fld1424 = true;
            _lcls1428.execPendingActions();
            _lcls1428._mth02CA(0, 0, 0, false);
            _lcls1428.mHost = null;
            _lcls1428._fld02E3 = null;
            _lcls1428._fld05D5 = null;
        }
        mCalled = false;
        onDestroy();
        if (!mCalled)
        {
            throw new _cls15EE((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onDestroy()").toString());
        } else
        {
            return;
        }
    }

    public void performDestroyView()
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager._mth02CA(1, 0, 0, false);
        }
        mCalled = false;
        onDestroyView();
        if (!mCalled)
        {
            throw new _cls15EE((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onDestroyView()").toString());
        }
        if (mLoaderManager != null)
        {
            mLoaderManager._mth1D4E();
        }
    }

    public void performLowMemory()
    {
        onLowMemory();
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.dispatchLowMemory();
        }
    }

    public boolean performOptionsItemSelected(MenuItem menuitem)
    {
        if (!mHidden)
        {
            if (mHasMenu && mMenuVisible && onOptionsItemSelected(menuitem))
            {
                return true;
            }
            if (mChildFragmentManager != null && mChildFragmentManager.dispatchOptionsItemSelected(menuitem))
            {
                return true;
            }
        }
        return false;
    }

    public void performOptionsMenuClosed(Menu menu)
    {
        if (!mHidden)
        {
            if (mHasMenu && mMenuVisible)
            {
                onOptionsMenuClosed(menu);
            }
            if (mChildFragmentManager != null)
            {
                mChildFragmentManager.dispatchOptionsMenuClosed(menu);
            }
        }
    }

    public void performPause()
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager._mth02CA(4, 0, 0, false);
        }
        mCalled = false;
        onPause();
        if (!mCalled)
        {
            throw new _cls15EE((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onPause()").toString());
        } else
        {
            return;
        }
    }

    public boolean performPrepareOptionsMenu(Menu menu)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        if (!mHidden)
        {
            boolean flag = flag2;
            if (mHasMenu)
            {
                flag = flag2;
                if (mMenuVisible)
                {
                    flag = true;
                    onPrepareOptionsMenu(menu);
                }
            }
            flag1 = flag;
            if (mChildFragmentManager != null)
            {
                flag1 = flag | mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
            }
        }
        return flag1;
    }

    public void performReallyStop()
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager._mth02CA(2, 0, 0, false);
        }
        if (mLoadersStarted)
        {
            mLoadersStarted = false;
            if (!mCheckedForLoaderManager)
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mHost._mth02CA(mWho, mLoadersStarted, false);
            }
            if (mLoaderManager != null)
            {
                if (mHost._fld1507)
                {
                    mLoaderManager._mth1D35();
                    return;
                }
                mLoaderManager._mth0674();
            }
        }
    }

    public void performResume()
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager._fld13A5 = false;
            mChildFragmentManager.execPendingActions();
        }
        mCalled = false;
        onResume();
        if (!mCalled)
        {
            throw new _cls15EE((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onResume()").toString());
        }
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.dispatchResume();
            mChildFragmentManager.execPendingActions();
        }
    }

    public void performSaveInstanceState(Bundle bundle)
    {
        onSaveInstanceState(bundle);
        if (mChildFragmentManager != null)
        {
            FragmentManagerState fragmentmanagerstate = mChildFragmentManager._mth02B9();
            if (fragmentmanagerstate != null)
            {
                bundle.putParcelable("android:support:fragments", fragmentmanagerstate);
            }
        }
    }

    public void performStart()
    {
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager._fld13A5 = false;
            mChildFragmentManager.execPendingActions();
        }
        mCalled = false;
        onStart();
        if (!mCalled)
        {
            throw new _cls15EE((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onStart()").toString());
        }
        if (mChildFragmentManager != null)
        {
            mChildFragmentManager.dispatchStart();
        }
        if (mLoaderManager != null)
        {
            mLoaderManager._mth1D54();
        }
    }

    public void performStop()
    {
        if (mChildFragmentManager != null)
        {
            _cls1428 _lcls1428 = mChildFragmentManager;
            _lcls1428._fld13A5 = true;
            _lcls1428._mth02CA(3, 0, 0, false);
        }
        mCalled = false;
        onStop();
        if (!mCalled)
        {
            throw new _cls15EE((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onStop()").toString());
        } else
        {
            return;
        }
    }

    public void registerForContextMenu(View view)
    {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(String as[], int i)
    {
        if (mHost == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            mHost._mth02CA(this, as, i);
            return;
        }
    }

    public final void restoreViewState(Bundle bundle)
    {
        if (mSavedViewState != null)
        {
            mInnerView.restoreHierarchyState(mSavedViewState);
            mSavedViewState = null;
        }
        mCalled = false;
        onViewStateRestored(bundle);
        if (!mCalled)
        {
            throw new _cls15EE((new StringBuilder("Fragment ")).append(this).append(" did not call through to super.onViewStateRestored()").toString());
        } else
        {
            return;
        }
    }

    public void setAllowEnterTransitionOverlap(boolean flag)
    {
        mAllowEnterTransitionOverlap = Boolean.valueOf(flag);
    }

    public void setAllowReturnTransitionOverlap(boolean flag)
    {
        mAllowReturnTransitionOverlap = Boolean.valueOf(flag);
    }

    public void setArguments(Bundle bundle)
    {
        if (mIndex >= 0)
        {
            throw new IllegalStateException("Fragment already active");
        } else
        {
            mArguments = bundle;
            return;
        }
    }

    public void setEnterSharedElementCallback(_cls1508 _pcls1508)
    {
        mEnterTransitionCallback = _pcls1508;
    }

    public void setEnterTransition(Object obj)
    {
        mEnterTransition = obj;
    }

    public void setExitSharedElementCallback(_cls1508 _pcls1508)
    {
        mExitTransitionCallback = _pcls1508;
    }

    public void setExitTransition(Object obj)
    {
        mExitTransition = obj;
    }

    public void setHasOptionsMenu(boolean flag)
    {
        if (mHasMenu != flag)
        {
            mHasMenu = flag;
            if (isAdded() && !isHidden())
            {
                mHost._mth02CE();
            }
        }
    }

    public final void setIndex(int i, Fragment fragment)
    {
        mIndex = i;
        if (fragment != null)
        {
            mWho = (new StringBuilder()).append(fragment.mWho).append(":").append(mIndex).toString();
            return;
        } else
        {
            mWho = (new StringBuilder("android:fragment:")).append(mIndex).toString();
            return;
        }
    }

    public void setInitialSavedState(SavedState savedstate)
    {
        if (mIndex >= 0)
        {
            throw new IllegalStateException("Fragment already active");
        }
        if (savedstate != null && savedstate._fld1D63 != null)
        {
            savedstate = savedstate._fld1D63;
        } else
        {
            savedstate = null;
        }
        mSavedFragmentState = savedstate;
    }

    public void setMenuVisibility(boolean flag)
    {
        if (mMenuVisible != flag)
        {
            mMenuVisible = flag;
            if (mHasMenu && isAdded() && !isHidden())
            {
                mHost._mth02CE();
            }
        }
    }

    public void setReenterTransition(Object obj)
    {
        mReenterTransition = obj;
    }

    public void setRetainInstance(boolean flag)
    {
        if (flag && mParentFragment != null)
        {
            throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
        } else
        {
            mRetainInstance = flag;
            return;
        }
    }

    public void setReturnTransition(Object obj)
    {
        mReturnTransition = obj;
    }

    public void setSharedElementEnterTransition(Object obj)
    {
        mSharedElementEnterTransition = obj;
    }

    public void setSharedElementReturnTransition(Object obj)
    {
        mSharedElementReturnTransition = obj;
    }

    public void setTargetFragment(Fragment fragment, int i)
    {
        mTarget = fragment;
        mTargetRequestCode = i;
    }

    public void setUserVisibleHint(boolean flag)
    {
        if (!mUserVisibleHint && flag && mState < 4)
        {
            mFragmentManager._mth02CA(this);
        }
        mUserVisibleHint = flag;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mDeferStart = flag;
    }

    public boolean shouldShowRequestPermissionRationale(String s)
    {
        if (mHost != null)
        {
            return mHost._mth141D(s);
        } else
        {
            return false;
        }
    }

    public void startActivity(Intent intent)
    {
        if (mHost == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            mHost._mth02CA(this, intent, -1);
            return;
        }
    }

    public void startActivityForResult(Intent intent, int i)
    {
        if (mHost == null)
        {
            throw new IllegalStateException((new StringBuilder("Fragment ")).append(this).append(" not attached to Activity").toString());
        } else
        {
            mHost._mth02CA(this, intent, i);
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        o._cls141D._cls02CA._mth02CA(this, stringbuilder);
        if (mIndex >= 0)
        {
            stringbuilder.append(" #");
            stringbuilder.append(mIndex);
        }
        if (mFragmentId != 0)
        {
            stringbuilder.append(" id=0x");
            stringbuilder.append(Integer.toHexString(mFragmentId));
        }
        if (mTag != null)
        {
            stringbuilder.append(" ");
            stringbuilder.append(mTag);
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public void unregisterForContextMenu(View view)
    {
        view.setOnCreateContextMenuListener(null);
    }

}
