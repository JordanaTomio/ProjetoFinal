package Utilis;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

	// bloqueia caracteres

public class ExcluiCaracteres extends PlainDocument{
	
    private CharSequence chars;

    public ExcluiCaracteres(CharSequence lockedChars) {
        chars = lockedChars;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException{

        boolean teste = false;
        if (str == null) super.insertString(offset, str, attr);
        int length = chars.length();
        for(int i = 0; i < length; i++){
            if (str.contains(""+chars.charAt(i)+"")){
                return;
            }
            else{
                teste = true;
            }
        }
        if(teste == true) super.insertString(offset, str, attr);
    }
}
