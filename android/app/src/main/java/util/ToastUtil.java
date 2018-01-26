package util;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.xlbaidumapflutter.MyApplication;

/**
 * @author xz
 */
public class ToastUtil {

    public static void showToast(String string) {
        Toast.makeText(MyApplication.mContext, string, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(String string) {
        Toast.makeText(MyApplication.mContext, string, Toast.LENGTH_LONG).show();
    }

    /**
     * 暂无更多数据吐司
     */
    public static void noData() {
        Toast.makeText(MyApplication.mContext, "暂无更多数据", Toast.LENGTH_SHORT).show();
    }

    /**
     * 无网络吐司
     *
     * @param
     */
    public static void noNet() {
        Toast.makeText(MyApplication.mContext, "网络繁忙,请检查网络!", Toast.LENGTH_SHORT).show();
    }

    public static void noServiceData() {
        Toast.makeText(MyApplication.mContext, "获取失败,服务器繁忙!", Toast.LENGTH_SHORT).show();
    }


    public static void doException(Exception exc) {
        exc.getLocalizedMessage();
        if (TextUtils.equals(exc.toString(), AppStaticVariable.TOAST_ERROR_TIMEOUT)) {
            showToast("服务器连接超时，请稍后再试");
        } else {
            noNet();
        }
    }

}
