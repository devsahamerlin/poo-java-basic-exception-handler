package EntierNaturel.exception;

public class NombreNegatifException extends Exception {
    private int nombreNegatif;

    public NombreNegatifException(int nombreNegatif){
        super("Nombre negatif non autorisé: " + nombreNegatif);
        this.nombreNegatif = nombreNegatif;
    }

    public int getNombreNegatif(){
        return nombreNegatif;
    }
}
