package customviews.typefacesviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class TypeFaceGoogleBold extends TextView {

    public TypeFaceGoogleBold(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public TypeFaceGoogleBold(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public TypeFaceGoogleBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("GoogleSans-Bold.ttf", context);
        setTypeface(customFont);
    }

}

