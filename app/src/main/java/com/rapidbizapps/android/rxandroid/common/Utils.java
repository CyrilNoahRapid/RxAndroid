package com.rapidbizapps.android.rxandroid.common;

import android.content.Context;
import android.widget.ProgressBar;

import com.rapidbizapps.android.rxandroid.R;
import com.rba.ui.dialog.MaterialDialog;
import com.rba.ui.dialog.Theme;


/**
 * Utils contains all the required common methods.
 */
public class Utils {
    private final String TAG = Utils.class.getSimpleName();

    private MaterialDialog ringProgressDialog = null;

    /**
     * Method to show progress dialog on the screen.
     *
     * @param ctx Context.
     */
    public void showProgressDialog(final Context ctx) {
        if (ringProgressDialog == null) {
            ringProgressDialog = new MaterialDialog.Builder(ctx)
                    .title(ctx.getResources().getString(R.string.app_name))
                    .content("Please wait.... ")
                    .progress(true, 0)
                    .theme(Theme.LIGHT)
                    .cancelable(false)
                    .show();
            ringProgressDialog.setOnShowListener(dialog -> {
                try {
                    ProgressBar v = (ProgressBar) ringProgressDialog.findViewById(android.R.id.progress);
                    v.getIndeterminateDrawable().setColorFilter(ctx.getResources().getColor(R.color.colorAccent),
                            android.graphics.PorterDuff.Mode.MULTIPLY);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * Method to show progress dialog with a message, on the screen.
     *
     * @param ctx Context.
     * @param msg Message to be shown.
     */
    public void showProgressDialog(final Context ctx, String msg) {
        if (ringProgressDialog == null) {
            ringProgressDialog = new MaterialDialog.Builder(ctx)
                    //  .title(ctx.getResources().getString(R.string.app_name))
                    .content(msg)
                    .progress(true, 0)
                    .theme(Theme.LIGHT)
                    .cancelable(false)
                    .show();
            ringProgressDialog.setOnShowListener(dialog -> {
                try {
                    ProgressBar v = (ProgressBar) ringProgressDialog.findViewById(android.R.id.progress);
                    v.getIndeterminateDrawable().setColorFilter(ctx.getResources().getColor(R.color.colorAccent),
                            android.graphics.PorterDuff.Mode.MULTIPLY);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * Method to dismiss the progress dialog, if it's currently displayed on the screen.
     */
    public void dismissDialog() {
        if (ringProgressDialog != null) {
            if (ringProgressDialog.isShowing()) {
                ringProgressDialog.dismiss();
                ringProgressDialog = null;
            }
        }
    }

    /**
     * Two button alert dialog.
     *
     * @param ctx      Context.
     * @param title    Title of the dialog.
     * @param message  Message to be shown to the user.
     * @param okCancel Boolean to display Ok/Cancel or Yes/No on buttons respectively.
     * @param cb       Callback for the dialog.
     */
    public void twoButtonAlertDialog(Context ctx, String title, String message, boolean okCancel, final MaterialDialog.ButtonCallback cb) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(ctx);
        builder.theme(Theme.LIGHT);
        if (title != null) {
            //  builder.title(title);
        }
        builder.content(message);

        if (okCancel) {
            builder.negativeText(android.R.string.cancel);
            builder.positiveText(android.R.string.ok);
        } else {
            builder.negativeText("No");
            builder.positiveText("Yes");
        }

        builder.positiveColorRes(R.color.colorAccent);
        builder.negativeColorRes(R.color.colorAccent);
        builder.callback(cb);
        builder.cancelable(false);
        builder.show();

    }

    /**
     * Single button alert dialog.
     *
     * @param ctx     Context.
     * @param title   Title of the dialog.
     * @param message Message to be shown to the user.
     */
    public void singleButtonAlertDialog(Context ctx, String title, String message) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(ctx);
        builder.theme(Theme.LIGHT);
        if (title != null) {
            //  builder.title(title);
        }
        builder.content(message);

        builder.positiveText("Ok");

        builder.positiveColorRes(R.color.colorAccent);
        builder.negativeColorRes(R.color.colorAccent);
        builder.cancelable(false);
        builder.show();

    }

    /**
     * Single button alert dialog with custom callback.
     *
     * @param ctx     Context.
     * @param title   Title of the dialog.
     * @param message Message to be shown to the user.
     * @param cb      Callback for the dialog.
     */
    public void singleButtonAlertDialog(Context ctx, String title, String message, final MaterialDialog.ButtonCallback cb) {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(ctx);
        builder.theme(Theme.LIGHT);
        if (title != null) {
            // builder.title(title);
        }
        builder.content(message);

        builder.positiveText("Ok");
        if (message.contains("Are you sure"))
            builder.negativeText("Cancel");
        builder.positiveColorRes(R.color.colorAccent);
        builder.negativeColorRes(R.color.colorAccent);
        builder.callback(cb);
        builder.cancelable(false);
        builder.show();

    }
}
