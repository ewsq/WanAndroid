package showmethe.github.core.widget.common

import android.content.Context
import android.text.TextPaint
import android.util.AttributeSet
import android.widget.ImageView

import android.graphics.*

/**
 * Author: showMeThe
 * Update Time: 2019/10/28
 * Package Name:showmethe.github.core.widget.common
 */
class ProgressImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    private val proPaint = Paint()
    private val bgPaint = Paint()
    private var  progressPercent = 0f
    private var  radius  = 0f
    private val rect = RectF()


    init {
        proPaint.style = Paint.Style.FILL_AND_STROKE
        proPaint.isAntiAlias = true
        proPaint.color = Color.WHITE
        proPaint.alpha = (255 * 0.7f).toInt()

        //设置抗锯齿
        bgPaint.isAntiAlias = true
        bgPaint.color = Color.parseColor("#66FFFFFF")
    }



    override fun draw(canvas: Canvas) {
        canvas.drawRect(0f,0f,measuredWidth.toFloat(),measuredHeight.toFloat(),bgPaint)
        if(progressPercent <=99){
            if(radius == 0f){
                val centerX = measuredWidth/2f
                val centerY = measuredHeight/2f
                radius = measuredWidth.div(12f)
                rect.set(centerX - radius,centerY - radius,centerX + radius,centerY + radius)
            }
            canvas.drawArc(rect,90f,(progressPercent/100) * 360f,true,proPaint)
        }
        super.draw(canvas)
    }


    fun setPercentage(percentage: Float) {
        this.progressPercent = percentage
        invalidate()
    }

}