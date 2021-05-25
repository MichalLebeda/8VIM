package inc.flide.vim8.utilities;

import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static float[] convertPointFListToPrimitiveFloatArray(List<PointF> FloatList) {
        float[] floatArray = new float[FloatList.size() * 2];
        for (int i = 0, j = 0; i < FloatList.size(); i++) {
            floatArray[j++] = FloatList.get(i).x;
            floatArray[j++] = FloatList.get(i).y;
        }
        return floatArray;
    }

    public static final ArrayList<Integer> initArrayList(int... ints) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : ints) {
            list.add(i);
        }
        return list;
    }

    public static int getPrevWordIndex(int startIndex, CharSequence s) {
        if (Character.isWhitespace(s.charAt(startIndex))) {
            for (;startIndex>0;startIndex--){
                if(Character.isWhitespace(s.charAt(startIndex))){
                    break;
                }
            }
        }

        boolean foundNonWhitespace = false;

        for (int i = startIndex; i > 0; i--) {
            if (foundNonWhitespace) {
                if (Character.isWhitespace(s.charAt(i))) {
                    return i + 1;
                }
            } else {
                if (!Character.isWhitespace(s.charAt(i))) {
                    foundNonWhitespace = true;
                }
            }
        }
        return -1;
    }

    public static int getNextWordIndex(int startIndex, CharSequence s) {
        boolean foundWhitespace = false;
        for (int i = startIndex; i < s.length(); i++) {
            if (foundWhitespace) {
                if (!Character.isWhitespace(s.charAt(i))) {
                    return i;
                }
            } else {
                if (Character.isWhitespace(s.charAt(i))) {
                    foundWhitespace = true;
                }
            }
        }
        return -1;
    }
}
