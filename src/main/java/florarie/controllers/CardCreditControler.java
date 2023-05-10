package florarie.controllers;

import florarie.model.CardCredit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardCreditControler {
        public static boolean verificareCard(CardCredit card) {
            if (card.getNumarCard().length() != 16) {
                return false;
            }

            if (card.getNumeDetinator().isEmpty()) {
                return false;
            }


            SimpleDateFormat formatter = new SimpleDateFormat("MM/yy");
            Date currentDate = new Date();
            try {
                Date dataExpirare = formatter.parse(card.getDataExpirare());
                if (currentDate.after(dataExpirare)) {
                    return false;
                }
            } catch (ParseException e) {
                return false;
            }

            if (card.getCodSecuritate() < 100 || card.getCodSecuritate() > 999) {
                return false;
            }

            return true;
        }
    }
