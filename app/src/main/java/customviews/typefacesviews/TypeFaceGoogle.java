package customviews.typefacesviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by user on 2/28/2017.
 */

@SuppressLint("AppCompatCustomView")
public class TypeFaceGoogle extends TextView {

    public TypeFaceGoogle(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public TypeFaceGoogle(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public TypeFaceGoogle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("GoogleSans-Regular.ttf", context);
        setTypeface(customFont);
    }

}

