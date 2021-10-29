package uebung1;
public class Datum {

    private static final int[] MONATSLAENGEN = { 31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31 };

    private int tag;
    private int monat;
    private int jahr;

    private boolean isSchaltjahr;
    
    public static void main(String[] args) {
        
    }

    public Datum(int tag, int monat, int jahr) {
        int maxDay = getMonatslaenge(monat, tag);

        this.isSchaltjahr = isSchaltjahr(jahr);
        
        if ((monat <= 12) && (tag <= maxDay)) {
            if ((jahr < 1800) || (jahr < 2100)) {
                this.tag = tag;
                this.monat = monat;
                this.jahr = jahr;
            } else {
                throw new DateOutOfRangeException("Ungültiges Jahr!");
            }
        } else {
            throw new InvalidDateException(
                    "Ungültige Kombinate von Tag, Monat und Jahr!");
        }
    }

    public static int getMonatslaenge(int monat, int jahr) {
        int maxDay = Datum.MONATSLAENGEN[monat-1];
        if ((monat == 2) && isSchaltjahr(jahr)) {
            maxDay = 29;
        }
        return maxDay;
    }

    public static boolean isSchaltjahr(int jahr) {
        boolean ret = false;
        if ((jahr % 4) == 0) {
            if ((jahr % 100) == 0) {
                if ((jahr % 400) == 0) {
                    ret = true;
                } else {
                    ret = false;
                }
            } else {
                ret = true;
            }
        }
        return ret;
    }

    public boolean equals(Datum a) {
        if ((this.jahr == a.jahr) && isGleicherTag(a)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGleicherTag(Datum a) {
        if ((this.monat == a.monat) && (this.tag == a.tag)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("%4d-%2d-%2d", this.jahr,this.monat,this.tag);
    }

    public Datum morgen() {
        int nextDay = this.tag;
        int nextMonth = this.monat;
        int nextYear = this.jahr;
        if(this.tag == Datum.MONATSLAENGEN[this.monat-1]) {
            nextDay = 1;
            if((this.monat+1)==Datum.MONATSLAENGEN.length) {
                nextMonth = 1;
                nextYear = this.jahr+1;
            }else {
                nextMonth = this.monat+1;
            }
        }
        return new Datum(nextDay, nextMonth, nextYear);
    }

    public Datum gestern() {
        int lastDay = this.tag;
        int lastMonth = this.monat;
        int lastYear = this.jahr;
        if(this.tag == 0) {
            if(this.monat==0) {
                lastMonth = 12;
                lastYear = lastYear-1;
                lastDay = Datum.MONATSLAENGEN[lastMonth-1];
            }else {
                lastMonth = this.monat-1;
            }
        }
        return new Datum(lastDay, lastMonth, lastYear);
    }
}
