package br.com.dipaulamobilesolutions.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.dipaulamobilesolutions.model.Pacote;

public class ResourcesUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable retornaDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(drawableEmTexto, DRAWABLE, context.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }
}
