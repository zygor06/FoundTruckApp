package foundtruck.com.br.foundtruck.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Aragorn on 15/09/2017.
 */

public class Fonts extends AppCompatActivity {

    private Context context;

    public static final String BLOATED = 			"fonts/FoodTruckBloated.ttf";
    public static final String CHALKBOARD_ITALIC = 	"fonts/FoodTruckChalkboard-Italic.ttf";
    public static final String CHALBOARD_REGULAR = 	"fonts/FoodTruckChalkboard-Regular.ttf";
    public static final String DOODLES_REGULAR = 	"fonts/FoodTruckDoodles-Regular.ttf";
    public static final String MENU_ITALIC = 		"fonts/FoodTruckMenu-Italic.ttf";
    public static final String MENU_REGULAR = 		"fonts/FoodTruckMenu-Regular.ttf";
    public static final String OUTLINE_ITALIC = 	"fonts/FoodTruckOutline-Italic.ttf";
    public static final String OUTLINE_REGULAR = 	"fonts/FoodTruckOutline-Regular.ttf";
    public static final String SIGNATURE_ITALIC = 	"fonts/FoodTruckSignage-Italic.ttf";
    public static final String SIGNATURE_REGULAR = 	"fonts/FoodTruckSignage-Regular.ttf";
    public static final String ROBOTO_REGULAR = 	"fonts/Roboto-Regular.ttf";
    public static final String ROBOTO_LIGHT = 	    "fonts/Roboto-Light.ttf";
    public static final String ROBOTO_BOLD = 	    "fonts/Roboto-Bold.ttf";

    private Typeface FONT_BLOATED;
    private Typeface FONT_CHALKBOARD_ITALIC;
    private Typeface FONT_CHALBOARD_REGULAR;
    private Typeface FONT_DOODLES_REGULAR	;
    private Typeface FONT_MENU_ITALIC		;
    private Typeface FONT_MENU_REGULAR		;
    private Typeface FONT_OUTLINE_ITALIC	;
    private Typeface FONT_OUTLINE_REGULAR	;
    private Typeface FONT_SIGNATURE_ITALIC	;
    private Typeface FONT_SIGNATURE_REGULAR;
    private Typeface FONT_ROBOTO_REGULAR;
    private Typeface FONT_ROBOTO_LIGHT;
    private Typeface FONT_ROBOTO_BOLD;



    public Fonts(Context c){
        this.context = c;
        this.FONT_BLOATED           = Typeface.createFromAsset(context.getAssets(), BLOATED);
        this.FONT_CHALKBOARD_ITALIC	= Typeface.createFromAsset(context.getAssets(), CHALKBOARD_ITALIC);
        this.FONT_CHALBOARD_REGULAR	= Typeface.createFromAsset(context.getAssets(), CHALBOARD_REGULAR);
        this.FONT_DOODLES_REGULAR	= Typeface.createFromAsset(context.getAssets(), DOODLES_REGULAR);
        this.FONT_MENU_ITALIC		= Typeface.createFromAsset(context.getAssets(), MENU_ITALIC);
        this.FONT_MENU_REGULAR		= Typeface.createFromAsset(context.getAssets(), MENU_REGULAR);
        this.FONT_OUTLINE_ITALIC	= Typeface.createFromAsset(context.getAssets(), OUTLINE_ITALIC);
        this.FONT_OUTLINE_REGULAR	= Typeface.createFromAsset(context.getAssets(), OUTLINE_REGULAR);
        this.FONT_SIGNATURE_ITALIC	= Typeface.createFromAsset(context.getAssets(), SIGNATURE_ITALIC);
        this.FONT_SIGNATURE_REGULAR	= Typeface.createFromAsset(context.getAssets(), SIGNATURE_REGULAR);
        this.FONT_ROBOTO_REGULAR    = Typeface.createFromAsset(context.getAssets(), ROBOTO_REGULAR);
        this.FONT_ROBOTO_LIGHT    = Typeface.createFromAsset(context.getAssets(), ROBOTO_LIGHT);
        this.FONT_ROBOTO_BOLD    = Typeface.createFromAsset(context.getAssets(), ROBOTO_BOLD);
    }

    public Typeface bloated() {
        return FONT_BLOATED;
    }

    public Typeface chalkboardItalic() {
        return FONT_CHALKBOARD_ITALIC;
    }

    public Typeface chalkboardRegular() {
        return FONT_CHALBOARD_REGULAR;
    }

    public Typeface doodlesRegular() {
        return FONT_DOODLES_REGULAR;
    }

    public Typeface menuItalic() {
        return FONT_MENU_ITALIC;
    }

    public Typeface menuRegular() {
        return FONT_MENU_REGULAR;
    }

    public Typeface outlineItalic() {
        return FONT_OUTLINE_ITALIC;
    }

    public Typeface outlineRegular() {
        return FONT_OUTLINE_REGULAR;
    }

    public Typeface signatureItalic() {
        return FONT_SIGNATURE_ITALIC;
    }

    public Typeface signatureRegular() {
        return FONT_SIGNATURE_REGULAR;
    }

    public Typeface robotoRegular() {
        return FONT_ROBOTO_REGULAR;
    }

    public Typeface robotoLight() {
        return FONT_ROBOTO_LIGHT;
    }

    public Typeface robotoBold() {
        return FONT_ROBOTO_BOLD;
    }
}
