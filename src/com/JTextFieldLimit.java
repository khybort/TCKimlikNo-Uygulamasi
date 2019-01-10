package com;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class JTextFieldLimit extends PlainDocument {
        private int limit;
        // optional uppercase conversion
        private boolean toUppercase = false;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        JTextFieldLimit(int limit, boolean upper) {
            super();
            this.limit = limit;
            toUppercase = upper;
        }

        public void insertString
                (int offset, String  str, AttributeSet attr)
                throws BadLocationException {
            if (str == null) return;
         //   String oldString = getText(0, getLength());
         //   String newString = oldString.substring(0, offset) + str
         //           + oldString.substring(offset);
            try {
                if ((getLength() + str.length()) <= limit){
                    Integer.parseInt(str);
                    super.insertString(offset, str, attr);
            }
            }
            catch (NumberFormatException e){}
           /* if ((getLength() + str.length()) <= limit) {
                if (toUppercase) str = str.toUpperCase();
                super.insertString(offset, str, attr);
            }*/

    }}




