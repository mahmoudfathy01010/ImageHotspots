package mahmoud.nousir.imagehotspots

import android.content.Context

fun convertPxToDp(px: Float, context: Context): Float {
    val density = context.resources.displayMetrics.density
    return (px * density)
}
