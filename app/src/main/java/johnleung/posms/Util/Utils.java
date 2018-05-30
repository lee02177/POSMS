package johnleung.posms.Util;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.widget.EditText;

import java.math.BigDecimal;

import johnleung.posms.ProductDetailsActivity;
import johnleung.posms.bean.OrderBean;
import johnleung.posms.bean.ProductBean;
import johnleung.posms.db.TestData;

public class Utils {

    public static void popAlertDialog(Context context, String title, String message)
    {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        do nothing
                    }
                })
                .show();
    }

    public static void popOrderDialog(final Context context, final ProductBean aProduct)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Qty:");

        // Set up the input
        final EditText input = new EditText(context);

        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                BigDecimal qty = new BigDecimal(input.getText().toString());
                TestData.myOrders.add(new OrderBean(aProduct, qty.intValue()));
                Utils.popAlertDialog(context, "Success", aProduct.getProd_nm() + " ordered!");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
