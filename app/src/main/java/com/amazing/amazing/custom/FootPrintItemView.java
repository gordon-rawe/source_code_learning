package com.amazing.amazing.custom;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by gordon on 6/22/16.
 */
public class FootPrintItemView extends ViewGroup {
    public static final String TAG = FootPrintItemView.class.getCanonicalName();

    /**
     * Params
     */
    private int logoWidth = 100, logoHeight = 100;
    private int logoTitleGap = 30;
    private int titleSubTitleGap = 30;
    int subTitleColor = 0xFF999999;
    /**
     * Temporary Variables
     */
    private int titleWidth, titleHeight, subTitleWidth, subTitleHeight;
    /**
     * Controls
     */
    private ImageView logo;
    private TextView title, subTitle;

    public void configure(int logoRes, String titleValue, String subTitleValue) {
        title.setText(titleValue);
        subTitle.setText(subTitleValue);
        logo.setImageResource(logoRes);
        invalidate();
    }

    public FootPrintItemView(Context context) {
        super(context);
        init(context);
    }

    public FootPrintItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FootPrintItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        addView(logo = new ImageView(context));
        addView(title = new TextView(context), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(subTitle = new TextView(context), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        initBasic();
    }

    private void initBasic() {
        title.setText("Gordon raweGordon raweGord");
        subTitle.setText("1990-04-15");
        subTitle.setTextColor(subTitleColor);
        title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        subTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
        title.setIncludeFontPadding(false);
        title.setSingleLine();
        title.setEllipsize(TextUtils.TruncateAt.END);
        subTitle.setIncludeFontPadding(false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int totalWidth = getMeasuredWidth();
        /**
         * calc the container width first
         * */
        measureChild(subTitle, widthMeasureSpec, heightMeasureSpec);
        subTitleWidth = subTitle.getMeasuredWidth();
        subTitleHeight = subTitle.getMeasuredHeight();
        /**
         * calc the subtitle width
         * */
        int maxWidthLeft = totalWidth - subTitleWidth - logoWidth - titleSubTitleGap - logoTitleGap;
        title.setMaxWidth(maxWidthLeft);
        /**
         * calc the title max width left and set it to max width
         * */
        measureChild(title, widthMeasureSpec, heightMeasureSpec);
        titleWidth = title.getMeasuredWidth();
        titleHeight = title.getMeasuredHeight();
        /**
         * calc the title width(if text view is dotted.)
         * */
        setMeasuredDimension(widthMeasureSpec, MeasureSpec.makeMeasureSpec(logoHeight, MeasureSpec.EXACTLY));
        /**
         * set the height the container should be.
         * */
    }

    @Override
    protected void onLayout(boolean flag, int l, int t, int r, int b) {
        /**
         * int pl = getPaddingLeft(), pt = getPaddingTop(), right = getPaddingRight(), pb = getPaddingBottom();
         * padding are ignored here because we don't have relative demands.
         * */
        logo.layout(0, 0, logoWidth, logoHeight);
        title.layout(logoWidth + logoTitleGap, calcBaseLineY(logoHeight, titleHeight) - titleHeight + 4, logoWidth + logoTitleGap + titleWidth, calcBaseLineY(logoHeight, titleHeight));
        subTitle.layout(logoWidth + logoTitleGap + titleWidth + titleSubTitleGap, calcBaseLineY(logoHeight, titleHeight) - subTitleHeight,
                logoWidth + logoTitleGap + titleWidth + titleSubTitleGap + subTitleWidth, calcBaseLineY(logoHeight, titleHeight));
    }

    private int calcBaseLineY(int longer, int shorter) {
        return (longer + shorter) / 2;
    }
}
